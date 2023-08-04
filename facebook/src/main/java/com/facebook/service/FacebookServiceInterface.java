package com.facebook.service;

import com.facebook.entity.FacebookUser;

public interface FacebookServiceInterface {

	int createProfileService(FacebookUser fuser);

	FacebookUser viewProfileService(FacebookUser fuser);

}
