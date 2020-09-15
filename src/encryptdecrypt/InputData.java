package encryptdecrypt;

public class InputData {
    int x = 0;
    String mode = "enc";
    int key = 0;
    String data = "";
    String in = "";
    String out = "";
    // String alg = "shift";

    public void setX(int x) {
        this.x = x;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setIn(String in) {
        this.in = in;
    }

    public void setOut(String out) {
        this.out = out;
    }

    public int getX() {
        return x;
    }

    public String getMode() {
        return mode;
    }

    public int getKey() {
        return key;
    }

    public String getData() {
        if (!data.isEmpty()) {
            return data;
        }
        return in;
    }

    public String getIn() {
        return in;
    }

    public String getOut() {
        return out;
    }
//    if (data.isEmpty() && !in.isEmpty()) {
//        setData(in);
//    }
//    public void setAlg(String alg) {
//        this.alg = alg;
//    }
}
