package uvg.edu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The Main class reads expressions from a file and evaluates them using the Calculadora class.
 *
 * Authors:
 * - Javier Alvarado 24546
 * - Juan Montenegro 24750
 * - Jonathan Tubac 24484
 *
 */
public class Main {
    /**
     * The main method is the entry point of the application.
     * It reads expressions from a file and evaluates them.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Calculadora calculator = new Calculadora();
        String archivo = "src/main/java/uvg/edu/datos.txt";

        try {
            calculator.readFromFile(archivo);
            System.out.println("Resultado: " + calculator.evaluateExpression());
        } catch (IOException e) {
            System.err.println("Error leyendo el archivo: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error evaluando la expresión: " + e.getMessage());
        }
    }
}