package com.ues.sv.proyecto.controladministrativoapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ENCARGADOIMPRESION")
public class EncargadoImpresion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ENCARGADO")
	private Long idEncargado;

	@JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA")
	@ManyToOne
	private Persona persona;

	@Column(name = "AREA", nullable = false)
	private String area;

	public EncargadoImpresion() {
	}

	public EncargadoImpresion(Long idEncargado, Persona persona, String area) {
		this.idEncargado = idEncargado;
		this.persona = persona;
		this.area = area;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		EncargadoImpresion that = (EncargadoImpresion) o;

		return idEncargado.equals(that.idEncargado);
	}

	@Override
	public int hashCode() {
		return idEncargado.hashCode();
	}

	public Long getIdEncargado() {
		return idEncargado;
	}

	public void setIdEncargado(Long idEncargado) {
		this.idEncargado = idEncargado;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
}
