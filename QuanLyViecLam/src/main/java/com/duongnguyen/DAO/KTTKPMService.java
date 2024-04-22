package com.duongnguyen.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class KTTKPMService {
  public Connection ConnectDB(){
    Connection connection = null;
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlynhancong", "root", "ngocanh286");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return connection;
  }

}
