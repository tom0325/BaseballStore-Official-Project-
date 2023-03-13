package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the orderdetail database table.
 * 
 */
@Embeddable
public class OrderdetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int orderId;

	private int productId;

	public OrderdetailPK() {
	}
	public int getOrderId() {
		return this.orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return this.productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OrderdetailPK)) {
			return false;
		}
		OrderdetailPK castOther = (OrderdetailPK)other;
		return 
			(this.orderId == castOther.orderId)
			&& (this.productId == castOther.productId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.orderId;
		hash = hash * prime + this.productId;
		
		return hash;
	}
}