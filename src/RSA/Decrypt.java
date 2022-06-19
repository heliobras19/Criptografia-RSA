package RSA;

import java.math.BigInteger;

public class Decrypt {
    private BigInteger d;
    private BigInteger n;

    public Decrypt(BigInteger dValue, BigInteger nValue){
        this.d = dValue;
        this.n = nValue;
    }

    public String decifarad(String sms){
        String smsDecript = new String(new BigInteger(sms).modPow(d, n).toByteArray());
        return smsDecript;
    }
}
