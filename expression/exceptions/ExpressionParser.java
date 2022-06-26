package expression.exceptions;

import expression.*;
import expression.parser.BaseParser;
import expression.parser.StringSource;

import java.util.List;

public class ExpressionParser implements TripleParser {
    @Override
    public GeneralExpression parse(String expression) {
        return new ExpParser(expression).parseExpression();
    }

    private static class ExpParser extends BaseParser {
        List<Character> VariablesNames = List.of('x', 'y', 'z');

        ExpParser(String s) {
            super(new StringSource(s));
        }

        public GeneralExpression parseExpression() {
            GeneralExpression resultingExpression = parseElement();
            if (!eof()) {
                throw new ParseVariablesException("EOF not found");
            }
            return resultingExpression;
        }

        public GeneralExpression parseElement() {
            skipWhitespaces();
            return parseThirdPriority();
        }

        private GeneralExpression parseThirdPriority() {
            skipWhitespaces();
            GeneralExpression exp = parseSecondPriority();
            while (!eof()) {
                if (isLetter()) {
                    StringBuilder sb = new StringBuilder();
                    while (isLetter()) sb.append(take());
                    if ("max".equals(sb.toString())) exp = new CheckedMax(exp, parseSecondPriority());
                    else if ("min".equals(sb.toString())) exp = new CheckedMin(exp, parseSecondPriority());
                    else throw new ParseOperationException("invalid operation");
                } else return exp;
            }
            return exp;
        }

        private GeneralExpression parseSecondPriority() {
            skipWhitespaces();
            GeneralExpression exp = parseFirstPriority();
            while (!eof()) {
                skipWhitespaces();
                if (take('+')) {
                    exp = new CheckedAdd(exp, parseFirstPriority());
                }
                else if (take('-')) {
                    exp = new CheckedSubtract(exp, parseFirstPriority());
                } else return exp;
            }
            return exp;
        }

        private GeneralExpression parseFirstPriority() {
            skipWhitespaces();
            GeneralExpression exp = parseToken();
            while (!eof()) {
                skipWhitespaces();
                if (take('*')) {
                    exp = new CheckedMultiply(exp, parseToken());
                }
                else if (take('/')) {
                    exp = new CheckedDivide(exp, parseToken());
                }
                else return exp;
            }
            return exp;
        }

        private GeneralExpression parseToken() {
            skipWhitespaces();
            if (isDigit()) {
                StringBuilder sb = new StringBuilder();
                while (constructNumber(sb));
                if (!isLetter()) return new Const(Integer.parseInt(sb.toString()));
                throw new ParseVariablesException("invalid number");
            }
            if (take('-')) {
                if (isDigit()) {
                    StringBuilder sb = new StringBuilder("-");
                    while (constructNumber(sb));
                    return new Const(Integer.parseInt(sb.toString()));
                }
                return new CheckedNegate(parseToken());
            }
            if (isLetter()) {
                for (Character c : VariablesNames) {
                    if (take(c)) return new Variable(c.toString());
                }
                if(take('l') && take('0') && (isWhitespace() || test('('))) return new CheckedL0(parseToken());
                if (take('t') && take('0') && (isWhitespace() || test('('))) return new CheckedT0(parseToken());
                throw new ParseVariablesException("unknown variable");
            }
            if (take('(')) {
                GeneralExpression exp = parseElement();
                if (!take(')')) throw new ParseParenthesesException("invalid parentheses");
                return exp;
            }
            throw new ParseVariablesException("invalid token");
        }

        private boolean constructNumber(StringBuilder builder) {
            if (isDigit()) {
                builder.append(take());
                return true;
            }
            return false;
        }

        private void skipWhitespaces() {
            while (isWhitespace()) {
                take();
            }
        }
    }
}
