package parser;

public class CheckingExpression {

    public static boolean checkOnValidExpression(String expression){
        if(expression.matches("[-]?([(]*[0-9]+[)]*[+*/-])+[0-9]+[)]*$")){
            return checkParentheses(expression);
        } else {
            return false;
        }
    }

    public static boolean checkParentheses(String expression){
        int rightParentheses = 0;
        int leftParentheses = 0;
        for (int i = 0; i < expression.length(); i++){
            if (expression.charAt(i) == ')')
                rightParentheses++;
            if (expression.charAt(i) == '(')
                leftParentheses++;
        }
        if (rightParentheses == leftParentheses)
            return true;
        return false;
    }

    public static boolean checkExpressionOnParentheses(String expression){
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

    public static int checkLowPriorityOperationsInExpression(String expression){
        int index = -1;
        char[] operations = ParserExpression.LOW_PRIORITY_OPERATIONS;

        for (char operation : operations){
            int validParentheses = 0;
            for(int i = expression.length()-1; i > 0; i--){
                if(expression.charAt(i) == ')'){
                    validParentheses++;
                }
                if(expression.charAt(i) == '('){
                    validParentheses--;
                }
                if(expression.charAt(i) == operation && validParentheses == 0){
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

    public static int checkHighPriorityOperationsInExpression(String expression){
        int index;
        char[] operations = ParserExpression.HIGH_PRIORITY_OPERATIONS;

        if(expression.indexOf('(') == 0)
            index = expression.lastIndexOf(')') + 1;
        else index = expression.indexOf('(') - 1;

        if(index == -2){
            for(char operation : operations){
                if ((expression.indexOf(operation)) != -1){
                    index = expression.indexOf(operation);
                }
            }
        }
        return index;
    }
}
