package TT_file;

import java.io.File;
import java.util.Objects;

class QuanLyThuMuc {
    public static void lietKeTapTin(String duongDan) {
        File thuMuc = new File(duongDan);
        if (thuMuc.isDirectory()) {
            for (File tapTin : Objects.requireNonNull(thuMuc.listFiles())) {
                System.out.println(tapTin.getName());
            }
        } else {
            System.out.println("Không phải thư mục hợp lệ!");
        }
    }
}