package projeto.sistema;

import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializacao {

    public static void serializar(Object obj, String filePath) {
        try {
            File file = new File(filePath);
            file.getParentFile().mkdirs();

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath));
            out.writeObject(obj);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
    
}