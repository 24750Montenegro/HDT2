package uvg.edu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The Calculadora class provides a method to evaluate arithmetic expressions using a stack-based approach.
 * Authors:
 *  Javier Alvarado 24546
 *  Juan Montenegro 24750
 *  Jonathan Tubac 24484
 */
public class Calculadora implements IPostfixCalculator {

    private String expresion;
    private StackVector<Integer> pila = new StackVector<Integer>();

    /**
     * Reads an arithmetic expression from a file.
     *
     * @param path the path to the file containing the expression
     * @throws IOException if an I/O error occurs
     */
    private List<String> expresiones = new ArrayList<>();

    @Override
    public void readFromFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                expresiones.add(linea);
            }
        } catch (IOException e) {
            throw new IOException("Error leyendo el archivo: " + e.getMessage());
        }
    }

    public List<String> getExpresiones() {
        return expresiones;
    }

    public void setExpresion(String expresion) {
        this.expresion = expresion;
    }

    /**
     * Evaluates an arithmetic expression in Reverse Polish Notation (RPN).
     *
     * @return the result of the evaluated expression
     * @throws IllegalArgumentException if the expression is invalid
     * @throws IllegalStateException if there is no expression to evaluate
     * @throws ArithmeticException if there is an attempt to divide by zero
     */
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
                if(pila.size() < 2){
                    throw new IllegalArgumentException("Faltan operandos");
                }
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

    /**
     * Checks if a token is an operand.
     *
     * @param token the token to check
     * @return true if the token is an operand, false otherwise
     */
    private boolean esOperando(String token) {
        return token.matches("\\d+(\\.\\d+)?"); // Matches integers and decimals
    }
}