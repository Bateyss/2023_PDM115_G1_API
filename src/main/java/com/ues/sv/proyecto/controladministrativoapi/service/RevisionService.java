package com.ues.sv.proyecto.controladministrativoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ues.sv.proyecto.controladministrativoapi.models.Revision;
import com.ues.sv.proyecto.controladministrativoapi.repository.RevisionRepo;

@Service
public class RevisionService extends AbstractService<Revision, Long, RevisionRepo> {

	@Autowired
	private RevisionRepo revisionRepo;

	@Override
	protected RevisionRepo getRepo() {
		return revisionRepo;
	}

	@Override
	protected Long getEntityId(Revision entity) {
		return entity.getIdRevision();
	}
}
