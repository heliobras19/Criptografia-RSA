package RSA;


import files.WriteKeys;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;

public class GenerateKey {
    private BigInteger d;
    private BigInteger n;
    private BigInteger e;
    private BigInteger p;
    private BigInteger q;
    private BigInteger fiN;
    public GenerateKey() throws IOException {
        SecureRandom random = new SecureRandom();
        WriteKeys writeKeys = new WriteKeys();
        int bitlen = 2048;
        this.p = new BigInteger(bitlen / 2, 100, random);
        this.q = new BigInteger(bitlen / 2, 100, random);
        this.n = this.p.multiply(q);
        this.fiN = p.subtract(new BigInteger("1")).multiply(q.subtract(new BigInteger("1")));
        this.e = new BigInteger("3");
        while(this.fiN.gcd(this.e).intValue() > 1) {
            this.e = this.e.add(new BigInteger("2"));
        }
        this.d = e.modInverse(this.fiN);
      //  writeKeys.write(textKey());
    }

    private String textKey(){
        String textKey = "" +
                "As suas chaves são as seguintes:\n" +
                "d: "+this.d.toString()+ "\n" +
                "e: "+this.e.toString()+ "\n" +
                "n: "+this.n.toString() ;
        return textKey;
    }



    public BigInteger getN() {
        return this.n;
    }

    public BigInteger getE() {
        return this.e;
    }

    public BigInteger getD() {
        return this.d;
    }

    public void setE(BigInteger e) {
        this.e = e;
    }

    public void setN(BigInteger n) {
        this.n = n;
    }
}
