package fr.km.io;

import java.io.*;

/**
 * with byte
 */
public class ByteArrayService {

    public static void main(String[] args) {

        File file =  new File("c:/tmp/test.txt");
        byte[] buffer;
        try (InputStream is = new FileInputStream(file);
             BufferedInputStream bis = new BufferedInputStream(is);
             ByteArrayOutputStream bos = new ByteArrayOutputStream()){

            byte[] bytes = new byte[1024];
            int count = bis.read(bytes);
            while (count != -1 ){
                bos.write(bytes, 0, count);
                count = bis.read(bytes);
            }
            bos.flush();
            buffer = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
