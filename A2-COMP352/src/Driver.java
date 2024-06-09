//Botao Yang (40213554) and Valerie Nguyen (40284261)
//COMP 352 AA Programming Assignment 2
//Due June 9 2024

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Driver {
   public static void main(String[] args) {
      Scanner sc = null;
      PrintWriter pw = null;
      try {
         sc = new Scanner(new FileInputStream("input.txt"));
         pw = new PrintWriter(new FileOutputStream("output.txt"));
         while (sc.hasNextLine()) {
            String expression = sc.nextLine();
            double answer = Calculator.evalExp(expression);
            pw.println("Expression: " + expression);
            pw.println("Answer: " + answer);
         }
         sc.close();
         pw.close();
      } catch (FileNotFoundException e) {
         System.out.println("File could not be opened.");
      }
   }
}
