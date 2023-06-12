package com.ues.sv.proyecto.controladministrativoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ues.sv.proyecto.controladministrativoapi.models.Coordinador;
import com.ues.sv.proyecto.controladministrativoapi.repository.CoordinadorRepo;

@Service
public class CoordinadorService extends AbstractService<Coordinador, Long, CoordinadorRepo> {

	@Autowired
	private CoordinadorRepo coordinadorRepo;

	@Override
	protected CoordinadorRepo getRepo() {
		return coordinadorRepo;
	}

	@Override
	protected Long getEntityId(Coordinador entity) {
		return entity.getIdCoordinador();
	}

}
