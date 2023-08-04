package com.facebook.service;

import com.facebook.dao.FacebookDAO;
import com.facebook.dao.FacebookDAOInterface;
import com.facebook.entity.FacebookUser;

public class FacebookService implements FacebookServiceInterface {

	public int createProfileService(FacebookUser fuser) {
		FacebookDAOInterface fdao=new FacebookDAO();
		return fdao.createProfileDAO(fuser);
	}

	public FacebookUser viewProfileService(FacebookUser fuser) {
		FacebookDAOInterface fdao=new FacebookDAO();
		return fdao.viewProfileDAO(fuser);
	}

}
