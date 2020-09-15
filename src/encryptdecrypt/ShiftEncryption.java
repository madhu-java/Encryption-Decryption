package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ShiftEncryption implements EncInterface {
    public void encrypt(InputData input) {
        //Scanner scanner = new Scanner(System.in);
        String inputString = "";
        StringBuilder sb = new StringBuilder();
        if (input.getData().matches(".*(\\.txt)$")) {
            // System.out.println("in enc file ");
            File file = new File(input.getData());
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNext()) {
                    inputString = scanner.nextLine();
                    sb.append(encShift(inputString, input.getKey()));
                    System.out.println(encShift(inputString, input.getKey()));
                }
                // System.out.println(sb.toString());
            } catch (IOException e) {
                System.out.println("ERROR from reading input.txt");
            }
            File outFile = new File(input.getOut());
            System.out.println("out file " + input.getOut());
            // PrintWriter printWriter = null;
            try (PrintWriter printWriter = new PrintWriter(outFile)) {
                //System.out.println("writing to file:"+sb.toString()+":");
                printWriter.write(sb.toString());
                System.out.println("written to file");

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        } else {
            //System.out.println("entering shife enc ");
            inputString = input.getData();
            encShift(inputString, input.getKey());
        }
    }
}


