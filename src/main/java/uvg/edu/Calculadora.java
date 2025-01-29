package uvg.edu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The Calculadora class provides a method to evaluate arithmetic expressions
 * using a stack-based approach.
 * Authors:
 * Javier Alvarado 24546
 * Juan Montenegro 24750
 * Jonathan Tubac 24484
 */
public class Calculadora implements IPostfixCalculator {

    private String expresion;
    /**
     * Evaluates an arithmetic expression in Reverse Polish Notation (RPN).
     *
     * @param expression the arithmetic expression to evaluate
     * @return the result of the evaluated expression
     * @throws IllegalArgumentException if the expression is invalid
     * @throws ArithmeticException if there is an attempt to divide by zero
     */

    private StackVector<Integer> pila = new StackVector<Integer>();

    @Override
    public void readFromFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linea;
            if ((linea = br.readLine()) != null) {
                this.expresion = linea;
                System.out.println("Contenido leído: " + this.expresion);
            }
        } catch (IOException e) {
            throw new IOException("Error leyendo el archivo: " + e.getMessage());
        }
    }


    @Override
    public int evaluateExpression() throws IllegalArgumentException {
        if (expresion == null || expresion.isEmpty()) {
            throw new IllegalStateException("No hay expresión para evaluar");
        }

        String[] tokens = expresion.split(" ");
        for (String token : tokens) {
            if (esOperando(token)) {
                pila.push(Integer.parseInt(token));
            } else if (esOperador(token)) {
                int operandoB = pila.pop();
                int operandoA = pila.pop();

                int resultado;
                switch (token) {
                    case "+":
                        resultado = operandoA + operandoB;
                        break;
                    case "-":
                        resultado = operandoA - operandoB;
                        break;
                    case "*":
                        resultado = operandoA * operandoB;
                        break;
                    case "/":
                        if (operandoB == 0) {
                            throw new ArithmeticException("División por cero");
                        }
                        resultado = operandoA / operandoB;
                        break;
                    case "%":
                        resultado = operandoA % operandoB;
                        break;
                    default:
                        throw new IllegalArgumentException("Operador desconocido: " + token);
                }
                pila.push(resultado);
            }
        }
        return pila.pop();
    }

    /**
     * Checks if a token is an operator.
     *
     * @param token the token to check
     * @return true if the token is an operator, false otherwise
     */
    private boolean esOperador(String token) {
        return "+-*/%".contains(token);
    }
    private boolean esOperando(String token) {
        return token.matches("\\d+(\\.\\d+)?"); // Matches integers and decimals
    }
    }