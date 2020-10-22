package config;

public class Url {
	
	String baseUrl = "https://www.rctiplus.com";
	
	public String urls(String slash) {
		
		return baseUrl + slash;
	}

}
