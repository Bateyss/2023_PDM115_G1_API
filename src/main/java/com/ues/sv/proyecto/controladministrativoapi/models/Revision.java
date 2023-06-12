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
@Table(name = "REVISION")
public class Revision {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_REVISION")
	private Long idRevision;

	@JoinColumn(name = "ID_EVALUACION", referencedColumnName = "ID_EVALUACION")
	@ManyToOne
	private Evaluacion evaluacion;

	@Column(name = "NUMERO_REVISION", nullable = false)
	private String numeroRevision;

	@Column(name = "OBSERVACIONES_REVISION")
	private String observacionesRevision;

	@Column(name = "ESTADO_REVISION", nullable = false)
	private Integer estadoRevision;

	@Column(name = "NOTA_REVISION", nullable = false)
	private Double notaRevision;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_REVISION")
	private Date fechaRevision;

	public Revision() {
	}

	public Revision(Long idRevision, Evaluacion evaluacion, String numeroRevision, String observacionesRevision,
			Integer estadoRevision, Double notaRevision, Date fechaRevision) {
		this.idRevision = idRevision;
		this.evaluacion = evaluacion;
		this.numeroRevision = numeroRevision;
		this.observacionesRevision = observacionesRevision;
		this.estadoRevision = estadoRevision;
		this.notaRevision = notaRevision;
		this.fechaRevision = fechaRevision;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Revision revision = (Revision) o;

		return idRevision.equals(revision.idRevision);
	}

	@Override
	public int hashCode() {
		return idRevision.hashCode();
	}

	public Long getIdRevision() {
		return idRevision;
	}

	public void setIdRevision(Long idRevision) {
		this.idRevision = idRevision;
	}

	public Evaluacion getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(Evaluacion evaluacion) {
		this.evaluacion = evaluacion;
	}

	public String getNumeroRevision() {
		return numeroRevision;
	}

	public void setNumeroRevision(String numeroRevision) {
		this.numeroRevision = numeroRevision;
	}

	public String getObservacionesRevision() {
		return observacionesRevision;
	}

	public void setObservacionesRevision(String observacionesRevision) {
		this.observacionesRevision = observacionesRevision;
	}

	public Integer getEstadoRevision() {
		return estadoRevision;
	}

	public void setEstadoRevision(Integer estadoRevision) {
		this.estadoRevision = estadoRevision;
	}

	public Double getNotaRevision() {
		return notaRevision;
	}

	public void setNotaRevision(Double notaRevision) {
		this.notaRevision = notaRevision;
	}

	public Date getFechaRevision() {
		return fechaRevision;
	}

	public void setFechaRevision(Date fechaRevision) {
		this.fechaRevision = fechaRevision;
	}
}
