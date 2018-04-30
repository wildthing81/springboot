/**
 * 
 */
package com.ram.microservice.security.services.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.microservice.security.dao.UserActivityDao;
import com.ram.microservice.security.entities.UCFUserActivity;
import com.ram.microservice.security.services.UserActivityService;
import com.ram.microservice.security.utils.UCFConstants;

/**
 * @author r79
 *
 */
@Service
public class UserActivityServiceImpl implements UserActivityService {

	@Autowired
	private UserActivityDao userActivityDao;
	
	/*@Override
	public Flux<UCFUserActivity> userActivityFeed(String userName) 
	{
		ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(() -> {
           try {
        	    userEventsEmmitter.send(userEventsList, MediaType.TEXT_PLAIN);
                Thread.sleep(UCFConstants.USR_ACTV_REFRESH_PERIOD);
        	   
            } catch (Exception e) {
                e.printStackTrace();
                emitter.completeWithError(e);
                return;
            }
            emitter.complete();
        });
        service.shutdown();
        return emitter;
		return userActivityDao.getActivityFeed(userName);
	}*/

	@Override
	public void updateLoginActivity(LocalDateTime loginTime, String userName) {
		UCFUserActivity loginActivity=new UCFUserActivity();
		loginActivity.setActivityKey(UCFConstants.ACTV_LOGIN);
		loginActivity.setUserName(userName);
		loginActivity.setActivityTime(loginTime);
		loginActivity.setActivityText(userName+" logged in at "+loginTime);
		userActivityDao.updateLoginActivity(loginActivity);
	}

	@Override
	public UCFUserActivity getCurrentLoginActivity(String username) {
		 return userActivityDao.getCurrentLoginActivity(username);
	}
	
	

}
