package JpgConsole;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tester {


        public static void main(String[] args) {
            String path = "C:\\Users\\35770\\Downloads\\1";
            System.out.println("ORC Test Begin......");
            Map<String, List<String>> levelMap = new HashMap<>();
            List<String> files =FindFiles.folderMethod1(path);
            try {
                files.forEach(a->{
                    String valCode = null;
                    try {
                        valCode = new OCRUtil().recognizeText(new File(a), "jpg");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if(valCode!=null && valCode.length()>2) {
                    String level = "";
                    String reg = "[A-Z]";
                    Pattern pattern = Pattern.compile(reg);
                    Matcher matcher = pattern.matcher(valCode);
                    if (matcher.find()){
                        level = matcher.group();
                    }
//                        System.out.println(a.substring(a.lastIndexOf("\\") + 1) + ":" + valCode.substring(1, 2));
                        System.out.println(a.substring(a.lastIndexOf("\\") + 1) + ":" + level);
                        if(levelMap.get(level)==null) {
                            List<String> pic_list = new ArrayList<>();
                            pic_list.add(a);
                            levelMap.put(level, pic_list);
                        } else {
                            levelMap.get(level).add(a);
                        }

                    } else {
                        System.out.println("error pic:" +a);
                        if(levelMap.get("unknown")==null) {
                            List<String> pic_list = new ArrayList<>();
                            pic_list.add(a);
                            levelMap.put("unknown", pic_list);
                        } else {
                            levelMap.get("unknown").add(a);
                        }
                    }
                });
              levelMap.keySet().stream().forEach(a->{
               List<String> oldPath_List = levelMap.get(a);
                  for (String oldPath : oldPath_List) {
                      String sortPath = "C:\\Users\\35770\\Downloads\\temp\\";
                      File  file =new File(sortPath + a);
                      if(!file.exists()) {
                          file.mkdir();
                      }
                      File oldName = new File(oldPath);
                      File newName = new File(sortPath+a+"\\"+oldPath.substring(oldPath.lastIndexOf("\\") + 1));
                      System.out.println(oldName.renameTo(newName));
                  }
              });
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("ORC Test End......");
        }

}
