package model;

import java.sql.Timestamp;
import java.util.Date;

public class NguoiDung {
    private int id;
    private String tenDangNhap;
    private String matKhau;
    private String email;
    private String soDienThoai;
    private String vaiTro;
    private String ho_ten;
    private String cccd;
    private double soDu;

    public NguoiDung(int id, String tenDangNhap, String matKhau, String email, String soDienThoai, String vaiTro, String ho_ten, String cccd, double soDu) {
        this.id = id;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.vaiTro = vaiTro;
        this.ho_ten = ho_ten;
        this.cccd = cccd;
        this.soDu = soDu;
    }

    public void setSoDu(double soDu) {
        this.soDu = soDu;
    }

    public double getSoDu() {
        return soDu;
    }

    public void setHo_ten(String ho_ten) {
        this.ho_ten = ho_ten;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getCccd() {
        return cccd;
    }

    public String getHo_ten() {
        return ho_ten;
    }

    // Constructor
    public NguoiDung() {}


    // Getters và Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTenDangNhap() { return tenDangNhap; }
    public void setTenDangNhap(String tenDangNhap) { this.tenDangNhap = tenDangNhap; }

    public String getMatKhau() { return matKhau; }
    public void setMatKhau(String matKhau) { this.matKhau = matKhau; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSoDienThoai() { return soDienThoai; }
    public void setSoDienThoai(String soDienThoai) { this.soDienThoai = soDienThoai; }

    public String getVaiTro() { return vaiTro; }
    public void setVaiTro(String vaiTro) { this.vaiTro = vaiTro; }
}

// Tương tự, tạo class PhongTro, HopDong, HoaDon, ThongBao
