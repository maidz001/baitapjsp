package dao;

import common.Database;
import model.TinNhan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TinNhanDAO {
    public List<TinNhan> layTinNhanGiua2Nguoi(int idnguoigui, int idnguoinhan) {
        List<TinNhan> l = new ArrayList<>();
        String sql = "SELECT * FROM tin_nhan WHERE idnguoigui=? AND idnguoinhan=? OR idnguoinhan=? AND idnguoigui=? ORDER BY thoigian";

        Connection conn = null;
        PreparedStatement pstt = null;
        ResultSet rs = null;

        try {
            conn = Database.getConnection();
            pstt = conn.prepareStatement(sql);
            pstt.setInt(1, idnguoigui);
            pstt.setInt(2, idnguoinhan);
            pstt.setInt(3, idnguoigui);
            pstt.setInt(4, idnguoinhan);

            rs = pstt.executeQuery();
            while (rs.next()) {
                TinNhan tinNhan = new TinNhan(
                        rs.getInt("id"),
                        rs.getInt("idnguoigui"),
                        rs.getInt("idnguoinhan"),
                        rs.getString("noidung"),
                        rs.getDate("thoigian").toLocalDate(),
                        rs.getString("trangthai")
                );
                l.add(tinNhan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (pstt != null) pstt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return l;
    }

}
