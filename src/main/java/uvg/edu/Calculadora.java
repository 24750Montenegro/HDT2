package uvg.edu;

/**
 * The Calculadora class provides a method to evaluate arithmetic expressions using a stack-based approach.
 * Authors:
 *  Javier Alvarado 24546
 *  Juan Montenegro 24750
 *  Jonathan Tubac 24484
 */
public class Calculadora {

    /**
     * Evaluates an arithmetic expression in Reverse Polish Notation (RPN).
     *
     * @param expression the arithmetic expression to evaluate
     * @return the result of the evaluated expression
     * @throws IllegalArgumentException if the expression is invalid
     * @throws ArithmeticException if there is an attempt to divide by zero
     */
    public int evaluar(String expression) {
        StackVector<Integer> stack = new StackVector<>();
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (token.matches("\\d+")) { // If the token is a number
                stack.push(Integer.parseInt(token));
            } else { // If the token is an operator
                if (stack.size() < 2) throw new IllegalArgumentException("Expresión inválida.");
                int b = stack.pop();
                int a = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        if (b == 0) throw new ArithmeticException("División por cero.");
                        stack.push(a / b);
                        break;
                    case "%":
                        stack.push(a % b);
                        break;
                    default:
                        throw new IllegalArgumentException("Operador desconocido: " + token);
                }
            }
        }
        if (stack.size() != 1) throw new IllegalArgumentException("Expresión inválida.");
        return stack.pop();
    }
}