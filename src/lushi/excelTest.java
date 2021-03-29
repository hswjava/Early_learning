package lushi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: create by hsw
 * @description: lushi
 * @date:2021/3/29
 **/
public class excelTest {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\heshiwei\\Desktop\\database_export-9TbtzEm2gJBw.json");
        String result = "";

        Map<String, Map<String, Map<String ,Double>>> excelMap =  new HashMap<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
//                result = result + "\n" +s;
                ScoreBean t =  JSON.parseObject(s, new TypeReference<ScoreBean>(){});
                Field[] fields = ScoreBean.class.getDeclaredFields();
                for (Field field : fields) {
                    if(field.getType().toString().contains("List")) {
                        buildExcelMap(field.getName(), t, excelMap);
                    }
                }

            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }


        //创建HSSFWorkbook对象
        HSSFWorkbook wb = new HSSFWorkbook();

        excelMap.keySet().forEach(key->{
            //创建HSSFSheet对象
            HSSFSheet sheet = wb.createSheet(key);

            HashMap map = (HashMap) excelMap.get(key);
            AtomicInteger count = new AtomicInteger();
            map.keySet().forEach(a->{
                //创建HSSFRow对象
                HSSFRow row = sheet.createRow(count.getAndIncrement());
//创建HSSFCell对象
                HSSFCell cell=row.createCell(count.getAndIncrement());
//设置单元格的值
                cell.setCellValue((String)a);
            });

        });


//输出Excel文件
        FileOutputStream output=new FileOutputStream("d:\\workbook.xls");
        wb.write(output);
        output.flush();




    }

    private static void buildExcelMap (String HeroName,ScoreBean t, Map excelMap) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
//        List<CardBean> score = t.getDemonhunter();
        PropertyDescriptor pd = new PropertyDescriptor(HeroName,
                ScoreBean.class);
        Method getMethod = pd.getReadMethod();//获得get方法
        List<CardBean> score = (List<CardBean>) getMethod.invoke(t);
        if (score != null && score.size() > 0) {
            Map<String, Map<String, Double>> cardMap = (Map) excelMap.get(HeroName);
            if (cardMap == null) {
                cardMap = new HashMap<>();
                excelMap.put(HeroName, cardMap);
            }
            for (CardBean cardBean : score) {
                if (cardBean.getName() == null) continue;
                Map<String, Double> nameScoreMap;
                if (cardMap.get(cardBean.getName()) == null) {
                    nameScoreMap = new HashMap<>();
                    cardMap.put(cardBean.getName(), nameScoreMap);
                } else {
                    nameScoreMap = (Map) cardMap.get(cardBean.getName());
                }
                if(cardBean.getStars()!=0) // 0分表示没评，区分开
                nameScoreMap.put(t.getNickName(), cardBean.getStars());
            }
        }
    }
}
