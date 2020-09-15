package encryptdecrypt;

public interface DecInterface {
    void decrypt(InputData inputData);

    default void decUnicode(String inputString, int key) {
        for (char c : inputString.toCharArray()) {
            System.out.print((char) (c - key));
        }
    }

    default String decShift(String inputString, int key) {
        StringBuilder sb = new StringBuilder();
        for (char c : inputString.toCharArray()) {
            if (String.valueOf(c).matches("[a-z]")) {
                // System.out.println("before "+(int)c);
                c = (char) ((c - key) >= 97 ? c - key : c - key + 26);
                //System.out.println("after "+c);
                // System.out.print(c);
                sb.append(c);
            } else if (String.valueOf(c).matches("[A-Z]")) {
                // System.out.println("before "+(int)c);
                c = (char) ((c - key) >= 65 ? c - key : c - key + 26);
                sb.append(c);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
