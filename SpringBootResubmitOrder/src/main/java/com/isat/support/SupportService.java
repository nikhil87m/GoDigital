package com.isat.support;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import oracle.jdbc.driver.OracleDriver;
import weblogic.jndi.WLInitialContextFactory;

public class SupportService {
	private static Logger logger= LoggerFactory.getLogger(SupportService.class);
	 void resubmitOrder(String refId, int orderId) {
		 logger.info("inside resubmit order");
		    if (refId == null || refId.length() < 1)
		      throw new IllegalArgumentException("Missing ref. id."); 
		    String query = "select /*+ parallel(a,8) */ a.KEY_1 || '_' || a.REF_ID as RESUBMIT_ID, 'channel5' as CHANNEL";
		    query = String.valueOf(query) + " from OOS_TRX_ORDER_HDR a";
		    query = String.valueOf(query) + " where 1 = 1";
		    query = String.valueOf(query) + " and not (a.STATUS = 1 and a.RESPOND = 1)";
		    query = String.valueOf(query) + " and a.KEY_1 = '" + refId + "'";
		    if (orderId != -1)
		      query = String.valueOf(query) + " and a.ORDER_ID = " + orderId; 
		    query = String.valueOf(query) + " order by a.ORDER_ID";
		    Connection conn = null;
		    Statement stat = null;
		    ResultSet rst = null;
		    Map<String, String> resubmitIds = new LinkedHashMap<String, String>();
		   
		    try {
		      Class.forName(OracleDriver.class.getName());
		      conn = DriverManager.getConnection(Constants.URL_OOS, Constants.USER_OOS, Constants.PWD_OOS);
		      stat = conn.createStatement();
		      logger.info("query:"+query);
		      rst = stat.executeQuery(query);
		      while (rst.next())
		        resubmitIds.put(rst.getString("RESUBMIT_ID"), rst.getString("CHANNEL")); 
		      
		      logger.info("resubmitIds"+resubmitIds);
		      if (resubmitIds.size() < 1) {
		    	  logger.info("Unable to find order with ref. id '" + refId + "' which has status and respond other than 1.");
		        return;
		      } 
		    } catch (Exception e) {
		      e.printStackTrace();
		      return;
		    } finally {
		      if (rst != null)
		        try {
		          rst.close();
		        } catch (SQLException e) {
		          e.printStackTrace();
		        }  
		      if (stat != null)
		        try {
		          stat.close();
		        } catch (SQLException e) {
		          e.printStackTrace();
		        }  
		      if (conn != null)
		        try {
		          conn.close();
		        } catch (SQLException e) {
		          e.printStackTrace();
		        }  
		    } 
		    Hashtable<String, String> env = new Hashtable<String, String>();
		    env.put("java.naming.factory.initial", WLInitialContextFactory.class.getName());
		    env.put("java.naming.provider.url", Constants.URL_JMS);
		    Session session = null;
		    javax.jms.Connection jmsConnection = null;
		    MessageProducer producer = null;
		    try {
		      Context context = new InitialContext(env);
		      ConnectionFactory factory = (ConnectionFactory)context.lookup(Constants.JNDI_JMS_OOS_CONNECTION_FACTORY);
		      Queue queue = (Queue)context.lookup(Constants.JNDI_QUEUE_INCOMINGORDERQ);
		      jmsConnection = factory.createConnection();
		      session = jmsConnection.createSession(false, 1);
		      producer = session.createProducer((Destination)queue);
		      for (Map.Entry<String, String> entry : resubmitIds.entrySet()) {
		        TextMessage message = session.createTextMessage(entry.getKey());
		        message.setStringProperty("ooschannel", entry.getValue());
		        logger.info("Sending '" + (String)entry.getKey() + "' ...");
		        producer.send((Message)message);
		        logger.info("Done sending message");
		      } 
		    } catch (Exception e) {
		      e.printStackTrace();
		      return;
		    } finally {
		      if (producer != null)
		        try {
		          producer.close();
		        } catch (JMSException jMSException) {} 
		      if (session != null)
		        try {
		          session.close();
		        } catch (JMSException jMSException) {} 
		      if (jmsConnection != null)
		        try {
		          jmsConnection.close();
		        } catch (JMSException jMSException) {} 
		    } 
		  }
}
