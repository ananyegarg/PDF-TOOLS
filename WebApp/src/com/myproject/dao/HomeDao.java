package com.myproject.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.myproject.model.User;

@Repository
public class HomeDao {
@Autowired
JdbcTemplate jdbcTemplate;


	public void insertInfo(User user) throws SQLException {
		
		Connection con=jdbcTemplate.getDataSource().getConnection();
		CallableStatement pst=con.prepareCall("call test(?,?,?)");
		pst.setString(1, "add");
		pst.setString(2,"anany");
		pst.setInt(3, 10);
		ResultSet i=pst.executeQuery();
		while(i.next())
		{
			System.out.println(i.getString(2));
		}
		
		con.close();	
	}
	public String getInfo() {
		
		String s=null;
		Connection con=null;
		try {
			con=jdbcTemplate.getDataSource().getConnection();
			PreparedStatement pst=con.prepareStatement("insert into student values(?,?)");
			pst.setInt(1, 23);
			pst.setString(2, "Anany");
			//pst.setString(2,"Anany");
			ResultSet rs=pst.executeQuery();
			//System.out.println(i);
			while(rs.next())
			{
				System.out.println(s);
				s=rs.getString(2);
			}
		}
		catch(Exception e) {e.printStackTrace();}
		finally {
			try {
				con.close();
			}
			catch(Exception e) {e.printStackTrace();}
		}
		return s;
	}
	public User getUser() {
		String s=null;
		Connection con=null;
		User u=new User();
		try {
			con=jdbcTemplate.getDataSource().getConnection();
			PreparedStatement pst=con.prepareStatement("insert into student values(?,?)");
			pst.setInt(1, 23);
			pst.setString(2, "Anany");
			//pst.setString(2,"Anany");
			ResultSet rs=pst.executeQuery();
			//System.out.println(i);
			while(rs.next())
			{
				u.setEmail(rs.getString(2));
				u.setMobile(rs.getString(2));
			}
		}
		catch(Exception e) {e.printStackTrace();}
		finally {
			try {
				con.close();
			}
			catch(Exception e) {e.printStackTrace();}
		}
		return u;
	}
}
