package com.duongnguyen.Model;

import java.sql.Date;

public class DauViec {
    private int id;
    private String ten;
    private String moTa;
  private Date thoiHan;

  private String maDV;

  public DauViec(int id, String ten, String moTa, Date thoiHan, String maDV) {
    this.id = id;
    this.ten = ten;
    this.moTa = moTa;
    this.thoiHan = thoiHan;
    this.maDV = maDV;
  }

  public DauViec() {

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

  public String getMoTa() {
    return moTa;
  }

  public void setMoTa(String moTa) {
    this.moTa = moTa;
  }

  public void setThoiHan(Date thoiHan) {
    this.thoiHan = thoiHan;
  }

  public Date getThoiHan() {
    return thoiHan;
  }

  public String getMaDV() {
    return maDV;
  }

  public void setMaDV(String maDV) {
    this.maDV = maDV;
  }
}
