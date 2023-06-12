package com.ues.sv.proyecto.controladministrativoapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PERSONA")
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PERSONA")
	private Long idPersona;

	@Column(name = "NOMBRE", nullable = false)
	private String nombre;

	@Column(name = "APELLIDO", nullable = false)
	private String apellido;

	@Column(name = "IDENTIFICACION")
	private String identificacion;

	@Column(name = "SEXO")
	private String sexo;
	
	@Column(name = "ID_IMAGEN")
	private Integer idImagen;

	public Persona() {
		idImagen = null;
	}

	public Persona(Long idPersona, String nombre, String apellido, String identificacion, String sexo,Integer idImagen) {
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apellido = apellido;
		this.identificacion = identificacion;
		this.sexo = sexo;
		this.idImagen = idImagen;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Persona persona = (Persona) o;

		return idPersona.equals(persona.idPersona);
	}

	@Override
	public int hashCode() {
		return idPersona.hashCode();
	}

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Integer getIdImagen() {
		return idImagen;
	}

	public void setIdImagen(Integer idImagen) {
		this.idImagen = idImagen;
	}
}
