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

        // Try-with-resources to ensure the BufferedReader is closed after use
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String expression;
            // Read each line (expression) from the file
            while ((expression = reader.readLine()) != null) {
                try {
                    // Evaluate the expression and print the result
                    int result = calculator.evaluar(expression);
                    System.out.println("Expresión: " + expression );
                    System.out.println("Resultado = " + result);
                    System.out.println();
                } catch (Exception e) {
                    // Handle any exceptions that occur during evaluation
                    System.out.println("Error evaluando '" + expression + "': " + e.getMessage());
                }
            }
        } catch (IOException e) {
            // Handle any exceptions that occur during file reading
            System.out.println("Error leyendo el archivo: " + e.getMessage());
        }
    }
}