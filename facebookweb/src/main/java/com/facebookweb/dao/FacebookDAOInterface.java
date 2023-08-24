package com.facebookweb.dao;

import java.util.List;

import com.facebookweb.entity.FacebookUser;
import com.facebookweb.entity.TimeLine;

public interface FacebookDAOInterface {

	int createProfileDao(FacebookUser fu);

	boolean loginProfileDao(FacebookUser fu);

	List<TimeLine> timelineDao(FacebookUser fu);

}
