package org.particular.model.cliente.components;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CPF {
	@Column(name="cpf")
	private String cpf;

	public CPF(String valor) {
		/*
		 * Posso realizar a formatação aqui
		 */
		this.cpf = valor;
	}
	
	@Override
	public String toString() {
		return this.cpf;
	}
}
