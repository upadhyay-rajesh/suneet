package com.facebookweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.facebookweb.entity.FacebookUser;
import com.facebookweb.entity.TimeLine;

public class FacebookDAO implements FacebookDAOInterface {

	public int createProfileDao(FacebookUser fuser) {
		int i=0;
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		
		EntityTransaction et=s.getTransaction();
		et.begin();
		s.save(fuser);
		et.commit();
		i=1;
		
		/*//step 1 load driver
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
		*/
		return i;
	}

	public boolean loginProfileDao(FacebookUser fuser) {
		boolean i=false;
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		Query q=s.createQuery("from com.facebookweb.entity.FacebookUser f where f.email=:ee and f.password=:pw");
		q.setParameter("ee", fuser.getEmail());
		q.setParameter("pw", fuser.getPassword());
		int j=q.getFirstResult();
		if(j>0) {
			i=true;
		}
		//step 1 load driver
		/*try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//step 2 create connection with database
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","rajesh");
		//step 3 create query
		
		PreparedStatement ps=con.prepareStatement("select * from facebookusersuneetweb where email=? and password=?");
		ps.setString(1,fuser.getEmail());
		ps.setString(2, fuser.getPassword());
		
		
		
		ResultSet res=ps.executeQuery();
		if(res.next()) {
			i=true;
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		*/
		return i;
	}

	public List<TimeLine> timelineDao(FacebookUser fuser) {
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		Query q=s.createQuery("from com.facebookweb.entity.TimeLine t where t.receiver=:ee");
		q.setParameter("ee", fuser.getEmail());
		List<TimeLine> mm=q.getResultList();
		
		/*
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//step 2 create connection with database
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","rajesh");
			//step 3 create query
			
			PreparedStatement ps=con.prepareStatement("select * from timeline where receiver=?");
			ps.setString(1,fuser.getEmail());
		
			
			ResultSet res=ps.executeQuery();
			while(res.next()) {
			TimeLine t1=new TimeLine();
			t1.setSender(res.getString(1));
			t1.setReceiver(res.getString(2));
			t1.setMessage(res.getString(3));
			t1.setMlike(res.getInt(4));
			t1.setMdislike(res.getInt(5));
			t1.setMtime(res.getString(6));
			
			mm.add(t1);
			
			}
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		return mm;
	}

	public boolean checkemailDao(FacebookUser fuser) {
		boolean i=false;
		//step 1 load driver
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//step 2 create connection with database
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","rajesh");
		//step 3 create query
		
		PreparedStatement ps=con.prepareStatement("select * from facebookusersuneetweb where email=? ");
		ps.setString(1,fuser.getEmail());
		
		
		
		
		ResultSet res=ps.executeQuery();
		if(res.next()) {
			i=true;
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}

}
