package com.ues.sv.proyecto.controladministrativoapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PARAMETROS")
public class Parametros {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PARAMETRO")
	private Long idParametro;

	@Column(name = "NOMBRE", nullable = false)
	private String nombre;

	@Column(name = "VALOR", nullable = false)
	private String valor;

	@Column(name = "ID_HISTORICO", nullable = false)
	private Integer idHistorico;

	public Parametros() {
	}

	public Parametros(Long idParametro, String nombre, String valor, Integer idHistorico) {
		this.idParametro = idParametro;
		this.nombre = nombre;
		this.valor = valor;
		this.idHistorico = idHistorico;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Parametros that = (Parametros) o;

		return idParametro.equals(that.idParametro);
	}

	@Override
	public int hashCode() {
		return idParametro.hashCode();
	}

	public Long getIdParametro() {
		return idParametro;
	}

	public void setIdParametro(Long idParametro) {
		this.idParametro = idParametro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Integer getIdHistorico() {
		return idHistorico;
	}

	public void setIdHistorico(Integer idHistorico) {
		this.idHistorico = idHistorico;
	}
}
