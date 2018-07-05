package parser;

import expression.*;

public class ParserExpression {

    public static Expression parseInitialExpression(String expression) {
        expression.replaceAll(" ","");

        if(CheckingExpression.checkOnValidExpression(expression))
            return createExpressionFromInput(expression);
        else return null;

    }

    private static Expression createExpressionFromInput(String expressionString){

        if (CheckingExpression.checkExpressionOnParentheses(expressionString)){
            expressionString = expressionString.substring(1,expressionString.length()-1);
        }

        Expression expression;
        if ((expression = performOperationsLowPriority(expressionString))!= null)
            return expression;

        if ((expression = performOperationsHighPriority(expressionString))!= null)
            return expression;

        return new ExpressionAloneValue(Double.valueOf(expressionString));
    }

    private  static  Expression performOperationsHighPriority(String expression){
        int index;
        if(expression.indexOf('(') == 0)
            index = expression.lastIndexOf(')')+1;
        else index = expression.indexOf('(')-1;
        if(index == -2){
            if ((expression.indexOf('*'))!=-1){
                index = expression.indexOf('*');
            }
            if ((expression.indexOf('/'))!=-1){
                index = expression.indexOf('/');
            }
        }
        return creationOfTwoSubexpressions(expression,index);

    }

    private static Expression performOperationsLowPriority(String expression){
        int validParentheses = 0;
        for (int i=expression.length()-1; i > 0;i--){
            switch (expression.charAt(i)){
                case '(':
                    validParentheses--;
                    break;
                case ')':
                    validParentheses++;
                    break;
                case '+':
                    if(validParentheses == 0)
                        return creationOfTwoSubexpressions(expression,i);
                    break;
                case '-':
                    if(validParentheses == 0)
                        return creationOfTwoSubexpressions(expression,i);
                    break;
            }
        }
        return null;
    }

    private static Expression creationOfTwoSubexpressions(String expression, int separatorPoint){
        try{
            Double.valueOf(expression);
            return new ExpressionAloneValue(Double.valueOf(expression));
        }catch (NumberFormatException e){
        }

        Expression firstValue = createExpressionFromInput(expression.substring(0,separatorPoint));
        Expression secondValue = createExpressionFromInput(expression.substring(separatorPoint+1,expression.length()));

        switch (expression.charAt(separatorPoint)){
            case '+':
                return new ExpressionSum(firstValue,secondValue);
            case '-':
                return new ExpressionSub(firstValue,secondValue);
            case '*':
                return new ExpressionMul(firstValue,secondValue);
            case '/':
                return new ExpressionDiv(firstValue,secondValue);
        }
        return null;
    }
}
