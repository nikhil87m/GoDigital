package com.isat.support.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.isat.support.domain.OrderHeader;

public interface OrderHeaderRepository extends CrudRepository<OrderHeader, Integer> {
	
	public abstract List<OrderHeader> findOrderIdByKey1(String key1);

}
