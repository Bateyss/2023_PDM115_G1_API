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
@Table(name = "MOTIVOERRORIMPRESION")
public class MotivoErrorImpresion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MOTIVO")
	private Long idMotivo;

	@JoinColumn(name = "ID_IMPRESION", referencedColumnName = "ID_IMPRESION")
	@ManyToOne
	private Impresion impresion;

	@Column(name = "DESCRIPCION_MOTIVO", nullable = false)
	private String descripcionMotivo;

	public MotivoErrorImpresion() {
	}

	public MotivoErrorImpresion(Long idMotivo, Impresion impresion, String descripcionMotivo) {
		this.idMotivo = idMotivo;
		this.impresion = impresion;
		this.descripcionMotivo = descripcionMotivo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		MotivoErrorImpresion that = (MotivoErrorImpresion) o;

		return idMotivo.equals(that.idMotivo);
	}

	@Override
	public int hashCode() {
		return idMotivo.hashCode();
	}

	public Long getIdMotivo() {
		return idMotivo;
	}

	public void setIdMotivo(Long idMotivo) {
		this.idMotivo = idMotivo;
	}

	public Impresion getImpresion() {
		return impresion;
	}

	public void setImpresion(Impresion impresion) {
		this.impresion = impresion;
	}

	public String getDescripcionMotivo() {
		return descripcionMotivo;
	}

	public void setDescripcionMotivo(String descripcionMotivo) {
		this.descripcionMotivo = descripcionMotivo;
	}
}
