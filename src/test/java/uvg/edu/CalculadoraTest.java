package uvg.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

/**
 * The CalculadoraTest class contains unit tests for the Calculadora class.
 * Authors:
 *  Javier Alvarado 24546
 *  Juan Montenegro 24750
 *  Jonathan Tubac 24484
 */
public class CalculadoraTest {

    private Calculadora calculadora;

    /**
     * Sets up a new instance of Calculadora before each test.
     */
    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    /**
     * Tests reading and evaluating an expression from a file.
     *
     * @throws IOException if an I/O error occurs
     */
    @Test
    void testLeerYEvaluarExpresion() throws IOException {
        String archivo = "src/main/java/uvg/edu/datos.txt";
        calculadora.readFromFile(archivo);

        int resultado = calculadora.evaluateExpression();
        Assertions.assertEquals(3, resultado);
    }

    /**
     * Tests evaluating an expression that results in division by zero.
     * Expects an ArithmeticException to be thrown.
     */
    @Test
    void testEvaluarExpresionDivisionPorCero() {
        calculadora.setExpresion("10 0 /");
        Assertions.assertThrows(ArithmeticException.class, () -> {
            calculadora.evaluateExpression();
        }, "Se esperaba una ArithmeticException por división por cero");
    }

    /**
     * Tests evaluating an empty expression.
     * Expects an IllegalStateException to be thrown.
     */
    @Test
    void testEvaluarExpresionVacia() {
        calculadora.setExpresion("");
        Assertions.assertThrows(IllegalStateException.class, () -> {
            calculadora.evaluateExpression();
        }, "Se esperaba una IllegalStateException por expresión vacía");
    }
}