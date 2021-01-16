package com.nagarro.hrmanagerREST.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.nagarro.hrmanagerREST.entity.Employee;
import com.nagarro.hrmanagerREST.entity.User;
import com.nagarro.hrmanagerREST.utilities.HibernateSessionUtil;

public class UserDAOImpl implements UserDAO {

	public User getUser(String username) {
		try {
		Session session = HibernateSessionUtil.getSession();
		Query query = session.createQuery("from User where username=:username");
		query.setParameter("username", username);
		User user = (User) query.uniqueResult();
		session.close();
		return user;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
