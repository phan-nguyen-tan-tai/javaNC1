package BT_20th3;

import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        File folder = new File("G:\\JAVA\\javaNC1");
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                System.out.println("Danh sách file trong thư mục:");
                for (File file : files) {
                    System.out.println(file.getName());
                }
            } else {
                System.out.println("Thư mục trống.");
            }
        } else {
            System.out.println("Thư mục không tồn tại.");
        }
    }
}
