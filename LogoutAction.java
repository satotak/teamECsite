package com.internousdev.texas.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.texas.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session;

	public String execute() {
		UserInfoDAO dao =  new UserInfoDAO();

		String userId=String.valueOf(session.get("userId"));
		boolean savedUserIdFlag=Boolean.valueOf(String.valueOf(session.get("savedUserIdFlag")));
		int count=dao.logout(userId);

		if(count>0){
			session.clear();
			if(savedUserIdFlag){
				session.put("savedUserIdFlag",savedUserIdFlag);
				session.put("userId",userId);
			}

		}
		return SUCCESS;

	}
	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}
