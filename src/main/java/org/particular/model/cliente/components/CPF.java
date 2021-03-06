package org.particular.model.cliente.components;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CPF {
	@Column(name="cpf")
	private String valor;

	@SuppressWarnings("unused")
	private CPF() {/*construtor default que só existe por causa do hibernate*/}

	public CPF(String valor) {
		/*
		 * Posso realizar a formatação aqui
		 */
		this.valor = valor;
	}
	
	public String get() {
		return valor;
	}
	
	@Override
	public String toString() {
		return (this.valor != null ? this.valor : "");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		CPF other = (CPF) obj;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
}
