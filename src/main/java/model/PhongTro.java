package model;

public class PhongTro {
    private int id;
    private int idChuTro;
    private String diaChi;
    private String khuVuc;
    private double gia;
    private double tienDichVu;
    private String trangThai;
    private String moTa;
    private int soNguoi;
    private String dieuKien;
    private String image;

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public PhongTro(int id, int idChuTro, String diaChi, String khuVuc, double gia, double tienDichVu, String trangThai, String moTa, int soNguoi, String dieuKien, String image) {
        this.id = id;
        this.idChuTro = idChuTro;
        this.diaChi = diaChi;
        this.khuVuc = khuVuc;
        this.gia = gia;
        this.tienDichVu = tienDichVu;
        this.trangThai = trangThai;
        this.moTa = moTa;
        this.soNguoi = soNguoi;
        this.dieuKien = dieuKien;
        this.image=image;
    }

    public void setTienDichVu(double tienDichVu) {
        this.tienDichVu = tienDichVu;
    }

    public double getTienDichVu() {
        return tienDichVu;
    }

    public void setDieuKien(String dieuKien) {
        this.dieuKien = dieuKien;
    }

    public String getDieuKien() {
        return dieuKien;
    }

    public void setSoNguoi(int soNguoi) {
        this.soNguoi = soNguoi;
    }



    public PhongTro() {}

    public int getSoNguoi() {
        return soNguoi;
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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getKhuVuc() {
        return khuVuc;
    }

    public void setKhuVuc(String khuVuc) {
        this.khuVuc = khuVuc;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
