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
@Table(name = "COORDINADOR")
public class Coordinador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_COORDINADOR")
	private Long idCoordinador;

	@JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA")
	@ManyToOne
	private Persona persona;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_INGRESO")
	private Date fechaIngreso;

	public Coordinador() {
	}

	public Coordinador(Long idCoordinador, Persona persona, Date fechaIngreso) {
		this.idCoordinador = idCoordinador;
		this.persona = persona;
		this.fechaIngreso = fechaIngreso;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Coordinador that = (Coordinador) o;

		return idCoordinador.equals(that.idCoordinador);
	}

	@Override
	public int hashCode() {
		return idCoordinador.hashCode();
	}

	public Long getIdCoordinador() {
		return idCoordinador;
	}

	public void setIdCoordinador(Long idCoordinador) {
		this.idCoordinador = idCoordinador;
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
