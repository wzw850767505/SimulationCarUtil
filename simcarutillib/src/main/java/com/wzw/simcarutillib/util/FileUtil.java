package com.wzw.simcarutillib.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileUtil {
    
    public static byte[] getFileBytes(String files){
        byte[] re = new byte[0];
        ByteArrayOutputStream baos = null;
        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(files));
            baos = new ByteArrayOutputStream(bis.available());

            int len = -1;
            byte[] buff = new byte[2048];
            while ((len = bis.read(buff)) != -1) {
                baos.write(buff, 0, len);
            }
            re=new byte[baos.toByteArray().length];
            re=baos.toByteArray();

        } catch (FileNotFoundException e) {
            Logger.e("FileNotFoundException");
            e.printStackTrace();

        } catch (IOException e) {
            Logger.e("IOException");
            e.printStackTrace();

        } finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return re;
        }
    }

}
