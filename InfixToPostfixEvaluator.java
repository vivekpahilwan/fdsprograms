import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfixEvaluator {

    static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/');
    }

    static int getPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }

    static String infixToPostfix(String infixExpression) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>();

        for (char c : infixExpression.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                operatorStack.push(c);
            } else if (c == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfix.append(operatorStack.pop());
                }
                operatorStack.pop(); // Pop the '('
            } else if (isOperator(c)) {
                while (!operatorStack.isEmpty() && getPrecedence(c) <= getPrecedence(operatorStack.peek())) {
                    postfix.append(operatorStack.pop());
                }
                operatorStack.push(c);
            }
        }

        while (!operatorStack.isEmpty()) {
            postfix.append(operatorStack.pop());
        }

        return postfix.toString();
    }

    static int evaluatePostfix(String postfixExpression) {
        Stack<Integer> operandStack = new Stack<>();

        for (char c : postfixExpression.toCharArray()) {
            if (Character.isDigit(c)) {
                operandStack.push(Character.getNumericValue(c));
            } else if (isOperator(c)) {
                int operand2 = operandStack.pop();
                int operand1 = operandStack.pop();

                switch (c) {
                    case '+':
                        operandStack.push(operand1 + operand2);
                        break;
                    case '-':
                        operandStack.push(operand1 - operand2);
                        break;
                    case '*':
                        operandStack.push(operand1 * operand2);
                        break;
                    case '/':
                        operandStack.push(operand1 / operand2);
                        break;
                }
            }
        }

        return operandStack.pop();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter infix expression: ");
        String infixExpression = scanner.nextLine();

        scanner.close();

        String postfixExpression = infixToPostfix(infixExpression);

        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);

        int result = evaluatePostfix(postfixExpression);
        System.out.println("Result after evaluation: " + result);
    }
}