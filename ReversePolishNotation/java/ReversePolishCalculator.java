import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * This is the simple implementation of a calculator using the Reverse Polish notation.
 * 
 * The input has to be an operation separated with spaces. For example: 5 1 2 + 4 * + 3 - 
 */
public class ReversePolishCalculator {
    public static double calculatePolishNotation(String input) {
        Stack<Double> valueStack = new Stack<>();
        for(String s : input.split(" ")) {
            if(isNumeric(s)) {
                valueStack.push(Double.parseDouble(s));
            }
            else {
                if(valueStack.size() < 2) {
                    throw new IllegalArgumentException("Too few values on the stack to perform the operation!");
                }
                double b = valueStack.pop();
                double a = valueStack.pop();
                valueStack.push(doOperation(a, b, s));
            }
        }
        if(valueStack.size() != 1) {
            throw new IllegalArgumentException("Too many values remained on the value stack. Something is missing.");
        }
        return valueStack.pop();
        
    }
    
    private static double doOperation(double a, double b, String operation) {
        switch(operation) {
        case "+":
            return a + b;
        case "-":
            return a - b;
        case "*": 
            return a * b;
        case "/": 
            if(b == 0.0) {
                return 0.0;
            }
            return a / b;
        case "^":
            return Math.pow(a, b);
        default:
            System.out.println("Unknown operation " + operation);
            System.out.println("Returning 0 as the result");
            return 0.0;
        }
    }
    
    private static boolean isNumeric(String str)
    {
      return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }
}
