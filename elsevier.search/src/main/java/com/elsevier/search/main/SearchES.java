package com.elsevier.search.main;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.text.StrSubstitutor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.elsevier.search.model.SearchConstants;
import com.elsevier.search.util.FileReader;

public class SearchES {
	
	public static void main(String args[]) throws Exception{			
		
		try{
			
//			QueryService service = new ESQueryServiceImpl();
			
			//String JSON_query = URLEncoder.encode(FileReader.getQueryFromFile(),"UTF-8");
			String JSON_query = FileReader.getQueryFromFile();
			System.out.println("JSON_query>"+JSON_query);
			
			String queryString = SearchConstants.QUERY_URI.getValue() + JSON_query;
			Map<String, String> values = new HashMap<String, String>();
			values.put( "BIB_REC_ENGLISH_TITLE_NAME", "TEST_TITLE" );
			values.put( "BIB_REC_ENGLISH_TITLE_NAME", "NIKHI" );
            values.put( "VOLUME_FIRST_QTY", "TEST" );
            values.put( "ISSUE_FIRST_QTY", "TEST_QTY" );
            values.put( "BIB_REC_END_PAGE_TEXT", "TEST_ss" );
//            values.put( "test", "NIKHIL" );
//            values.put( "test", "NIKHIL" );
            
//            System.out.println(queryString);
            
//			StrSubstitutor strSubstitutor = new StrSubstitutor( values );
//			String filtered = strSubstitutor.replace( queryString );
			
//			System.out.println("queryString"+queryString);
//			System.out.println("filtered"+filtered);
//			System.out.println("replace"+queryString.replace("BIB_REC_END_PAGE_TEXT", "TEST"));
			
//			Map valuesMap = new HashMap();
//			 valuesMap.put("BIB_REC_ENGLISH_TITLE_NAME", "quick brown fox");
//			 valuesMap.put("test", "lazy dog");
//			 String templateString = queryString;
//			 StrSubstitutor sub = new StrSubstitutor(valuesMap);
//			 String resolvedString = sub.replace(templateString);
			 
//			 System.out.println("resolvedString>>"+resolvedString);
			
			/*SearchCriteria criteria = new SearchCriteria(SearchConstants.METHOD_GET.getValue(),queryString,true);			
			String response = service.findMatchingCAR(criteria, true);
			
			printHits(response);*/	
			

			/*IndexResponse response = client.prepareIndex("twitter", "tweet", "1")
			        .setSource(jsonBuilder()
			                    .startObject()
			                        .field("user", "kimchy")
			                        .field("postDate", new Date())
			                        .field("message", "trying out Elasticsearch")
			                    .endObject()
			                  )
			        .get();*/
			 
			 
			 String queryString ="{\n"
						+ "    \"CAR_ID\" : \"${CAR_ID}\",\n"
						+ "    \"ARTICLE_TITLE\" : \"${ARTICLE_TITLE}\"\n"
						+

						"}";
				//TODO fetch it from property file
				Map<String, String> values = new HashMap<String, String>();
				values.put( "CAR_ID", "1234");
				values.put( "ARTICLE_TITLE", "testing article" );
				StrSubstitutor strSubstitutor = new StrSubstitutor( values );
				String filtered = strSubstitutor.replace( queryString );
				
				System.out.println(filtered);
				

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void printHits (String response) throws ParseException{
		
		String hits = "\"total\" : 0";
		//System.out.println("---------> "+hits);
		if(response.contains(hits)){
			System.out.println("\n\n---------> NOT a Duplicate CAR !!.........");
		} else {
			System.out.println("---------> Duplicate CAR found !!.........");
			
			System.out.println("\nData-->\n\n*******************Response START************************");
			System.out.println(response);
			System.out.println("******************Response END*************************");		
		}
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(response);
		//JSONArray  hitsTotal = (JSONArray) jsonObject.get("hits");
		//System.out.println(hitsTotal);

	}

}
