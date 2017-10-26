package com.deepali.neu.edu.messenger.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.deepali.neu.edu.messenger.Dao.JDBCConnection;
import com.deepali.neu.edu.messenger.model.Message;
import com.deepali.neu.edu.messenger.model.Vote;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class VotesDaoImpl {

	public Vote addVotes(Vote v) {

		String dateCreated = v.getDateCreated();
		int msgId = v.getMessageId();
		String username = v.getUsername();
		String vote = v.getVote();

		int voteId = 0;

		JDBCConnection jdbcConnection = new JDBCConnection();
		Connection connection = jdbcConnection.getConnnection();
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2 = null;

		String insertTableSQL = "INSERT INTO vote" + "(voteId,messageId, username, vote) VALUES" + "(?,?,?,?)";
		String retriveId = "select max(voteId) from vote";
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(insertTableSQL);
			preparedStatement2 = (PreparedStatement) connection.prepareStatement(retriveId);
			ResultSet rs = preparedStatement2.executeQuery();

			while (rs.next()) {
				voteId = rs.getInt(1);
			}
			voteId = voteId + 1;
			v.setId(voteId);

			preparedStatement.setInt(1, voteId);
			preparedStatement.setInt(2, msgId);
			preparedStatement.setString(3, username);
			preparedStatement.setString(4, vote);
			preparedStatement.setString(5, dateCreated);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return v;
	}

	public String winnerOption() {

		JDBCConnection jdbcConnection = new JDBCConnection();
		Connection connection = jdbcConnection.getConnnection();
		PreparedStatement preparedStatement = null;
		String winningOption = null;


		String retriveId = "select votes, count(votes) from Messanger.vote group by votes having count(votes)= (select max(myvotes) from (select votes, count(votes) myVotes from Messanger.VOTE group by votes) AS T)";
		try {
			
			preparedStatement = (PreparedStatement) connection.prepareStatement(retriveId);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				winningOption = rs.getString(2);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return winningOption;
		
		
	}
	
	public Vote editVote(Vote v) {

		int msgId = v.getMessageId();
		String vote = v.getVote();

		JDBCConnection jdbcConnection = new JDBCConnection();
		Connection connection = jdbcConnection.getConnnection();
		PreparedStatement preparedStatement = null;
	
		

		String updateTableSQL = "UPDATE vote SET votes = ? \" + \" WHERE messageId = ?";

		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(updateTableSQL);
	
			preparedStatement.setString(4, vote);
			preparedStatement.setInt(2, msgId);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return v;
	}

}
