package com.elsevier.search.model;

public enum SearchConstants
{
	HOST("host", "localhost"),
	PORT("port", 9200),
	METHOD_GET("GET", "GET"),
	PROTOCOL_HTTP("http","http"),
	PROTOCOL_HTTPS("https","https"),
	QUERY_URI("QUERY_URI","/obii_dedup_car/_search?pretty&filter_path=hits.total,hits.hits._source.BIB_REC_ID,source=")	
	;
    
    private String name;
    private String value;
	private int intValue;

	private SearchConstants(String name, String value)
    {
        this.name = name;
        this.value = value;
    }

	private SearchConstants(String name, int intValue)
    {
        this.name = name;
        this.intValue = intValue;
    }
	
	public String getValue() {
		return value;
	}
	
	public int getIntValue() {
		return intValue;
	}
    
    public String getName() {
		return name;
	}

}
