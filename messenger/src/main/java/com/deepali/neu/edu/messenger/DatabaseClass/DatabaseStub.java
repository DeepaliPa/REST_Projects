package com.deepali.neu.edu.messenger.DatabaseClass;

import java.util.HashMap;
import java.util.Map;

import com.deepali.neu.edu.messenger.model.Message;

public class DatabaseStub {

	public static Map<Long, Message> message = new HashMap<Long, Message>();

	public static Map<Long, Message> getMessage() {
		return message;
	}

}
