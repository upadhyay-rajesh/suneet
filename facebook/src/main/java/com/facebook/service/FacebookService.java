package com.facebook.service;

import java.sql.SQLException;
import java.util.List;

import com.facebook.dao.FacebookDAO;
import com.facebook.dao.FacebookDAOInterface;
import com.facebook.entity.FacebookUser;
import com.facebook.exception.UserNotFoundException;

public class FacebookService implements FacebookServiceInterface {

	public int createProfileService(FacebookUser fuser) throws ClassNotFoundException,SQLException{
		FacebookDAOInterface fdao=new FacebookDAO();
		return fdao.createProfileDAO(fuser);
	}

	public FacebookUser viewProfileService(FacebookUser fuser) throws UserNotFoundException{
		FacebookDAOInterface fdao=null;
		FacebookUser f=null;
		try {
		fdao=new FacebookDAO();
		f=fdao.viewProfileDAO(fuser);
		if(f==null) {
			throw new UserNotFoundException("given user not available in database");
		}
		}
		catch(UserNotFoundException e) {
			throw new UserNotFoundException("given user not available in database");
		}
		return f;
	}

	public List<FacebookUser> viewAllProfileService() {
		FacebookDAOInterface fdao=new FacebookDAO();
		return fdao.viewAllProfileDAO();
	}

}
