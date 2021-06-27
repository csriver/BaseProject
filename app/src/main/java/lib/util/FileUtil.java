package lib.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.text.TextUtils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Describe
 */
public class FileUtil {
    /*APP包名*/
    private static final String PACKAGE_NAME="com.base.pj";

    /*数据保存在APP内部、SD卡文件夹名称*/
    private static final String APP_DATA_FOLDER="Basepj";

    /**
     * 从APP内部读取字符串
     * @param fileName 文件名
     * @return
     */
    public static String getStringFromApp(String fileName){
        String folderPath = "data/data/" + PACKAGE_NAME + "/"+APP_DATA_FOLDER;
        byte[] data = getFile(folderPath,fileName);
        if(data == null){
            return null;
        }else {
            return new String(data, StandardCharsets.UTF_8);
        }
    }

    /**
     * 保存字符串到APP内部文件
     * @param fileName 保存文件名
     * @param content 保存字符串内容
     * @param isDelOld 是否删除旧文件
     */
    public static void saveStringToApp(String fileName,String content,boolean isDelOld){
        if(TextUtils.isEmpty(content)){
            return;
        }
        String folderPath = "data/data/" + PACKAGE_NAME + "/"+APP_DATA_FOLDER;
        saveFile(folderPath,fileName,content.getBytes(),isDelOld);
    }

    /**
     * 从APP内部读取Byte[]
     * @param fileName 文件名
     * @return
     */
    public static byte[] getByteFromApp(String fileName){
        String folderPath = "data/data/" + PACKAGE_NAME + "/"+APP_DATA_FOLDER;
        return getFile(folderPath,fileName);
    }

    /**
     * 保存byte[]到APP内部文件
     * @param fileName 保存文件名
     * @param content 保存字符串内容
     * @param isDelOld 是否删除旧文件
     */
    public static void saveByteToApp(String fileName,byte[] content,boolean isDelOld){
        if(content==null){
            return;
        }
        String folderPath = "data/data/" + PACKAGE_NAME + "/"+APP_DATA_FOLDER;
        saveFile(folderPath,fileName,content,isDelOld);
    }

    /**从APP内部读取图片
     * @param folderName
     * @param photoName
     * @return
     */
    public static Bitmap getBitmapFromApp(String folderName,String photoName) {
        String folderPath = "data/data/" + PACKAGE_NAME + "/"+APP_DATA_FOLDER +"/"+folderName;
        return getBitmap(folderPath,photoName);
    }

    /**将图片保存到APP内部
     * @param bitmap 图片
     * @param folderName 保存文件夹名称
     * @param fileName 保存文件名
     */
    public static void saveBitmapToApp(Bitmap bitmap, String folderName, String fileName) {
        String folderPath = "data/data/" + PACKAGE_NAME + "/"+APP_DATA_FOLDER +"/"+folderName;
        saveBitmap(bitmap,folderPath,fileName);
    }

    /**从SD卡读取字符串
     * @param folderName
     * @param fileName
     * @return
     */
    @SuppressWarnings("deprecation")
    public static String getStringFromSD(String folderName,String fileName){
        String folderPath = Environment.getExternalStorageDirectory() + "/"+APP_DATA_FOLDER +"/"+folderName;
        byte[] data =  getFile(folderPath,fileName);
        if(data == null){
            return null;
        }else {
            return new String(data, StandardCharsets.UTF_8);
        }
    }


    /**
     * 保存字符串到SD卡
     * @param fileName 保存文件名
     * @param content 保存字符串内容
     * @param isDelOld 是否删除旧文件
     */
    @SuppressWarnings("deprecation")
    public static void saveStringToSD(String folderName,String fileName,String content,boolean isDelOld){
        if(TextUtils.isEmpty(content)){
            return;
        }
        String folderPath = Environment.getExternalStorageDirectory() +"/"+APP_DATA_FOLDER +"/"+folderName;
        saveFile(folderPath,fileName,content.getBytes(),isDelOld);
    }


