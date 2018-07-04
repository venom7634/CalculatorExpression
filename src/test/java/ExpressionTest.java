import expression.Expression;
import expression.ExpressionAlone;
import expression.ExpressionSub;
import expression.ExpressionSum;
import org.junit.Test;

public class ExpressionTest {

    @Test
    public void testExpressionCalculate(){
        Expression aloneFirst = new ExpressionAlone(10);
        Expression aloneSecond = new ExpressionAlone(20);
        Expression sub = new ExpressionSub(aloneFirst,aloneSecond);
        Expression sum = new ExpressionSum(aloneFirst,aloneSecond);
        Expression bigSum = new ExpressionSum(sub,sum);

        double result = bigSum.calculate();
    }
}
