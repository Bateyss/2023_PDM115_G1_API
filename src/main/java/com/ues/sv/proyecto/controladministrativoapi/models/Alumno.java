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
@Table(name = "ALUMNO")
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ALUMNO")
	private Long idAlumno;

	@JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA")
	@ManyToOne
	private Persona persona;

	@Column(name = "CARNET", nullable = false)
	private String carnet;

	public Alumno() {
	}

	public Alumno(Long idAlumno, Persona persona, String carnet) {
		this.idAlumno = idAlumno;
		this.persona = persona;
		this.carnet = carnet;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Alumno alumno = (Alumno) o;

		return idAlumno.equals(alumno.idAlumno);
	}

	@Override
	public int hashCode() {
		return idAlumno.hashCode();
	}

	public Long getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Long idAlumno) {
		this.idAlumno = idAlumno;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getCarnet() {
		return carnet;
	}

	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}
}
