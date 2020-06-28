package com.elsevier.search.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;

import com.elsevier.search.client.ClientProvider;
import com.elsevier.search.model.SearchConstants;
import com.elsevier.search.model.SearchCriteria;
import com.elsevier.search.util.QueryUtil;

public class QueryServiceImpl {
	
	private static final Logger logger = Logger.getLogger("QueryServiceImpl");	

	private String executeQuery(String method, String queryString,
			boolean isURLEncoded) {
		logger.log(Level.FINEST, "Entry:executeQuery");
			
		BufferedReader in = null;
		HttpURLConnection con = null;
		StringBuffer response = null;

		try {
			String urlStr = QueryUtil.buildURI(queryString, isURLEncoded);
			
			URL url = new URL(urlStr);

			con = (HttpURLConnection) url.openConnection();

			con.setRequestMethod(method);

			int responseCode = con.getResponseCode();

			in = new BufferedReader(new InputStreamReader(con.getInputStream()));

			String inputLine;
			response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (in != null)
					in.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(con != null)
				con.disconnect();
		}
		logger.log(Level.FINEST, "Exit:executeQuery");
		return response.toString();
	}
	
	public String findMatchingCARS(SearchCriteria criteria) throws Exception{
		
		String response = null;
		
		if(criteria == null)
			throw new Exception("No Criteria found !!");
		
			response = executeQuery(criteria.getMethod(), criteria.getQueryString(), criteria.isURLEncoded());
		
		return response;
	}
}
