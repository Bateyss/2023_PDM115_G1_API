package com.ues.sv.proyecto.controladministrativoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ues.sv.proyecto.controladministrativoapi.models.ParticipanteRevision;
import com.ues.sv.proyecto.controladministrativoapi.repository.ParticipanteRevisionRepo;

@Service
public class ParticipanteRevisionService extends AbstractService<ParticipanteRevision, Long, ParticipanteRevisionRepo> {

	@Autowired
	private ParticipanteRevisionRepo participanteRevisionRepo;

	@Override
	protected ParticipanteRevisionRepo getRepo() {
		return participanteRevisionRepo;
	}

	@Override
	protected Long getEntityId(ParticipanteRevision entity) {
		return entity.getIdParticipante();
	}
}
