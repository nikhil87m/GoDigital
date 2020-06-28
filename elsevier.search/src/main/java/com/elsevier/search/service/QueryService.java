package com.elsevier.search.service;

import java.io.IOException;

import org.elasticsearch.client.Response;

import com.elsevier.search.model.SearchCriteria;

public interface QueryService {

	String findMatchingCAR(SearchCriteria criteria, boolean isJSONQuery) throws IOException;
	
	String findMatchingCARS(SearchCriteria criteria) throws Exception;
}
