package com.ues.sv.proyecto.controladministrativoapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MATERIA")
public class Materia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MATERIA")
	private Long idMateria;

	@Column(name = "NOMBRE_MATERIA", nullable = false)
	private String nombreMateria;
	
	@Column(name = "ID_IMAGEN")
	private Integer idImagen;

	public Materia() {
	}

	public Materia(Long idMateria, String nombreMateria,Integer idImagen) {
		this.idMateria = idMateria;
		this.nombreMateria = nombreMateria;
		this.idImagen = idImagen;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Materia materia = (Materia) o;

		return idMateria.equals(materia.idMateria);
	}

	@Override
	public int hashCode() {
		return idMateria.hashCode();
	}

	public Long getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(Long idMateria) {
		this.idMateria = idMateria;
	}

	public String getNombreMateria() {
		return nombreMateria;
	}

	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}

	public Integer getIdImagen() {
		return idImagen;
	}

	public void setIdImagen(Integer idImagen) {
		this.idImagen = idImagen;
	}
}
