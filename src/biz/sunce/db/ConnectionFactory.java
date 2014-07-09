package biz.sunce.db;

import java.io.IOException;

import biz.sunce.web.config.Configuration;

public final class ConnectionFactory {

	static ConnectionBroker broker = null;
	static Configuration c = null;

	public static void inject(Configuration cfg) {
		c = cfg;
	}

	public static DbConnection getDbConnection() {

		if (broker == null) {
			try {
				broker = new ConnectionBroker("com.mysql.jdbc.Driver",
						"jdbc:mysql://localhost/sunce_repo", c.getUsername(),
						c.getPassword(), 2, 10, null, 
						600000);
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		return broker;
	}

}
