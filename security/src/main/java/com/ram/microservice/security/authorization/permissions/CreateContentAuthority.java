package com.forum.authorization.permissions;

import org.springframework.security.core.GrantedAuthority;

public class CreateContentAuthority implements GrantedAuthority {

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return "OP_CREATE_CONTENT";
	}

}
