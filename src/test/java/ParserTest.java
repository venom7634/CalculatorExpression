import expression.Expression;
import org.junit.Test;
import parser.ParserExpression;


public class ParserTest {

    @Test
    public void testParseExpression(){
        String expression = "5+6+1-42+5-21+6";
        Expression ex =ParserExpression.parseExpression(expression);

        expression = "156";
        ex = ParserExpression.parseExpression(expression);
    }

    @Test
    public void testParseExpressionDoubleSign(){
        String expression = "242++21";
        Expression ex = ParserExpression.parseExpression(expression);
    }

    @Test
    public void testParseExpressionExcessSign(){
        String expression = "51+8651+";
        Expression ex = ParserExpression.parseExpression(expression);
    }

    @Test
    public void testParseExpressionWithParentheses(){
        String expression = "50+(7-5)";
        Expression ex = ParserExpression.parseExpression(expression);
    }
    @Test
    public void testParseExpressionFullInParentheses(){
        String expression = "(6+5(2-3))";
        Expression ex = ParserExpression.parseExpression(expression);
    }
    @Test
    public void testParseExpressionWithDoubleParentheses(){
        String expression = "25+(6-(5-2))";
        Expression ex = ParserExpression.parseExpression(expression);
    }

    @Test
    public void testParseExpressionMoreParentheses(){
        String expression = "50+(7-5))))))))))))))))))))";
        Expression ex = ParserExpression.parseExpression(expression);
    }
    @Test
    public void testParseExpressionMul(){
        String expression = "40+2*5";
        Expression ex = ParserExpression.parseExpression(expression);
    }
    @Test
    public void testParseExpressionDiv(){
        String expression = "36/6-5";
        Expression ex = ParserExpression.parseExpression(expression);
    }
    @Test
    public void testParseBigExpression(){
        String expression = "(3*6+7*(6-5*3*(4-5)))/15-25*5-(65-20*3)";
        Expression ex = ParserExpression.parseExpression(expression);
    }
}
