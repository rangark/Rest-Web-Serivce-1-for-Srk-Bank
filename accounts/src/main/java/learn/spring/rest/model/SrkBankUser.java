package learn.spring.rest.model;

public class SrkBankUser {
	
	private String userid;
	private String emailid;
	private String password;
	
	public SrkBankUser(String userid, String emailid, String password) {
		super();
		this.userid = userid;
		this.emailid = emailid;
		this.password = password;
	}

	//{"userid":"a", "emailid":"a", "password":"a"}
	public String toJsonString() {
		String jsonPattern = "{\"userid\":\"%s\", \"emailid\":\"%s\", \"password\":\"%s\"}";
		return String.format(jsonPattern, this.userid, this.emailid, this.password);
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
