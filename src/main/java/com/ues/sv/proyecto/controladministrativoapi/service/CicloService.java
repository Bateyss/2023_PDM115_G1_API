package com.ues.sv.proyecto.controladministrativoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ues.sv.proyecto.controladministrativoapi.models.Ciclo;
import com.ues.sv.proyecto.controladministrativoapi.repository.CicloRepo;

@Service
public class CicloService extends AbstractService<Ciclo, Long, CicloRepo> {

	@Autowired
	private CicloRepo cicloRepo;

	@Override
	protected CicloRepo getRepo() {
		return cicloRepo;
	}

	@Override
	protected Long getEntityId(Ciclo entity) {
		return entity.getIdCiclo();
	}

}
