package com.neu.edu.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.neu.edu.Exception.AdException;
import com.neu.edu.Pojo.User;

public class UserDAO extends DAO {

	public UserDAO() {
	}

	public User get(String username) throws AdException {
		try {
			begin();
			Query q = getSession().createQuery("from User where username = :username");
			q.setString("username", username);
			User user = (User) q.uniqueResult();

			System.out.println("user Inside get------>" + user);
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get user " + username, e);
		}
	}

	public List<User> getList(String type) throws AdException {
		try {
			begin();

			Query q = getSession().createQuery("from User where type = :type");
			q.setString("type", type);
			List<User> list = q.list();
			System.out.println("deepali--->" + list);
			commit();
			return list;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get tutor " + e);
		}
	}

	public List<User> getListOfUser(String username) throws AdException {
		try {
			begin();

			Query q = getSession().createQuery("from User where username = :username");
			q.setString("username", username);
			List<User> list = q.list();
			System.out.println("deepali--->" + list);
			commit();
			return list;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get tutor " + e);
		}
	}

	public User create(String username, String password, String email, String fullname) throws AdException {
		try {
			begin();
			User user = new User(username, password);

			user.setFullname(fullname);
			user.setEmail(email);
			user.setType("Participant");
			getSession().save(user);
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();

			throw new AdException("Exception while creating user: " + e.getMessage());
		}
	}

	public User update(User user) throws AdException {
		try {
			begin();
			getSession().update(user);
			commit();
			return user;

		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not delete user " + e);
		}

	}

	public List<User> search(String status) throws AdException {
		try {
			begin();
			System.out.println("Inside search" + status);
			Criteria criteria = getSession().createCriteria(User.class);
			criteria.add(Restrictions.eq("flag", status));
			List<User> listUser = criteria.list();
			System.out.println("size of the list is " + listUser.size());
			commit();
			return listUser;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get airlines for current selection", e);
		}
	}

	public User getUserObject(String username) throws AdException {
		try {
			begin();
			Query q = getSession().createQuery("from User where username = :username");
			q.setString("username", username);
			User user = (User) q.uniqueResult();

			System.out.println("user Inside get------>" + user);
			commit();
			return user;

		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get user ", e);
		}
	}

	public User updateUserStatus(User user) throws AdException {
		try {
			begin();
			getSession().update(user);
			commit();
			return user;

		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not delete user " + e);
		}

	}

}