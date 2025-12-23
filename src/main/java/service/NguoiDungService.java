package service;

import dao.NguoiDungDAO;
import model.HoaDon;
import model.HopDong;
import model.NguoiDung;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NguoiDungService {
    private NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();

    public NguoiDung getNguoiThue(HopDong hd) {
        return nguoiDungDAO.getNguoiThue(hd);
    }

    public NguoiDung getNguoiDungById(int id) {
        return nguoiDungDAO.getNguoiDungById(id);
    }
    public void themNguoiDung(NguoiDung n) throws SQLException {
       nguoiDungDAO.themNguoiDung(n);
    }
    public boolean checkUser(String user,String pass) throws SQLException {
        return nguoiDungDAO.checkUser(user,pass);
    }
    public void setSoDu(int id,double sodu) throws SQLException {
         nguoiDungDAO.setSoDu(id,sodu);
    }

    public NguoiDung getNguoiDungByUser(String user) {
        return nguoiDungDAO.getNguoiDungByUser(user);
    }
    public List<NguoiDung> nguoiDungByHD(List<HopDong> hd){
        List<NguoiDung> nd=new ArrayList<>();
        for(HopDong h:hd){
            nd.add(getNguoiDungById(h.getIdNguoiThue()));
        }
        return nd;
    }
    public void setNguoiDungByHD(String email,String sdt,int id){
         nguoiDungDAO.setNguoiDungByHD(email,sdt,id);
    }
}