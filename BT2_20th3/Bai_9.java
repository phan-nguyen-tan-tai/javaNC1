//package BT2_20th3;
//
//import org.jsoup.Jsoup;
//import org.jsoup.safety.Safelist;
//import java.io.*;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.nio.charset.StandardCharsets;
//import java.util.concurrent.*;
//
//public class Bai_9 {
//    private static final String[] URLS = {
//            "https://thanhnien.vn/nhung-hot-girl-ma-tuy-tu-hao-quang-den-vuc-tham-tu-toi-185250308094530101.htm",
//            "https://thanhnien.vn/kinh-te.htm",
//            "https://thanhnien.vn/kinh-te.htm"
//    };
//
//    private static final String OUTPUT_DIR = "downloads/";
//    private static final String MERGED_JSON_FILE = "merged_output.json";
//    private static final int THREAD_COUNT = 5;
//
//    public static void main(String[] args) {
//        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
//        new File(OUTPUT_DIR).mkdirs(); // Tạo thư mục nếu chưa có
//
//        for (int i = 0; i < URLS.length; i++) {
//            final int index = i;
//            executor.execute(() -> downloadContent(URLS[index], OUTPUT_DIR + "file" + (index + 1) + ".json"));
//        }
//
//        executor.shutdown();
//        try {
//            executor.awaitTermination(10, TimeUnit.MINUTES);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        processAndMergeFiles();
//    }
//    private static void downloadContent(String urlString, String filePath) {
//        try {
//            URL url = new URL(urlString);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//            conn.setRequestProperty("Accept", "application/json");
//
//            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
//            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
//
//            String line;
//            while ((line = reader.readLine()) != null) {
//                writer.write(line);
//                writer.newLine();
//            }
//
//            reader.close();
//            writer.close();
//            System.out.println("Tải xong: " + filePath);
//        } catch (IOException e) {
//            System.err.println("Lỗi tải từ " + urlString + ": " + e.getMessage());
//        }
//    }
//
//    private static void processAndMergeFiles() {
//        File outputFile = new File(MERGED_JSON_FILE);
//        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
//
//        try (BufferedWriter mergedWriter = new BufferedWriter(new FileWriter(outputFile))) {
//            File[] files = new File(OUTPUT_DIR).listFiles((dir, name) -> name.endsWith(".json"));
//            if (files == null) return;
//
//            mergedWriter.write("[\n");
//
//            CountDownLatch latch = new CountDownLatch(files.length);
//            for (int i = 0; i < files.length; i++) {
//                final File file = files[i];
//                final boolean isLast = (i == files.length - 1);
//
//                executor.execute(() -> {
//                    processJsonFile(file, mergedWriter, isLast);
//                    latch.countDown();
//                });
//            }
//
//            latch.await();
//            mergedWriter.write("\n]");
//            System.out.println("Hợp nhất hoàn tất: " + MERGED_JSON_FILE);
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            executor.shutdown();
//        }
//    }
//
//    private static synchronized void processJsonFile(File file, BufferedWriter mergedWriter, boolean isLast) {
//        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
//            StringBuilder jsonContent = new StringBuilder();
//            String line;
//            while ((line = reader.readLine()) != null) {
//                jsonContent.append(line).append("\n");
//            }
//
//            String cleanedJson = Jsoup.clean(jsonContent.toString(), Safelist.none());
//            mergedWriter.write(cleanedJson.trim());
//            if (!isLast) mergedWriter.write(",\n");
//
//            System.out.println("Đã xử lý: " + file.getName());
//        } catch (IOException e) {
//            System.err.println("Lỗi khi xử lý file " + file.getName() + ": " + e.getMessage());
//        }
//    }
//}
