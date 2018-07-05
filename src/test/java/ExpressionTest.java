import expression.*;
import org.junit.Test;

public class ExpressionTest {

    @Test
    public void testExpressionCalculate(){
        Expression aloneFirst = new ExpressionAloneValue(10);
        Expression aloneSecond = new ExpressionAloneValue(20);
        Expression sub = new ExpressionSub(aloneFirst,aloneSecond);
        Expression sum = new ExpressionSum(aloneFirst,aloneSecond);
        Expression bigSum = new ExpressionSum(sub,sum);
        Expression div = new ExpressionDiv(bigSum,aloneFirst);
        Expression mulFirst = new ExpressionMul(div,aloneFirst);
        Expression mulSecond = new ExpressionMul(mulFirst,aloneFirst);

        double result = mulSecond.calculate();
    }
}
