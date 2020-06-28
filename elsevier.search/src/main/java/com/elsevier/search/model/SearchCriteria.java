package com.elsevier.search.model;

public class SearchCriteria {
	
	private String queryString;
	private String method;
	private boolean isURLEncoded;	
	
	public SearchCriteria(String method, String queryString,
			boolean isURLEncoded) {
		super();
		this.method = method;
		this.queryString = queryString;
		this.isURLEncoded = isURLEncoded;
	}
	public boolean isURLEncoded() {
		return isURLEncoded;
	}
	public void setURLEncoded(boolean isURLEncoded) {
		this.isURLEncoded = isURLEncoded;
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
	@Override
	public String toString() {
		return "SearchCriteria [queryString=" + queryString + ", method="
				+ method + ", isURLEncoded=" + isURLEncoded + "]";
	}
	
	
}
