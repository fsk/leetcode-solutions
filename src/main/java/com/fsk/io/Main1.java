package com.fsk.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * == BYTE STREAM ==
 * Reading and writing any kind of Binary files. For Ex: images , PDFS , VIDEO
 * ==> Use Cases
 * - Working with binary files
 * - Reading / Writing images , videos , PDFs
 * - Network I/O
 * - Serialization raw bytes
 * - Low Level Data Processing
 */


/**
 * FILE INPUT STREAM
 */
public class Main1 {

    public static final String IMAGE_FILE_PATH = "/Users/fsk/Desktop/coding/leetcode-solutions/src/main/java/com/fsk/io/img.png";

    public static void main(String[] args) throws FileNotFoundException {

        //fileInputStreamMethod1();
        fileInputStreamMethod2();
    }

    /**
     * Dosyayi tek seferde okumak mumkun olmayabilir. Dogru da degildir.
     * 10 gb lik bir dosyayi tek seferde okumaya kalkismak demek OOM demek.
     *
     * Bu yuzden method2 deki gibi chunk chunk okumak lazim.
     *
     */
    private static void fileInputStreamMethod1() {
        try(FileInputStream fis = new FileInputStream(IMAGE_FILE_PATH)) {
            byte[] read = fis.readAllBytes();
            for (byte b : read) {
                System.out.printf("%02X ", b);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private static void fileInputStreamMethod2() {

        try(FileInputStream fis = new FileInputStream(IMAGE_FILE_PATH)) {
            byte[] buffer = new byte[4096];
            int len;
            while (((len = fis.read(buffer)) != -1)) {
                System.out.printf(len + "\n");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
