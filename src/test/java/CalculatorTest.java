import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.softie.automation.Calculator;
import org.junit.jupiter.api.Assertions;

public class CalculatorTest {

    @Test
    public void addErrorTest() {
        Assertions.assertFalse(5 == Calculator.add(4, 9));
    }

    @Test
    public void addTest() {
        Assertions.assertTrue(5 == Calculator.add(4, 1));
    }

    @Test
    public void subtractErrorTest() {
        Assertions.assertFalse(10 == Calculator.subtract(11, 9));
    }

    @Test
    @Disabled("Enabled when subtract method is fixed")
    public void subtractTest() {
        Assertions.assertTrue(10 == Calculator.subtract(20, 10));
    }

    @Test
    public void multiplyErrorTest() {
        Assertions.assertFalse(10 == Calculator.multiply(11, 9));
    }

    @Test
    public void multiplyTest() {
        Assertions.assertTrue(10 == Calculator.multiply(2, 5));
    }
}
