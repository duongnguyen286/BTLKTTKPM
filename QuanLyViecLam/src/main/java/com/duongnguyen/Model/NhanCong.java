package com.duongnguyen.Model;

import java.sql.Date;

public class NhanCong {
  private int id;
  private String ten;

  private Date ngaySinh;
  private String diaChi;


  private String email;
  private String maNC;


  public NhanCong(int id, String ten, Date ngaySinh, String diaChi, String email, String maNC) {
    this.id = id;
    this.ten = ten;
    this.ngaySinh = ngaySinh;
    this.diaChi = diaChi;
    this.email = email;
    this.maNC = maNC;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTen() {
    return ten;
  }

  public void setTen(String ten) {
    this.ten = ten;
  }

  public Date getNgaySinh() {
    return ngaySinh;
  }

  public void setNgaySinh(Date ngaySinh) {
    this.ngaySinh = ngaySinh;
  }

  public String getDiaChi() {
    return diaChi;
  }

  public void setDiaChi(String diaChi) {
    this.diaChi = diaChi;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getMaNC() {
    return maNC;
  }

  public void setMaNC(String maNC) {
    this.maNC = maNC;
  }
}
