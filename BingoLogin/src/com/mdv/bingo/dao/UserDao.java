package com.mdv.bingo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.mdv.bingo.model.User;
import com.mdv.bingo.model.UserDetail;

public class UserDao {

	@Autowired
    private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		System.out.println("===========Set Session created=========="+sessionFactory);
		this.sessionFactory = sessionFactory;
	}
	
	public boolean saveUser(UserDetail userDetail) {
		boolean status = false;
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try{
			long id = (long) session.save(userDetail);
			//session.flush();
			User user = new User();
			user.setId(id);
			user.setUsername(userDetail.getUserName());
			user.setPassword(userDetail.getPassword());
			session.save(user);
			tx.commit();
			status= true;
		}catch(Exception e){
			System.out.println("exception occured in save user detail==="+e.getMessage());
			tx.rollback();
		}finally{
			session.close();
		}
		return status;
	}
	
	public boolean editUser(UserDetail userDetail) {
		boolean status = false;
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try{
			long id = (long) session.save(userDetail);
			//session.flush();
			User user = new User();
			user.setId(id);
			user.setUsername(userDetail.getUserName());
			user.setPassword(userDetail.getPassword());
			session.save(user);
			tx.commit();
			status= true;
		}catch(Exception e){
			System.out.println("exception occured in save user detail==="+e.getMessage());
			tx.rollback();
		}finally{
			session.close();
		}
		return status;
	}
	
	public boolean findByUserName(String userName, String tableName){
		User user =  isUserExist(userName, tableName);
		if(user!=null)
			return true;
		else
			return false;
	}
	
	public User isUserExist(String userName, String tableName){
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from "+tableName+" where username = :username");
		query.setParameter("username", userName);
		User user = (User) query.uniqueResult();
		session.close();
		return user;
	}
	
	public UserDetail getUser(Long userId) {
		Session session = this.sessionFactory.openSession();
	    UserDetail userDetail = (UserDetail) session.load(UserDetail.class, userId);
	    return userDetail;
	}
	
	public void deleteUser(Integer userId) {
		Session session = this.sessionFactory.openSession();
	    UserDetail userDetail = (UserDetail) session.load(UserDetail.class, userId);
	    if (null != userDetail) {
	        this.sessionFactory.getCurrentSession().delete(userDetail);
	    }
	}
	
	public boolean updateUser(UserDetail userDetail) {
		boolean status = false;
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try{
			session.saveOrUpdate(userDetail);
			User user = (User) session.load(User.class, userDetail.getId());
			user.setUsername(userDetail.getUserName());
			user.setPassword(userDetail.getPassword());
			session.saveOrUpdate(user);
			tx.commit();
			status= true;
		}catch(Exception e){
			System.out.println("exception occured in update user detail==="+e.getMessage());
			tx.rollback();
		}finally{
			session.close();
		}
		return status;
	}
	
	/*@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<EmpDetail> getAllEmployees() {
		//System.out.println("===========SessionFactory created=========="+sessionFactory);
		//Session ses1 = sessionFactory.openSession();
		//System.out.println("===========Session created=========="+ses1);
		Session ses2 = sessionFactory.getCurrentSession();
		System.out.println("===========Session created=========="+ses2);
	    return ses2.createQuery("from EmpDetail").list();
	}*/
}
