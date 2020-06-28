package com.isat.support.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.isat.support.domain.LineOrder;
import com.isat.support.domain.OrderLineItemParam;

public interface OrderLineItemParameterRepository extends CrudRepository<OrderLineItemParam, Integer> {
	
	//@Query(value="select * from OOS_TRX_ORDER_LI_P   where LINE_ID=?2 and ORDER_ID=?1 ",nativeQuery = true)
	public abstract List<OrderLineItemParam> findByOrderIdAndLineId(Integer orderId,Integer lineId);

}
