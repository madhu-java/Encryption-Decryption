package encryptdecrypt;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String mode = "enc";

        String alg = "shift";
        InputData inputdata = new InputData();
        if (args.length == 0) {
            encryptAString();
            return;
        }

        for (int j = 0; j < args.length; j = j + 2) {
            if (args[j].equals("-mode")) {
                //inputdata.setMode( args[j + 1]);
                mode = args[j + 1];
            }
            if (args[j].equals("-key")) {
                inputdata.setKey(Integer.parseInt(args[j + 1]));
            }
            if (args[j].equals("-data")) {
                inputdata.setData(args[j + 1]);
                //data = args[j + 1];
            }
            if (args[j].equals("-in")) {
                inputdata.setIn(args[j + 1]);
                //in = args[j + 1];
            }
            if (args[j].equals("-out")) {
                inputdata.setOut(args[j + 1]);
                // out = args[j + 1];
            }
            if (args[j].equals("-alg")) {
                alg = args[j + 1];
            }

        }

        switch (mode) {
            case "enc":
                ContextForEncDec contextForEnc = new ContextForEncDec(selectEncAlogorithem(inputdata, alg));
                try {
                    contextForEnc.enc(inputdata);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "dec":
                ContextForEncDec contextForDec = new ContextForEncDec(selectDecAlogorithem(inputdata, alg));
                try {
                    contextForDec.dec(inputdata);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

        }
    }


    public static DecInterface selectDecAlogorithem(InputData input, String alg) {
        //if (mode.equals("enc") && data.equals(in) && !in.isEmpty()) {
        if (input.getData().matches(".*(\\.txt)$") && alg.equals("unicode")) {
            //System.out.println("calluing file enc");
            //encFile(data, key, out);
            return new UnicodeDecryption();
            //
        } else if (alg.equals("shift")) {
            // enc(data, key);
            return new ShiftDecryption();

        }
        return null;
    }

    public static EncInterface selectEncAlogorithem(InputData input, String alg) {
        //if (mode.equals("enc") && data.equals(in) && !in.isEmpty()) {
        if (input.getData().matches(".*(\\.txt)$") && alg.equals("unicode")) {
            //System.out.println("calluing file enc");
            //encFile(data, key, out);
            return new UnicodeEncryption();
            //
        } else if (alg.equals("shift")) {
            // enc(data, key);
            return new ShiftEncryption();

        }

        return null;
    }


    private static void decToFile(String out, int key) {
        File file = new File(out);
        StringBuilder sb = new StringBuilder();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                sb.append(scanner.nextLine());
            }
            dec(sb.toString(), key);
        } catch (IOException e) {
            System.out.println("ERROR");
        }
    }

    private static void encDecWithAKey() {
        Scanner scanner = new Scanner(System.in);
        String operation = scanner.nextLine();
        String inputString = scanner.nextLine();
        int key = scanner.nextInt();
        if (operation.equals("enc")) {
            enc(inputString, key);
        } else if (operation.equals("dec")) {
            dec(inputString, key);
        }
    }

    private static void dec(String inputString, int key) {
        for (char c : inputString.toCharArray()) {
            System.out.print((char) (c - key));
        }
    }

    private static void enc(String inputString, int key) {
        for (char c : inputString.toCharArray()) {
            //System.out.println("c= "+c+" key= "+key);
            System.out.print((char) (c + key));
        }
    }


    //encrypt a string by changing a->z..z->a
    private static void encryptAString() {
        String input = "we found a treasure!";  //scanner.nextLine();
        StringBuffer sb = new StringBuffer();

        for (char c : input.toCharArray()) {
            if (String.valueOf(c).matches("[a-z]")) {
                //sb.append((char) ('a' + (26 + 'a' - c - 1)));
                sb.append((char) ('a' + ('z' - c)));
            } else {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }
}