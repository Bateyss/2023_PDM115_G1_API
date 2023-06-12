package com.ues.sv.proyecto.controladministrativoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ues.sv.proyecto.controladministrativoapi.models.Inscripcion;
import com.ues.sv.proyecto.controladministrativoapi.repository.InscripcionRepo;

@Service
public class InscripcionService extends AbstractService<Inscripcion, Long, InscripcionRepo> {

	@Autowired
	private InscripcionRepo inscripcionRepo;

	@Override
	protected InscripcionRepo getRepo() {
		return inscripcionRepo;
	}

	@Override
	protected Long getEntityId(Inscripcion entity) {
		return entity.getIdInscripcion();
	}

}
