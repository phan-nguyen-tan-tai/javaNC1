package TT_file;

public class Main {
    public static void main(String[] args) {
        String duongDanThuMuc = "duong_dan_thu_muc_cua_ban";
        QuanLyThuMuc.lietKeTapTin(duongDanThuMuc);

        String[] danhSachTapTin = {"file1.txt", "file2.txt"};
        XuLyDongThoi.docTapTinDongThoi(danhSachTapTin);
    }
}