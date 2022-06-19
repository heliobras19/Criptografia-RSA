package RSA;

import java.math.BigInteger;

public class Encrypt {
    private BigInteger n;
    private BigInteger e;
    public Encrypt(BigInteger nValue, BigInteger eValue){
        this.e = eValue;
        this.n = nValue;
    }

    public String encryptor(String sms){
        String smsEncript = new BigInteger(sms.getBytes()).modPow(this.e, this.n).toString();
        return smsEncript;
    }
}
