package parser;

public class CheckingExpression {

    static boolean checkOnValidExpression(String expression){
        if(expression.matches("[-]?([(]*[0-9]+[)]*[+*/-])+[0-9]+[)]*$")){
            return checkParentheses(expression);
        } else{
            System.out.print("Error! Expression not valid\n");
            return false;
        }
    }

    static boolean checkParentheses(String expression){
        int rightParentheses = 0;
        int leftParentheses = 0;
        for (int i = 0; i<expression.length();i++){
            if (expression.charAt(i) == ')')
                rightParentheses++;
            if (expression.charAt(i) == '(')
                leftParentheses++;
        }
        if (rightParentheses == leftParentheses)
            return true;
        System.out.print("Error! Expression not valid\n");
        return false;
    }

    static boolean checkExpressionOnParentheses(String expression){
        int countParentheses = 0;
        boolean expressionInParentheses = true;
        if(expression.charAt(0) == '(') {
            for (int i = 1; i < expression.length() - 2; i++) {
                if (expression.charAt(i) == '(')
                    countParentheses++;
                if (expression.charAt(i) == ')')
                    countParentheses--;
                if (countParentheses < 0) {
                    expressionInParentheses = false;
                    break;
                }
            }
            return expressionInParentheses;
        }
        else
            return false;
    }
}
