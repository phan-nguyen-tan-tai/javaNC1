package BT2_20th3;

import java.io.*;
import java.util.concurrent.*;

public class Bai_7 {
    private static final String INPUT_FILE = "source.txt";
    private static final String OUTPUT_FILE = "output.txt";
    private static final int CHUNK_SIZE = 1024 * 1024;

    public static void main(String[] args) {
        File file = new File(INPUT_FILE);
        long fileSize = file.length();
        int numChunks = (int) Math.ceil((double) fileSize / CHUNK_SIZE);

        ExecutorService executor = Executors.newFixedThreadPool(numChunks);
        for (int i = 0; i < numChunks; i++) {
            final int chunkIndex = i;
            executor.execute(() -> readChunk(chunkIndex, fileSize));
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        System.out.println("File read complete!");
    }

    private static void readChunk(int chunkIndex, long fileSize) {
        try (RandomAccessFile raf = new RandomAccessFile(INPUT_FILE, "r")) {
            raf.seek((long) chunkIndex * CHUNK_SIZE);
            byte[] buffer = new byte[CHUNK_SIZE];
            int bytesRead = raf.read(buffer);

            synchronized (Bai_7.class) {
                try (FileOutputStream fos = new FileOutputStream(OUTPUT_FILE, true)) {
                    fos.write(buffer, 0, bytesRead);
                }
            }

        } catch (IOException e) {
            System.err.println("Error while read " + chunkIndex);
        }
    }
}
