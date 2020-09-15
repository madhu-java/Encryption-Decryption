package encryptdecrypt;

import java.io.IOException;

public class ContextForEncDec {
    EncInterface encInterface;
    DecInterface decInterface;
    public ContextForEncDec(EncInterface encInterface){
        this.encInterface = encInterface;
    }
    public ContextForEncDec(DecInterface decInterface){
        this.decInterface = decInterface;
    }
    public void enc(InputData input) throws IOException {
        this.encInterface.encrypt(input);
    }
    public void dec(InputData input) throws IOException {
        this.decInterface.decrypt(input);
    }
}
