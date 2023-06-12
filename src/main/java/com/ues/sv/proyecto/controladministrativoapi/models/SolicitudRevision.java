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
@Table(name = "SOLICITUDREVISION")
public class SolicitudRevision {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_SOLICITUD_REVISION")
	private Long idSolicitudRevision;

	@JoinColumn(name = "ID_INSCRIPCION", referencedColumnName = "ID_INSCRIPCION")
	@ManyToOne
	private Inscripcion inscripcion;

	@JoinColumn(name = "ID_EVALUACION", referencedColumnName = "ID_EVALUACION")
	@ManyToOne
	private Evaluacion evaluacion;

	@Column(name = "MOTIVO", nullable = false)
	private String motivo;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_CREACION", nullable = false)
	private Date fechaCreacion;

	@Column(name = "ESTADO_SOLICITUD", nullable = false)
	private Integer estadoSolicitud;

	public SolicitudRevision() {
	}

	public SolicitudRevision(Long idSolicitudRevision, Inscripcion inscripcion, Evaluacion evaluacion, String motivo,
			Date fechaCreacion, Integer estadoSolicitud) {
		this.idSolicitudRevision = idSolicitudRevision;
		this.inscripcion = inscripcion;
		this.evaluacion = evaluacion;
		this.motivo = motivo;
		this.fechaCreacion = fechaCreacion;
		this.estadoSolicitud = estadoSolicitud;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		SolicitudRevision that = (SolicitudRevision) o;

		return idSolicitudRevision.equals(that.idSolicitudRevision);
	}

	@Override
	public int hashCode() {
		return idSolicitudRevision.hashCode();
	}

	public Long getIdSolicitudRevision() {
		return idSolicitudRevision;
	}

	public void setIdSolicitudRevision(Long idSolicitudRevision) {
		this.idSolicitudRevision = idSolicitudRevision;
	}

	public Inscripcion getInscripcion() {
		return inscripcion;
	}

	public void setInscripcion(Inscripcion inscripcion) {
		this.inscripcion = inscripcion;
	}

	public Evaluacion getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(Evaluacion evaluacion) {
		this.evaluacion = evaluacion;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Integer getEstadoSolicitud() {
		return estadoSolicitud;
	}

	public void setEstadoSolicitud(Integer estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
	}
}
