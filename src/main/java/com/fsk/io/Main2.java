package com.fsk.io;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Buffered Input Stream
 * - FileInputStream veriyi diskten direkt okurken BufferedInputStream
 * Verileri önce kendi içinde tanımlı bir buffer isimli ara belleğe çeker, sonra bu bellekten okur.
 * - FileInputStream’de her read() → işletim sistemine çağrı yapılır (system call).
 * Bu çok maliyetlidir çünkü diskten tek tek byte okumak zaman alır.
 * - BufferedInputStream’de:
 *İlk seferde büyük bir chunk (örneğin 4 KB) okur.
 * Sonraki read() çağrıları buffer’dan alınır → çok hızlıdır
 * - BufferedInputStream tek başına çalışmaz.
 * Başka bir InputStream’i (örneğin FileInputStream’i) sararak (“wrap ederek”) ekstra özellik kazandırır.
 * - İçinde bir byte[] buffer oluşturur. Veriyi önce bu buffer’a yükler.
 * Sonra senin read() çağrılarını bu buffer üzerinden cevaplar.
 * Bu sayede:
 * Diskten sık sık okuma yapılmaz.
 * Performans ciddi şekilde artar.
 *
 * FileInputStream → Benzin istasyonuna her seferinde gidip 1 litre benzin almak gibi.
 * BufferedInputStream → Depoyu doldurup ordan azar azar kullanmak gibi.
 *
 */
public class Main2 {

    public static void main(String[] args) {


        bufferedInputStreamMethod1();


    }

    private static void bufferedInputStreamMethod1() {
        byte[] buffer = new byte[8192];
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(Main1.IMAGE_FILE_PATH))) {
            int len;
            while ((len = bis.read(buffer)) != -1) {
                // Buffer'ın kullanılabilir kısmı len kadardır
                // Binary dosyayı karakter basmak yerine hex veya işlem yap
                printHex(buffer, len);
            }
        } catch (
                FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void printHex(byte[] buffer, int len) {
        for (int i = 0; i < len; i++) {
            System.out.printf("%02X ", buffer[i]);
        }
        System.out.println();
    }
}
