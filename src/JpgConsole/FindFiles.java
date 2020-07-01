package JpgConsole;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindFiles {
    public static void main(String[] args) {
        folderMethod1("D:\\1\\1");
    }

    public static List folderMethod1(String path) {
        List result = new ArrayList<String>();
        int fileNum = 0, folderNum = 0;
        File file = new File(path);
        LinkedList<File> list = new LinkedList<>();

        if (file.exists()) {
            if (null == file.listFiles()) {
                return null;
            }
            list.addAll(Arrays.asList(file.listFiles()));
            while (!list.isEmpty()) {
                File[] files = list.removeFirst().listFiles();
                if (null == files) {
                    continue;
                }
                for (File f : files) {
                    if (f.isDirectory()) {
                        System.out.println("�ļ���:" + f.getAbsolutePath());
                        list.add(f);
                        folderNum++;
                    } else {
                        System.out.println("�ļ�:" + f.getAbsolutePath());
                        result.add(f.getAbsolutePath());
                        fileNum++;
                    }
                }
            }
        } else {
            System.out.println("�ļ�������!");
        }
        System.out.println("�ļ�������:" + folderNum + ",�ļ�����:" + fileNum);
        return result;
    }
}
