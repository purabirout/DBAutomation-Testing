package com.DBAutomationTest;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DBTest extends Base{
	@Test(priority = 1)
	public void getData() throws SQLException {
connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify","root","root");
		
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("Select * from users");
		while(resultSet.next()) {
			int id =resultSet.getInt(1);
			String nameString = resultSet.getString(2);
			String emString = resultSet.getString(3);
			System.out.println(id +nameString +emString);
		}
	}
	
	@Test(priority = 2)
	public void insertData() throws SQLException {
		PreparedStatement ps = connection.prepareStatement("insert into users values(?,?,?,?,?)");
		ps.setInt(1,105);
		ps.setString(2,"ankit");
		ps.setString(3, "M");
		ps.setString(4,"ankit123@gmail.com");
		ps.setString(5,"djdjhd@677");
		
		ps.executeUpdate();
		getData();
		}
	
	@Test(priority = 3)
	public void updateData() throws SQLException {
		PreparedStatement ps1 = connection.prepareStatement("update users set Email = ? where User_id = ?");
		ps1.setString(1,"trisha@gmail.com");
		ps1.setInt(2,103);
		ps1.executeUpdate();
		getData();
	}
	
	@Test(priority = 4)
	public void deleteData() throws SQLException {
		PreparedStatement ps2 = connection.prepareStatement("Delete from users where User_id = ?");
		ps2.setInt(1, 105);
		ps2.executeUpdate();
		getData();
	}
	
		}
