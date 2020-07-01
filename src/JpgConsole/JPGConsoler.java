package JpgConsole;

import javax.imageio.ImageIO;
import java.io.*;

public class JPGConsoler {

    public static void main(String[] args) throws IOException {
        String oldPath = "D:\\1\\1\\2\\072.jpg";
        String sortPath = "D:\\temp\\";
        File file =new File(sortPath + "A");
        if(!file.exists()) {
            file.mkdir();
        }
        File oldName = new File(oldPath);
        File newName = new File(sortPath+"A"+"\\"+oldPath.substring(oldPath.lastIndexOf("\\") + 1));
        System.out.println(oldName.renameTo(newName));
    }
}
