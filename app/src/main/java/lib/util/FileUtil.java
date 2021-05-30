package lib.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Describe
 */
class FileUtil {

    /**
     * 将文件保存到本地
     */
    public static void saveFileCache(byte[] fileData, String folderPath, String fileName) {
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        File file = new File(folderPath, fileName);
        ByteArrayInputStream is = new ByteArrayInputStream(fileData);
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
            throw new RuntimeException("FileUtil", e);
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
