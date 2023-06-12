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
@Table(name = "INSCRIPCION")
public class Inscripcion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_INSCRIPCION")
	private Long idInscripcion;

	@JoinColumn(name = "ID_ALUMNO", referencedColumnName = "ID_ALUMNO")
	@ManyToOne
	private Alumno alumno;

	@JoinColumn(name = "ID_CURSO", referencedColumnName = "ID_CURSO")
	@ManyToOne
	private Curso curso;

	public Inscripcion() {
	}

	public Inscripcion(Long idInscripcion, Alumno alumno, Curso curso) {
		this.idInscripcion = idInscripcion;
		this.alumno = alumno;
		this.curso = curso;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Inscripcion that = (Inscripcion) o;

		return idInscripcion.equals(that.idInscripcion);
	}

	@Override
	public int hashCode() {
		return idInscripcion.hashCode();
	}

	public Long getIdInscripcion() {
		return idInscripcion;
	}

	public void setIdInscripcion(Long idInscripcion) {
		this.idInscripcion = idInscripcion;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}
