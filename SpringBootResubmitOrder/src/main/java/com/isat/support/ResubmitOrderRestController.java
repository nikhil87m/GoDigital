package com.isat.support;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isat.support.domain.OrderHeader;
import com.isat.support.domain.OrderLineItem;
import com.isat.support.domain.OrderLineItemParam;
import com.isat.support.repo.OrderHeaderRepository;
import com.isat.support.repo.OrderLineItemParameterRepository;
import com.isat.support.repo.OrderLineItemRepository;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/RORestController")
public class ResubmitOrderRestController {
	
	private static Logger logger= LoggerFactory.getLogger(ResubmitOrderRestController.class);
	
	@Autowired
	OrderLineItemRepository orderLineItemRepository;
	
	@Autowired
	OrderHeaderRepository orderHeaderRepository;
	
	@Autowired
	OrderLineItemParameterRepository orderLineItemParameterRepository;
	
	@PostMapping("/resubmitOrder")
	public ResponseEntity<String> resubmitOrder(@RequestBody String key) {
		String[] words = key.split(",");
		logger.info(words[0]);
		logger.info(words[1]);
	logger.info("Entry: resubmitOrder: key :"+key);
	new SupportService().resubmitOrder(words[1], Integer.parseInt(words[0]));
		return new ResponseEntity<String>("Completed succesfully !", HttpStatus.OK);
	}
	
	@GetMapping("/resendResponse")
	public String resendResponse(@RequestParam(name="key", required = false) String key, @RequestParam(name="orderId", required = false) String orderId) {
		logger.info("Entry: resendResponse: key"+key+"orderId :"+orderId);
		return "Resent msg succesfully !";
	}
	
	@GetMapping("/getOrderHeaderDetails")
	public List<OrderHeader> getOrderHeaderDetails(@RequestParam(name="key", required = false) String key) {
		logger.info("Entry: getOrderHeaderDetails: key:"+key);
		List<OrderHeader> orderHeaderList = orderHeaderRepository.findOrderIdByKey1(key);
		logger.info("Exit: getOrderHeaderDetails: orderHeaderList"+orderHeaderList);
		return orderHeaderList;
	}
	
	@PostMapping("/saveOrderHeaderDetails")
	public void saveOrderHeaderDetails(@RequestBody OrderHeader orderHeader) {
		logger.info("Entry: saveOrderHeaderDetails :orderHeader "+orderHeader);
		orderHeaderRepository.save(orderHeader);
		logger.info("Exit: saveOrderHeaderDetails");
	}
	
	@GetMapping("/getOrderLineItems")
	public List<OrderLineItem> getOrderLineItems(@RequestParam(name="mworderid", required = false) Integer mworderid) {
		logger.info("Entry: getOrderLineItems : orderId :"+mworderid);
		 List<OrderLineItem> oli = orderLineItemRepository.findByOrderId(mworderid);
		 logger.info("Exit: getOrderLineItems: oli:"+oli);
		 return oli;
	}
	
	@PostMapping("/saveOrderLineItem")
	public void saveOrderLineItem(@RequestBody OrderLineItem orderLineItem) {
		logger.info("Entry: saveOrderLineItem :orderLineItem "+orderLineItem);
		orderLineItemRepository.save(orderLineItem);
		logger.info("Exit: saveOrderLineItem");
	}
	
	@GetMapping("/getOrderLineItemParam")
	public List<OrderLineItemParam> getOrderLineItemParam(@RequestParam(name="selectedOrderIdLineId", required = false) String selectedOrderIdLineId) {
		logger.info("Entry: getOrderLineItemParam :selectedOrderIdLineId "+selectedOrderIdLineId);
		List<OrderLineItemParam> olip = new ArrayList<OrderLineItemParam>();
		if(!"".equals(selectedOrderIdLineId)) {
		String[] words = selectedOrderIdLineId.split(",");
		olip = orderLineItemParameterRepository.findByOrderIdAndLineId(Integer.parseInt(words[0]),Integer.parseInt(words[1]));
		}
		logger.info("Exit: getOrderLineItemParam : olip"+olip);
		return olip;
	}

}
