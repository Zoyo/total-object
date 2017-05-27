package org.particular.model.cliente.components;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Fone {
	@Column(name="fone")
	private String valor;

	@SuppressWarnings("unused")
	private Fone() {/*construtor default que só existe por causa do hibernate*/}

	public Fone(String valor) {
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
		Fone other = (Fone) obj;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
}
