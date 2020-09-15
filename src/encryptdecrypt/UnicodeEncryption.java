package encryptdecrypt;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class UnicodeEncryption implements EncInterface {
    @Override
    public void encrypt(InputData input) {
        //private static void encFile(String in ,int key,String out){
        if (input.getData().matches(".*(\\.txt)$")) {
            File file = new File(input.getIn());
            StringBuilder sb = new StringBuilder();
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNext()) {
                    for (char c : scanner.nextLine().toCharArray()) {
                        sb.append((char) (c + input.getKey()));
                    }
                }
            } catch (IOException e) {
                System.out.println("ERROR");
                //System.out.println(e.getMessage());
            }
            if (input.getOut().isEmpty()) {
                System.out.println(sb.toString());
            } else {
                File outFile = new File(input.getOut());
                try (PrintWriter printWriter = new PrintWriter(outFile)) {
                    printWriter.printf("%s", sb.toString());
                } catch (IOException e) {
                    System.out.println("ERROR");
                }

            }
            File print = new File(input.getOut());
            try (Scanner scanner = new Scanner(print)) {
                while (scanner.hasNext()) {
                    System.out.println(scanner.nextLine());
                }
            } catch (IOException e) {
                System.out.println("ERROR");
            }

        } else {
            encUnicode(input.getData(), input.getKey());
        }
    }
}
