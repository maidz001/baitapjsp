package model;

import java.sql.Timestamp;
import java.time.LocalDate;

public class TinNhan {
    private int id;
    private int idNguoiGui;
    private int idNguoiNhan;
    private String noiDung;
    private LocalDate thoiGian;
    private String trangThai;



    public TinNhan(int id,int idNguoiGui, int idNguoiNhan, String noiDung, LocalDate thoiGian, String trangThai) {
        this.id=id;
        this.idNguoiGui = idNguoiGui;
        this.idNguoiNhan = idNguoiNhan;
        this.noiDung = noiDung;
        this.thoiGian = thoiGian;
        this.trangThai = trangThai;
    }

    // Getter & Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdNguoiGui() {
        return idNguoiGui;
    }

    public void setIdNguoiGui(int idNguoiGui) {
        this.idNguoiGui = idNguoiGui;
    }

    public int getIdNguoiNhan() {
        return idNguoiNhan;
    }

    public void setIdNguoiNhan(int idNguoiNhan) {
        this.idNguoiNhan = idNguoiNhan;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public LocalDate getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(LocalDate thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}

