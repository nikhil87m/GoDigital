package com.isat.support.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OOS_TRX_ORDER_HDR")
public class OrderHeader {

	@Id
	@Column(name="ORDER_ID")
	private Integer orderId;
	
	@Column(name="ORDER_TYPE")
	private String orderType;
	
	@Column(name="ORDER_SRC")
	private String orderSrc;
	
	@Column(name="KEY_1")
	private String key1;
	
	@Column(name="KEY_2")
	private String key2;
	
	@Column(name="KEY_3")
	private String key3;
	
	@Column(name="REF_ID")
	private String refId;
	
	@Column(name="EXEC_DATE")
	private Timestamp execDate;
	
	@Column(name="START_EXEC_DATE")
	private Timestamp startExecDate;
	
	@Column(name="END_EXEC_DATE")
	private Timestamp endExecDate;
	
	@Column(name="ROW_CREATED_DATE")
	private Timestamp rowCreatedDate;
	
	@Column(name="ROW_CREATED_BY")
	private String rowCreatedBy;
	
	@Column(name="ROW_UPDATED_DATE")
	private Timestamp rowUpdatedDate;
	
	@Column(name="ROW_UPDATED_BY")
	private String rowUpdatedBy;
	
	@Column(name="STATUS")
	private Integer status;
	
	@Column(name="RESPOND")
	private Integer respond;
	
	@Column(name="ERROR_CODE")
	private String errorCode;
	
	@Column(name="ERROR_DESC")
	private String errorDesc;
	
	@Column(name="RESPOND_ERROR_DESC")
	private String respondErrorDesc;
	
	@Column(name="RESPOND_DATE")
	private Timestamp respondDate;
	
	@Column(name="CHANNEL")
	private String channel;
	
	@Column(name="DPD_ORDER_ID")
	private Integer dpdOrderId;
	
	@Column(name="RESUBMIT_ATTEMPT")
	private Integer resubmitAttempt;
	
	@Column(name="ADDITIONAL_FIELD1")
	private String additionalField1;
	
	@Column(name="ERROR_MAPMSG")
	private String errorMapmsg;
	
	@Column(name="ORDER_DATE")
	private Timestamp orderDate;

	@Override
	public String toString() {
		return "OrderHeader [orderId=" + orderId + ", orderType=" + orderType + ", orderSrc=" + orderSrc + ", key1="
				+ key1 + ", key2=" + key2 + ", key3=" + key3 + ", refId=" + refId + ", execDate=" + execDate
				+ ", startExecDate=" + startExecDate + ", endExecDate=" + endExecDate + ", rowCreatedDate="
				+ rowCreatedDate + ", rowCreatedBy=" + rowCreatedBy + ", rowUpdatedDate=" + rowUpdatedDate
				+ ", rowUpdatedBy=" + rowUpdatedBy + ", status=" + status + ", respond=" + respond + ", errorCode="
				+ errorCode + ", errorDesc=" + errorDesc + ", respondErrorDesc=" + respondErrorDesc + ", respondDate="
				+ respondDate + ", channel=" + channel + ", dpdOrderId=" + dpdOrderId + ", resubmitAttempt="
				+ resubmitAttempt + ", additionalField1=" + additionalField1 + ", errorMapmsg=" + errorMapmsg
				+ ", orderDate=" + orderDate + "]";
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getOrderSrc() {
		return orderSrc;
	}

	public void setOrderSrc(String orderSrc) {
		this.orderSrc = orderSrc;
	}

	public String getKey1() {
		return key1;
	}

	public void setKey1(String key1) {
		this.key1 = key1;
	}

	public String getKey2() {
		return key2;
	}

	public void setKey2(String key2) {
		this.key2 = key2;
	}

	public String getKey3() {
		return key3;
	}

	public void setKey3(String key3) {
		this.key3 = key3;
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public Timestamp getExecDate() {
		return execDate;
	}

	public void setExecDate(Timestamp execDate) {
		this.execDate = execDate;
	}

	public Timestamp getStartExecDate() {
		return startExecDate;
	}

	public void setStartExecDate(Timestamp startExecDate) {
		this.startExecDate = startExecDate;
	}

	public Timestamp getEndExecDate() {
		return endExecDate;
	}

	public void setEndExecDate(Timestamp endExecDate) {
		this.endExecDate = endExecDate;
	}

	public Timestamp getRowCreatedDate() {
		return rowCreatedDate;
	}

	public void setRowCreatedDate(Timestamp rowCreatedDate) {
		this.rowCreatedDate = rowCreatedDate;
	}

	public String getRowCreatedBy() {
		return rowCreatedBy;
	}

	public void setRowCreatedBy(String rowCreatedBy) {
		this.rowCreatedBy = rowCreatedBy;
	}

	public Timestamp getRowUpdatedDate() {
		return rowUpdatedDate;
	}

	public void setRowUpdatedDate(Timestamp rowUpdatedDate) {
		this.rowUpdatedDate = rowUpdatedDate;
	}

	public String getRowUpdatedBy() {
		return rowUpdatedBy;
	}

	public void setRowUpdatedBy(String rowUpdatedBy) {
		this.rowUpdatedBy = rowUpdatedBy;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getRespond() {
		return respond;
	}

	public void setRespond(Integer respond) {
		this.respond = respond;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDesc() {
		return errorDesc;
	}

	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

	public String getRespondErrorDesc() {
		return respondErrorDesc;
	}

	public void setRespondErrorDesc(String respondErrorDesc) {
		this.respondErrorDesc = respondErrorDesc;
	}

	public Timestamp getRespondDate() {
		return respondDate;
	}

	public void setRespondDate(Timestamp respondDate) {
		this.respondDate = respondDate;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public Integer getDpdOrderId() {
		return dpdOrderId;
	}

	public void setDpdOrderId(Integer dpdOrderId) {
		this.dpdOrderId = dpdOrderId;
	}

	public Integer getResubmitAttempt() {
		return resubmitAttempt;
	}

	public void setResubmitAttempt(Integer resubmitAttempt) {
		this.resubmitAttempt = resubmitAttempt;
	}

	public String getAdditionalField1() {
		return additionalField1;
	}

	public void setAdditionalField1(String additionalField1) {
		this.additionalField1 = additionalField1;
	}

	public String getErrorMapmsg() {
		return errorMapmsg;
	}

	public void setErrorMapmsg(String errorMapmsg) {
		this.errorMapmsg = errorMapmsg;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}
	
}

