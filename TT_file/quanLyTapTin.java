package TT_file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class QuanLyTapTin {
    public static void docTapTin(String duongDan) {
        try {
            String noiDung = new String(Files.readAllBytes(Paths.get(duongDan)));
            System.out.println("Nội dung tập tin " + duongDan + ":\n" + noiDung);
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc tập tin: " + duongDan);
        }
    }
}