package text_file;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class Stream {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập tên file để ghi từ bàn phím:");
        String fileName = scanner.nextLine();
        writeFromKeyboard(fileName);

        System.out.println("Nội dung file sau khi ghi từ bàn phím:");
        readFile(fileName);

        System.out.println("Số dòng trong file: " + countLines(fileName));

        String numberFile = "numbers.dat";
        writeNumbersToFile(numberFile);
        readNumbersFromFile(numberFile);

        System.out.println("Nhập thư mục cần liệt kê file:");
        String dirPath = scanner.nextLine();
        listFilesInDirectory(dirPath);

        System.out.println("Nhập danh sách file cần đọc đa luồng (cách nhau bởi dấu cách):");
        String[] files = scanner.nextLine().split(" ");
        readFilesConcurrently(files);
    }

    private static void writeFromKeyboard(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập nội dung (gõ EXIT để kết thúc):");
            String line;
            while (!(line = scanner.nextLine()).equals("EXIT")) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int countLines(String fileName) {
        int lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.readLine() != null) {
                lines++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private static void writeNumbersToFile(String fileName) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            for (int i = 1; i <= 10; i++) {
                dos.writeInt(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readNumbersFromFile(String fileName) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            while (dis.available() > 0) {
                System.out.print(dis.readInt() + " ");
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void listFilesInDirectory(String dirPath) {
        File dir = new File(dirPath);
        if (dir.isDirectory()) {
            for (File file : Objects.requireNonNull(dir.listFiles())) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("Không phải thư mục hợp lệ!");
        }
    }

    private static void readFilesConcurrently(String[] files) {
        ExecutorService executor = Executors.newFixedThreadPool(files.length);
        for (String file : files) {
            executor.execute(() -> readFile(file));
        }
        executor.shutdown();
    }
}
