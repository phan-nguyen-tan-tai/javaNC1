package BT2_20th3;

import java.io.*;
import java.util.concurrent.*;

public class Bai_8 {
    private static final String KEYWORD = "lalalaaaaa";

    public static void main(String[] args) {
        String[] inputFiles = {"dest.txt", "source.txt"};
        ExecutorService executor = Executors.newFixedThreadPool(inputFiles.length);
        ConcurrentHashMap<String, Integer> resultMap = new ConcurrentHashMap<>();

        for (String file : inputFiles) {
            executor.execute(() -> {
                int count = searchKeywordInFile(file, KEYWORD);
                resultMap.put(file, count);
            });
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        resultMap.forEach((file, count) -> {
            System.out.println("Keyword '" + KEYWORD + "' appear " + count + " in file " + file);
        });
    }

    private static int searchKeywordInFile(String fileName, String keyword) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                count += line.split(keyword, -1).length - 1;
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + fileName);
        }
        return count;
    }
}
