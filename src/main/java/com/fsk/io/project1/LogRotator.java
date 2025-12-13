package com.fsk.io.project1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class LogRotator {

    public static final long MAX_FILE_SIZE_AS_BYTE = 5 * 1024 * 1024;

    private final String logDirectoryPath;
    private final String logFileName;
    private final int maxBackupCount;
    private final long pollIntervalMillis;

    public LogRotator(String logDirectoryPath, String logFileName, int maxBackupCount, long pollIntervalMillis) {
        this.logDirectoryPath = logDirectoryPath;
        this.logFileName = logFileName;
        this.maxBackupCount = maxBackupCount;
        this.pollIntervalMillis = pollIntervalMillis;
    }

    public boolean needsRotation() {
        String logFilePath = logDirectoryPath + File.separator + logFileName;
        File file = new File(logFilePath);

        if (!file.exists()) {
            return false;
        }

        return file.length() >= MAX_FILE_SIZE_AS_BYTE;

    }

    public void performRotation() {
        for (int i = maxBackupCount; i >=1; i--) {
            File source = getBackupFile(i);
            File target = getBackupFile(i + 1);
            rotateFile(source, target);
        }
        rotateFile(getMainLogFile(), getBackupFile(1));

        try (FileOutputStream fos = new FileOutputStream(getMainLogFile())) {
        } catch (IOException e) {
            throw new RuntimeException("Cannot create new log file", e);
        }
    }

    private File getBackupFile(int index) {
        return new File(logDirectoryPath, logFileName + "." + index);
    }

    public File getMainLogFile() {
        return new File(logDirectoryPath, logFileName);
    }

    public void rotateIfNeeded() {
        if (needsRotation()) {
            performRotation();
        }
    }

    public void rotateFile(File source, File target) {
        if (!source.exists()) return;
        if (target.exists()) {
            boolean delete = target.delete();
            if (!delete) {
                throw new RuntimeException("Can't delete " + target.getAbsolutePath());
            }
        }
        boolean rename = source.renameTo(target);
        if (!rename) {
            throw new RuntimeException("Can't rename " + source.getAbsolutePath() + " to " + target.getAbsolutePath());
        }

    }

    @SuppressWarnings("BusyWait")
    public void start() {
        new Thread(() -> {
            while (true) {
                rotateIfNeeded();
                try {
                    Thread.sleep(pollIntervalMillis);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }).start();
    }

}
