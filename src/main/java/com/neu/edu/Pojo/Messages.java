package com.neu.edu.Pojo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Messages {

	private long messageId;
	private String message;
	private Date created;
	private String username;
	private Map<Long, Votes> votes = new HashMap<Long, Votes>();

	public Messages() {

	}

	public Messages(long messageId, String message, String username) {
		this.messageId = messageId;
		this.message = message;
		this.created = new Date();
		this.username = username;
	}

	public long getMessageId() {
		return messageId;
	}

	public void setMessageId(long messageId) {
		this.messageId = messageId;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@XmlTransient
	public Map<Long, Votes> getVotes() {
		return votes;
	}

	public void setVotes(Map<Long, Votes> votes) {
		this.votes = votes;
	}

}
