package dao;

import common.Database;
import model.HopDong;
import model.NguoiDung;

import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class NguoiDungDAO {
    public NguoiDung getNguoiThue(HopDong hd) {
        NguoiDung nguoiDung = new NguoiDung();
        String sql = "SELECT * FROM nguoi_dung WHERE vai_tro = 'nguoi_thue'";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                if(rs.getInt("id_nguoi_thue")==hd.getIdNguoiThue()){

                    nguoiDung.setId(rs.getInt("id"));
                    nguoiDung.setTenDangNhap(rs.getString("ten_dang_nhap"));
                    nguoiDung.setMatKhau(rs.getString("mat_khau"));
                    nguoiDung.setEmail(rs.getString("email"));
                    nguoiDung.setSoDienThoai(rs.getString("so_dien_thoai"));
                    nguoiDung.setVaiTro(rs.getString("vai_tro"));

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nguoiDung;
    }

    public NguoiDung getNguoiDungById(int id) {
        NguoiDung nguoiDung = null;
        String sql = "SELECT * FROM nguoi_dung WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    nguoiDung = new NguoiDung();
                    nguoiDung.setCccd(rs.getString("cccd"));
                    nguoiDung.setHo_ten(rs.getString("ho_ten"));
                    nguoiDung.setId(rs.getInt("id"));
                    nguoiDung.setTenDangNhap(rs.getString("ten_dang_nhap"));
                    nguoiDung.setMatKhau(rs.getString("mat_khau"));
                    nguoiDung.setEmail(rs.getString("email"));
                    nguoiDung.setSoDienThoai(rs.getString("so_dien_thoai"));
                    nguoiDung.setVaiTro(rs.getString("vai_tro"));
                    nguoiDung.setSoDu(rs.getDouble("so_du"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nguoiDung;
    }
    public void themNguoiDung(NguoiDung n) throws SQLException {
        String sql = "INSERT INTO nguoi_dung (ten_dang_nhap, mat_khau, email, so_dien_thoai, vai_tro, ho_ten, cccd,so_du) VALUES (?,?,?,?,?,?,?,?)";
        try {
            Connection conn=Database.getConnection();
            PreparedStatement pstt=conn.prepareStatement(sql);
            pstt.setString(1, n.getTenDangNhap());
            pstt.setString(2, n.getMatKhau());
            pstt.setString(3, n.getEmail());
            pstt.setString(4, n.getSoDienThoai());
            pstt.setString(5, n.getVaiTro());
            pstt.setString(6, n.getHo_ten());
            pstt.setString(7, n.getCccd());
            pstt.setDouble(8,0);
            pstt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public boolean checkUser(String user,String pass) throws SQLException {
        String sql="select * from nguoi_dung";
        boolean check=false;
        Connection conn=Database.getConnection();
        PreparedStatement pstt=conn.prepareStatement(sql);
        ResultSet rs=pstt.executeQuery();
        while ((rs.next())){
            if(rs.getString("ten_dang_nhap").equals(user)&&rs.getString("mat_khau").equals(pass)){
                check=true;
            }
            else{
                check=false;
            }
        }
        return check;
    }
    public boolean checkVaiTro(String user,String pass) throws SQLException {
        String sql="select * from nguoi_dung";
        boolean check=false;
        Connection conn=Database.getConnection();
        PreparedStatement pstt=conn.prepareStatement(sql);
        ResultSet rs=pstt.executeQuery();
        while ((rs.next())){
            if(rs.getString("ten_dang_nhap").equals(user)&&rs.getString("mat_khau").equals(pass)&&rs.getString("vai_tro").equals("nguoi_thue")){
                check=true;
            }
            else{
                check=false;
            }
        }
        return check;
    }
    public boolean checkUserName(String user) throws SQLException {
        String sql="select * from nguoi_dung";
        boolean check=false;
        Connection conn=Database.getConnection();
        PreparedStatement pstt=conn.prepareStatement(sql);
        ResultSet rs=pstt.executeQuery();
        while ((rs.next())){
            if(rs.getString("ten_dang_nhap").equals(user)){
                check=true;
            }
        }
        return check;
    }
    public boolean checkEmail(String email) throws SQLException {
        String sql="select * from nguoi_dung";
        boolean check=false;
        Connection conn=Database.getConnection();
        PreparedStatement pstt=conn.prepareStatement(sql);
        ResultSet rs=pstt.executeQuery();
        while ((rs.next())){
            if(rs.getString("email").equals(email)){
                check=true;
            }
        }
        return check;
    }
    public NguoiDung getNguoiDungByUser(String user) {
        NguoiDung nguoiDung = null;
        String sql = "SELECT * FROM nguoi_dung WHERE ten_dang_nhap = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    nguoiDung = new NguoiDung();
                    nguoiDung.setId(rs.getInt("id"));
                    nguoiDung.setTenDangNhap(rs.getString("ten_dang_nhap"));
                    nguoiDung.setMatKhau(rs.getString("mat_khau"));
                    nguoiDung.setCccd(rs.getString("cccd"));
                    nguoiDung.setHo_ten(rs.getString("ho_ten"));
                    nguoiDung.setEmail(rs.getString("email"));
                    nguoiDung.setSoDienThoai(rs.getString("so_dien_thoai"));
                    nguoiDung.setVaiTro(rs.getString("vai_tro"));
                    nguoiDung.setSoDu(rs.getDouble("so_du"));

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nguoiDung;
    }

    public void setSoDu(int id,double sodu) {
        String sql="UPDATE nguoi_dung set so_du=? WHERE id=?";
        try{
            Connection conn=Database.getConnection();
            PreparedStatement pstt=conn.prepareStatement(sql);
            pstt.setDouble(1,sodu);
            pstt.setInt(2,id);
            pstt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setNguoiDungByHD(String email,String sdt,int id){

        String sql="UPDATE nguoi_dung set email=?,so_dien_thoai=? WHERE id=?";
        try{
            Connection conn=Database.getConnection();
            PreparedStatement pstt=conn.prepareStatement(sql);
            pstt.setString(1,email);
            pstt.setString(2,sdt);
            pstt.setInt(3,id);
            pstt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}