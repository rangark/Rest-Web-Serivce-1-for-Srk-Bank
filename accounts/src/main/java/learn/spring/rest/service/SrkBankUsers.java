package learn.spring.rest.service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import learn.spring.rest.model.SrkBankUser;

@RestController
public class SrkBankUsers {

	private Map<String, SrkBankUser> users;

	public SrkBankUsers() {
		this.users = new HashMap<String, SrkBankUser>();
//		vurike konni userlu pedadam.. rest svc test ki pani chesthayi 
		this.users.put("first", new SrkBankUser("first","first@srk.com","first"));
		this.users.put("last", new SrkBankUser("last","last@srk.com","last"));
		this.users.put("aaaa", new SrkBankUser("aaaa","aaaa@srk.com","aaaapass"));
		this.users.put("bbbb", new SrkBankUser("bbbb","bbbb@srk.com","bbbbpass"));
	}
	
	@RequestMapping(value="/users", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public String getAllUsersAsJson() {
		String jsonArrayPatter="[%s]";
		String usersListStr = this.getUsers().values().stream()
									.map( u -> u.toJsonString())
									.collect(Collectors.joining(","));
		return String.format(jsonArrayPatter, usersListStr);
	}
	
	@RequestMapping(value="/users/{userid}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public String getUser(@PathVariable("userid") String userId) {
		String jsonValue = this.getUsers().get(userId).toJsonString();
		return (jsonValue==null)?"":jsonValue;
	}
	//{"userid":"a", "emailid":"a", "password":"a"}
	@RequestMapping(value="/users/new", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
	public String addUser(	@RequestParam(value="userid", required=false) String userId,
							@RequestParam(value="emailid", required=false) String emailId,
							@RequestParam(value="password", required=false) String passWord) {
		String newUserJson="";
		if(userId != null) {
			SrkBankUser newUser = new SrkBankUser(userId, (emailId==null)?"":emailId, (passWord==null)?"":passWord);
			this.getUsers().put(userId, newUser);
			newUserJson = newUser.toJsonString();
		}
		return newUserJson;
	}
	
	@RequestMapping(value="/users/first", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public String getFirstUser() {
		//return this.getUsers().get("first").toJsonString();
		return this.getUser("first");
	}

	@RequestMapping(value="/users/last", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public String getLastUser() {
//		return this.getUsers().get("last").toJsonString();
		return this.getUser("last");
	}

	public Map<String, SrkBankUser> getUsers() {
		return users;
	}

}
