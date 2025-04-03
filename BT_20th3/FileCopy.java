package BT_20th3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy { // đọc file này và ghi sang file khác
    public static void main(String[] args) {
        String sourceFile = "file1.txt"; // Tệp nguồn cần sao chép
        String destinationFile = "file2.txt"; // Tệp đích

        try (
                FileInputStream fis = new FileInputStream(sourceFile);
                FileOutputStream fos = new FileOutputStream(destinationFile)
        ) {
            int byteData;
            while ((byteData = fis.read()) != -1) { // Đọc từng byte cho đến khi kết thúc
                fos.write(byteData); // Ghi byte vào tệp đích
            }
            System.out.println("Sao chép tệp thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}

