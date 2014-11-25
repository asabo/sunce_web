package biz.sunce.db;

import java.io.IOException;

import biz.sunce.web.controller.config.Configuration;

public final class ConnectionFactory {

	private static ConnectionBroker broker = null;
	private static Configuration c;
	 

	public static DbConnection getDbConnection() {

		if (broker == null) {
			try {
				broker = new ConnectionBroker("com.mysql.jdbc.Driver",
						"jdbc:mysql://"+c.getAddress()+":"+c.getPort()+"/"
						+c.getDatabase()+"?characterEncoding="+c.getEncoding(), c.getUsername(),
						c.getPassword(), 2, 10, null, 
						600000);
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		return broker;
	}

	public static void inject(Configuration cnf) {
		c=cnf;		
	}

}
