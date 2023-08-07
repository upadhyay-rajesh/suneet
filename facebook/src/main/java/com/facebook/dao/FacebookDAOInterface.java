package com.facebook.dao;

import java.sql.SQLException;
import java.util.List;

import com.facebook.entity.FacebookUser;

public interface FacebookDAOInterface {

	int createProfileDAO(FacebookUser fuser)throws ClassNotFoundException,SQLException;

	FacebookUser viewProfileDAO(FacebookUser fuser);

	List<FacebookUser> viewAllProfileDAO();

}
