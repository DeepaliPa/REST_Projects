/*package com.deepali.neu.edu.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.deepali.neu.edu.messenger.model.Votes;
import com.deepali.neu.edu.messenger.services.VoteService;

import java.util.List;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VoteResources {
	
private VoteService cs=new VoteService();
	
	@GET
	public List<Votes> getAllComments(@PathParam("messageId") long messageId){
		return cs.getAllComments(messageId);
	}
		
}
*/