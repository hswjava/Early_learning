package lushi.poi;

import com.sun.istack.internal.Nullable;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * List<User> users = ...;
 * List<String> fields = Arrays.asList("username", "password", "email", "address.country.name");
 * PoiWriter writer = new PoiWriter()
 *   .write("User Name", "Password", "E-mail", "Country")
 *   .newln();
 * for (User user : users) {
 *   writer.write(fields, user).newln();
 * }
 * writer.writeToFilePath("D:/users.xls");
 * </pre>
 */
public final class PoiWriter {

    private final Workbook book;
    private final Sheet sheet;
    private final Type type;

    private int rowNo, colNo;

    public enum Type {xls, xlsx}

    /**
     * 创建一个HSSFWorkBook（.xls格式）的writer
     */
    public PoiWriter() {
        this(Type.xls);
    }

    /**
     * 创建一个指定类型的writer
     */
    public PoiWriter(Type type) {
        this.type = type;
        switch (type) {
            case xls:
                book = new HSSFWorkbook();
                break;
            case xlsx:
                book = new XSSFWorkbook();
                break;
            default:
                throw new AssertionError("impossible type " + type);
        }
        
        sheet = book.createSheet();
    }

    /**
     * 写入一个单元格
     */
    public PoiWriter write(@Nullable Object cellContent) {
        return writeAt(cellContent, rowNo, colNo++);
    }

    /**
     * 连续写入多个单元格
     */
    public <T> PoiWriter write(@SuppressWarnings("unchecked") T... cellContents) {
        for (Object cellContent : cellContents)
            write(cellContent);
        return this;
    }

    /**
     * 连续写入多个单元格
     */
    public PoiWriter write(Iterable<?> cellContents) {
        for (Object cellContent : cellContents)
            write(cellContent);
        return this;
    }


    /**
     * 将map中的数据按fieldList中的顺序取出，并依次写入
     */
    public PoiWriter write(List<String> fieldList, Map<String, ?> data) {
        for (String field : fieldList)
            if (field != null)
                write(data.get(field));
            else
                colNo++;
        return this;
    }

    /**
     * 修改指定位置的单元格的内容（不改变当前游标位置）
     * @param rowNo 目标单元格的行号，从0开始
     * @param colNo 目标单元格的列号，从0开始
     */
    public PoiWriter writeAt(@Nullable Object cellContent, int rowNo, int colNo) {
        Row row = sheet.getRow(rowNo);
        if (row == null)
            row = sheet.createRow(rowNo);
        Cell cell = row.getCell(colNo);
        if (cell == null)
            cell = row.createCell(colNo);
        cell.setCellValue(cellContent != null ? cellContent.toString() : "");
        return this;
    }

    /**
     * 开始下一行
     */
    public PoiWriter newln() {
        rowNo++;
        colNo = 0;
        return this;
    }

    /**
     * 将workbook写入到某个文件
     * @param path 文件路径。如果文件后缀名与workbook类型不符，则会自动加上合适的后缀名
     * @return 实际写入的文件路径
     */
    public String writeToFilePath(String path) throws IOException {
        String ext = "." + type.name();
        if (!path.endsWith(ext))
            path += ext;        
        book.write(FileUtils.openOutputStream(new File(path)));
        return path;
    }
    
    
    public String writeToFilePath(String path, String password) throws IOException {
        String ext = "." + type.name();
        if (!path.endsWith(ext))
            path += ext;       
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        book.write(swapStream); 
        
        OPCPackage opc = null;
	    FileOutputStream fos = null;
	    POIFSFileSystem fs = null;	    
	    
        EncryptionInfo info = new EncryptionInfo(EncryptionMode.standard);
        Encryptor enc = info.getEncryptor();
        enc.confirmPassword(password);
        
        try
        {
	        ByteArrayInputStream intStreanm = new ByteArrayInputStream(swapStream.toByteArray());
	        opc = OPCPackage.open(intStreanm);
	        
	        fs = new POIFSFileSystem();
	        OutputStream os = enc.getDataStream(fs);
	        opc.save(os);
	        opc.flush();
	        
	        fos =  new FileOutputStream(path);
	        fs.writeFilesystem(fos);
	        fos.flush();
	        
        }catch(Exception ex) {
        	ex.printStackTrace();
        }finally {
	        try {
	            if (opc != null) {
	                opc.close();
	            }
	            if (fos != null) {
	                fos.close();
	            }	           
	            if (fs != null) {
	                fs.close();
	            }
	        } catch (Exception ex1) {
	            ex1.printStackTrace();
	        }
	    }
        return path;
    }

    /**
     * 将workbook写入到指定的输出流
     */
    public void writeTo(OutputStream out) throws IOException {
        book.write(out);
    }

    /**
     * PoiWriter内部维护了一个游标，指向下一次write将会写入的单元格
     * @return 当前游标的行号，从0开始
     */
    public int getRow() {
        return rowNo;
    }

    /**
     * PoiWriter内部维护了一个游标，指向下一次write将会写入的单元格
     * @param rowNo 当前游标的行号，从0开始
     */
    public void setRow(int rowNo) {
        this.rowNo = rowNo;
    }

    /**
     * PoiWriter内部维护了一个游标，指向下一次write将会写入的单元格
     * @return 当前游标的列号，从0开始
     */
    public int getCol() {
        return colNo;
    }

    /**
     * PoiWriter内部维护了一个游标，指向下一次write将会写入的单元格
     * @param colNo 当前游标的列号，从0开始
     */
    public void setCol(int colNo) {
        this.colNo = colNo;
    }

    /**
     * PoiWriter内部维护了一个游标，指向下一次write将会写入的单元格
     * @param rowNo 当前游标的行号，从0开始
     * @param colNo 当前游标的列号，从0开始
     */
    public PoiWriter seek(int rowNo, int colNo) {
        this.rowNo = rowNo;
        this.colNo = colNo;
        return this;
    }

    /**
     * 用于替代原有的ExcelUtil中的类似方法
     */
    public static void exportExcel(List<String[]> list, String path) throws IOException {
       exportExcel(list, path, Type.xls);
    }

    /**
     * 输出Excel内容
     * @param list 待输出的内容
     * @param path 路径
     * @param type xls/xlsx
     * @throws IOException
     */
    public static String exportExcel(List<String[]> list, String path, Type type) throws IOException {
        PoiWriter writer = new PoiWriter(type);
        for (String[] ln : list)
            writer.write(ln).newln();
        return writer.writeToFilePath(path);
    }
    
    /**
     * 输出Excel文件，并设置密码
     * @param list 待输出的内容
     * @param path 路径
     * @param type xls/xlsx
     * @param password 密码
     * @throws IOException
     */
    public static String exportExcel(List<String[]> list, String path, Type type, String password) throws IOException {
        PoiWriter writer = new PoiWriter(type);
        for (String[] ln : list)
            writer.write(ln).newln();
        return writer.writeToFilePath(path,password);
    }
    
    /**
     * 输出Excel 写入到指定的输出流
     * @param list 待输出的内容
     * @param out 路径
     * @param type xls/xlsx
     * @throws IOException
     */
    public static void exportExcel(List<String[]> list, OutputStream out, Type type) throws IOException {
        PoiWriter writer = new PoiWriter(type);
        for (String[] ln : list)
            writer.write(ln).newln();
        writer.writeTo(out);
    }


}
