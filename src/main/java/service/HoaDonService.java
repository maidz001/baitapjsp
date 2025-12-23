package service;

import dao.HoaDonDAO;
import model.HoaDon;
import model.HopDong;

import java.sql.SQLException;
import java.util.List;

public class HoaDonService {
    private HoaDonDAO hoaDonDAO = new HoaDonDAO();

    public List<HoaDon> getHoaDonThangVuaQua(int idhopdong) {
        return hoaDonDAO.getHoaDonThangVuaQua(idhopdong);
    }

    public List<HoaDon> getHoaDonByChuTro(int idChuTro) {
        return hoaDonDAO.getHoaDonByChuTro(idChuTro);
    }

    public void themHoaDon(HoaDon hoaDon) {
        hoaDonDAO.themHoaDon(hoaDon);
    }

    public void suaHoaDon(HoaDon hoaDon) {
        hoaDonDAO.suaHoaDon(hoaDon);
    }

    public void xoaHoaDon(int id) {
        hoaDonDAO.xoaHoaDon(id);
    }

    public void thanhToanHoaDon(int idHoaDon) {
        hoaDonDAO.thanhToanHoaDon(idHoaDon);
    }

    public List<HoaDon> getCocByHopDong(int id) throws SQLException {
        return hoaDonDAO.getCocByHopDong(id);
    }
    public List<HoaDon> getHoaDonByHD(List<HopDong> hd){
        return hoaDonDAO.getHoaDonByHD(hd);
    }
    public HoaDon getHoaDonById(int id) {
        return hoaDonDAO.getHoaDonById(id);
    }
}