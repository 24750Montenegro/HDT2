package uvg.edu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Calculadora calculator = new Calculadora();
        String archivo = "src/main/java/uvg/edu/datos.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String expression;
            while ((expression = reader.readLine()) != null) {
                try {
                    int result = calculator.evaluar(expression);
                    System.out.println("Expresión: " + expression );
                    System.out.println("Resultado = " + result);
                    System.out.println();
                } catch (Exception e) {
                    System.out.println("Error evaluando '" + expression + "': " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo: " + e.getMessage());
        }
    }
}