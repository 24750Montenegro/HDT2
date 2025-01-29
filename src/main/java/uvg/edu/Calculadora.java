package uvg.edu;

public class Calculadora {
  public int evaluar(String expression) {
      StackVector<Integer> stack = new StackVector<>();
      String[] tokens = expression.split(" ");

      for (String token : tokens) {
          if (token.matches("\\d+")) { // Si es número
              stack.push(Integer.parseInt(token));
          } else { // Si es operador
              if (stack.size() < 2) throw new IllegalArgumentException("Expresión inválida.");
              int b = stack.pop();
              int a = stack.pop();
              switch (token) {
                  case "+": stack.push(a + b); break;
                  case "-": stack.push(a - b); break;
                  case "*": stack.push(a * b); break;
                  case "/":
                      if (b == 0) throw new ArithmeticException("División por cero.");
                      stack.push(a / b);
                      break;
                  case "%": stack.push(a % b); break;
                  default: throw new IllegalArgumentException("Operador desconocido: " + token);
              }
          }
      }
      if (stack.size() != 1) throw new IllegalArgumentException("Expresión inválida.");
      return stack.pop();
  }
}
