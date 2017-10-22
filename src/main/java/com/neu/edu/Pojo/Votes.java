package com.neu.edu.Pojo;


import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Votes {

	private long voteId;
	private String message;
	private Date created;
	private String author;

	public Votes() {

	}

	public Votes(long voteId, String message, String author) {
		this.voteId = voteId;
		this.message = message;
		this.author = author;
		this.created=new Date();
	}

	public long getVoteId() {
		return voteId;
	}

	public void setVoteId(long voteId) {
		this.voteId = voteId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
