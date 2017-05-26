package org.particular.model.cliente.components;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Fone {
	@Column(name="fone")
	private String fone;

	public Fone(String valor) {
		this.fone = valor;
	}
	
	@Override
	public String toString() {
		return this.fone;
	}
}
