package encryptdecrypt;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
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