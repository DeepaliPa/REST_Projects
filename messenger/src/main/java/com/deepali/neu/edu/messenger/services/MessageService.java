package com.deepali.neu.edu.messenger.services;

import java.util.ArrayList;
import java.util.List;

import com.deepali.neu.edu.messenger.Dao.MessageDao;
import com.deepali.neu.edu.messenger.model.Message;

public class MessageService {

	MessageDao messageDao = new MessageDao();

	public Message getAllMessages(String username) {
		return messageDao.getAllMessages(username);
	}
}
