package model;

import java.time.LocalDate;
import java.util.Date;

public class ThongBao {
    private int id;
    private int idChuTro;
    private int idNguoiThue;
    private String noiDung;
    private LocalDate ngayTao;
    private String loai;

    public ThongBao() {}

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getLoai() {
        return loai;
    }

    public ThongBao(int id, int idChuTro, int idNguoiThue, String noiDung, LocalDate ngayTao, String loai) {
        this.id = id;
        this.idChuTro = idChuTro;
        this.idNguoiThue = idNguoiThue;
        this.noiDung = noiDung;
        this.ngayTao = ngayTao;
        this.loai=loai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdChuTro() {
        return idChuTro;
    }

    public void setIdChuTro(int idChuTro) {
        this.idChuTro = idChuTro;
    }

    public int getIdNguoiThue() {
        return idNguoiThue;
    }

    public void setIdNguoiThue(int idNguoiThue) {
        this.idNguoiThue = idNguoiThue;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }
}