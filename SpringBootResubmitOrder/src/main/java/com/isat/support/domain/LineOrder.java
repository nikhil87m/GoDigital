package com.isat.support.domain;

import java.io.Serializable;

public class LineOrder implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3996203356963889820L;

	private Integer lineId;
	
	private Integer orderId;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lineId == null) ? 0 : lineId.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LineOrder other = (LineOrder) obj;
		if (lineId == null) {
			if (other.lineId != null)
				return false;
		} else if (!lineId.equals(other.lineId))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}

	

}
