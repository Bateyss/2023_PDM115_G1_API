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
@Table(name = "USUARIO")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO")
	private Long idUsuario;

	@JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA")
	@ManyToOne
	private Persona persona;

	@Column(name = "USER_NAME", nullable = false)
	private String userName;

	@Column(name = "USER_PASS", nullable = false)
	private String userPass;

	public Usuario() {
	}

	public Usuario(Long idUsuario, Persona persona, String userName, String userPass) {
		this.idUsuario = idUsuario;
		this.persona = persona;
		this.userName = userName;
		this.userPass = userPass;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Usuario usuario = (Usuario) o;

		return idUsuario.equals(usuario.idUsuario);
	}

	@Override
	public int hashCode() {
		return idUsuario.hashCode();
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
}
