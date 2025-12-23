package dao;

import common.Database;
import model.HopDong;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HopDongDAO {
    public List<HopDong> getHopDongByNguoiThue(int idNguoiThue) {
        List<HopDong> dsHopDong = new ArrayList<>();
        String sql = "SELECT * FROM hop_dong WHERE id_nguoi_thue = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idNguoiThue);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    HopDong hopDong = new HopDong();
                    hopDong.setId(rs.getInt("id"));
                    hopDong.setIdPhongTro(rs.getInt("id_phong_tro"));
                    hopDong.setIdNguoiThue(rs.getInt("id_nguoi_thue"));
                    hopDong.setNgayBatDau(rs.getDate("ngay_bat_dau").toLocalDate());
                    hopDong.setNgayKetThuc(rs.getDate("ngay_ket_thuc").toLocalDate());
                    hopDong.setTrangThai(rs.getString("trang_thai"));
                    dsHopDong.add(hopDong);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsHopDong;
    }

    public List<HopDong> getHopDongByChuTro(int idChuTro) {
        List<HopDong> dsHopDong = new ArrayList<>();
        String sql = "SELECT h.* FROM hop_dong h JOIN phong_tro p ON h.id_phong_tro = p.id WHERE p.id_chu_tro = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idChuTro);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    HopDong hopDong = new HopDong();
                    hopDong.setId(rs.getInt("id"));
                    hopDong.setIdPhongTro(rs.getInt("id_phong_tro"));
                    hopDong.setIdNguoiThue(rs.getInt("id_nguoi_thue"));
                    hopDong.setNgayBatDau(rs.getDate("ngay_bat_dau").toLocalDate());
                    hopDong.setNgayKetThuc(rs.getDate("ngay_ket_thuc").toLocalDate());
                    hopDong.setTrangThai(rs.getString("trang_thai"));
                    dsHopDong.add(hopDong);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsHopDong;
    }
    public void themHopDong(HopDong hopDong) {
        String sql = "INSERT INTO hop_dong (id_phong_tro, id_nguoi_thue, ngay_bat_dau, ngay_ket_thuc, trang_thai) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, hopDong.getIdPhongTro());
            ps.setInt(2, hopDong.getIdNguoiThue());
            ps.setString(3, hopDong.getNgayBatDau().toString());
            ps.setString(4, hopDong.getNgayKetThuc().toString());
            ps.setString(5, hopDong.getTrangThai());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void suaHopDong(LocalDate nbd,LocalDate nkt, int id) {
        String sql = "UPDATE hop_dong SET ngay_bat_dau = ?, ngay_ket_thuc = ? WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nbd.toString());
            ps.setString(2, nkt.toString());
            ps.setInt(3, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void xoaHopDong(int id) {
        String sql = "DELETE FROM hop_dong WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public HopDong getHDById(int id) {
        HopDong hopDong = new HopDong();
        String sql = "SELECT * FROM hop_dong WHERE id=?";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                     hopDong = new HopDong();
                    hopDong.setId(rs.getInt("id"));
                    hopDong.setIdPhongTro(rs.getInt("id_phong_tro"));
                    hopDong.setIdNguoiThue(rs.getInt("id_nguoi_thue"));
                    hopDong.setNgayBatDau(rs.getDate("ngay_bat_dau").toLocalDate());
                    hopDong.setNgayKetThuc(rs.getDate("ngay_ket_thuc").toLocalDate());
                    hopDong.setTrangThai(rs.getString("trang_thai"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hopDong;
    }
}