package com.ues.sv.proyecto.controladministrativoapi.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "DOCENTE")
public class Docente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_DOCENTE")
	private Long idDocente;

	@JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA")
	@ManyToOne
	private Persona persona;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_INGRESO", nullable = false)
	private Date fechaIngreso;

	public Docente() {
	}

	public Docente(Long idDocente, Persona persona, Date fechaIngreso) {
		this.idDocente = idDocente;
		this.persona = persona;
		this.fechaIngreso = fechaIngreso;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Docente docente = (Docente) o;

		return idDocente.equals(docente.idDocente);
	}

	@Override
	public int hashCode() {
		return idDocente.hashCode();
	}

	public Long getIdDocente() {
		return idDocente;
	}

	public void setIdDocente(Long idDocente) {
		this.idDocente = idDocente;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
}
