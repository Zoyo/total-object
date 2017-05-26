package org.particular.model.cliente.components;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Nome {
	@Column(name="nome")
	private String nome;
	
	public Nome(String valor) {
		this.nome = valor;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
}
