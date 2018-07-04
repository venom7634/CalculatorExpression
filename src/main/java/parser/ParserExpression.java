package parser;

import expression.Expression;
import expression.ExpressionAlone;
import expression.ExpressionSub;
import expression.ExpressionSum;

public class ParserExpression {

    public static Expression parseExpression(String expression){
        expression.replaceAll(" ","");
        return createExpression(expression);
    }

    private static long countOperation(String expression){
        return expression.chars().filter(ch -> ch == '+' || ch == '-').count();
    }

    private static Expression createExpression(String expression){
        if(countOperation(expression) == 0){
            return new ExpressionAlone(Double.valueOf(expression));
        } else
        if(countOperation(expression)%2==0){
            return creationOfTwoSubexpressions(expression,countOperation(expression));
        } else {
            return creationOfTwoSubexpressions(expression,(countOperation(expression)+1)/2);
        }
    }

    private static Expression creationOfTwoSubexpressions(String expression, long countSignSeparation){
        int separatorPoint = 0;
        for (int i = 0;countSignSeparation > 0;i++){
            if(expression.charAt(i) == '-' || expression.charAt(i)=='+'){
                countSignSeparation-=1;
                separatorPoint = i;
            }
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
