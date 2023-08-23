package com.facebookweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.facebookweb.entity.FacebookUser;

public class FacebookDAO implements FacebookDAOInterface {

	public int createProfileDao(FacebookUser fuser) {
		int i=0;
		//step 1 load driver
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//step 2 create connection with database
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","rajesh");
		//step 3 create query
		
		PreparedStatement ps=con.prepareStatement("insert into facebookusersuneetweb values(?,?,?,?)");
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

}
