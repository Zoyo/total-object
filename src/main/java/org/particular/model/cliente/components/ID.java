package org.particular.model.cliente.components;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ID implements Serializable {
	private static final long serialVersionUID = 6502811456640348288L;
	
	@Column(name="id")
	private Long valor;

	@SuppressWarnings("unused")
	private ID() {/*construtor default que só existe por causa do hibernate*/}
	
	public ID(Long id) {
		this.valor = id;
	}
	
	public Long get() {
		return this.valor;
	}
	
	@Override
	public String toString() {
		return (this.valor != null ? this.valor.toString() : "");
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
		ID other = (ID) obj;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
}
