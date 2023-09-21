package fr.eni.gamemanager.bo;

public class Passport {

	private String ipv4;
	private String userAgent;
	private User user;
	
	public Passport(String ipv4, String userAgent, User user) {
		this.ipv4 = ipv4;
		this.userAgent = userAgent;
		this.user = user;
	}

	public String getIpv4() {
		return ipv4;
	}

	public void setIpv4(String ipv4) {
		this.ipv4 = ipv4;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Passport [ipv4=" + ipv4 + ", userAgent=" + userAgent + ", user=" + user + "]";
	}
	
	
	
}
