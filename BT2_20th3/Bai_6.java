package BT2_20th3;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Bai_6 {
    private static final String OUTPUT_FILE = "output.txt";
    private static final Object lock = new Object();

    public static void main(String[] args) {
        String[] inputFiles = {"source.txt", "dest.txt"};
        ExecutorService executor = Executors.newFixedThreadPool(inputFiles.length);
        for (String file : inputFiles) {
            executor.execute(() -> readFileAndWrite(file));
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        System.out.println("Completed all threads");
    }

    private static void readFileAndWrite(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            synchronized (lock) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE, true))) {
                    writer.write("-- Content from " + fileName + " --\n");
                    writer.write(content.toString());
                    writer.write("\n");
                }
            }

        } catch (IOException e) {
            System.err.println("File error: " + fileName);
        }
    }
}
