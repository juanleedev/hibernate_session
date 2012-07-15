package com.py.hibernate;

import java.util.Date;

import org.hibernate.Session;



import com.py.test.hibernate.HibernateUtils;
import com.py.test.hibernate.User;

import junit.framework.TestCase;

public class SessionTest extends TestCase {
		
		public void testHello1(){
				System.out.print("--------------SessionTest.hello1");
				//throw new java.lang.RuntimeException();
		}
		
		public void testHello2(){
				System.out.print("--------------SessionTest.hello2");
				this.assertEquals("hello", "hello2");
		}
		
		public void testSave1(){
			  User user = null;
			  Session session = null;
			  try {
				  session = HibernateUtils.getSession();
				  session.beginTransaction();
				  
				  user = new User();
				  user.setName("Test1");
				  user.setPassword("111");
				  user.setCreateTime(new Date());
				  user.setExpireTime(new Date());
				
				  session.save(user);
				  
				  user.setName("Test2");
				  
				  session.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}finally{
				HibernateUtils.closeSession(session);
			}
			  
			  try {
				  session = HibernateUtils.getSession();
				  session.beginTransaction();
				  
				  user.setName("Test3");
				  session.update(user);
				  
				  session.getTransaction().commit();
					
			} catch (Exception e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}finally{
				HibernateUtils.closeSession(session);
			}
			  
			  try {
				  session = HibernateUtils.getSession();
				  session.beginTransaction();
				  user.setName("Test4");
				  user.setCreateTime(new Date());
				  user.setExpireTime(new Date());
				  
				  session.save(user);
				  
				  session.getTransaction().commit();
					
			} catch (Exception e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}finally{
				HibernateUtils.closeSession(session);
			}
		}
}
