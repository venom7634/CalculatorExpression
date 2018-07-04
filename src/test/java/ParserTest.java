import expression.Expression;
import org.junit.Test;
import parser.ParserExpression;


public class ParserTest {

    @Test
    public void testParseExpression(){
        String expression = "5+6+1-42+5-21+6";
        Expression ex =ParserExpression.parseExpression(expression); // OK. type ex - ExpressionSum

//        expression = "-5+6";
//        ex = ParserExpression.parseExpression(expression); // java.lang.NumberFormatException

//        expression = "156";
//        ex = ParserExpression.parseExpression(expression); // OK. type ex - ExpressionAlone

//        expression = "-16";
//        ex = ParserExpression.parseExpression(expression); // java.lang.NumberFormatException

//        expression = "242++21";
//        ex = ParserExpression.parseExpression(expression); // java.lang.NumberFormatException

//        expression = "51+8651+";
//        ex = ParserExpression.parseExpression(expression); //java.lang.NumberFormatException
    }

}
