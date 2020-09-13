package com.myproject.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.dao.HomeDao;
import com.myproject.model.User;



@Service
public class HomeService {
@Autowired
HomeDao homedao;
	public void insertInfo(User user) throws SQLException {
		System.out.println("Service first");
		homedao.insertInfo(user);
		System.out.println("Service last");
		
	}
	public String getInfo() {
		return homedao.getInfo();
	}
	public User getUser() {
		return homedao.getUser();
	}
}