    /**从SD卡读取图片
     * @param folderName
     * @param photoName
     * @return
     */
    @SuppressWarnings("deprecation")
    public static Bitmap getBitmapFromSD(String folderName,String photoName) {
        String folderPath = Environment.getExternalStorageDirectory()+"/"+APP_DATA_FOLDER +"/"+folderName;
        return getBitmap(folderPath,photoName);
    }

    /**将图片保存到SD卡
     * @param bitmap 图片
     * @param folderName 保存文件夹名称
     * @param fileName 保存文件名
     */
    @SuppressWarnings("deprecation")
    public static void saveBitmapToSD(Bitmap bitmap, String folderName, String fileName) {
        String folderPath = Environment.getExternalStorageDirectory()+"/"+APP_DATA_FOLDER +"/"+folderName;
        saveBitmap(bitmap,folderPath,fileName);
    }

    /**
     * 读取文件
     * @param folderPath
     * @param fileName
     * @return
     */
    public static byte[] getFile(String folderPath, String fileName) {
        File file = new File(folderPath, fileName);
        if (!file.exists()) {
            return null;
        }
        if(file.length() == 0){
            return null;
        }
        byte[] data = new byte[(int)file.length()];
        try {
            FileInputStream fileIn = new FileInputStream(file);
            int len = fileIn.read(data);
            JLog.d("getFile","len="+len);
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
     * 保存文件
     * @param folderPath
     * @param fileName
     * @param b
     */
    public static void saveFile(String folderPath, String fileName,byte[] b,boolean delOld) {
        if(b == null){
            return;
        }
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        try {
            File file = new File(folderPath, fileName);
            if (!file.exists()) {
                file.createNewFile();
            }else {
                if(delOld){
                    file.delete();
                    file.createNewFile();
                }
            }
            FileOutputStream  fileOut = new FileOutputStream(file, true);
            fileOut.write(b);
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

    /**读取图片
     * @param folderPath 绝对路径
     * @param photoName 图片名称
     * @return
     */
    private static Bitmap getBitmap(String folderPath,String photoName)
    {
        File file = new File(folderPath,photoName);
        // 若该文件存在
        if (file.exists()) {
            return BitmapFactory.decodeFile(file.getAbsolutePath());
        }
        return null;
    }

    /**保存图片
     * @param bitmap 图片
     * @param folderPath 保存绝对路径
     * @param photoName 保存图片名
     */
    private static void saveBitmap(Bitmap bitmap, String folderPath, String photoName) {
        if(bitmap == null){
            return;
        }
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        try {
            File file = new File(folderPath, photoName);
            if (!file.exists()) {
                file.createNewFile();
            }
            Bitmap.CompressFormat format = null;
            if (photoName.toLowerCase().endsWith("jpg") || photoName.toLowerCase().endsWith("jpeg")) {
                format = Bitmap.CompressFormat.JPEG;
            } else {
                format = Bitmap.CompressFormat.PNG;
            }
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(format, 100, bos);
            bos.flush();
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 清除APP内部缓存数据
     */
    public static void clearAppCache(){
        String folderPath = "data/data/" + PACKAGE_NAME + "/"+APP_DATA_FOLDER;
        File file = new File(folderPath);
        if (file.exists()) {
            deleteFile(file);
        }
    }

    /**
     * 清除APP在SD卡缓存数据
     */
    @SuppressWarnings("deprecation")
    public static void clearSDCache(){
        String folderPath = Environment.getExternalStorageDirectory()+"/"+APP_DATA_FOLDER;
        File file = new File(folderPath);
        if (file.exists()) {
            deleteFile(file);
        }
    }

    /**
     * 删除文件、文件夹
     * @param file
     */
    public static void deleteFile(File file){
        if(file.isDirectory()){
            for (File item : file.listFiles()) {
                deleteFile(item);
            }
        }else {
            file.delete();
        }
    }


}
