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
@Table(name = "IMPRESION")
public class Impresion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_IMPRESION")
	private Long idImpresion;

	@JoinColumn(name = "ID_EVALUACION", referencedColumnName = "ID_EVALUACION")
	@ManyToOne
	private Evaluacion evaluacion;

	@JoinColumn(name = "ID_ENCARGADO", referencedColumnName = "ID_ENCARGADO")
	@ManyToOne
	private EncargadoImpresion encargadoImpresion;

	@Column(name = "FORMATO", nullable = false)
	private String formato;

	@Column(name = "OBSERVACIONES_IMPRESION")
	private String observacionesImpresion;

	@Column(name = "ESTADO_IMPRESION")
	private Integer estadoImpresion;

	public Impresion() {
	}

	public Impresion(Long idImpresion, Evaluacion evaluacion, EncargadoImpresion encargadoImpresion, String formato,
			String observacionesImpresion, Integer estadoImpresion) {
		this.idImpresion = idImpresion;
		this.evaluacion = evaluacion;
		this.encargadoImpresion = encargadoImpresion;
		this.formato = formato;
		this.observacionesImpresion = observacionesImpresion;
		this.estadoImpresion = estadoImpresion;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Impresion impresion = (Impresion) o;

		return idImpresion.equals(impresion.idImpresion);
	}

	@Override
	public int hashCode() {
		return idImpresion.hashCode();
	}

	public Long getIdImpresion() {
		return idImpresion;
	}

	public void setIdImpresion(Long idImpresion) {
		this.idImpresion = idImpresion;
	}

	public Evaluacion getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(Evaluacion evaluacion) {
		this.evaluacion = evaluacion;
	}

	public EncargadoImpresion getEncargadoImpresion() {
		return encargadoImpresion;
	}

	public void setEncargadoImpresion(EncargadoImpresion encargadoImpresion) {
		this.encargadoImpresion = encargadoImpresion;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getObservacionesImpresion() {
		return observacionesImpresion;
	}

	public void setObservacionesImpresion(String observacionesImpresion) {
		this.observacionesImpresion = observacionesImpresion;
	}

	public Integer getEstadoImpresion() {
		return estadoImpresion;
	}

	public void setEstadoImpresion(Integer estadoImpresion) {
		this.estadoImpresion = estadoImpresion;
	}
}
