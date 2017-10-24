/*package com.deepali.neu.edu.messenger.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.deepali.neu.edu.messenger.DatabaseClass.DatabaseStub;
import com.deepali.neu.edu.messenger.model.Message;

public class MyService {

	Map<Long, Message> messages = DatabaseStub.getMessage();
	
	public MyService(){
		
		messages.put(1L,new Message(1L,"Deepali Hello", "Deepali"));
		
	}

	public Message postMessage(Message message) {

		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;

	}

	public Message getMessage(long id) {
		return messages.get(id);
	}

	public List<Message> getAllMessages() {
		return new ArrayList(messages.values());
	}

	public Message deleteMessage(long id) {
		return messages.remove(id);
	}

	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
}
*/