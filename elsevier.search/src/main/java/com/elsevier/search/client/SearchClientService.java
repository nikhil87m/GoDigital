package com.elsevier.search.client;


/**
 * Interface for getting client for working with search engine
 * 
 */
public interface SearchClientService
{
    /**
     * Get Search engine client
     * @return JestHttpClient
     */
//	ClientProvider getClient();

    void addNewNode(String name);

    void removeNode(String nodeName);
}
