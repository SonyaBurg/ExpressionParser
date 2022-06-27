# ExpressionParser

Tool to parse arithmetic expressions and perform operations with exception checks (such as overflow or division by zero). Supports operations with 1 or 3 variables (x, y, z).

# Usage

Expression `5 + x` would have the following representation:

```java
GeneralExpression x = new Add(new Const(5), new Variable("x"));
```

To calculate the value for a specific set of variables you use the evaluate function:

```java
int result = x.evaluate(1)
```

In this case the resulting value would be equal to 6.


You can also parse expressions directly from string using the `ExpressionParser` class:

```java
ExpressionParser parser = new ExpressionParser();
GeneralExpression result = parser.parse("  (4 + x) * 8 ");
```

In this case the parsed expression would look as following:

```java
new Multiply(new Add(new Const(4), new Variable("x")), new Const(8));
```
