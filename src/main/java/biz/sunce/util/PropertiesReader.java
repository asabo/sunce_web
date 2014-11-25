package biz.sunce.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Hashtable;
import java.util.Properties;

import org.apache.log4j.Logger;

public final class PropertiesReader
{
	private static Logger LOG = Logger.getLogger(PropertiesReader.class);
	private static PropertiesReader instance = null;
	
	private Hashtable<String, Properties> propertiesHash = new Hashtable<String, Properties>();
	
 	private Hashtable<String, Long> propertiesLastModifiedHash = new Hashtable<String, Long>();
	
	private PropertiesReader()
	{	}
	
	public static PropertiesReader getInstance()
	{
		if (instance == null)
		{
			instance = new PropertiesReader();
		}
		return instance;
	}
	
	public Properties getProperties(String propFileStr)
	{
 		Long datePropFileModified = (Long) this.propertiesLastModifiedHash.get(propFileStr);
		 
		URL url = this.getClass().getResource(propFileStr);
		if (url == null)
		{
			throw new RuntimeException("Property file " + propFileStr + " ne postoji...");
		}
		
		File propFile = null;
		Properties prop = (Properties) this.propertiesHash.get(propFileStr);
		try
		{
			propFile = new File(url.toString());
			 
			Long lastModified = new Long(propFile.lastModified());
			
						if (prop == null || datePropFileModified != null && !datePropFileModified.equals(lastModified))
			{
			
				synchronized (this)
				{
					 
					InputStream is = url.openStream();
					prop = new Properties();
					try
					{
						prop.load(is);
					}
					catch (IOException e)
					{
						throw new RuntimeException(e);
					}
					try
					{
						is.close();
					}
					catch (IOException e)
					{
						LOG.error(e.getMessage(), e);
					}
				}
				
				 
				this.propertiesHash.put(propFileStr, prop);
				this.propertiesLastModifiedHash.put(propFileStr, lastModified);
			}
		}
		catch (IOException e)
		{
			LOG.error(e);
			throw new RuntimeException("Greska pri pristupu property datoteci: " + propFileStr, e);
		}
		
		return prop;
	}
}