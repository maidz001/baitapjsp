package dao;

import common.Database;
import model.HoaDon;
import model.HopDong;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HoaDonDAO {
    public List<HoaDon> getHoaDonThangVuaQua(int idhopdong) {
        List<HoaDon> dsHoaDon = new ArrayList<>();
        LocalDate lastMonth = LocalDate.now().minusMonths(1);
        String sql = "SELECT * FROM hoa_don WHERE id_hop_dong=?";
        try {Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idhopdong);
            ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    HoaDon hoaDon = new HoaDon();
                    hoaDon.setId(rs.getInt("id"));
                    hoaDon.setIdHopDong(rs.getInt("id_hop_dong"));
                    hoaDon.setSoTien(rs.getDouble("so_tien"));
                    hoaDon.setNgayHan(rs.getDate("ngay_han").toLocalDate());
                    hoaDon.setLoaiThanhToan(rs.getString("loai_thanh_toan"));
                    hoaDon.setTrangThai(rs.getString("trang_thai"));
                    dsHoaDon.add(hoaDon);
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsHoaDon;
    }

    public List<HoaDon> getHoaDonByChuTro(int idChuTro) {
        List<HoaDon> dsHoaDon = new ArrayList<>();
        String sql = "SELECT hd.* FROM hoa_don hd " +
                "JOIN hop_dong h ON hd.id_hop_dong = h.id " +
                "JOIN phong_tro p ON h.id_phong_tro = p.id " +
                "WHERE p.id_chu_tro = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idChuTro);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    HoaDon hoaDon = new HoaDon();
                    hoaDon.setId(rs.getInt("id"));
                    hoaDon.setIdHopDong(rs.getInt("id_hop_dong"));
                    hoaDon.setSoTien(rs.getDouble("so_tien"));
                    hoaDon.setNgayHan(rs.getDate("ngay_han").toLocalDate());
                    hoaDon.setLoaiThanhToan(rs.getString("loai_thanh_toan"));
                    hoaDon.setTrangThai(rs.getString("trang_thai"));
                    dsHoaDon.add(hoaDon);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsHoaDon;
    }

    public void themHoaDon(HoaDon hoaDon) {
        String sql = "INSERT INTO hoa_don (id_hop_dong, so_tien, ngay_han, loai_thanh_toan,ngay_thanh_toan, trang_thai) VALUES (?,?, ?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, hoaDon.getIdHopDong());
            ps.setDouble(2, hoaDon.getSoTien());
            ps.setString(3, hoaDon.getNgayHan().toString());
            ps.setString(4, hoaDon.getLoaiThanhToan());
            ps.setString(5,hoaDon.getNgayThanhToan().toString());
            ps.setString(6, hoaDon.getTrangThai());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<HoaDon> getCocByHopDong(int idHopDong) throws SQLException {
        List<HoaDon> all=new ArrayList<>();
        String sql = "select * from hoa_don where id_hop_dong =? AND loai_thanh_toan ='tien_coc'";
        try {Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idHopDong);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                HoaDon hoaDon = new HoaDon();
                hoaDon.setId(rs.getInt("id"));
                hoaDon.setIdHopDong(rs.getInt("id_hop_dong"));
                hoaDon.setSoTien(rs.getDouble("so_tien"));
                hoaDon.setNgayHan(rs.getDate("ngay_han").toLocalDate());
                hoaDon.setNgayThanhToan(rs.getDate("ngay_thanh_toan").toLocalDate());
                hoaDon.setLoaiThanhToan(rs.getString("loai_thanh_toan"));
                hoaDon.setTrangThai(rs.getString("trang_thai"));
                all.add(hoaDon);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }


    public List<HoaDon> getHoaDonByIdHD(HopDong hd) throws SQLException {
        List<HoaDon> all=new ArrayList<>();
        String sql = "select * from hoa_don where id_hop_dong =?";
        try {Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, hd.getId());
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                HoaDon hoaDon = new HoaDon();
                hoaDon.setId(rs.getInt("id"));
                hoaDon.setIdHopDong(rs.getInt("id_hop_dong"));
                hoaDon.setSoTien(rs.getDouble("so_tien"));
                hoaDon.setNgayHan(rs.getDate("ngay_han").toLocalDate());
                hoaDon.setNgayThanhToan(rs.getDate("ngay_thanh_toan").toLocalDate());
                hoaDon.setLoaiThanhToan(rs.getString("loai_thanh_toan"));
                hoaDon.setTrangThai(rs.getString("trang_thai"));
                all.add(hoaDon);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }


    public void suaHoaDon(HoaDon hoaDon) {
        String sql = "UPDATE hoa_don SET id_hop_dong = ?, so_tien = ?, ngay_han = ?, loai_thanh_toan = ?, trang_thai = ? WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, hoaDon.getIdHopDong());
            ps.setDouble(2, hoaDon.getSoTien());
            ps.setString(3, hoaDon.getNgayHan().toString());
            ps.setString(4, hoaDon.getLoaiThanhToan());
            ps.setString(5, hoaDon.getTrangThai());
            ps.setInt(6, hoaDon.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void xoaHoaDon(int id) {
        String sql = "DELETE FROM hoa_don WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void thanhToanHoaDon(int idHoaDon) {
        String sql = "UPDATE hoa_don SET trang_thai = 'da_thanh_toan' WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idHoaDon);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public HoaDon getHoaDonById(int id) {
        String sql="SELECT * FROM hoa_don WHERE id=?";
        HoaDon hoaDonById=new HoaDon();
        try{
            Connection conn=Database.getConnection();
            PreparedStatement pstt=conn.prepareStatement(sql);
            pstt.setInt(1,id);
            ResultSet rs=pstt.executeQuery();
            while (rs.next()){
                hoaDonById.setId(rs.getInt("id"));
                hoaDonById.setIdHopDong(rs.getInt("id_hop_dong"));
                hoaDonById.setNgayHan(rs.getDate("ngay_han").toLocalDate());
                hoaDonById.setSoTien(rs.getDouble("so_tien"));
                hoaDonById.setTrangThai(rs.getString("trang_thai"));
                hoaDonById.setLoaiThanhToan(rs.getString("loai_thanh_toan"));
                hoaDonById.setGhiChu(rs.getString("ghi_chu"));
                hoaDonById.setNgayThanhToan(rs.getDate("ngay_thanh_toan").toLocalDate());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hoaDonById;
    }

    public List<HoaDon> getHoaDonByIdHD(int id) {
        String sql="SELECT * FROM hoa_don WHERE id_hop_dong=?";
        List<HoaDon> hoaDon=new ArrayList<>();
        try{
            Connection conn=Database.getConnection();
            PreparedStatement pstt=conn.prepareStatement(sql);
            pstt.setInt(1,id);
            ResultSet rs=pstt.executeQuery();
            while (rs.next()){
                HoaDon hoaDonById=new HoaDon();
                hoaDonById.setId(rs.getInt("id"));
                hoaDonById.setIdHopDong(rs.getInt("id_hop_dong"));
                hoaDonById.setNgayHan(rs.getDate("ngay_han").toLocalDate());
                hoaDonById.setSoTien(rs.getDouble("so_tien"));
                hoaDonById.setTrangThai(rs.getString("trang_thai"));
                hoaDonById.setLoaiThanhToan(rs.getString("loai_thanh_toan"));
                hoaDonById.setGhiChu(rs.getString("ghi_chu"));
                hoaDonById.setNgayThanhToan(rs.getDate("ngay_thanh_toan").toLocalDate());
                hoaDon.add(hoaDonById);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hoaDon;
    }


    public List<HoaDon> getHoaDonByHD(List<HopDong> hd) {
        List<HoaDon> dsHoaDon=new ArrayList<>();
        for(HopDong h:hd){
             for(HoaDon g:getHoaDonByIdHD(h.getId())){
                 dsHoaDon.add(g);
             }
        }

        return dsHoaDon;
    }
}
