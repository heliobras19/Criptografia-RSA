package files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static String read() throws IOException {
        String s;
        String fileName;
        fileName = "sms.txt";
        BufferedReader f = null;
        try {
            f = new BufferedReader(new FileReader(fileName));
        }catch (IOException e){
            System.out.println("Não é possivel abrir o ficheiro");
            System.out.println("Exit...");
            return "";
        }
        s = f.readLine();

        f.close();
        return s;

    }
}
