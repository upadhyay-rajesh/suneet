package com.facebook.controller;

import java.sql.SQLException;

public interface FacebookControllerInterface {
	public void createProfileController()throws ClassNotFoundException,SQLException;
	public void viewProfileController();
	public void editProfileController();
	public void deleteProfileController();
	public void searchProfileController();
	public void viewAllProfileController();
}
