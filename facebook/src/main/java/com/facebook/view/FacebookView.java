package com.facebook.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.facebook.controller.FacebookController;
import com.facebook.controller.FacebookControllerInterface;

public class FacebookView {

	public static void main(String[] args)throws ClassNotFoundException,SQLException {
		String s = "y";

		while (s.equals("y")) {
			System.out.println("******************Main Menu***************");
			System.out.println("press 1 to create profile");
			System.out.println("press 2 to view profile");
			System.out.println("press 3 to edit profile");
			System.out.println("press 4 to delete profile");
			System.out.println("press 5 to search profile");
			System.out.println("press 6 to view all profile");
			System.out.println("please enter your choice");

			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			
			FacebookControllerInterface fccontroller=new FacebookController();

			switch (choice) {
			case 1:
				fccontroller.createProfileController();
				break;
			case 2:
				fccontroller.viewProfileController();
				break;
			case 3:
				fccontroller.editProfileController();
				break;
			case 4:
				fccontroller.deleteProfileController();
				break;
			case 5:
				fccontroller.searchProfileController();
				break;
			case 6:
				fccontroller.viewAllProfileController();
				break;
			default:
				System.out.println("wrong choice");
			}

			System.out.println("do you want continue press y or n");
			s = sc.next();
		}

	}

}
