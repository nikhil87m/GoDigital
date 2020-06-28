package com.isat.support.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.isat.support.domain.Order;
import com.isat.support.domain.OrderLineItem;

@Repository
public interface OrderLineItemRepository extends CrudRepository<OrderLineItem, Order>{
	
	public abstract List<OrderLineItem> findByOrderId(Integer orderId);

}
