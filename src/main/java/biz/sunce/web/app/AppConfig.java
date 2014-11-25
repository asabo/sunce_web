package biz.sunce.web.app;

import java.util.Properties;

import biz.sunce.web.controller.config.Configuration;

/*
 * sva konfiguracija vezana za aplikaciju, spojevi na baze, vanjske ovisnosti i sl.
 * svaki konfiguracijski objekt mora izaci u vidu nekakvog beana, kako bi ga se moglo injekrtirati 
 * drugim objektima kojima je potreban, a u isto vrijeme testove olaksati uvaljivanjem nekih drugih konfiguracija
 * klasama koje trebaju biti ili mockane ili raditi svoj posao na nekim privremenim resursima
 */
public final class AppConfig {

	private static Configuration cnf=null ;
	
	private static void init()
	{
	Properties DB_PROPERTIES = biz.sunce.util.PropertiesReader.getInstance().getProperties("/db.properties");

	String address = DB_PROPERTIES.getProperty("mysql.address");
	String user = DB_PROPERTIES.getProperty("mysql.username");
	String password = DB_PROPERTIES.getProperty("mysql.password");
	String repo = DB_PROPERTIES.getProperty("mysql.db");
	String portStr = DB_PROPERTIES.getProperty("mysql.port");
	String encoding = DB_PROPERTIES.getProperty("mysql.encoding");
	
	int port = Integer.valueOf(portStr);
	
	 cnf = new Configuration(user, repo, password,address, port, encoding);
	}
	
	public static Configuration getCnf()
	{
		if (cnf==null)
			init();
		
		return cnf;
	}
	  
}
