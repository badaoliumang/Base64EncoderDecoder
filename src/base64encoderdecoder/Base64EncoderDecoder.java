/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base64encoderdecoder;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author zoraf
 */
public class Base64EncoderDecoder {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
         File file =  new File("/home/zoraf/Pictures/image.jpg");
         String encodedString = encodeFileToBase64Binary(file);
//         System.out.println(encodedString);
        decodeBase64encodedStringToImage(encodedString);
        
    }
    private static void decodeBase64encodedStringToImage(String base64encodedString){
        byte[] data = DatatypeConverter.parseBase64Binary(base64encodedString);
        File file = new File ("/home/zoraf/Pictures/newImage.jpg");
        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            outputStream.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String encodeFileToBase64Binary(File file) throws IOException{
            String encodedfile = null;
            try {
                FileInputStream fileInputStreamReader = new FileInputStream(file);
                byte[] bytes = new byte[(int)file.length()];
                fileInputStreamReader.read(bytes);
                encodedfile = new String(Base64.getEncoder().encodeToString(bytes));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return encodedfile;
        }
    
}
