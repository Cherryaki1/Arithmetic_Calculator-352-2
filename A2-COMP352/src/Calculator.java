public class Calculator {
    private static Stack<Double> valStk;
    private static Stack<Character> opStk;

    public static double evalExp(String token) {
        int i = 0;
        while (i < token.length() - 1) {
            char c = token.charAt(i);
            if (isNumber(c)) {
                String num = "";
                while (i < token.length() - 1 && isNumber(c)) {
                    num += c;
                    c = token.charAt(++i);
                }
                i--;
                valStk.push(Double.parseDouble(num));
            } else {
                repeatOps(c);
                opStk.push(c);
            }
        }
        repeatOps('$');
        return valStk.top();
    }

    public static void repeatOps(char c) {
        while (valStk.size() > 1 && prec(c) <= prec(opStk.top())) {
            doOp();
        }
    }

    public static void doOp() {
        double x = valStk.pop();
        double y = valStk.pop();
        char op = opStk.pop();
        switch (op) {
            case '+':
                valStk.push(y + x);
                break;
            case '-':
                valStk.push(y - x);
                break;
            case '*':
                valStk.push(y * x);
                break;
            case '/':
                valStk.push(y / x);
                break;
            case '^':
                valStk.push(Math.pow(y, x));
                break;
            // >, >=, <, <=, ==, !=
        }
    }

    public static boolean isNumber(char c) {
        return (c >= '0' && c <= '9');
    }

    public static int prec(char op) {
        switch (op) {
            case '(':
            case ')':
                return 1;
            case '^':
                return 2;
            case '*':
            case '/':
                return 3;
            case '+':
            case '-':
                return 4;
            case '>':
            case '<':
                return 5;
            case '$':
                return 6;
            // >=, <=, ==, !=
        }
        return -1;
    }
}
