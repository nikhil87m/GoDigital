package com.javacodegeeks.spring.elasticsearch;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface CARRepository extends ElasticsearchRepository<CAR,String> {
    List<CAR> findCARsByAge(int age);  
    List<CAR> findCARsByName(String name);
    List<CAR> findCARsBySkillsIn(List<String> skills);
}
