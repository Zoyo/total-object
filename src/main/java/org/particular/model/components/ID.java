package org.particular.model.components;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ID {
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
