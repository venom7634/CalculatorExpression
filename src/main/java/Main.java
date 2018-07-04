import expression.Expression;
import parser.ParserExpression;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the expression:");
        Expression ex = ParserExpression.parseExpression(sc.next());
        System.out.println("Result: "+ex.calculate());

        sc.close();
    }
}
