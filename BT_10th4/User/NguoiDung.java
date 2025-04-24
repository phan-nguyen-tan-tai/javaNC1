package BT_10th4.User;

public class NguoiDung {
    private String tenDangNhap;
    private String matKhauDaBam;
    private String email;

    public NguoiDung(String tenDangNhap, String matKhauDaBam, String email) {
        this.tenDangNhap = tenDangNhap;
        this.matKhauDaBam = matKhauDaBam;
        this.email = email;
    }

    public String getTenDangNhap() { return tenDangNhap; }
    public String getMatKhauDaBam() { return matKhauDaBam; }
    public String getEmail() { return email; }
}
