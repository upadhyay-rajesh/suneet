package com.facebookweb.service;

import java.util.List;

import com.facebookweb.dao.FacebookDAO;
import com.facebookweb.dao.FacebookDAOInterface;
import com.facebookweb.entity.FacebookUser;
import com.facebookweb.entity.TimeLine;

public class FacebookService implements FacebookServiceInterface {

	public int createProfileService(FacebookUser fu) {
		FacebookDAOInterface fs=new FacebookDAO();
		int i=fs.createProfileDao(fu);
		return i;
	}

	public boolean loginProfileService(FacebookUser fu) {
		FacebookDAOInterface fs=new FacebookDAO();
		boolean i=fs.loginProfileDao(fu);
		return i;
	}

	public List<TimeLine> timelineService(FacebookUser fu) {
		FacebookDAOInterface fs=new FacebookDAO();
		List<TimeLine> i=fs.timelineDao(fu);
		return i;
	}

}
