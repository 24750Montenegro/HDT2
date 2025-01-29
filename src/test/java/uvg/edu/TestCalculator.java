package uvg.edu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class TestCalculator {

    Calculadora calc = new Calculadora();

    @Test
    public void suma() {
        assertEquals(10, calc.evaluar("5 5 +"));
        assertEquals(15, calc.evaluar("3 4 + 3 + 2 2 + + 1 +"));
    }

    @Test
    public void resta() {
        assertEquals(4, calc.evaluar("8 4 -"));
        assertEquals(7, calc.evaluar("20 8 - 10 5 - -"));
    }

    @Test
    public void mult() {
        assertEquals(4, calc.evaluar("2 2 *"));
        assertEquals(100, calc.evaluar("2 2 * 5 * 5 *"));
    }

    @Test
    public void div() {
        assertEquals(2, calc.evaluar("8 4 /"));
        assertEquals(100, calc.evaluar("10000 1000 10 / /"));
    }

    @Test
    public void modulo() {
        assertEquals(0, calc.evaluar("8 8 %"));
        assertEquals(2, calc.evaluar("16 10 % 4 %"));
    }

    @Test
    public void testDivisionPorCero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calc.evaluar("5 0 /"));
        assertEquals("División por cero.", exception.getMessage());
    }

    @Test
    public void testExpresionInvalida() {
        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> calc.evaluar("3 +"));
        assertEquals("Expresión inválida.", exception1.getMessage());

        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> calc.evaluar("5 1 + 2"));
        assertEquals("Expresión inválida.", exception2.getMessage());
    }

    @Test
    public void testOperadorDesconocido() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calc.evaluar("4 2 &"));
        assertTrue(exception.getMessage().contains("Operador desconocido"));
    }
}
