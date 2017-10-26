package com.deepali.neu.edu.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Vote {

	private int id;
	private int messageId;
	private String username;
	private String vote;
	private String dateCreated;

	public Vote() {

	}

	public Vote(int id, int messageId, String username, String vote, String dateCreated) {
		super();
		this.id = id;
		this.messageId = messageId;
		this.username = username;
		this.vote = vote;
		this.dateCreated = dateCreated;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getVote() {
		return vote;
	}

	public void setVote(String vote) {
		this.vote = vote;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	

}
