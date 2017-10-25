package com.deepali.neu.edu.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Votes {

	private int id;
	private String username;
	private String vote;
	private String dateCreated;

	public Votes() {

	}

	public Votes(int id, String username, String vote, String dateCreated) {
		super();
		this.id = id;
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
