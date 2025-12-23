package dao;

import common.Database;
import model.ThongBao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ThongBaoDAO {
    public void guiThongBaoChoND(ThongBao thongBao) {
        String sql = "INSERT INTO thong_bao (id_chu_tro, id_nguoi_thue, noi_dung,ngay_tao,loai) VALUES (?, ?,?, ?,?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, null);
            ps.setInt(2, thongBao.getIdNguoiThue());
            ps.setString(3, thongBao.getNoiDung());
            ps.setString(4,thongBao.getNgayTao().toString());
            ps.setString(5,thongBao.getLoai());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void guiThongBaoChoCT(ThongBao thongBao) {
        String sql = "INSERT INTO thong_bao (id_chu_tro, id_nguoi_thue, noi_dung,ngay_tao,loai) VALUES (?, ?,?, ?,?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, thongBao.getIdChuTro());
            ps.setInt(2, thongBao.getIdNguoiThue());
            ps.setString(3, thongBao.getNoiDung());
            ps.setString(4,thongBao.getNgayTao().toString());
            ps.setString(5,thongBao.getLoai());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<ThongBao> allThongBao(int idnguoidung) {
        List<ThongBao> all=new ArrayList<>();
        String sql="SELECT * FROM thong_bao WHERE id_nguoi_thue=? AND id_chu_tro IS NULL";
        try{
            Connection conn=Database.getConnection();
            PreparedStatement pstt=conn.prepareStatement(sql);
            pstt.setInt(1,idnguoidung);
            ResultSet rs=pstt.executeQuery();
            while (rs.next()){
                ThongBao thongbao=new ThongBao(rs.getInt("id"),rs.getInt("id_chu_tro"),rs.getInt("id_nguoi_thue"),rs.getString("noi_dung"),rs.getDate("ngay_tao").toLocalDate(),rs.getString("loai"));
                all.add(thongbao);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return all;
    }
    public List<ThongBao> allThongBaoByCT(int idnguoidung) {
        List<ThongBao> all=new ArrayList<>();
        String sql="SELECT * FROM thong_bao WHERE id_chu_tro=?";
        try{
            Connection conn=Database.getConnection();
            PreparedStatement pstt=conn.prepareStatement(sql);
            pstt.setInt(1,idnguoidung);
            ResultSet rs=pstt.executeQuery();
            while (rs.next()){
                ThongBao thongbao=new ThongBao(rs.getInt("id"),rs.getInt("id_chu_tro"),rs.getInt("id_nguoi_thue"),rs.getString("noi_dung"),rs.getDate("ngay_tao").toLocalDate(),rs.getString("loai"));
                all.add(thongbao);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return all;
    }
    public void xoaThongBao(int id){
        String sql="DELETE FROM thong_bao WHERE id = ?";
        try{
            Connection conn=Database.getConnection();
            PreparedStatement pstt=conn.prepareStatement(sql);
            pstt.setInt(1,id);
            pstt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void xoaThongBaoTTHD(String yeucau) {
        String sql="";
        if(yeucau.equals("tien_dich_vu")) {
            sql = "DELETE FROM thong_bao WHERE loai='tien_dich_vu'";
        }
        if(yeucau.equals("tien-tro")) {
            sql = "DELETE FROM thong_bao WHERE loai='tien_tro'";
        }
        try{
            Connection conn=Database.getConnection();
            PreparedStatement pstt=conn.prepareStatement(sql);
            pstt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}