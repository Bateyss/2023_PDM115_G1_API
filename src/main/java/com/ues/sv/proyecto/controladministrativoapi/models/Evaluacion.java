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
@Table(name = "EVALUACION")
public class Evaluacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_EVALUACION")
	private Long idEvaluacion;

	@JoinColumn(name = "ID_CURSO", referencedColumnName = "ID_CURSO")
	@ManyToOne
	private Curso curso;

	@JoinColumn(name = "ID_TIPO_EVALUACION", referencedColumnName = "ID_TIPO_EVALUACION")
	@ManyToOne
	private TipoEvaluacion tipoEvaluacion;

	@Column(name = "NUMERO_EVALUACION", nullable = false)
	private Integer numeroEvaluacion;

	public Evaluacion() {
	}

	public Evaluacion(Long idEvaluacion, Curso curso, TipoEvaluacion tipoEvaluacion, Integer numeroEvaluacion) {
		this.idEvaluacion = idEvaluacion;
		this.curso = curso;
		this.tipoEvaluacion = tipoEvaluacion;
		this.numeroEvaluacion = numeroEvaluacion;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Evaluacion that = (Evaluacion) o;

		return idEvaluacion.equals(that.idEvaluacion);
	}

	@Override
	public int hashCode() {
		return idEvaluacion.hashCode();
	}

	public Long getIdEvaluacion() {
		return idEvaluacion;
	}

	public void setIdEvaluacion(Long idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public TipoEvaluacion getTipoEvaluacion() {
		return tipoEvaluacion;
	}

	public void setTipoEvaluacion(TipoEvaluacion tipoEvaluacion) {
		this.tipoEvaluacion = tipoEvaluacion;
	}

	public Integer getNumeroEvaluacion() {
		return numeroEvaluacion;
	}

	public void setNumeroEvaluacion(Integer numeroEvaluacion) {
		this.numeroEvaluacion = numeroEvaluacion;
	}
}
