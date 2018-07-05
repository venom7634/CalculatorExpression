import expression.Expression;
import org.junit.Test;
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
    public void testParseExpressionWithDoubleParentheses(){
        String expression = "25+(6-(5-2))";
        Expression ex = ParserExpression.parseInitialExpression(expression);
        assertTrue(ex.calculate() == 28);
    }

    @Test
    public void testParseExpressionMul(){
        String expression = "40+2*5";
        Expression ex = ParserExpression.parseInitialExpression(expression);
        assertTrue(ex.calculate() == 50);
    }

    @Test
    public void testParseExpressionDiv(){
        String expression = "36/6-5";
        Expression ex = ParserExpression.parseInitialExpression(expression);
        assertTrue(ex.calculate() == 1);
    }

    @Test
    public void testParseBigExpression(){
        String expression = "(3*6+7*(6-5*3*(4-5)))/15-25*5-(65-20*3)";
        Expression ex = ParserExpression.parseInitialExpression(expression);
        assertTrue(ex.calculate() == -119);
    }
}
