package org.particular.model.cliente.components;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ID implements Serializable {
	private static final long serialVersionUID = 6502811456640348288L;
	
	@Column(name="id")
	private Long id;

	public ID(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return (this.id != null ? this.id.toString() : "");
	}
}
