package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the productkind database table.
 * 
 */
@Entity
//@NamedQuery(name="Productkind.findAll", query="SELECT p FROM Productkind p")
public class Productkind implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String productKindId;

	private String productKindName;

	public Productkind() {
	}

	public String getProductKindId() {
		return this.productKindId;
	}

	public void setProductKindId(String productKindId) {
		this.productKindId = productKindId;
	}

	public String getProductKindName() {
		return this.productKindName;
	}

	public void setProductKindName(String productKindName) {
		this.productKindName = productKindName;
	}

}