package uvg.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

public class CalculadoraTest {

    private Calculadora calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    void testLeerYEvaluarExpresion() throws IOException {

        String archivo = "src/main/java/uvg/edu/datos.txt";
        calculadora.readFromFile(archivo);

        int resultado = calculadora.evaluateExpression();
        Assertions.assertEquals(3, resultado);
    }

    @Test
    void testEvaluarExpresionDivisionPorCero() {
        calculadora.setExpresion("10 0 /");
        Assertions.assertThrows(ArithmeticException.class, () -> {
            calculadora.evaluateExpression();
        }, "Se esperaba una ArithmeticException por división por cero");
    }

    @Test
    void testEvaluarExpresionVacia() {
        calculadora.setExpresion("");
        Assertions.assertThrows(IllegalStateException.class, () -> {
            calculadora.evaluateExpression();
        }, "Se esperaba una IllegalStateException por expresión vacía");
    }
}
