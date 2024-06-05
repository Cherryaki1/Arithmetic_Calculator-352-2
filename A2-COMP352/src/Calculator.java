public class Calculator {
    private static Stack<Object> valStk = new ArrayStack<>();
    private static Stack<String> opStk = new ArrayStack<>();

    public static Object evalExp(String expression) { // returns either a number or true/false
        String[] tokens = expression.split(" ");
        int i = 0;
        while (i < tokens.length) {
            String z = tokens[i];
            if (isNumber(z)) {
                valStk.push(Double.parseDouble(z));
            } else {
                repeatOps(z);
                opStk.push(z);
            }
            i++;
        }
        repeatOps("$");
        return valStk.top();
    }

    public static void repeatOps(String z) {
        while (valStk.size() > 1 && (prec(z) >= prec(opStk.top()))) {
            doOp();
        }
    }

    public static void doOp() {
        double x = (double) valStk.pop();
        double y = (double) valStk.pop();
        String op = opStk.pop();
        switch (op) {
            case "(":

                break;
            case ")": // to fix
                break;
            case "+":
                valStk.push(y + x);
                break;
            case "-":
                valStk.push(y - x);
                break;
            case "*":
                valStk.push(y * x);
                break;
            case "/":
                valStk.push(y / x);
                break;
            case "^":
                valStk.push(Math.pow(y, x));
                break;
            case ">":
                valStk.push(y > x);
                break;
            case ">=":
                valStk.push(y >= x);
                break;
            case "<":
                valStk.push(y < x);
                break;
            case "<=":
                valStk.push(y <= x);
                break;
            case "==":
                valStk.push(y == x);
                break;
            case "!=":
                valStk.push(y != x);
                break;
        }
    }

    public static boolean isNumber(String z) {
        for (int i = 0; i < z.length(); i++) {
            if (z.charAt(i) < '0' || z.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    public static int prec(String op) {
        switch (op) {
            case "(":
            case ")":
                return 1;
            case "^":
                return 2;
            case "*":
            case "/":
                return 3;
            case "+":
            case "-":
                return 4;
            case ">":
            case "<":
            case ">=":
            case "<=":
                return 5;
            case "==":
            case "!=":
                return 6;
            case "$":
                return 7;
        }
        return -1;
    }

    public boolean ParenMatch(String[] tokens) {
        int n = tokens.length;
        for (int i = 0; i < n; i++) {
            if (tokens[i].equals("(")) {
                opStk.push(tokens[i]);
            } else if (tokens[i].equals(")")) {
                if (opStk.isEmpty()) {
                    return false;
                }
                if (opStk.pop() != "(") {
                    return false;
                }
            }
        }
        if (opStk.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
