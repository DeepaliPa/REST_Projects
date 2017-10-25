package com.deepali.neu.edu.messenger.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.deepali.neu.edu.messenger.Dao.JDBCConnection;
import com.deepali.neu.edu.messenger.model.Message;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class MessageDaoImpl {

	public Message getAllMessage() {

		JDBCConnection jdbcConnection = new JDBCConnection();
		Connection connection = jdbcConnection.getConnnection();
		Message msg = null;

		try {
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(
					"select id,endDate, username, message, opt1, opt2, opt3, opt4 from message");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				msg = new Message();
				msg.setId(rs.getInt("id"));
				msg.setMessage(rs.getString("message"));
				msg.setEndDate(rs.getString("endDate"));
				msg.setUsername(rs.getString("username"));
				msg.setOpt1(rs.getString("opt1"));
				msg.setOpt2(rs.getString("opt2"));
				msg.setOpt3(rs.getString("opt3"));
				msg.setOpt4(rs.getString("opt4"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return msg;
	}

	// public Message creatMessage(String username, String message, String opt1,
	// String opt2,
	// String opt3, String opt4,String endDate) {
	// JDBCConnection jdbcConnection = new JDBCConnection();
	// Connection connection = jdbcConnection.getConnnection();
	// PreparedStatement preparedStatement = null;
	// Message msgs = null;
	// id = 1;
	// System.out.println("EndDate" + endDate);
	// System.out.println("opt1" + opt1);
	//
	//
	// String insertTableSQL = "INSERT INTO message" + "(id,endDate, username,
	// message, opt1, opt2, opt3, opt4 ) VALUES" + "(?,?,?,?,?,?,?,?)";
	//
	// try {
	//
	// preparedStatement = (PreparedStatement)
	// connection.prepareStatement(insertTableSQL);
	//
	// preparedStatement.setInt(1, id);
	// preparedStatement.setString(2, endDate);
	// preparedStatement.setString(3, username);
	// preparedStatement.setString(4, message);
	// preparedStatement.setString(5, opt1);
	// preparedStatement.setString(6, opt2);
	// preparedStatement.setString(7, opt3);
	// preparedStatement.setString(8, opt4);
	//
	// preparedStatement.executeUpdate();
	// msgs = new Message();
	//
	// msgs.setId(id);
	// msgs.setEndDate(endDate);
	// msgs.setMessage(message);
	// msgs.setUsername(username);
	// msgs.setOpt1(opt1);
	// msgs.setOpt2(opt2);
	// msgs.setOpt3(opt3);
	// msgs.setOpt4(opt4);
	//
	//
	//
	//
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return msgs;
	// }

	public Message creatMessage(Message mes) {

		String endDate = mes.getEndDate();
		String message = mes.getMessage();
		String username = mes.getUsername();
		String opt1 = mes.getOpt1();
		String opt2 = mes.getOpt2();
		String opt3 = mes.getOpt3();
		String opt4 = mes.getOpt4();
		int id = 0;

		JDBCConnection jdbcConnection = new JDBCConnection();
		Connection connection = jdbcConnection.getConnnection();
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2 = null;

		String insertTableSQL = "INSERT INTO message"
				+ "(id,endDate, username, message, opt1, opt2, opt3, opt4 ) VALUES" + "(?,?,?,?,?,?,?,?)";
		String retriveId = "select max(id) from message";
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(insertTableSQL);
			preparedStatement2 = (PreparedStatement) connection.prepareStatement(retriveId);
			ResultSet rs = preparedStatement2.executeQuery();

			while (rs.next()) {
				id = rs.getInt(1);
			}
			id = id + 1;
			mes.setId(id);

			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, endDate);
			preparedStatement.setString(3, username);
			preparedStatement.setString(4, message);
			preparedStatement.setString(5, opt1);
			preparedStatement.setString(6, opt2);
			preparedStatement.setString(7, opt3);
			preparedStatement.setString(8, opt4);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mes;
	}

}
