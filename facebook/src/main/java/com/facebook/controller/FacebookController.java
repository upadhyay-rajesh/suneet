package com.facebook.controller;

import java.util.Scanner;

import com.facebook.entity.FacebookUser;
import com.facebook.service.FacebookService;
import com.facebook.service.FacebookServiceInterface;

public class FacebookController implements FacebookControllerInterface {

	public void createProfileController() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Your Name");
		String name=sc.next();
		System.out.println("Enter Your Password");
		String password=sc.next();
		System.out.println("Enter Your Email");
		String email=sc.next();
		System.out.println("Enter Your Address");
		String address=sc.next();
		
		FacebookUser fuser=new FacebookUser();
		fuser.setName(name);
		fuser.setPassword(password);
		fuser.setEmail(email);
		fuser.setAddress(address);
		
		FacebookServiceInterface fservice=new FacebookService();
		int i=fservice.createProfileService(fuser);
		
		if(i>0) {
			System.out.println("profile created");
		}
		else {
			System.out.println("could not create profile");
		}
		

	}

	public void viewProfileController() {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

	}

}
