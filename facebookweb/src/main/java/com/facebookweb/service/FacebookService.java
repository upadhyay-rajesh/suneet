package com.facebookweb.service;

import com.facebookweb.dao.FacebookDAO;
import com.facebookweb.dao.FacebookDAOInterface;
import com.facebookweb.entity.FacebookUser;

public class FacebookService implements FacebookServiceInterface {

	public int createProfileService(FacebookUser fu) {
		FacebookDAOInterface fs=new FacebookDAO();
		int i=fs.createProfileDao(fu);
		return i;
	}

}
