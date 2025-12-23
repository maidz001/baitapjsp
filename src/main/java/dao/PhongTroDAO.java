package dao;

import common.Database;
import model.PhongTro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhongTroDAO {

    public List<PhongTro> hienThiPhongTro(){
        String sql="SELECT * FROM phong_tro where trang_thai='trong' AND trang_thai<>'da_xoa'";
        List<PhongTro> dsPhong = new ArrayList<>();
        try {
            Connection conn = Database.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                int idchutro =rs.getInt("id_chu_tro");
                String diachi=rs.getString("dia_chi");
                String khuvuc=rs.getString("khu_vuc");
                double gia=rs.getDouble("gia");
                double tien_dich_vu=rs.getDouble("tien_dich_vu");
                int so_nguoi=rs.getInt("so_nguoi");
                String trangthai=rs.getString("trang_thai");
                String mota=rs.getString("mo_ta");
                String dieukien=rs.getString("thanhtoan");
                String image=rs.getString("image");
                PhongTro phong = new PhongTro(id,idchutro,diachi,khuvuc,gia,tien_dich_vu,trangthai,mota,so_nguoi,dieukien,image);
                dsPhong.add(phong);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return dsPhong;
    }
    public List<PhongTro> hienThiPhongTroDaXoa(){
        String sql="SELECT * FROM phong_tro where trang_thai='da_xoa'";
        List<PhongTro> dsPhong = new ArrayList<>();
        try {
            Connection conn = Database.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                int idchutro =rs.getInt("id_chu_tro");
                String diachi=rs.getString("dia_chi");
                String khuvuc=rs.getString("khu_vuc");
                double gia=rs.getDouble("gia");
                double tien_dich_vu=rs.getDouble("tien_dich_vu");
                int so_nguoi=rs.getInt("so_nguoi");
                String trangthai=rs.getString("trang_thai");
                String mota=rs.getString("mo_ta");
                String dieukien=rs.getString("thanhtoan");
                String image=rs.getString("image");
                PhongTro phong = new PhongTro(id,idchutro,diachi,khuvuc,gia,tien_dich_vu,trangthai,mota,so_nguoi,dieukien,image);
                dsPhong.add(phong);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return dsPhong;
    }
    public List<PhongTro> timPhongTro(String khuVuc, Double minGia, Double maxGia) {
        List<PhongTro> dsPhong = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM phong_tro WHERE trang_thai = 'trong'");
        if (khuVuc!="") {
            sql.append(" AND khu_vuc LIKE ?");
        }
        if (minGia != null&&minGia!=-1) {
            sql.append(" AND gia >= ?");
        }
        if (maxGia != null&&maxGia!=-1) {
            sql.append(" AND gia <= ?");
        }

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql.toString())) {
              int i=0;
            if (khuVuc!="") {
                i++;
                ps.setString(i,"%"+khuVuc+"%");
            }
            if (minGia != null&&minGia!=-1) {
                i++;
                ps.setDouble(i, minGia);
            }
            if (maxGia != null&&maxGia!=-1) {
                i++;
                ps.setDouble(i, maxGia);
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PhongTro phong = new PhongTro();
                phong.setId(rs.getInt("id"));
                phong.setIdChuTro(rs.getInt("id_chu_tro"));
                phong.setDiaChi(rs.getString("dia_chi"));
                phong.setKhuVuc(rs.getString("khu_vuc"));
                phong.setGia(rs.getDouble("gia"));
                phong.setTrangThai(rs.getString("trang_thai"));
                phong.setMoTa(rs.getString("mo_ta"));
                phong.setImage(rs.getString("image"));
                dsPhong.add(phong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsPhong;
    }

    public List<PhongTro> getPhongTroByChuTro(int idChuTro) {
        List<PhongTro> dsPhong = new ArrayList<>();
        String sql = "SELECT * FROM phong_tro WHERE id_chu_tro = ? AND trang_thai <> 'da_xoa' AND trang_thai <> 'da_thue'<>'da_xoa'" ;
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idChuTro);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    PhongTro phong = new PhongTro();
                    phong.setId(rs.getInt("id"));
                    phong.setIdChuTro(rs.getInt("id_chu_tro"));
                    phong.setDiaChi(rs.getString("dia_chi"));
                    phong.setKhuVuc(rs.getString("khu_vuc"));
                    phong.setGia(rs.getDouble("gia"));
                    phong.setSoNguoi(rs.getInt("so_nguoi"));
                    phong.setTrangThai(rs.getString("trang_thai"));
                    phong.setMoTa(rs.getString("mo_ta"));
                    phong.setImage(rs.getString("image"));
                    dsPhong.add(phong);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsPhong;
    }

    public void themPhongTro(PhongTro phong) {
        String sql = "INSERT INTO phong_tro (id_chu_tro, dia_chi, khu_vuc, gia, trang_thai, mo_ta, so_nguoi, thanhtoan, tien_dich_vu, image) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, phong.getIdChuTro());
            ps.setString(2, phong.getDiaChi());
            ps.setString(3, phong.getKhuVuc());
            ps.setDouble(4, phong.getGia());
            ps.setString(5, phong.getTrangThai());
            ps.setString(6, phong.getMoTa());
            ps.setInt(7, phong.getSoNguoi());
            ps.setString(8, phong.getDieuKien());
            ps.setDouble(9, phong.getTienDichVu());
            ps.setString(10, phong.getImage());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void suaPhongTro(PhongTro phong) {
        String sql = "UPDATE phong_tro SET dia_chi = ?, khu_vuc = ?, gia = ?, trang_thai = ?, mo_ta = ? , so_nguoi=?,thanhtoan=? ,tien_dich_vu=? WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, phong.getDiaChi());
            ps.setString(2, phong.getKhuVuc());
            ps.setDouble(3, phong.getGia());
            ps.setString(4, phong.getTrangThai());
            ps.setString(5, phong.getMoTa());
            ps.setInt(6,phong.getSoNguoi());
            ps.setString(7,phong.getDieuKien());
            ps.setDouble(8,phong.getTienDichVu());
            ps.setInt(9, phong.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void xoaPhongTro(int id) {
        String sql = " UPDATE phong_tro SET trang_thai = 'da_xoa' WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<PhongTro> phongTroById(int id){
        List<PhongTro> listById=new ArrayList<>();
       PhongTro one=new PhongTro();
        try {
            Connection conn = Database.getConnection();
            PreparedStatement pstt = conn.prepareStatement("SELECT * FROM phong_tro WHERE id=?");
            pstt.setInt(1, id);
            ResultSet rs = pstt.executeQuery();
            while(rs.next()){
                int id1=rs.getInt("id");
                int idchutro =rs.getInt("id_chu_tro");
                String diachi=rs.getString("dia_chi");
                String khuvuc=rs.getString("khu_vuc");
                double gia=rs.getDouble("gia");
                double tiendichvu=rs.getDouble("tien_dich_vu");
                int so_nguoi=rs.getInt("so_nguoi");
                String trangthai=rs.getString("trang_thai");
                String mota=rs.getString("mo_ta");
                String dieuKien=rs.getString("thanhtoan");
                String image=rs.getString("image");
                one = new PhongTro(id1,idchutro,diachi,khuvuc,gia,tiendichvu,trangthai,mota,so_nguoi,dieuKien,image);
                listById.add(one);
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listById;
    }
    public PhongTro phongById(int id){
        PhongTro one=new PhongTro();
        try {
            Connection conn = Database.getConnection();
            PreparedStatement pstt = conn.prepareStatement("SELECT * FROM phong_tro WHERE id=?");
            pstt.setInt(1, id);
            ResultSet rs = pstt.executeQuery();
            while(rs.next()){
                int id1=rs.getInt("id");
                int idchutro =rs.getInt("id_chu_tro");
                String diachi=rs.getString("dia_chi");
                String khuvuc=rs.getString("khu_vuc");
                double gia=rs.getDouble("gia");
                double tiendichvu=rs.getDouble("tien_dich_vu");
                int so_nguoi=rs.getInt("so_nguoi");
                String trangthai=rs.getString("trang_thai");
                String mota=rs.getString("mo_ta");
                String dieuKien=rs.getString("thanhtoan");
                String image=rs.getString("image");
                one = new PhongTro(id1,idchutro,diachi,khuvuc,gia,tiendichvu,trangthai,mota,so_nguoi,dieuKien,image);
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return one;
    }
    public List<PhongTro> dangKyHopDong(int id) {
        List<PhongTro> all=new ArrayList<>();
        PhongTro one=new PhongTro();
        String sql = "SELECT nguoi_dung.ho_ten,phong_tro.gia, phong_tro.dia_chi ,phong_tro.tien_dich_vu FROM nguoi_dung JOIN phong_tro ON nguoi_dung.id = phong_tro.id_chu_tro  WHERE phong_tro.id = ?";
        try {
            Connection conn = Database.getConnection();
            PreparedStatement pstt = conn.prepareStatement(sql);
            pstt.setInt(1, id);
            ResultSet rs = pstt.executeQuery();
            String name="aaaa";
            String diaChi="aaaaa";
            while(rs.next()){
                name=rs.getString("ho_ten");
                diaChi=rs.getString("dia_chi");
                double gia=rs.getDouble("gia");
                double tiendichvu=rs.getDouble("tien_dich_vu");

                one = new PhongTro(id,0,diaChi,name,gia,tiendichvu,"trangthai","mota",1,"dieuKien","0");
                all.add(one);
            }
        }

        catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        return all;
    }
    public void suaTrangThai(String trangThai, int id){
        String sql="UPDATE phong_tro SET trang_thai = ? WHERE id = ?";
        try {
            Connection conn=Database.getConnection();
            PreparedStatement pstt=conn.prepareStatement(sql);
            pstt.setString(1,trangThai);
            pstt.setInt(2,id);
            pstt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<PhongTro> sortByGia(String yeuCau) throws SQLException {
        List<PhongTro> sort=new ArrayList<>();
        String sql="";
        if(yeuCau.equals("tang")){
            sql="SELECT * FROM phong_tro WHERE trang_thai<>'da_xoa' AND trang_thai<>'da_thue' ORDER BY gia ASC";
        }
        if(yeuCau.equals("giam")){
            sql="SELECT * FROM phong_tro WHERE trang_thai<>'da_xoa' AND trang_thai<>'da_thue' ORDER BY gia DESC";
        }
        Connection conn=Database.getConnection();
        PreparedStatement pstt=conn.prepareStatement(sql);
        ResultSet rs=pstt.executeQuery();
        while (rs.next()){
            int id1=rs.getInt("id");
            int idchutro =rs.getInt("id_chu_tro");
            String diachi=rs.getString("dia_chi");
            String khuvuc=rs.getString("khu_vuc");
            double gia=rs.getDouble("gia");
            double tiendichvu=rs.getDouble("tien_dich_vu");
            int so_nguoi=rs.getInt("so_nguoi");
            String trangthai=rs.getString("trang_thai");
            String mota=rs.getString("mo_ta");
            String dieuKien=rs.getString("thanhtoan");
            String image=rs.getString("image");
             PhongTro one = new PhongTro(id1,idchutro,diachi,khuvuc,gia,tiendichvu,trangthai,mota,so_nguoi,dieuKien,image);
            sort.add(one);
        }
        return sort;
    }
    public List<PhongTro> locTheoTieuChi(String tieuchi) throws SQLException {
        List<PhongTro> listByTieuChi = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM phong_tro WHERE trang_thai<>'da_xoa' AND trang_thai<>'da_thue' ");
        if(tieuchi.equals("giare")){
            sql.append("AND gia<=2500000");
        }
        if(tieuchi.equals("giatot")){
            sql.append("AND gia<3000000");
        }
        if(tieuchi.equals("hanoi")){
            sql.append("AND khu_vuc like '%Hà Nội%'");
        }
        if(tieuchi.equals("hochiminh")){
            sql.append("AND khu_vuc like '%Hồ Chí Minh%'");
        }
        if(tieuchi.equals("caocap")){
            sql.append("AND gia>=3000000");
        }
        try{
            Connection conn=Database.getConnection();
            PreparedStatement pstt=conn.prepareStatement(sql.toString());
            ResultSet rs=pstt.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                int idchutro =rs.getInt("id_chu_tro");
                String diachi=rs.getString("dia_chi");
                String khuvuc=rs.getString("khu_vuc");
                double gia=rs.getDouble("gia");
                double tien_dich_vu=rs.getDouble("tien_dich_vu");
                int so_nguoi=rs.getInt("so_nguoi");
                String trangthai=rs.getString("trang_thai");
                String mota=rs.getString("mo_ta");
                String dieukien=rs.getString("thanhtoan");
                String image=rs.getString("image");
                PhongTro phong = new PhongTro(id,idchutro,diachi,khuvuc,gia,tien_dich_vu,trangthai,mota,so_nguoi,dieukien,image);
                listByTieuChi.add(phong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listByTieuChi;
    }

    public List<PhongTro> sortByGiaTheoCT(String yeuCau, int idChuTro) throws SQLException {
        List<PhongTro> sort=new ArrayList<>();
        String sql="";
        if(yeuCau.equals("tang")){
            sql="SELECT * FROM phong_tro WHERE id_chu_tro=? AND trang_thai<>'da_xoa' AND trang_thai<>'da_thue' ORDER BY gia ASC ";
        }
        if(yeuCau.equals("giam")){
            sql="SELECT * FROM phong_tro WHERE id_chu_tro=? AND trang_thai<>'da_xoa' AND trang_thai<>'da_thue' ORDER BY gia DESC ";
        }
        Connection conn=Database.getConnection();
        PreparedStatement pstt=conn.prepareStatement(sql);
        pstt.setInt(1,idChuTro);
        ResultSet rs=pstt.executeQuery();
        while (rs.next()){
            int id1=rs.getInt("id");
            int idchutro =rs.getInt("id_chu_tro");
            String diachi=rs.getString("dia_chi");
            String khuvuc=rs.getString("khu_vuc");
            double gia=rs.getDouble("gia");
            double tiendichvu=rs.getDouble("tien_dich_vu");
            int so_nguoi=rs.getInt("so_nguoi");
            String trangthai=rs.getString("trang_thai");
            String mota=rs.getString("mo_ta");
            String dieuKien=rs.getString("thanhtoan");
            String image=rs.getString("image");
            PhongTro one = new PhongTro(id1,idchutro,diachi,khuvuc,gia,tiendichvu,trangthai,mota,so_nguoi,dieuKien,image);
            sort.add(one);
        }
        return sort;
    }
    public List<PhongTro> locTheoTieuChiByCT(String tieuchi,int id_chu_tro) throws SQLException {
        List<PhongTro> listByTieuChi = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM phong_tro WHERE id_chu_tro=? AND trang_thai<>'da_xoa' AND trang_thai<>'da_thue' ");
        if(tieuchi.equals("giare")){
            sql.append("AND gia<=2500000");
        }
        if(tieuchi.equals("giatot")){
            sql.append("AND gia<3000000");
        }
        if(tieuchi.equals("hanoi")){
            sql.append("AND khu_vuc like '%Hà Nội%'");
        }
        if(tieuchi.equals("hochiminh")){
            sql.append("AND khu_vuc like '%Hồ Chí Minh%'");
        }
        if(tieuchi.equals("caocap")){
            sql.append("AND gia>=3000000");
        }
        try{
            Connection conn=Database.getConnection();
            PreparedStatement pstt=conn.prepareStatement(sql.toString());
            pstt.setInt(1,id_chu_tro);
            ResultSet rs=pstt.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                int idchutro =rs.getInt("id_chu_tro");
                String diachi=rs.getString("dia_chi");
                String khuvuc=rs.getString("khu_vuc");
                double gia=rs.getDouble("gia");
                double tien_dich_vu=rs.getDouble("tien_dich_vu");
                int so_nguoi=rs.getInt("so_nguoi");
                String trangthai=rs.getString("trang_thai");
                String mota=rs.getString("mo_ta");
                String dieukien=rs.getString("thanhtoan");
                String image=rs.getString("image");
                PhongTro phong = new PhongTro(id,idchutro,diachi,khuvuc,gia,tien_dich_vu,trangthai,mota,so_nguoi,dieukien,image);
                listByTieuChi.add(phong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listByTieuChi;
    }

    public List<PhongTro> phongMoiNhat() throws SQLException {
        List<PhongTro> sort=new ArrayList<>();
        String sql="SELECT * FROM phong_tro WHERE trang_thai<>'da_xoa' AND trang_thai<>'da_thue' ORDER BY id DESC";
        Connection conn=Database.getConnection();
        PreparedStatement pstt=conn.prepareStatement(sql);
        ResultSet rs=pstt.executeQuery();
        while (rs.next()){
            int id1=rs.getInt("id");
            int idchutro =rs.getInt("id_chu_tro");
            String diachi=rs.getString("dia_chi");
            String khuvuc=rs.getString("khu_vuc");
            double gia=rs.getDouble("gia");
            double tiendichvu=rs.getDouble("tien_dich_vu");
            int so_nguoi=rs.getInt("so_nguoi");
            String trangthai=rs.getString("trang_thai");
            String mota=rs.getString("mo_ta");
            String dieuKien=rs.getString("thanhtoan");
            String image=rs.getString("image");
            PhongTro one = new PhongTro(id1,idchutro,diachi,khuvuc,gia,tiendichvu,trangthai,mota,so_nguoi,dieuKien,image);
            sort.add(one);
        }
        return sort;
    }

}