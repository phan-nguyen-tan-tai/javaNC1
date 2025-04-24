package BT_10th4.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;

public class GiaoDienNguoiDung extends JFrame {
    private JTextField txtTenDangNhap, txtEmail;
    private JPasswordField txtMatKhau;
    private JTable bangNguoiDung;
    private DefaultTableModel moHinhBang;
    private QuanLyNguoiDung quanLy = new QuanLyNguoiDung();

    public GiaoDienNguoiDung() {
        setTitle("Ứng dụng Đăng ký & Đăng nhập");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        JPanel khungNhap = new JPanel(new GridLayout(4, 2));

        khungNhap.add(new JLabel("Tên đăng nhập:"));
        txtTenDangNhap = new JTextField();
        khungNhap.add(txtTenDangNhap);

        khungNhap.add(new JLabel("Mật khẩu:"));
        txtMatKhau = new JPasswordField();
        khungNhap.add(txtMatKhau);

        khungNhap.add(new JLabel("Email:"));
        txtEmail = new JTextField();
        khungNhap.add(txtEmail);

        JButton btnDangKy = new JButton("Đăng ký");
        JButton btnDangNhap = new JButton("Đăng nhập");
        khungNhap.add(btnDangKy);
        khungNhap.add(btnDangNhap);

        add(khungNhap, BorderLayout.NORTH);

        moHinhBang = new DefaultTableModel(new String[]{"Tên đăng nhập", "Email"}, 0);
        bangNguoiDung = new JTable(moHinhBang);
        add(new JScrollPane(bangNguoiDung), BorderLayout.CENTER);

        JPanel khungDuoi = new JPanel();
        JButton btnXuat = new JButton("Xuất XML");
        JButton btnNhap = new JButton("Nhập XML");
        khungDuoi.add(btnXuat);
        khungDuoi.add(btnNhap);
        add(khungDuoi, BorderLayout.SOUTH);

        btnDangKy.addActionListener(e -> dangKy());
        btnDangNhap.addActionListener(e -> dangNhap());
        btnXuat.addActionListener(e -> xuatXML());
        btnNhap.addActionListener(e -> nhapXML());

        setVisible(true);
    }

    private void dangKy() {
        String ten = txtTenDangNhap.getText();
        String mk = new String(txtMatKhau.getPassword());
        String email = txtEmail.getText();
        if (quanLy.dangKy(ten, mk, email)) {
            JOptionPane.showMessageDialog(this, "Đăng ký thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Người dùng đã tồn tại");
        }
    }

    private void dangNhap() {
        String ten = txtTenDangNhap.getText();
        String mk = new String(txtMatKhau.getPassword());
        if (quanLy.dangNhap(ten, mk)) {
            JOptionPane.showMessageDialog(this, "Xin chào " + ten);
        } else {
            JOptionPane.showMessageDialog(this, "Sai thông tin đăng nhập");
        }
    }

    private void xuatXML() {
        try {
            JFileChooser chon = new JFileChooser();
            if (chon.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                File tep = chon.getSelectedFile();
                XMLTienIch.xuatXML(quanLy.getDanhSach(), tep);
                JOptionPane.showMessageDialog(this, "Xuất thành công");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi xuất");
        }
    }

    private void nhapXML() {
        try {
            JFileChooser chon = new JFileChooser();
            if (chon.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File tep = chon.getSelectedFile();
                var ds = XMLTienIch.nhapXML(tep);
                moHinhBang.setRowCount(0);
                for (NguoiDung nguoi : ds.values()) {
                    moHinhBang.addRow(new Object[]{nguoi.getTenDangNhap(), nguoi.getEmail()});
                }
                JOptionPane.showMessageDialog(this, "Nhập thành công");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi nhập");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GiaoDienNguoiDung::new);
    }
}