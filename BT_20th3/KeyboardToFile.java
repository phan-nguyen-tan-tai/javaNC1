package BT_20th3;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardToFile {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             FileWriter fw = new FileWriter("output.txt")) {
            System.out.println("Nhập nội dung (gõ 'exit' để kết thúc):");
            String line;
            while (!(line = br.readLine()).equalsIgnoreCase("exit")) {
                fw.write(line + "\n");
            }
            System.out.println("Dữ liệu đã được ghi vào output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
