public class Calculator {
    private static Stack<Integer> valStk;
	private static Stack<Character> opStk;

    public static double evalExp(String token) {
        int i = 0;
        while (i < token.length()-1) {
            char c = token.charAt(i);
            if (isNumber(c)) {
                String num = "";
                while (i < token.length()-1 && isNumber(c)) {
                    num += c;
                    c = token.charAt(++i);
                }
                i--;
                valStk.push(Integer.parseInt(num));
            }
        }
        
        return 0;
    }

    public static boolean isNumber(char c) {
        return (c >= '0' && c <= '9');
    }
}
