package biz.sunce.web.config;

public final class Configuration {

	private String username = "sn_web";
	
	public Configuration(String uname, String db, String p)
	{
		this.username = uname;
		this.database=db;
		this.password = p;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
	}
	
	private String password = "s3cret";
	private String database = "repo";
	
}
