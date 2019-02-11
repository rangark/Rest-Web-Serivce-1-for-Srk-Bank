package learn.spring.rest.service;

import java.util.HashMap;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import learn.spring.rest.model.Account;

@RestController
public class Accounts {
	
	private HashMap<String, Account> accounts;
	
	public Accounts() {
		accounts = new HashMap<String, Account>();
		accounts.put("first", new Account("first","100000000001","testType",(float)100000.00));
		accounts.put("last", new Account("last","100000000002","testType",(float)200000.00));
	}
	
	//[{"userId":"","account":c }]
	@RequestMapping(value="/accounts",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public String getAllAccountsAsJson(){
		String defaultString="{palaav vaasana ragaane kaavalante ela bujji.. kaasepu aagi raa}";
		String jsonStr = this.accounts.values().stream()
								.map(a -> a.toJsonString())
								.collect(Collectors.joining(","));
		if(jsonStr==null) { jsonStr = defaultString; 
		} else { jsonStr = "["+jsonStr+"]"; }

		return jsonStr;
	}

	//{}
	@RequestMapping(value="/accounts/first",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public String getFirstAccountAsJson() {
		return this.accounts.get("first").toJsonString();
	}

	@RequestMapping(value="/accounts/last",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public String getLastAccountAsJson() {
		return this.accounts.get("last").toJsonString();
	}
}
