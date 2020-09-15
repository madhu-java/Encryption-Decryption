package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ShiftDecryption implements DecInterface {
    public void decrypt(InputData input) {
        //Scanner scanner = new Scanner(System.in);
        String inputString = "";
        StringBuilder sb = new StringBuilder();
        if (input.getData().matches(".*(\\.txt)$")) {
            File file = new File(input.getData());
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNext()) {
                    inputString = scanner.nextLine();
                    System.out.println("inputstring " + inputString + "key " + input.getKey());
                    System.out.println("deshift " + decShift(inputString, input.getKey()));
                    sb.append(decShift(inputString, input.getKey()));
                }
            } catch (IOException e) {
                System.out.println("ERROR");
            }
            File outFile = new File(input.getOut());
            // PrintWriter printWriter = null;
            try (PrintWriter printWriter = new PrintWriter(outFile)) {
                printWriter.print(sb.toString());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


        } else {
            decShift(inputString, input.getKey());
        }
    }
}
