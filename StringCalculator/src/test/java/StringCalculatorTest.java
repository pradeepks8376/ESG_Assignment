import org.junit.Test;
import static org.junit.Assert.*;

public class StringCalculatorTest {

    @Test
    public void testEmptyString() {
        StringCalculator calc = new StringCalculator();
        assertEquals(0, calc.Add(""));
    }

    @Test
    public void testOneNumber() {
        StringCalculator calc = new StringCalculator();
        assertEquals(1, calc.Add("1"));
    }

    @Test
    public void testTwoNumbers() {
        StringCalculator calc = new StringCalculator();
        assertEquals(3, calc.Add("1,2"));
    }

    @Test
    public void testMultipleNumbers() {
        StringCalculator calc = new StringCalculator();
        assertEquals(6, calc.Add("1,2,3"));
    }

    @Test
    public void testNewLineDelimiter() {
        StringCalculator calc = new StringCalculator();
        assertEquals(6, calc.Add("1\n2,3"));
    }

    @Test
    public void testNegativeNumbers() {
        StringCalculator calc = new StringCalculator();
        try {
            calc.Add("1,-2,3");
            fail("Exception expected");
        } catch (IllegalArgumentException e) {
            assertEquals("Negatives not allowed: [-2]", e.getMessage());
        }
    }

    @Test
    public void testNumbersGreaterThan1000() {
        StringCalculator calc = new StringCalculator();
        assertEquals(2, calc.Add("1001,2"));
    }

    @Test
    public void testAnyLengthDelimiter() {
        StringCalculator calc = new StringCalculator();
        assertEquals(6, calc.Add("//[|||]\n1|||2|||3"));
    }

    @Test
    public void testMultipleDelimiters() {
        StringCalculator calc = new StringCalculator();
        assertEquals(6, calc.Add("//[|][%]\n1|2%3"));
    }

    @Test
    public void testMultipleDelimitersAnyLength() {
        StringCalculator calc = new StringCalculator();
        assertEquals(15, calc.Add("//[|||][%]\n1|||2%3|||4%5"));
    }
}