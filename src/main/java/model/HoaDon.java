package model;

import java.time.LocalDate;
import java.util.Date;

public class HoaDon {
    private int id;
    private int idHopDong;
    private double soTien;
    private LocalDate ngayHan;
    private String trangThai;
    private String loaiThanhToan;
    private LocalDate ngayThanhToan;
    private String ghiChu;

    public HoaDon() {}

    public HoaDon(int id, int idHopDong, double soTien, LocalDate ngayHan, String trangThai,  LocalDate ngayThanhToan,String loaiThanhToan, String ghiChu) {
        this.id = id;
        this.idHopDong = idHopDong;
        this.soTien = soTien;
        this.ngayHan = ngayHan;
        this.trangThai = trangThai;
        this.loaiThanhToan = loaiThanhToan;
        this.ngayThanhToan = ngayThanhToan;
        this.ghiChu = ghiChu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdHopDong() {
        return idHopDong;
    }

    public void setIdHopDong(int idHopDong) {
        this.idHopDong = idHopDong;
    }

    public double getSoTien() {
        return soTien;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }

    public LocalDate getNgayHan() {
        return ngayHan;
    }

    public void setNgayHan(LocalDate ngayHan) {
        this.ngayHan = ngayHan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getLoaiThanhToan() {
        return loaiThanhToan;
    }

    public void setLoaiThanhToan(String loaiThanhToan) {
        this.loaiThanhToan = loaiThanhToan;
    }

    public LocalDate getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(LocalDate ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
