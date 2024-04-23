package com.duongnguyen.DAO;

import com.duongnguyen.Model.DauViec;
import com.duongnguyen.Model.NhanCong;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class DAO {

  private static KTTKPMService Ps = new KTTKPMService();

  private static final String select_dauviecs = "SELECT * FROM dauviec";
  private static final String select_dauviec = "SELECT * FROM dauviec where id = ?";
  private static final String update_dauviec = "update dauviec set ten=?,  moTa = ?, "
      + "thoiHan=?, maDV=? where id = ?";

  private static final String insert_dauviec = "insert into dauviec values(?, ?, ?, ?,?)";
  private static final String delete_dauviec = "delete from dauviec where id = ?";
  private static String search_by_name_dauviec = "SELECT * FROM dauviec";

  private static final String delete_nhancong_in_dauviec = "DELETE FROM nhancongdauviec\n"
      + "WHERE idNhanCong = ?;";

  private static String select_nhancongs_by_dauviec = "SELECT nc.*\n"
      + "FROM nhancong nc\n"
      + "JOIN nhancongdauviec ncdv ON nc.id = ncdv.idNhanCong\n"
      + "WHERE ncdv.idDauViec = ?;";

  private static String select_nhancongs_available ="SELECT *\n"
      + "FROM nhancong\n"
      + "WHERE id NOT IN (SELECT idNhanCong FROM nhancongdauviec);";


    // Câu lên truy vấn tìm nhân công đang sẵn sàng:
//  SELECT * FROM nhancong
//  WHERE id NOT IN (SELECT idNhanCong FROM nhancongdauviec)
//  AND ten LIKE '%keyword%';
  private static String search_nhancongs_available= "SELECT * FROM nhancong " +
        "WHERE id NOT IN (SELECT idNhanCong FROM nhancongdauviec) " +
        "AND ten LIKE ?;";

  private static String insert_nhancongdauviec = "INSERT INTO nhancongdauviec (idNhanCong, idDauViec)\n"
      + "VALUES (?,?);";

  public DAO (){
 }

 public List<DauViec> getAllDauViec(){
    List<DauViec> list = new ArrayList<>();
    try {
      PreparedStatement pr = Ps.ConnectDB().prepareStatement(select_dauviecs);
      ResultSet rs = pr.executeQuery();
      while (rs.next()){
        int id = rs.getInt("id");
        String ten = rs.getString("ten");
        String moTa = rs.getString("moTa");
        Date thoiHan = rs.getDate("thoiHan");
        String maDV = rs.getString("maDV");

        DauViec dauViec = new DauViec(id, ten, moTa, thoiHan, maDV);
        list.add(dauViec);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return list;
 }

  public DauViec getDauViec(int iddauviec) {
    DauViec dauviec = new DauViec();
    try {
      PreparedStatement pr = Ps.ConnectDB().prepareStatement(select_dauviec);
      pr.setInt(1, iddauviec);
      ResultSet rs = pr.executeQuery();

      while (rs.next()) {
        int id = rs.getInt("id");
        String ten = rs.getString("ten");
        String moTa = rs.getString("moTa");
        Date thoiHan = rs.getDate("thoiHan");
        String maDV = rs.getString("maDV");

        dauviec = new DauViec(id, ten, moTa, thoiHan, maDV);
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return dauviec;
  }

  public void updateDauViec(DauViec dauviec, String id) {
    try {
      PreparedStatement ps = Ps.ConnectDB().prepareStatement(update_dauviec);
      ps.setString(1, dauviec.getTen());
      ps.setString(2, dauviec.getMoTa());
      ps.setDate(3, dauviec.getThoiHan());
      ps.setString(4, dauviec.getMaDV());
      ps.setInt(5, Integer.parseInt(id));

      ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void addDauViec(DauViec dauviec) {
    System.out.println("Ham adddauviec duoc goi");
    try {
      PreparedStatement ps = Ps.ConnectDB().prepareStatement(insert_dauviec);
      ps.setInt(1, dauviec.getId());
      ps.setString(2, dauviec.getTen());
      ps.setString(3, dauviec.getMoTa());
      ps.setDate(4, dauviec.getThoiHan());
      ps.setString(5, dauviec.getMaDV());

      ps.executeUpdate();

      System.out.println("Thêm thành công");
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  public void delete(String id) {
    try {
      PreparedStatement ps = Ps.ConnectDB().prepareStatement(delete_dauviec);
      ps.setString(1, id);
      ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public List<DauViec> searchDauViec(String key) {
    List<DauViec> list = new ArrayList<>();
// SELECT * FROM dauviec WHERE (ten LIKE '%key%') OR (moTa LIKE '%key%');
//    SELECT * FROM dauviec
//    WHERE (ten LIKE '%8%') OR (moTa LIKE '%z%') OR (maDV LIKE '%dv005%') OR (maDV LIKE '%dv005%');
    search_by_name_dauviec = "SELECT * FROM dauviec WHERE (ten LIKE '%" + key + "%') OR (moTa LIKE '%" + key + "%') OR (maDV LIKE '%" + key +"%')" ;

    try {
      PreparedStatement pr = Ps.ConnectDB().prepareStatement(search_by_name_dauviec);
      ResultSet rs = pr.executeQuery();

      while (rs.next()) {
        int id = rs.getInt("id");
        String ten = rs.getString("ten");
        String moTa = rs.getString("moTa");
        Date thoiHan = rs.getDate("thoiHan");
        String maDV = rs.getString("maDV");

        DauViec dauViec = new DauViec(id, ten, moTa, thoiHan, maDV);
        list.add(dauViec);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return list;
  }


  // Liên quan đến lên lịch làm việc cho nhân công
  public List<NhanCong> getNhanCongsByDauViec(int iddauviec){
    List<NhanCong> list = new ArrayList<>();
    try {
      PreparedStatement pr = Ps.ConnectDB().prepareStatement(select_nhancongs_by_dauviec);
      pr.setInt(1, iddauviec);
      ResultSet rs = pr.executeQuery();
      while (rs.next()){
        int id = rs.getInt("id");
        String ten = rs.getString("ten");
        Date ngaySinh = rs.getDate("ngaySinh");
        String diaChi = rs.getString("diaChi");
        String email = rs.getString("email");
        String maNC = rs.getString("maNC");

        NhanCong nhancong = new NhanCong(id, ten, ngaySinh, diaChi, email, maNC);
        list.add(nhancong);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return list;
  }

  public List<NhanCong> getNhanCongsAvailable(){
    List<NhanCong> list = new ArrayList<>();
    try {
      PreparedStatement pr = Ps.ConnectDB().prepareStatement(select_nhancongs_available);
      ResultSet rs = pr.executeQuery();
      while (rs.next()){
        int id = rs.getInt("id");
        String ten = rs.getString("ten");
        Date ngaySinh = rs.getDate("ngaySinh");
        String diaChi = rs.getString("diaChi");
        String email = rs.getString("email");
        String maNC = rs.getString("maNC");

        NhanCong nhancong = new NhanCong(id, ten, ngaySinh, diaChi, email, maNC);
        list.add(nhancong);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return list;
  }

  // Tìm kiếm nhân công đang ss theo tên
  public List<NhanCong> searchNhanCongsAvailable(String keyword){
    List<NhanCong> list = new ArrayList<>();
    try {
      PreparedStatement pr = Ps.ConnectDB().prepareStatement(search_nhancongs_available);
      pr.setString(1, "%" + keyword + "%");
      ResultSet rs = pr.executeQuery();
      while (rs.next()){
        int id = rs.getInt("id");
        String ten = rs.getString("ten");
        Date ngaySinh = rs.getDate("ngaySinh");
        String diaChi = rs.getString("diaChi");
        String email = rs.getString("email");
        String maNC = rs.getString("maNC");

        NhanCong nhancong = new NhanCong(id, ten, ngaySinh, diaChi, email, maNC);
        list.add(nhancong);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return list;
  }


  // Xóa nhân công trong 1 đầu việc
  public void deleteNhanCongInDauViec(String idnhancong) {
    try {
      PreparedStatement ps = Ps.ConnectDB().prepareStatement(delete_nhancong_in_dauviec);
      ps.setString(1, idnhancong);
      ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  // Thêm nhân công trong 1 đầu việc
  public void insertNhanCongDauViec(String idnhancong, String iddauviec) {
    try {
      PreparedStatement ps = Ps.ConnectDB().prepareStatement(insert_nhancongdauviec);
      ps.setString(1,idnhancong);
      ps.setString(2,iddauviec);

      ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}

