package com.facebook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.facebook.entity.FacebookUser;

public class FacebookDAO implements FacebookDAOInterface {

	public int createProfileDAO(FacebookUser fuser){
		int i=0;
		//step 1 load driver
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//step 2 create connection with database
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","rajesh");
		//step 3 create query
		
		PreparedStatement ps=con.prepareStatement("insert into facebookusersuneet values(?,?,?,?)");
		ps.setString(1, fuser.getName());
		ps.setString(2, fuser.getPassword());
		ps.setString(3,fuser.getEmail());
		ps.setString(4,fuser.getAddress());
		
		i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public FacebookUser viewProfileDAO(FacebookUser fuser) {
		FacebookUser ff=null;
		//step 1 load driver
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//step 2 create connection with database
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","rajesh");
		//step 3 create query
		
		PreparedStatement ps=con.prepareStatement("select * from facebookusersuneet where email=?");
		
		ps.setString(1,fuser.getEmail());
		
		
		ResultSet res=ps.executeQuery();
		if(res.next()) {
			
			String n=res.getString(1);
			String p=res.getString(2);
			String e=res.getString(3);
			String a=res.getString(4);
			
			ff=new FacebookUser();
			
			ff.setName(n);
			ff.setPassword(p);
			ff.setEmail(e);
			ff.setAddress(a);
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ff;
	}

}
