package biz.sunce.db;

import java.io.IOException;

import biz.sunce.web.config.Configuration;

public class ConnectionFactory {

	static ConnectionBroker broker = null;

	public static DbConnection getDbConnection()
	{
		
		if (broker == null)
		{
			Configuration c=new Configuration();
			
			try {
				broker = new ConnectionBroker(
						"com.mysql.jdbc.Driver",
						"jdbc:mysql://localhost/sunce_repo",
					  c.getUsername(),
					  c.getPassword(),
					  2, 
					  10, 
					  null, //logFileString
					  600000);
			} catch (IOException e) {				
				e.printStackTrace();
				throw new RuntimeException(e);
			}			
		}
		return broker;
	}

}
