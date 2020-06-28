package com.elsevier.search.service;

import java.io.IOException;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;

import com.elsevier.search.client.ClientProvider;
import com.elsevier.search.model.SearchConstants;
import com.elsevier.search.model.SearchCriteria;

public class ESQueryServiceImpl implements QueryService {
	
	private static final Logger logger = Logger.getLogger("ESQueryServiceImpl");
	
	private static RestClient client = null;
	
	public ESQueryServiceImpl(){		
		logger.info("Initilising Query service...");		
		initilise();
	}
	
	public String findMatchingCAR(SearchCriteria criteria, boolean isJSONQuery)throws IOException{
		String result = null;
		
		if(criteria != null && isJSONQuery){
			result = findMatchingCARAsJSON(criteria);
			
		} else {
			
		}
		
		return result;
	}
	
	private void initilise(){
		
		int port = SearchConstants.PORT.getIntValue();
		String hostname = SearchConstants.HOST.getValue();	
		
		client = ClientProvider.getRestClient(hostname, port);
		
		logger.info("Initilised client provider...");
	}
	
	private String findMatchingCARAsJSON(SearchCriteria criteria) throws IOException{
		
		Response response = null;
		StringBuffer result = new StringBuffer();
		
			response = executeQuery(criteria.getMethod(), criteria.getQueryString());
			
			if (response != null)
				result.append(EntityUtils.toString(response.getEntity()));
		 
		return result.toString();
	}
	
	private Response executeQuery(String method, String queryString) throws IOException{		
		logger.log(Level.FINEST,"Entry:executeQuery");
		
		Response response = client.performRequest(method, queryString, Collections.singletonMap("pretty", "true"));
		
		logger.log(Level.FINEST,"Exit:executeQuery");
		return response;
	}
	
	public String findMatchingCARS(SearchCriteria criteria) throws Exception {
		return new QueryServiceImpl().findMatchingCARS(criteria);
	}
}
