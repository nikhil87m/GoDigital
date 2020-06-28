package com.isat.support;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Constants {
	 public static final String USER_OOS = getProperty("user.oos");
	  
	  public static final String PWD_OOS = getProperty("pwd.oos");
	  
	  public static final String URL_OOS = getProperty("url.oos");
	  
	  public static final String USER_RBM = getProperty("user.rbm");
	  
	  public static final String PWD_RBM = getProperty("pwd.rbm");
	  
	  public static final String URL_RBM = getProperty("url.rbm");
	  
	  public static final String URL_JMS = getProperty("url.jms");
	  
	  public static final String JNDI_JMS_OOS_CONNECTION_FACTORY = getProperty("jndi.jms.oos.connection.factory");
	  
	  public static final String JNDI_JMS_OOS_XACONNECTION_FACTORY = getProperty("jndi.jms.oos.xaconnection.factory");
	  
	  public static final String JNDI_QUEUE_RESPONSEORDERQ = getProperty("jndi.queue.responseorderq");
	  
	  public static final String JNDI_QUEUE_INCOMINGORDERQ = getProperty("jndi.queue.incomingorderq");
	  
	  private static final String CONFIG_PROPERTIES = "config.properties";
	  
	  private static Properties properties = null;
	  
	  private static String getProperty(String key) {
	    if (properties == null) {
	      InputStream stream = Constants.class.getClassLoader().getResourceAsStream("config.properties");
	      properties = new Properties();
	      try {
	        properties.load(stream);
	      } catch (IOException e) {
	        e.printStackTrace();
	      } finally {
	        try {
	          stream.close();
	        } catch (IOException e) {
	          e.printStackTrace();
	        } 
	      } 
	    } 
	    return properties.getProperty(key);
	  }

}
