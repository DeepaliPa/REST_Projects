/*package com.deepali.neu.edu.messenger.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.deepali.neu.edu.messenger.DatabaseClass.DatabaseStub;
import com.deepali.neu.edu.messenger.model.Message;
import com.deepali.neu.edu.messenger.model.Votes;

public class VoteService {

	
private Map<Long,Message> messages=DatabaseStub.getMessage();
	
	public List<Votes> getAllComments(long messageId){
		Map<Long,Votes> votes =messages.get(messageId).getVotes();
		return new ArrayList<Votes>(votes.values());
	}
	
}
*/