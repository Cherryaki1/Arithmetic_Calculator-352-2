import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
         Scanner sc = null;
         try {
            sc = new Scanner(new FileInputStream("test.txt"));
            while (sc.hasNextLine()) {
                
            }

         } catch (FileNotFoundException e) {
            System.out.println("File could not be opened.");
         }
    }
}
