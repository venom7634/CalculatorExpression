package parser;

import expression.Expression;
import expression.ExpressionAlone;
import expression.ExpressionSub;
import expression.ExpressionSum;

public class ParserExpression {

    public static Expression parseExpression(String expression) {
        expression.replaceAll(" ","");
        if(CheckingExpression.checkOnValidExpression(expression))
            return createExpression(expression);
        else return null;

    }

    private static long countOperation(String expression){
        return expression.chars().filter(ch -> ch == '+' || ch == '-').count();
    }

    private static Expression createExpression(String expression){
        expression = trimExpressionFromParentheses(expression);

        if (expression.indexOf('(')!=-1){
            return creationOfTwoSubexpressions(expression,expression.indexOf('(')-1);
        }

        if (expression.lastIndexOf(')')!=-1){
            return creationOfTwoSubexpressions(expression,expression.lastIndexOf(')')+1);
        }

        if(countOperation(expression) == 0){
            return new ExpressionAlone(Double.valueOf(expression));
        } else
        if(countOperation(expression)%2==0){
            return creationOfTwoSubexpressions(expression,
                    searchPointSeparator(expression,countOperation(expression)));
        } else {
            return creationOfTwoSubexpressions(expression,
                    searchPointSeparator(expression,(countOperation(expression)+1)/2));
        }
    }



    private  static  String trimExpressionFromParentheses(String expression){
        if (expression.indexOf('(')==0&&expression.lastIndexOf(')')==expression.length()-1){
            return expression.substring(1,expression.length()-1);
        }
        return expression;
    }

    private static int searchPointSeparator(String expression, long countSignSeparation){
        int separatorPoint = 0;
        for (int i = 0;countSignSeparation > 0;i++){
            if(expression.charAt(i) == '-' || expression.charAt(i)=='+'){
                countSignSeparation-=1;
                separatorPoint = i;
            }
        }
        return separatorPoint;
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
        }
        return null;
    }
}
