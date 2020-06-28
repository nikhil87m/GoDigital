package com.isat.support.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="OOS_TRX_ORDER_LI_P")

public class OrderLineItemParam {
	@Id
	@Column(name="ROWID")
	private String rowId;
	//@Id
	@Column(name="LINE_ID")
	private Integer lineId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="VALUE")
	private String value;
	
	//@Id
	@Column(name="ORDER_ID")
	private Integer orderId;

	public Integer getLineId() {
		return lineId;
	}

	public void setLineId(Integer lineId) {
		this.lineId = lineId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "OrderLineItemParam [lineId=" + lineId + ", name=" + name + ", value=" + value + ", orderId=" + orderId
				+ "]";
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	
	
}
