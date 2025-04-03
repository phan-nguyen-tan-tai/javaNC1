package BT_20th3;

import java.io.*;

public class IntegerFile {
    public static void main(String[] args) {
        String filename = "numbers.dat";

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            int[] numbers = {10, 20, 30, 40, 50};
            for (int num : numbers) {
                dos.writeInt(num);
            }
            System.out.println("Đã ghi danh sách số nguyên vào " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            System.out.println("Các số đã đọc từ file:");
            while (dis.available() > 0) {
                System.out.print(dis.readInt() + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
