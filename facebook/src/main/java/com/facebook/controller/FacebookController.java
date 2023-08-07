package com.facebook.controller;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.facebook.entity.FacebookUser;
import com.facebook.exception.UserNotFoundException;
import com.facebook.service.FacebookService;
import com.facebook.service.FacebookServiceInterface;
import com.facebook.util.SortByName;

public class FacebookController implements FacebookControllerInterface {

	public void createProfileController() throws ClassNotFoundException,SQLException{
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Your Name");
		String name = sc.next();
		System.out.println("Enter Your Password");
		String password = sc.next();
		System.out.println("Enter Your Email");
		String email = sc.next();
		System.out.println("Enter Your Address");
		String address = sc.next();

		FacebookUser fuser = new FacebookUser();
		fuser.setName(name);
		fuser.setPassword(password);
		fuser.setEmail(email);
		fuser.setAddress(address);

		FacebookServiceInterface fservice = new FacebookService();
		int i = fservice.createProfileService(fuser);

		if (i > 0) {
			System.out.println("profile created");
		} else {
			System.out.println("could not create profile");
		}

	}

	public void viewProfileController() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Your Email to view profile");
		String email = sc.next();
		
		FacebookUser fuser = new FacebookUser();
		fuser.setEmail(email);
		try {
		FacebookServiceInterface fservice = new FacebookService();
		FacebookUser fu=fservice.viewProfileService(fuser);
		
		if(fu!=null) {
			System.out.println("your detail is below");
			System.out.println("Name is "+fu.getName());
			System.out.println("Password is "+fu.getPassword());
			System.out.println("Email is "+fu.getEmail());
			System.out.println("Address is "+fu.getAddress());
			
		}
		else {
			System.out.println("this email does not exist");
		}
		}
		catch(UserNotFoundException e) {
			System.out.println(e);
		}

	}

	public void editProfileController() {
		// TODO Auto-generated method stub

	}

	public void deleteProfileController() {
		// TODO Auto-generated method stub

	}

	public void searchProfileController() {
		// TODO Auto-generated method stub

	}

	public void viewAllProfileController() {
		FacebookServiceInterface fservice = new FacebookService();
		List<FacebookUser> fu=fservice.viewAllProfileService();
		System.out.println("Before Sorting ******");
		for(FacebookUser f1:fu) {
			System.out.println("your detail is below");
			System.out.println("Name is "+f1.getName());
			System.out.println("Password is "+f1.getPassword());
			System.out.println("Email is "+f1.getEmail());
			System.out.println("Address is "+f1.getAddress());
		}
		System.out.println("After Sorting ******");
		
		Collections.sort(fu, new SortByName());
		
		for(FacebookUser f1:fu) {
			System.out.println("your detail is below");
			System.out.println("Name is "+f1.getName());
			System.out.println("Password is "+f1.getPassword());
			System.out.println("Email is "+f1.getEmail());
			System.out.println("Address is "+f1.getAddress());
		}
	}

}









