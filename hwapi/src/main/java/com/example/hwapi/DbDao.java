package com.example.hwapi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


public class DbDao {
	
	static void UploadToDB(ArrayList<Student> SL) {
		
		Connection conn;
		String connectionUrl;
		connectionUrl = "jdbc:postgresql://localhost:5432/hongik?user=postgres&password=1234";
		try {
			conn = DriverManager.getConnection(connectionUrl);
			String sql;
			for (int i = 0; i < SL.size(); i++) {
				sql = "INSERT INTO STUDENTS VALUES(?,?,?,?,?)";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setInt(1, SL.get(i).getSid());
				pst.setString(2, SL.get(i).getName());
				pst.setString(3, SL.get(i).getEmail());
				pst.setInt(4, SL.get(i).getGraduation());
				pst.setString(5, SL.get(i).getDegree());
				pst.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
