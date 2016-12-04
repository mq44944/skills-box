package com.yew1eb.io;

import java.io.*;

/**
 * @author zhouhai
 * @createTime 16/4/3
 * @description
 */
public class IoTest1 {

    public static void copyFile1(String srcPath, String destPath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(srcPath);
            fos = new FileOutputStream(destPath);

            byte[] byt = new byte[1024 * 1024];
            int len = 0;
            while((len = fis.read(byt)) != -1) {
                fos.write(byt, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    /**
     * 缓冲区输入流会将读取到的数据读入缓冲区，当缓冲区满时，
     * 或者调用flush方法，缓冲输出流会将数据写出。
     * 注意：当然使用缓冲流来进行提高效率时，对于小文件可能看不到性能的提升。
     * 但是文件稍微大一些的话，就可以看到实质的性能提升了。
     */
    public static void copyFile2(String srcPath, String destPath) throws IOException {
        FileInputStream fis = new FileInputStream(srcPath);
        FileOutputStream fos = new FileOutputStream(destPath);

        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        int len = 0;

        while((len = bis.read()) != -1) {
            bos.write(len);
        }
        bis.close();
        bos.close();
    }

    public static void main(String[] args) throws IOException {
        String srcPath = "/Users/yew1eb/SoftWare/waimai_e_task.zip";
        String destPath = "/Users/yew1eb/SoftWare/waimai_e_task_bak.zip";
        copyFile2(srcPath, destPath);
    }
}
