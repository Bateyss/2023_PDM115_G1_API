package com.ues.sv.proyecto.controladministrativoapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TIPOEVALUACION")
public class TipoEvaluacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TIPO_EVALUACION")
	private Long idTipoEvaluacion;

	@Column(name = "NOMBRE_TIPO_EVALUACION", nullable = false)
	private String nombreTipoEvaluacion;

	public TipoEvaluacion() {
	}

	public TipoEvaluacion(Long idTipoEvaluacion, String nombreTipoEvaluacion) {
		this.idTipoEvaluacion = idTipoEvaluacion;
		this.nombreTipoEvaluacion = nombreTipoEvaluacion;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		TipoEvaluacion that = (TipoEvaluacion) o;

		return idTipoEvaluacion.equals(that.idTipoEvaluacion);
	}

	@Override
	public int hashCode() {
		return idTipoEvaluacion.hashCode();
	}

	public Long getIdTipoEvaluacion() {
		return idTipoEvaluacion;
	}

	public void setIdTipoEvaluacion(Long idTipoEvaluacion) {
		this.idTipoEvaluacion = idTipoEvaluacion;
	}

	public String getNombreTipoEvaluacion() {
		return nombreTipoEvaluacion;
	}

	public void setNombreTipoEvaluacion(String nombreTipoEvaluacion) {
		this.nombreTipoEvaluacion = nombreTipoEvaluacion;
	}
}
