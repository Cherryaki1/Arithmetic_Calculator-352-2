import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
      String expression = "2 * ( 6 - ( 3 + 2 ) )";
      System.out.println(Calculator.evalExp(expression));
      /*Scanner sc = null;
      PrintWriter pw = null;
         try {
            sc = new Scanner(new FileInputStream("input.txt"));
            pw = new PrintWriter(new FileOutputStream("output.txt"));
            while (sc.hasNextLine()) {
               String expression = sc.nextLine();
               double answer = Calculator.evalExp(expression);
               pw.println(expression + " = ");
               pw.print(answer);
            }
            sc.close();
            pw.close();
         } catch (FileNotFoundException e) {
            System.out.println("File could not be opened.");
         }*/
    }
}
