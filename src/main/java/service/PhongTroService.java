package service;

import dao.PhongTroDAO;
import model.HopDong;
import model.PhongTro;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhongTroService {
    private PhongTroDAO phongTroDAO = new PhongTroDAO();

    public List<PhongTro> findAll(){
        return phongTroDAO.hienThiPhongTro();
    }
    public List<PhongTro> phongTroById(int id){
        return phongTroDAO.phongTroById(id);
    }
    public List<PhongTro> timPhongTro(String khuVuc, Double minGia, Double maxGia) {
        return phongTroDAO.timPhongTro(khuVuc, minGia, maxGia);
    }

    public List<PhongTro> getPhongTroByChuTro(int idChuTro) {
        return phongTroDAO.getPhongTroByChuTro(idChuTro);
    }

    public void themPhongTro(PhongTro phong) {
        phongTroDAO.themPhongTro(phong);
    }

    public void suaPhongTro(PhongTro phong) {
        phongTroDAO.suaPhongTro(phong);
    }

    public void xoaPhongTro(int id) {
        phongTroDAO.xoaPhongTro(id);
    }
    public List<PhongTro> sortByGia(String yeuCau) throws SQLException {
        return phongTroDAO.sortByGia(yeuCau);
    }
    public void suaTrangthai(String trangThai,int id) {
        phongTroDAO.suaTrangThai(trangThai,id);
    }

    public List<PhongTro> phongByHopDong(List<HopDong> hd){
        List<PhongTro> phongByHD=new ArrayList<>();
        for(HopDong p : hd){
            phongByHD.add(phongTroById(p.getIdPhongTro()).get(0));
        }
        return phongByHD;
    }
    public List<PhongTro> locTheoTieuChi(String tieuchi) throws SQLException {
        return phongTroDAO.locTheoTieuChi(tieuchi);
    }

    public List<PhongTro> sortByGiaTheoCT(String yeuCau, int idChuTro) throws SQLException {
        return phongTroDAO.sortByGiaTheoCT(yeuCau,idChuTro);
    }

    public List<PhongTro> locTheoTieuChiByCT(String tieuchi,int id_chu_tro) throws SQLException {
        return phongTroDAO.locTheoTieuChiByCT(tieuchi,id_chu_tro);
    }

    public List<PhongTro> phongMoiNhat() throws SQLException {
        return phongTroDAO.phongMoiNhat();
    }

    public List<PhongTro> phongDaXoa() {
        return phongTroDAO.hienThiPhongTroDaXoa();
    }
    public PhongTro phongByID(int id) {
        return phongTroDAO.phongById(id);
    }
}