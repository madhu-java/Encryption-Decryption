package encryptdecrypt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //String [] input = args.split(" ");
        //enc-dec with command line args
        int x = 0;
        String mode = "enc";
        int key = 0;
        String data = "";


        for (int j = 0; j < args.length; j = j + 2) {
            if (args[j].equals("-mode")) {
                mode = args[j + 1];
            }
            if (args[j].equals("-key")) {
                key = Integer.parseInt(args[j + 1]);
            }
            if (args[j].equals("-data")) {
                data = args[j + 1];
            }
        }

        if (mode.equals("enc")) {
            enc(data, key);
        } else if (mode.equals("dec")) {
            dec(data, key);
        }

        //enc or dec with specified key
        //encDecWithAKey();

        //encOfaTOzAround();
        //encryptAString();
    }

    private static void encDecWithAKey() {
        Scanner scanner = new Scanner(System.in);
        String operation =  scanner.nextLine();
        String inputString = scanner.nextLine();
        int key = scanner.nextInt();
        if(operation.equals("enc")){
            enc(inputString, key);
        }else if(operation.equals("dec")){
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

    //encrypt by adding key
    private static void encOfaTOzAround() {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        int key = scanner.nextInt();
        for (char c : inputString.toCharArray()) {
            if (String.valueOf(c).matches("[a-z]")) {
                // System.out.println("before "+(int)c);
                c = (char) ((c + key) > 122 ? c + key - 26 : c + key);
                //System.out.println("after "+c);
                System.out.print(c);
            } else {
                //System.out.println("not char c "+(int)c);
                System.out.print(c);
            }
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