package com.deepali.neu.edu.messenger.Dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.deepali.neu.edu.messenger.model.Message;
import com.deepali.neu.edu.messenger.util.HibernateUtil;

public class MessageDao {

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public Message getAllMessages(String username) {

		Message message = null;
		Session session = null;

		try {

			session = sessionFactory.openSession();
			session.beginTransaction();

			Query query = session.createQuery("SELECT m.message FROM Message m WHERE m.username=:username");
			query.setParameter("username", username);
			message = (Message) query.uniqueResult();
			session.getTransaction().commit();

		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}

		} finally {
			if (session != null) {
				session.close();
			}
		}

		return message;

	}

}
