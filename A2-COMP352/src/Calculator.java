public class Calculator {
    private static Stack<Double> valStk = new ArrayStack<>(); // Stack to hold values
    private static Stack<String> opStk = new ArrayStack<>(); // Stack to hold operators

    // Method to evaluate expression
    public static Double evalExp(String expression) {
        String[] tokens = expression.split(" "); // Break expression into tokens using " " as delimiter

        // Reset the stack
        while (!valStk.isEmpty()) {
            valStk.pop();
        }

        int i = 0;
        while (i < tokens.length) {
            String z = tokens[i];
            // If token is a number, push token to valStk
            if (isNumber(z)) {
                valStk.push(Double.parseDouble(z));
            } else if (z.equals(")")) { // If token is ")", evaluate operations inside the parentheses
                while (!opStk.top().equals("(")) {
                    doOp();
                }
                opStk.pop(); // Pop "(" inside stack
            } else { // If token is a operator, evaluate operation if current token has a lower precendence than top of opStk and push token to opStk
                repeatOps(z);
                opStk.push(z);
            }
            i++;
        }
        repeatOps("$"); // To evaluate all remaining operators
        return valStk.top();
    }

    // Method to peform higher or equal precedence operations
    public static void repeatOps(String op) {
        // If the top of opStk has a higher or equal precedence than op, perform operation
        while (valStk.size() > 1 && (prec(op) >= prec(opStk.top()))) {
            if (opStk.top().equals("(")) { // If top of opStk is "(", do nothing
                break;
            }
            doOp();
        }
    }

    // Method to evaluate operation
    public static void doOp() {
        String op = opStk.pop();
        double x = (double) valStk.pop();
        double y = (double) valStk.pop();

        switch (op) {
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
            case ">": // Push 1 for true and 0 for false
                if (y > x) {
                    valStk.push(1.0);
                } else
                    valStk.push(0.0);
                break;
            case ">=":
                if (y >= x) {
                    valStk.push(1.0);
                } else
                    valStk.push(0.0);
                break;
            case "<":
                if (y < x) {
                    valStk.push(1.0);
                } else
                    valStk.push(0.0);
                break;
            case "<=":
                if (y <= x) {
                    valStk.push(1.0);
                } else
                    valStk.push(0.0);
                break;
            case "==":
                if (y == x) {
                    valStk.push(1.0);
                } else
                    valStk.push(0.0);
                break;
            case "!=":
                if (y != x) {
                    valStk.push(1.0);
                } else
                    valStk.push(0.0);
                break;
        }
    }

    // Method to determine if the String is a number
    public static boolean isNumber(String z) {
        try {
            Double.parseDouble(z);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Method to determine the precedence of an operator
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
}
