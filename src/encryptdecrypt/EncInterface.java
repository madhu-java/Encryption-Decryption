package encryptdecrypt;

import java.io.FileNotFoundException;

public interface EncInterface {
    void encrypt(InputData input) throws FileNotFoundException;

    default void encUnicode(String inputString, int key) {
        for (char c : inputString.toCharArray()) {
            //System.out.println("c= "+c+" key= "+key);
            System.out.print((char) (c + key));
        }
    }

    default String encShift(String inputString, int key) {
        StringBuilder sb = new StringBuilder();
        for (char c : inputString.toCharArray()) {
            //System.out.println("cutrrent char  "+c);
            if (String.valueOf(c).matches("[a-z]")) {
                // System.out.println("before "+(int)c);
                c = (char) ((c + key) > 122 ? c + key - 26 : c + key);
                sb.append(c);
                // System.out.println("small aipha "+c);
            } else if (String.valueOf(c).matches("[A-Z]")) {
                // System.out.println("before "+(int)c);
                c = (char) ((c + key) > 90 ? c + key - 26 : c + key);
                sb.append(c);
                //System.out.println("big aipha "+c);
            } else {
                sb.append(c);
                //System.out.println("not aipha "+c);
            }
        }
        return sb.toString();
    }
}

