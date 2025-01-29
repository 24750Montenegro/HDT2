package uvg.edu;

import java.io.IOException;

/**
 * The IPostfixCalculator interface defines the basic operations for a postfix calculator.
 * Authors:
 *  Javier Alvarado 24546
 *  Juan Montenegro 24750
 *  Jonathan Tubac 24484
 */
public interface IPostfixCalculator {
    /**
     * Reads expressions from a file.
     *
     * @param path the path to the file containing the expressions
     * @throws IOException if an I/O error occurs
     */
    void readFromFile(String path) throws IOException;

    /**
     * Evaluates the expression read from the file.
     *
     * @return the result of the evaluated expression
     * @throws IllegalArgumentException if the expression is invalid
     */
    int evaluateExpression() throws IllegalArgumentException;
}