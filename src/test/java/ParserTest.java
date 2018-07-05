import expression.Expression;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import parser.NotValidException;
import parser.ParserExpression;

import static org.junit.Assert.assertTrue;


public class ParserTest {

    @Test(expected = NotValidException.class)
    public void testParseExpressionIsSingleValue(){
        String expression = "156";
        ParserExpression.parseInitialExpression(expression);
    }

    @Test(expected = NotValidException.class)
    public void testParseExpressionDoubleSign(){
        String expression = "242++21";
        ParserExpression.parseInitialExpression(expression);
    }

    @Test(expected = NotValidException.class)
    public void testParseExpressionExcessSign(){
        String expression = "51+8651+";
        ParserExpression.parseInitialExpression(expression);
    }

    @Test(expected = NotValidException.class)
    public void testParseExpressionMoreParentheses(){
        String expression = "50+(7-5))))))))))))))))))))";
        ParserExpression.parseInitialExpression(expression);
    }

    @Test
    public void testParseExpression(){
        String expression = "5+6+1-42+5-21+6";
        Expression ex = ParserExpression.parseInitialExpression(expression);
        assertTrue(ex.calculate() == -40);
    }

    @Test
    public void testParseExpressionWithParentheses(){
        String expression = "50+(7-5)";
        Expression ex = ParserExpression.parseInitialExpression(expression);
        assertTrue(ex.calculate() == 52);
    }

    @Test
    public void testParseExpressionFullInParentheses(){
        String expression = "(6+5*(2-3))";
        Expression ex = ParserExpression.parseInitialExpression(expression);
        assertTrue(ex.calculate() == 1);
    }

    @Test
    public void testParseExpressionMul(){
        String expression = "40+2*5";
        Expression ex = ParserExpression.parseInitialExpression(expression);
        System.out.println(ex.calculate());
        assertTrue(ex.calculate() == 50);
    }
    @Test
    public void testParseExpressionWithPower(){
        String expression = "5^2-10";
        Expression ex = ParserExpression.parseInitialExpression(expression);
        System.out.println(ex.calculate());
        assertTrue(ex.calculate() == 15);
    }

    @Test
    public void testParseWithDivisionWithRemainder(){
        String expression = "(47-2)%40";
        Expression ex = ParserExpression.parseInitialExpression(expression);
        System.out.println(ex.calculate());
        assertTrue(ex.calculate() == 5);
    }

    @Test
    public void testParseExpressionDiv(){
        String expression = "36/6-5";
        Expression ex = ParserExpression.parseInitialExpression(expression);
        System.out.println(ex.calculate());
        assertTrue(ex.calculate() == 1);
    }

    @Test
    public void testParseExpressionWithConstant(){
        String expression = "pi-e";
        Expression ex = ParserExpression.parseInitialExpression(expression);
        System.out.println(ex.calculate());
        assertTrue(ex.calculate() == Math.PI-Math.E);
    }

    @Test
    public void testParseBigExpression(){
        String expression = "(4*(4+(17-(75%60))^3)-3)/5";
        Expression ex = ParserExpression.parseInitialExpression(expression);
        System.out.println(ex.calculate());
        assertTrue(ex.calculate() == 9);
    }


}
