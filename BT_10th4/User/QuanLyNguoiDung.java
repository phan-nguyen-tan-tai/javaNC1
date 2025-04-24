package BT_10th4.User;

import org.mindrot.jbcrypt.BCrypt;
import java.util.HashMap;

public class QuanLyNguoiDung {
    private HashMap<String, NguoiDung> danhSachNguoiDung = new HashMap<>();

    public boolean dangKy(String tenDangNhap, String matKhau, String email) {
        if (danhSachNguoiDung.containsKey(tenDangNhap)) return false;
        String maHoa = BCrypt.hashpw(matKhau, BCrypt.gensalt());
        danhSachNguoiDung.put(tenDangNhap, new NguoiDung(tenDangNhap, maHoa, email));
        return true;
    }

    public boolean dangNhap(String tenDangNhap, String matKhau) {
        NguoiDung nguoiDung = danhSachNguoiDung.get(tenDangNhap);
        return nguoiDung != null && BCrypt.checkpw(matKhau, nguoiDung.getMatKhauDaBam());
    }

    public HashMap<String, NguoiDung> getDanhSach() {
        return danhSachNguoiDung;
    }

    public void setDanhSach(HashMap<String, NguoiDung> moi) {
        danhSachNguoiDung = moi;
    }
}