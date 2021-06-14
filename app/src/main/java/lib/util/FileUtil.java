package lib.util;

import android.text.TextUtils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Describe
 */
public class FileUtil {


    /**
     * 从APP内部读取字符串
     * @param packageName
     * @param fileName
     * @return
     */
    public static String getStringFromApp(String packageName,String fileName){
        String folderPath = "data/data/" + packageName + "/MyData";
        File file = new File(folderPath, fileName);
        if (!file.exists()) {
            return null;
        }
        if(file.length() == 0){
            return "";
        }
        byte[] data = new byte[(int)file.length()];
        try {
            FileInputStream fileIn = new FileInputStream(file);
            int len = fileIn.read(data);
            JLog.d("getStringFromApp","len="+len);
            try {
                fileIn.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(data, StandardCharsets.UTF_8);
    }

    /**
     * 保存字符串到APP内部文件
     * @param packageName
     * @param fileName
     * @param content
     * @param isDelOld
     */
    public static void saveStringToApp(String packageName,String fileName,String content,boolean isDelOld){
        String folderPath = "data/data/" + packageName + "/MyData";
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        try {
            File file = new File(folderPath, fileName);
            //data/data/com../MyData/..
            if (!file.exists()) {
                file.createNewFile();
            }else {
                if(isDelOld){
                    file.delete();
                    file.createNewFile();
                }
            }
            FileOutputStream  fileOut = new FileOutputStream(file, true);
            fileOut.write(content.getBytes());
            fileOut.flush();
            try {
                fileOut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 从SD卡读取文件内容
     * @param folderPath
     * @param fileName
     * @return
     */
    public static byte[] getStringFromSD(String folderPath, String fileName) {
        File file = new File(folderPath, fileName);
        if (!file.exists()) {
            return null;
        }
        byte[] data = new byte[(int)file.length()];
        try {
            FileInputStream fileIn = new FileInputStream(file);
            int len = fileIn.read(data);
            JLog.d("getStringFromSD","len="+len);
            try {
                fileIn.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * 将文件保存到本地SD卡
     * @param str
     * @param folderPath
     * @param fileName
     */
    public static void saveStringToSD(String str, String folderPath, String fileName) {
        if(TextUtils.isEmpty(str)){
            return;
        }
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        File file = new File(folderPath, fileName);
        ByteArrayInputStream is = new ByteArrayInputStream(str.getBytes());
        OutputStream os = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            os = new FileOutputStream(file, true);
            byte[] buffer = new byte[1024];
            int len = 0;
            while (-1 != (len = is.read(buffer))) {
                os.write(buffer, 0, len);
            }
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
