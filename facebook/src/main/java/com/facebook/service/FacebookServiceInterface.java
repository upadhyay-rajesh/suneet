package com.facebook.service;

import java.sql.SQLException;
import java.util.List;

import com.facebook.entity.FacebookUser;
import com.facebook.exception.UserNotFoundException;

public interface FacebookServiceInterface {

	int createProfileService(FacebookUser fuser)throws ClassNotFoundException,SQLException;

	FacebookUser viewProfileService(FacebookUser fuser)throws UserNotFoundException;

	List<FacebookUser> viewAllProfileService();

}
