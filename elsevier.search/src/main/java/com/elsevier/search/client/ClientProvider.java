package com.elsevier.search.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

import javax.net.ssl.HttpsURLConnection;


//import io.searchbox.client.JestClientFactory;
//import io.searchbox.client.config.HttpClientConfig;
//import io.searchbox.client.http.JestHttpClient;
//
import org.apache.http.HttpHost;
//import org.apache.http.conn.routing.HttpRoute;
//import org.elasticsearch.client.RestClient;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//
public class ClientProvider
{
	private static final Logger logger = Logger.getLogger("ClientProvider");
    
    private static ClientProvider instance = null;
    private static Object lock = new Object();
    
//    private static JestHttpClient client;
//    private static RestClient restClient;
//    private String searchServerClusterNodes = "OBIISearchCluster";    
    
    private static ClientProvider instance(){
        
        if(instance == null) { 
            synchronized (lock) {
                if(null == instance){
                    instance = new ClientProvider();
                }
            }
        }
        return instance;
    }
    
//    public static JestHttpClient getJestClient()
//    {
//    	if(client == null) { 
//            client = ClientProvider.instance().createJestClient();
//         }    	
//        return client;
//    }
//    
/*    public static RestClient getRestClient(String hostname, int port)
    {
    	if(restClient == null) { 
    		restClient = RestClient.builder(
                    new HttpHost(hostname, port))
                    .setMaxRetryTimeoutMillis(10000)
                    .build();
         }    	
        return restClient;
    }
*/    
	// HTTP GET request
	private void sendGet() throws Exception {

		String url = "http://localhost:9200/car/_search?q=epidural&pretty=true";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		//con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());

	}

	// HTTP POST request
	private void sendPost() throws Exception {

		String url = "https://selfsolve.apple.com/wcResults.do";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		// add reuqest header
		String USER_AGENT = "Mozilla/5.0";
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());

	}
    
    
//
//	protected JestHttpClient createJestClient()
//    {
//    	JestHttpClient jestHttpClient = null;
//    	
//        if(client == null)
//        {
//            if (logger.isDebugEnabled())
//            {
//                logger.debug("Creating client for Search!");
//            }            
//            
//            try
//            {
//            	JestClientFactory factory = new JestClientFactory();
//                // can have different rout added for each environment
//                HttpRoute routeDev = new HttpRoute(new HttpHost("http://localhost"));
//
//                HttpClientConfig httpClientConfig = new HttpClientConfig.Builder("http://localhost:9200")
//                        .multiThreaded(true)
//                        .maxTotalConnection(5)
//                        .defaultMaxTotalConnectionPerRoute(2)
//                        .maxTotalConnectionPerRoute(routeDev, 2)
//                        .build();
//
//                factory.setHttpClientConfig(httpClientConfig);
//                jestHttpClient = (JestHttpClient) factory.getObject();
//                
//                logger.info("Created Jest HTTP client for Search!");
//            }
//            catch(Exception ex)
//            {
//                //ignore any exception, dont want to stop context loading
//                logger.error("Error occured while creating search client!", ex);
//            }
//        }
//        return jestHttpClient;
//    }
//    
//    public void addNewNode(String name)
//    {
//    	logger.info("TODO: Method needs to be implemented");        
//    }
//    
//    public void removeNode(String name)
//    {
//    	logger.info("TODO: Method needs to be implemented");
//    }
}
