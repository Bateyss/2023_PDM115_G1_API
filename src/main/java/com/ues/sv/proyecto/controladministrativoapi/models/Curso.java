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
@Table(name = "CURSO")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CURSO")
	private Long idCurso;

	@JoinColumn(name = "ID_CICLO", referencedColumnName = "ID_CICLO")
	@ManyToOne
	private Ciclo ciclo;

	@JoinColumn(name = "ID_MATERIA", referencedColumnName = "ID_MATERIA")
	@ManyToOne
	private Materia materia;

	@JoinColumn(name = "ID_DOCENTE", referencedColumnName = "ID_DOCENTE")
	@ManyToOne
	private Docente docente;

	@JoinColumn(name = "ID_COORDINADOR", referencedColumnName = "ID_COORDINADOR")
	@ManyToOne
	private Coordinador coordinador;

	public Curso() {
	}

	public Curso(Long idCurso, Ciclo ciclo, Materia materia, Docente docente, Coordinador coordinador) {
		this.idCurso = idCurso;
		this.ciclo = ciclo;
		this.materia = materia;
		this.docente = docente;
		this.coordinador = coordinador;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Curso curso = (Curso) o;

		return idCurso.equals(curso.idCurso);
	}

	@Override
	public int hashCode() {
		return idCurso.hashCode();
	}

	public Long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}

	public Ciclo getCiclo() {
		return ciclo;
	}

	public void setCiclo(Ciclo ciclo) {
		this.ciclo = ciclo;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Coordinador getCoordinador() {
		return coordinador;
	}

	public void setCoordinador(Coordinador coordinador) {
		this.coordinador = coordinador;
	}
}
