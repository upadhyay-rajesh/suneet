package com.facebookweb.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "suneethibernatetimelinemessage")
public class TimeLine {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long messageId;
	private String sender;
	private String receiver;
	private String message;
	private int mlike;
	private int mdislike;
	private String mtime;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private FacebookUser fuser;
	
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	public long getMessageId() {
		return messageId;
	}
	public void setMessageId(long messageId) {
		this.messageId = messageId;
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
