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
@Table(name = "PARTICIPANTEREVISION")
public class ParticipanteRevision {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PARTICIPANTE")
	private Long idParticipante;

	@JoinColumn(name = "ID_REVISION", referencedColumnName = "ID_REVISION")
	@ManyToOne
	private Revision revision;

	@JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA")
	@ManyToOne
	private Persona persona;

	public ParticipanteRevision() {
	}

	public ParticipanteRevision(Long idParticipante, Revision revision, Persona persona) {
		this.idParticipante = idParticipante;
		this.revision = revision;
		this.persona = persona;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		ParticipanteRevision that = (ParticipanteRevision) o;

		return idParticipante.equals(that.idParticipante);
	}

	@Override
	public int hashCode() {
		return idParticipante.hashCode();
	}

	public Long getIdParticipante() {
		return idParticipante;
	}

	public void setIdParticipante(Long idParticipante) {
		this.idParticipante = idParticipante;
	}

	public Revision getRevision() {
		return revision;
	}

	public void setRevision(Revision revision) {
		this.revision = revision;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
}
