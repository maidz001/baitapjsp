package model;

import java.sql.Date;
import java.time.LocalDate;

public class HopDong {
    private int id;
    private int idPhongTro;
    private int idNguoiThue;
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;
    private String trangThai;

    public HopDong(int id, int idPhongTro, int idNguoiThue, LocalDate ngayBatDau, LocalDate ngayKetThuc, String trangThai) {
        this.id = id;
        this.idPhongTro = idPhongTro;
        this.idNguoiThue = idNguoiThue;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.trangThai = trangThai;
    }
   public HopDong(){}
    // Getters và setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getIdPhongTro() { return idPhongTro; }
    public void setIdPhongTro(int idPhongTro) { this.idPhongTro = idPhongTro; }
    public int getIdNguoiThue() { return idNguoiThue; }
    public void setIdNguoiThue(int idNguoiThue) { this.idNguoiThue = idNguoiThue; }
    public LocalDate getNgayBatDau() { return ngayBatDau; }
    public void setNgayBatDau(LocalDate ngayBatDau) { this.ngayBatDau = ngayBatDau; }
    public LocalDate getNgayKetThuc() { return ngayKetThuc; }
    public void setNgayKetThuc(LocalDate ngayKetThuc) { this.ngayKetThuc = ngayKetThuc; }
    public String getTrangThai() { return trangThai; }
    public void setTrangThai(String trangThai) { this.trangThai = trangThai; }
}