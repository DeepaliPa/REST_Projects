package com.deepali.neu.edu.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.deepali.neu.edu.messenger.model.Message;
import com.deepali.neu.edu.messenger.services.MessageDaoImpl;


@Path("/messages/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Messages {

	// MessageService messageService =new MessageService();
	MessageDaoImpl msgDaoImpl = new MessageDaoImpl();

	@GET
	public Message getAllMessage() {
		return msgDaoImpl.getAllMessage();
	}

//	@POST
//	@Path("/{username}/{msg}/{opt1}/{opt2}/{opt3}/{opt4}/{endDate}/")
//	public Message creatMessage(@PathParam("username") String username,
//			@PathParam("msg") String msg,
//			@PathParam("opt1") String opt1,
//			@PathParam("opt2") String opt2,
//			@PathParam("opt3") String opt3,
//			@PathParam("opt4") String opt4,
//			@PathParam("endDate") String endDate) {
//		return msgDaoImpl.creatMessage(username, msg, opt1, opt2,opt3,opt4,endDate);
//	}
	
	
	@POST
	public Message addMessage(Message message) {
		Message msgs = new Message();
		msgs.setEndDate(message.getEndDate());
		msgs.setId(message.getId());
		msgs.setMessage(message.getMessage());
		msgs.setUsername(message.getUsername());
		msgs.setOpt1(message.getOpt1());
		msgs.setOpt2(message.getOpt2());
		msgs.setOpt3(message.getOpt3());
		msgs.setOpt4(message.getOpt4());
		return msgDaoImpl.creatMessage(msgs);
	}
	

	

}
