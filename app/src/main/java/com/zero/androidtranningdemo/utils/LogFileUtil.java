package com.zero.androidtranningdemo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

/**
 * 记录日志
 * Created by zero on 17-4-7.
 */

public class LogFileUtil {

    private static File sLogsDir = new File(SDUtils.PROJECT_ROOT_DIR + "/logs/");

    private static final long MAX_LOG_FILE_SIZE = 1024 * 1024L;
    private static final long MIN_LOG_FILE_SIZE = 200 * 1024L;

    public static void recordLogFile(String errorMsg) {

    }

    private void handleLog(File logFile, String tag, String tips, double threshold) {
        String errorMsg = null;

        try {
            if (SDUtils.isSdReady()) {
                synchronized (LogFileUtil.class) {
                    if (!sLogsDir.exists()) {
                        sLogsDir.mkdirs();
                    }

                    if (!logFile.exists()) {
                        logFile.createNewFile();
                    }

                    // 取得文件长度（字节数）
                    long length = logFile.length();
                    if (length > MAX_LOG_FILE_SIZE) {
                        File tempFile = new File(sLogsDir, "temp_" + logFile.getName());
                        copyLastBytes(logFile, tempFile, MIN_LOG_FILE_SIZE);
                        logFile.delete();
                        length = tempFile.length();
                        tempFile.renameTo(logFile.getAbsoluteFile());
                    }

                    if (errorMsg == null) {
//                        errorMsg = formatLogMsg(tag, tips);
                    }

                    RandomAccessFile randomAccessFile = null;
                    try {
                        randomAccessFile = new RandomAccessFile(logFile, "rw");
                        randomAccessFile.seek(length);
                        randomAccessFile.write(errorMsg.getBytes());
                    } catch (Exception e) {

                    } finally {
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                    }
                }
            }
        } catch (Exception e) {

        }
    }

    /**
     * 获取src文件最后limit个字节的内容到dst文件
     *
     * @param src
     * @param dst
     * @param limit
     * @throws IOException
     */
    private static void copyLastBytes(File src, File dst, long limit) throws IOException {
        InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(dst);

        long srcLength = src.length();
        long skipLength = srcLength < limit ? 0 : srcLength - limit;
        in.skip(skipLength);

        // Transfer bytes from in to out
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
    }

}
