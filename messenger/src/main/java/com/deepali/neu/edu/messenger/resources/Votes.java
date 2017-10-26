package com.deepali.neu.edu.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import com.deepali.neu.edu.messenger.model.Vote;
import com.deepali.neu.edu.messenger.services.VotesDaoImpl;


@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Votes {

	@POST
	public Vote addVote(JSONObject inputJsonObj) {
		
		VotesDaoImpl votesDaoImpl = new VotesDaoImpl();

		String username = (String) inputJsonObj.get("username");
		String dateCreated = (String) inputJsonObj.get("dateCreated");
		String vote = (String) inputJsonObj.get("vote");
		int msgId = (int) inputJsonObj.get("msgId");

		Vote v = new Vote();
		v.setDateCreated(dateCreated);
		v.setMessageId(msgId);
		v.setUsername(username);
		v.setVote(vote);

		return votesDaoImpl.addVotes(v);
	}
	
	@GET
	public String winnerOption() {
		
		VotesDaoImpl votesDaoImpl = new VotesDaoImpl();
		return votesDaoImpl.winnerOption();
	}
	
	@PUT
	public Vote editVote(JSONObject inputJsonObj) {
		
		VotesDaoImpl votesDaoImpl = new VotesDaoImpl();

		String username = (String) inputJsonObj.get("username");
		String dateCreated = (String) inputJsonObj.get("dateCreated");
		String vote = (String) inputJsonObj.get("vote");
		int msgId = (int) inputJsonObj.get("msgId");

		Vote v = new Vote();
		v.setDateCreated(dateCreated);
		v.setMessageId(msgId);
		v.setUsername(username);
		v.setVote(vote);

		return votesDaoImpl.editVote(v);
	}
}