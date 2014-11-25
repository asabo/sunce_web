package biz.sunce.web.controller.config;

public final class Configuration {

	private String username = "sn_web";	
	private String password = "s3cret";
	private String database = "repo";
	private String address = "localhost";
	private int port = 3306;
	private String encoding = "UTF-8";
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	
	
	public Configuration(String uname, String db, String p, String address, int port, String encoding)
	{
		this.username = uname;
		this.database=db;
		this.password = p;
		this.address = address;
		this.port = port;
		this.encoding = encoding;
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

	
}
