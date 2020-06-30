package com.isat.support.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="OOS_TRX_ORDER_LI")
@IdClass(Order.class)
public class OrderLineItem {
	
	@Id
	@Column(name="LINE_ID")
	private Integer lineId;
	
	@Id
	@Column(name="ORDER_ID")
	private Integer orderId;
	
	@Column(name="REF_ID")
	private String refId;
	
	@Column(name="SVC_ID")
	private String svcId;
	
	@Column(name="START_EXEC_DATE")
	private Timestamp startExecDate;
	
	@Column(name="END_EXEC_DATE")
	private Timestamp endExecDate;
	
	@Column(name="ROW_CREATED_DATE")
	private Timestamp rowCreatedDate;
	
	@Column(name="ROW_UPDATED_DATE")
	private Timestamp rowUpdatedDate;
	
	@Column(name="STATUS")
	private Integer status;
	
	@Column(name="NOTES")
	private String notes;
	
	@Column(name="HAS_OUTPUT")
	private Integer hasOutput;
	
	@Column(name="INVOKE_CNT")
	private Integer invokeCnt;
	
	@Column(name="AUTE_CREATE")
	private Integer auteCreate;
	
	@Column(name="DPD_LINE_ID")
	private String DPD_LINE_ID;
	
	@Column(name="RETRY_ATTEMPT")
	private Integer retryAttempt;
	
	@Column(name="MAPPING_FIELD")
	private String mappingField;

	public Integer getLineId() {
		return lineId;
	}

	public void setLineId(Integer lineId) {
		this.lineId = lineId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public String getSvcId() {
		return svcId;
	}

	public void setSvcId(String svcId) {
		this.svcId = svcId;
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

	public Timestamp getRowUpdatedDate() {
		return rowUpdatedDate;
	}

	public void setRowUpdatedDate(Timestamp rowUpdatedDate) {
		this.rowUpdatedDate = rowUpdatedDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Integer getHasOutput() {
		return hasOutput;
	}

	public void setHasOutput(Integer hasOutput) {
		this.hasOutput = hasOutput;
	}

	public Integer getInvokeCnt() {
		return invokeCnt;
	}

	public void setInvokeCnt(Integer invokeCnt) {
		this.invokeCnt = invokeCnt;
	}

	public Integer getAuteCreate() {
		return auteCreate;
	}

	public void setAuteCreate(Integer auteCreate) {
		this.auteCreate = auteCreate;
	}

	public String getDPD_LINE_ID() {
		return DPD_LINE_ID;
	}

	public void setDPD_LINE_ID(String dPD_LINE_ID) {
		DPD_LINE_ID = dPD_LINE_ID;
	}

	public Integer getRetryAttempt() {
		return retryAttempt;
	}

	public void setRetryAttempt(Integer retryAttempt) {
		this.retryAttempt = retryAttempt;
	}

	public String getMappingField() {
		return mappingField;
	}

	public void setMappingField(String mappingField) {
		this.mappingField = mappingField;
	}

	@Override
	public String toString() {
		return "OrderLineItem [lineId=" + lineId + ", orderId=" + orderId + ", refId=" + refId + ", svcId=" + svcId
				+ ", startExecDate=" + startExecDate + ", endExecDate=" + endExecDate + ", rowCreatedDate="
				+ rowCreatedDate + ", rowUpdatedDate=" + rowUpdatedDate + ", status=" + status + ", notes=" + notes
				+ ", hasOutput=" + hasOutput + ", invokeCnt=" + invokeCnt + ", auteCreate=" + auteCreate
				+ ", DPD_LINE_ID=" + DPD_LINE_ID + ", retryAttempt=" + retryAttempt + ", mappingField=" + mappingField
				+ "]";
	}
	
	

}
