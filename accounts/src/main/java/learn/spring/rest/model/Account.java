package learn.spring.rest.model;

public class Account {
	
	private String userid;
	private String acctNumber;
	private String acctType;
	private float balance;

	public Account(String userId, String acctNumber, String acctType, float balance) {
		super();
		this.userid = userId;
		this.acctNumber = acctNumber;
		this.acctType = acctType;
		this.balance = balance;
	}
	
	//{"acctNum":"a", "acctType":"a", "acctBal":"c"}
	public String toJsonString(){
		String acctPattern = "{\"userid\":\"%s\", \"acctNum\":\"%s\", \"acctType\":\"%s\", \"acctBal\":\"%s\"}";
		String jsonValue = String.format(acctPattern, this.userid, this.acctNumber, this.acctType, ""+this.balance);
		return jsonValue;
	}
	public String getUserId() {
		return userid;
	}
	public String getAcctNumber() {
		return acctNumber;
	}
	public String getAcctType() {
		return acctType;
	}
	public float getBalance() {
		return balance;
	}
	public void setUserId(String userId) {
		this.userid = userId;
	}
	public void setAcctNumber(String acctNumber) {
		this.acctNumber = acctNumber;
	}
	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	

}
