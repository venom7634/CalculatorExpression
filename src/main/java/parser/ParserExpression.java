package parser;

import expression.*;

public class ParserExpression {

    public static Expression parseExpression(String expression) {
        expression.replaceAll(" ","");
        if(CheckingExpression.checkOnValidExpression(expression))
            return createExpression(expression);
        else return null;

    }

    private static Expression createExpression(String expressionString){

        if(expressionString.charAt(0) == '(' && expressionString.charAt(expressionString.length()-1)==')')
            expressionString = trimExpressionFromParentheses(expressionString);

        Expression expression;
        if ((expression = performOperationsLowPriority(expressionString))!= null)
            return expression;

        if ((expression = performOperationsHighPriority(expressionString))!= null)
            return expression;

        return new ExpressionAlone(Double.valueOf(expressionString));
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

    private  static  String trimExpressionFromParentheses(String expression){
        boolean expressionInParentheses = true;
        int countParentheses = 0;

        for (int i = 1; i < expression.length()-2;i++){
            if(expression.charAt(i) == '(')
                countParentheses++;
            if(expression.charAt(i) == ')')
                countParentheses--;
            if(countParentheses < 0){
                expressionInParentheses = false;
                break;
            }
        }
        if (expressionInParentheses){
            return expression.substring(1,expression.length()-1);
        }
        return expression;
    }

    private static Expression creationOfTwoSubexpressions(String expression, int separatorPoint){
        try{
            Double.valueOf(expression);
            return new ExpressionAlone(Double.valueOf(expression));
        }catch (NumberFormatException e){
        }
        switch (expression.charAt(separatorPoint)){
            case '+':
                return new ExpressionSum(createExpression(expression.substring(0,separatorPoint)),
                        createExpression(expression.substring(separatorPoint+1,expression.length())));
            case '-':
                return new ExpressionSub(createExpression(expression.substring(0,separatorPoint)),
                        createExpression(expression.substring(separatorPoint+1,expression.length())));
            case '*':
                return new ExpressionMul(createExpression(expression.substring(0,separatorPoint)),
                        createExpression(expression.substring(separatorPoint+1,expression.length())));
            case '/':
                return new ExpressionDiv(createExpression(expression.substring(0,separatorPoint)),
                        createExpression(expression.substring(separatorPoint+1,expression.length())));
        }
        return null;
    }
}
