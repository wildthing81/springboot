package com.ram.microservice.security.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.ram.microservice.security.entities.UCFUserActivity;
import com.ram.microservice.security.utils.UCFConstants;

@Repository
public class UserActivityDao {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<UCFUserActivity> getActivityFeed(String userName) {	
		
		LocalDateTime loginTime=getCurrentLoginActivity(userName).getActivityTime();
		Query query=new Query();
		query.addCriteria(Criteria.where("activityTime").gte(loginTime));
	
		List<UCFUserActivity> activities=mongoTemplate.find(query,UCFUserActivity.class);
		return activities;
	}

	public void updateLoginActivity(UCFUserActivity loginActivity) {
		mongoTemplate.save(loginActivity);
		
	}

	public UCFUserActivity getCurrentLoginActivity(String username) {
		Query query=new Query();
		query.addCriteria(new Criteria().andOperator
						  (Criteria.where("userName").is(username),
						   Criteria.where("activityKey").is(UCFConstants.ACTV_LOGIN)));
	
		return mongoTemplate.find(query, UCFUserActivity.class).get(0);
		
	}

}
