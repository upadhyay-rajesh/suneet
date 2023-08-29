package com.facebookweb.service;

import java.util.List;

import com.facebookweb.entity.FacebookUser;
import com.facebookweb.entity.TimeLine;

public interface FacebookServiceInterface {

	int createProfileService(FacebookUser fu);

	boolean loginProfileService(FacebookUser fu);

	List<TimeLine> timelineService(FacebookUser fu);

	boolean checkEmailService(FacebookUser fu);

}
