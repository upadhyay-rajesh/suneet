package com.facebook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.facebook.entity.FacebookUser;

public class FacebookDAO implements FacebookDAOInterface {

	public int createProfileDAO(FacebookUser fuser)throws ClassNotFoundException,SQLException{
		int i=0;
		//step 1 load driver
		
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
		
		return i;
	}

	public FacebookUser viewProfileDAO(FacebookUser fuser) {
		FacebookUser ff=null;
		//Connection con=null;
		//step 1 load driver
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","rajesh")) {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//step 2 create connection with database
		
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
		catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
		
		/*finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		return ff;
	}

	public List<FacebookUser> viewAllProfileDAO() {
		List<FacebookUser> ff=new ArrayList<FacebookUser>();
		//step 1 load driver
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//step 2 create connection with database
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","rajesh");
		//step 3 create query
		
		PreparedStatement ps=con.prepareStatement("select * from facebookusersuneet");
		
		
		
		
		ResultSet res=ps.executeQuery();
		while(res.next()) {
			
			String n=res.getString(1);
			String p=res.getString(2);
			String e=res.getString(3);
			String a=res.getString(4);
			
			FacebookUser ff1=new FacebookUser();
			
			ff1.setName(n);
			ff1.setPassword(p);
			ff1.setEmail(e);
			ff1.setAddress(a);
			ff.add(ff1);
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ff;
	}

}
