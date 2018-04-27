package com.ram.microservice.security.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="useractivity")
public class UCFUserActivity {

    @Id
    private String userActivityID;

    private String userName;

    private String activityKey;
    
    private String activityText;

    private LocalDateTime activityTime;

	public String getUserActivityID() {
		return userActivityID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getActivityKey() {
		return activityKey;
	}

	public void setActivityKey(String activityKey) {
		this.activityKey = activityKey;
	}

	public String getActivityText() {
		return activityText;
	}

	public void setActivityText(String activityText) {
		this.activityText = activityText;
	}

	public LocalDateTime getActivityTime() {
		return activityTime;
	}

	public void setActivityTime(LocalDateTime loginTime) {
		this.activityTime = loginTime;
	}

    
}
