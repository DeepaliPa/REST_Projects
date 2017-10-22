package com.neu.edu.Databases;



import java.util.HashMap;
import java.util.Map;

import com.neu.edu.Pojo.Messages;



public class DatabaseClass {
	
	private static Map<Long,Messages> messages=new HashMap<Long, Messages>();
	
	public static Map<Long, Messages> getMessages() {
		return messages;
	}
}
	
