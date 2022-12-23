package com.example.hwapi.controller;

import java.sql.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/students")
public class hwController {
	
	
	private Connection conn;
	private Statement st;
	private String connectionUrl;
	
	public hwController() {
		
		connectionUrl = "jdbc:postgresql://localhost:5432/hongik?user=postgres&password=1234";
		
		try {
			conn = DriverManager.getConnection(connectionUrl);
			st = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@GetMapping("/degree")
	public String searchDegree (@RequestParam(value="name") String name) {
		
		int count = 0;
		String result = null;
		
		try {
			String sql;
			sql = "SELECT * FROM STUDENTS WHERE NAME = " + "'" + name + "'";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				count = count + 1;
				result = name + " : " + rs.getString(5);
			}
			if (count == 0) {
				String err = "No such student";
				return err;
			} else if (count >= 2) {
				String err = "There are multiple students with the same name. Please provide an email address instead.";
				return err;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	@GetMapping("/email")
	public String searchEmail (@RequestParam(value="name") String name) {
		
		int count = 0;
		String result = null;
		
		try {
			String sql;
			sql = "SELECT * FROM STUDENTS WHERE NAME = " + "'" + name + "'";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				count = count + 1;
				result = name + " : " + rs.getString(3);
			}
			if (count == 0) {
				String err = "No such student";
				return err;
			} else if (count >= 2) {
				String err = "There are multiple students with the same name. Please contact the administrator by phone.";
				return err;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	@GetMapping("/stat")
	public String searchStat (@RequestParam(value="degree") String degree) {
		
		int count = 0;
		String result = null;
		
		try {
			String sql;
			sql = "SELECT * FROM STUDENTS WHERE DEGREE = " + "'" + degree + "'";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				count = count + 1;
				result = rs.getString(5);
			}
			if (count == 0) {
				String err = "No such degree";
				return err;
			} else {
				result = "Number of " + degree + "'s student : " + Integer.toString(count);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	@PutMapping("/register")
	public String newRegister (@RequestParam(value="name") String name, @RequestParam(value="email") String email,
			@RequestParam(value="graduation") int graduation, @RequestParam(value="degree") String degree) {
		
		int count = 0;
		String resultname = null;
		String result = null;
		
		try {
			String sql1;
			String sql2;
			
			sql1 = "SELECT * FROM STUDENTS";
			ResultSet rs1 = st.executeQuery(sql1);
			
			while(rs1.next()) {
				count = count + 1;
				resultname = rs1.getString(2);
				
				if (name.equals(resultname)) {
					result = "Already registered";
					break;
				}
			}
			
			if (result == "Already registered") {
				return result;
			} else {
				sql2 = "INSERT INTO STUDENTS (sid, name, email, graduation, degree) VALUES (" + Integer.toString(count) + ", "
						+ "'" + name + "', " + "'" + email + "', " + Integer.toString(graduation) + ", " + "'" + degree + "')";
				int rs2 = st.executeUpdate(sql2);
				result = "Registration successful";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
