package com.fsk.youtube.binarysearch;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;

public class LogBinarySearchReadable {

    // -------------------------------
    // Bir log satırını temsil eden sınıf
    // -------------------------------
    static class LogRecord {
        final long timestampMillis; // epoch time (karşılaştırma için)
        final String message;       // log içeriği

        LogRecord(long timestampMillis, String message) {
            this.timestampMillis = timestampMillis;
            this.message = message;
        }
    }

    // Log zamanı için biçim (örnek: "2025-10-19 10:05:00")
    private static final DateTimeFormatter LOG_FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // "yyyy-MM-dd HH:mm:ss" -> epochMillis dönüşümü
    static long parseTimestampToMillis(String timestamp) {
        LocalDateTime localTime = LocalDateTime.parse(timestamp, LOG_FORMAT);
        return localTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    // ------------------------------------------------------------------------
    // 1️⃣  targetTs’ten SONRAKİ veya AYNI ilk log’un index’ini döndürür (lower bound)
    // ------------------------------------------------------------------------
    static int findFirstAtOrAfter(LogRecord[] sortedLogs, long targetTimestamp) {
        int left = 0;
        int right = sortedLogs.length; // half-open interval [left, right)
        while (left < right) {
            int middle = (left + right) >>> 1;
            if (sortedLogs[middle].timestampMillis >= targetTimestamp) {
                right = middle; // sol tarafa sıkıştır
            } else {
                left = middle + 1; // sağ tarafa ilerle
            }
        }
        return (left < sortedLogs.length) ? left : -1; // yoksa -1
    }

    // ------------------------------------------------------------------------
    // 2️⃣  targetTs’ten ÖNCEKİ veya AYNI son log’un index’ini döndürür (upper bound - 1)
    // ------------------------------------------------------------------------
    static int findLastAtOrBefore(LogRecord[] sortedLogs, long targetTimestamp) {
        int left = 0;
        int right = sortedLogs.length;
        while (left < right) {
            int middle = (left + right) >>> 1;
            if (sortedLogs[middle].timestampMillis <= targetTimestamp) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        int resultIndex = left - 1;
        return (resultIndex >= 0) ? resultIndex : -1;
    }

    // ------------------------------------------------------------------------
    // 3️⃣  [startTs, endTs] zaman aralığındaki log kayıtlarını döndürür
    // ------------------------------------------------------------------------
    static int[] findRangeIndices(LogRecord[] sortedLogs, long startTs, long endTs) {
        int startIndex = findFirstAtOrAfter(sortedLogs, startTs);
        int endIndex = findLastAtOrBefore(sortedLogs, endTs);
        if (startIndex == -1 || endIndex == -1 || endIndex < startIndex) {
            return new int[]{-1, -1}; // geçerli aralık yok
        }
        return new int[]{startIndex, endIndex};
    }

    // ------------------------------------------------------------------------
    // Demo
    // ------------------------------------------------------------------------
    public static void main(String[] args) {
        // Gerçekçi log örnekleri (sıralı)
        String[][] rawLogs = {
                {"2025-10-19 10:01:03", "INFO  app  - Started system"},
                {"2025-10-19 10:03:11", "INFO  auth - User login: alice"},
                {"2025-10-19 10:05:00", "INFO  svcA - Service A started"},
                {"2025-10-19 10:05:00", "WARN  svcA - Slow start, retrying"},
                {"2025-10-19 10:08:27", "INFO  svcB - Service B started"},
                {"2025-10-19 10:11:42", "INFO  app  - System stable"},
                {"2025-10-19 10:14:10", "ERROR svcB - OutOfMemoryError"},
                {"2025-10-19 10:20:00", "INFO  app  - Recovered"}
        };

        // LogRecord dizisi oluştur
        LogRecord[] logRecords = new LogRecord[rawLogs.length];
        for (int i = 0; i < rawLogs.length; i++) {
            long timestampMillis = parseTimestampToMillis(rawLogs[i][0]);
            logRecords[i] = new LogRecord(timestampMillis, rawLogs[i][1]);
        }

        // Sıralamayı garanti altına al
        Arrays.sort(logRecords, Comparator.comparingLong(l -> l.timestampMillis));

        // 1) Verilen andan sonraki ilk log (örnek: 10:06)
        long query1 = parseTimestampToMillis("2025-10-19 10:06:00");
        int indexAfter = findFirstAtOrAfter(logRecords, query1);
        System.out.println("🔹 First at or after 10:06 -> "
                + (indexAfter == -1 ? "(bulunamadı)" : logRecords[indexAfter].message));

        // 2) Verilen andan önceki son log (örnek: 10:06)
        long query2 = parseTimestampToMillis("2025-10-19 10:06:00");
        int indexBefore = findLastAtOrBefore(logRecords, query2);
        System.out.println("🔹 Last at or before 10:06 -> "
                + (indexBefore == -1 ? "(bulunamadı)" : logRecords[indexBefore].message));

        // 3) Belirli zaman aralığındaki tüm loglar
        long startRange = parseTimestampToMillis("2025-10-19 10:04:00");
        long endRange = parseTimestampToMillis("2025-10-19 10:12:00");
        int[] rangeIndices = findRangeIndices(logRecords, startRange, endRange);

        System.out.println("🔹 Range 10:04..10:12:");
        if (rangeIndices[0] == -1) {
            System.out.println("(hiç kayıt yok)");
        } else {
            for (int i = rangeIndices[0]; i <= rangeIndices[1]; i++) {
                String formattedTime = Instant.ofEpochMilli(logRecords[i].timestampMillis)
                        .atZone(ZoneId.systemDefault()).format(LOG_FORMAT);
                System.out.println("   • " + formattedTime + " | " + logRecords[i].message);
            }
        }
    }
}
