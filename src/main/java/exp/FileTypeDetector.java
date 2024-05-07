package exp;

import org.apache.tika.Tika;

import java.io.File;
import java.io.IOException;

public class FileTypeDetector {

        public static void main (String [] arg) {
            File file = new File("/Users/marina/Documents/Нумерология_Компас/арканы Егор/9 Отшельник.jpg");
            Tika tika = new Tika();
            try {
                String fileType = tika.detect(file);
                System.out.println("File type: " + fileType);
            }catch (IOException e) {e.printStackTrace();}

    }

}
