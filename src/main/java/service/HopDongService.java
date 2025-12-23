package service;

import dao.HopDongDAO;
import model.HopDong;

import java.time.LocalDate;
import java.util.List;

public class HopDongService {
    private HopDongDAO hopDongDAO = new HopDongDAO();

    public List<HopDong> getHopDongByNguoiThue(int idNguoiThue) {
        return hopDongDAO.getHopDongByNguoiThue(idNguoiThue);
    }
    public List<HopDong> getHopDongByChuTro(int idChuTro) {
        return hopDongDAO.getHopDongByChuTro(idChuTro);
    }
    public void themHopDong(HopDong hopDong) {
        hopDongDAO.themHopDong(hopDong);
    }

    public void suaHopDong(LocalDate nbd,LocalDate nkt,int id) {
        hopDongDAO.suaHopDong(nbd,nkt,id);
    }

    public void xoaHopDong(int id) {
        hopDongDAO.xoaHopDong(id);
    }
     public HopDong getHDById(int id){
        return hopDongDAO.getHDById(id);
     }
}