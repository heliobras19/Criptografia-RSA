package files;

import java.io.*;

public class WriteKeys {
    public void write(String keys) throws IOException {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("Keys.txt"));
           writer.write(keys);
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
