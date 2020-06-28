package com.elsevier.search.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Logger;

import com.elsevier.search.model.SearchConstants;

public class QueryUtil {

	private static final Logger logger = Logger.getLogger("QueryUtil");	

	public static String buildURI(String queryString, boolean isURLEncoded){
		
		StringBuffer uriString = new StringBuffer(SearchConstants.PROTOCOL_HTTP.getValue() + "://");
		
		uriString.append(SearchConstants.HOST.getValue());
		uriString.append(SearchConstants.PORT.getIntValue());
		
		try {
			
			uriString.append((isURLEncoded ? URLEncoder.encode(queryString, "UTF-8"): queryString));
			uriString.append("&pretty=true");
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		logger.finest("QueryUtil:uriString="+uriString.toString());
		
		return uriString.toString() ;
	}
}
