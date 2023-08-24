package com.facebookweb.entity;

public class TimeLine {
	private String sender;
	private String receiver;
	private String message;
	private int mlike;
	private int mdislike;
	private String mtime;
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getMlike() {
		return mlike;
	}
	public void setMlike(int mlike) {
		this.mlike = mlike;
	}
	public int getMdislike() {
		return mdislike;
	}
	public void setMdislike(int mdislike) {
		this.mdislike = mdislike;
	}
	public String getMtime() {
		return mtime;
	}
	public void setMtime(String mtime) {
		this.mtime = mtime;
	}
	
	
}
