import java.util.Stack;

public class Utilidades {

    public static int pasarAEntero(char c) {
        return Character.getNumericValue(c);
    }

    public static boolean esOperador(char c) {
        switch (c) {
            case '+':
            case '-':
            case '*':
            case '/':
                return true;
            default:
                return false;
        }
    }

    public static boolean esOperando(char c) {
        return ((c >= '0' && c <= '9') || c == 'x' || c == 'X');
    }

    /**
     * Código para pasar de infija a postfija, extraído de
     * https://www.geeksforgeeks.org/dsa/convert-infix-expression-to-postfix-expression/
     */
    // Function to return precedence of operators
    private static int prec(char c) {
        if (c == '^')
            return 3;
        else if (c == '/' || c == '*')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return -1;
    }

    // Function to check if operator is right-associative
    private static boolean isRightAssociative(char c) {
        return c == '^';
    }

    public static String infijaAPostFija(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If operand, add to result
            if (esOperando(c)) {
                if (i >= 1 && esOperando(s.charAt(i-1)))
                    throw new RuntimeException("ERROR: No puede haber operandos de más de un dígito.");
                else
                    res.append(c);
            }

            // If '(', push to stack
            else if (c == '(')
                st.push('(');

            // If ')', pop until '( '
            else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    res.append(st.pop());
                }
                st.pop();
            }

            // If operator
            else if (esOperador(c)) {
                while (!st.isEmpty() && st.peek() != '(' &&
                        (prec(st.peek()) > prec(c) ||
                                (prec(st.peek()) == prec(c) && !isRightAssociative(c)))) {
                    res.append(st.pop());
                }
                st.push(c);
            }
        }

        // Pop remaining operators
        while (!st.isEmpty()) {
            res.append(st.pop());
        }

        return res.toString();
    }

}

