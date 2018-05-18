package com.ram.microservice.security.datalayer;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ram.microservice.security.entities.UCFUser;


@Repository
@Transactional
public class UCFUserDao{

	@Autowired
	private EntityManagerFactory emFactory;
	/*@Autowired
	private MongoTemplate mongoTemplate;
	*/
	
	public UCFUser findUserByName(String userName)
	{
		Query<UCFUser> query=getSession().createQuery("from ucf_user where username = :username",UCFUser.class);
		query.setParameter("username", userName);
		return query.list().get(0);
	}

	public  UCFUser getUCFUser(final long userId)
    {
		return getSession().get(UCFUser.class, Long.toString(userId));
    }
	
	public void saveUCFUser(UCFUser ufcUser)
    {
		getSession().save(ufcUser);
    }
	
	private Session getSession(){
		return emFactory.unwrap(SessionFactory.class).getCurrentSession();
	}
}
