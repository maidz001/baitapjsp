package service;

import dao.ThongBaoDAO;
import model.ThongBao;

import java.util.List;

public class ThongBaoService {
    private ThongBaoDAO thongBaoDAO = new ThongBaoDAO();

    public void guiThongBaoChoND(ThongBao thongBao) {
        thongBaoDAO.guiThongBaoChoND(thongBao);
    }
    public void guiThongBaoChoCT(ThongBao thongBao) {
        thongBaoDAO.guiThongBaoChoCT(thongBao);
    }
    public List<ThongBao> allThongBao(int idnguoidung){
        return thongBaoDAO.allThongBao(idnguoidung);
    }public List<ThongBao> allThongBaoByCT(int idnguoidung){
        return thongBaoDAO.allThongBaoByCT(idnguoidung);
    }

    public void xoaThongBao(int id) {
        thongBaoDAO.xoaThongBao(id);
    }
    public void xoaThongBaoTTHD(String yeucau) {
        thongBaoDAO.xoaThongBaoTTHD(yeucau);
    }
}