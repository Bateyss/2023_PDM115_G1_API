package com.ues.sv.proyecto.controladministrativoapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CICLO")
public class Ciclo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CICLO")
	private Long idCiclo;

	@Column(name = "NUMERO_CICLO", nullable = false)
	private String numeroCiclo;

	@Column(name = "NUMERO_ANIO", nullable = false)
	private String numeroAnio;

	public Ciclo() {
	}

	public Ciclo(Long idCiclo, String numeroCiclo, String numeroAnio) {
		this.idCiclo = idCiclo;
		this.numeroCiclo = numeroCiclo;
		this.numeroAnio = numeroAnio;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Ciclo ciclo = (Ciclo) o;

		return idCiclo.equals(ciclo.idCiclo);
	}

	@Override
	public int hashCode() {
		return idCiclo.hashCode();
	}

	public Long getIdCiclo() {
		return idCiclo;
	}

	public void setIdCiclo(Long idCiclo) {
		this.idCiclo = idCiclo;
	}

	public String getNumeroCiclo() {
		return numeroCiclo;
	}

	public void setNumeroCiclo(String numeroCiclo) {
		this.numeroCiclo = numeroCiclo;
	}

	public String getNumeroAnio() {
		return numeroAnio;
	}

	public void setNumeroAnio(String numeroAnio) {
		this.numeroAnio = numeroAnio;
	}
}
