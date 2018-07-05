package parser;

import expression.*;

public class ParserExpression {
    final static public char[] HIGH_PRIORITY_OPERATIONS = {'*', '/', '^'};
    final static public char[] LOW_PRIORITY_OPERATIONS = {'-', '+'};

    public static Expression parseInitialExpression(String expression) {
        expression.replaceAll(" ","");

        if(ChecksExpression.checkOnValidExpression(expression)){
            return createExpressionFromInput(expression);
        }
        else
            throw new NotValidException("Expression not valid!");
    }

    private static Expression createExpressionFromInput(String expression){
        int positionOperation;

        if (ChecksExpression.checkExpressionOnParentheses(expression)){
            expression = expression.substring(1, expression.length() - 1);
        }

        positionOperation = ChecksExpression.checkLowPriorityOperationsInExpression(expression);
        if (positionOperation != -1){
            return creationOfTwoSubexpressions(expression,positionOperation);
        }

        positionOperation = ChecksExpression.checkHighPriorityOperationsInExpression(expression);
        if (positionOperation != -1){
            return creationOfTwoSubexpressions(expression,positionOperation);
        }

        return new ExpressionAloneValue(Double.valueOf(expression));
    }

    private static Expression creationOfTwoSubexpressions(String expression, int separatorPoint){
        if(separatorPoint != -2){
            Expression firstValue = createExpressionFromInput(expression.substring(0, separatorPoint));
            Expression secondValue = createExpressionFromInput(expression.substring
                    (separatorPoint + 1, expression.length()));

            switch (expression.charAt(separatorPoint)) {
                case '+':
                    return new ExpressionSum(firstValue, secondValue);
                case '-':
                    return new ExpressionSub(firstValue, secondValue);
                case '*':
                    return new ExpressionMul(firstValue, secondValue);
                case '/':
                    return new ExpressionDiv(firstValue, secondValue);
                case '^':
                    return new ExpressionPow(firstValue, secondValue);
            }
        }
        return new ExpressionAloneValue(Double.valueOf(expression));
    }
}
