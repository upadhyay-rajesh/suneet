package com.facebook.util;

import java.util.Comparator;

import com.facebook.entity.FacebookUser;

public class SortByName implements Comparator<FacebookUser>{

	public int compare(FacebookUser o1, FacebookUser o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}

}
