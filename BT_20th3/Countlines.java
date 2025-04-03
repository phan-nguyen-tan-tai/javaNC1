package BT_20th3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Countlines {
    public static void main(String[] args) {
        int lineCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("file1.txt"))) {
            while (br.readLine() != null) {
                lineCount++;
            }
            System.out.println("Số dòng trong file: " + lineCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
