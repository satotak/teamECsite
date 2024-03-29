package com.internousdev.texas.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class CreateUserAction extends ActionSupport implements SessionAware {
	private String backFlag;
	private Map<String, Object> session;

	public String execute() {
		if (!session.containsKey("tempUserId")) {
			return "sessionTimeout";
		}
        /* 次画面(createConfirm.jsp)から戻る場合はbackFlgでセッションを保持
         * 新規登録(login.jspから)であればセッションは消す
         * */
		if (backFlag == null) {
			session.remove("familyName");
			session.remove("firstName");
			session.remove("familyNameKana");
			session.remove("firstNameKana");
			session.remove("sex");
			session.remove("sexList");
			session.remove("email");
			session.remove("userIdForCreateUser");
			session.remove("password");
		}

		List<String> sexList = new ArrayList<String>();
		// 画面表示時に選択されている性別を作成

		if (!session.containsKey("sex")) {
			session.put("sex", "男性");
		} else {
			session.put("sex", String.valueOf(session.get("sex")));
		}
		sexList.add("男性");
		sexList.add("女性");
		session.put("sexList", sexList);

		return SUCCESS;
	}

	public String getBackFlag() {
		return backFlag;
	}

	public void setBackFlag(String backFlag) {
		this.backFlag = backFlag;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}

