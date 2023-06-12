package com.ues.sv.proyecto.controladministrativoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ues.sv.proyecto.controladministrativoapi.models.Docente;
import com.ues.sv.proyecto.controladministrativoapi.repository.DocenteRepo;

@Service
public class DocenteService extends AbstractService<Docente, Long, DocenteRepo> {

	@Autowired
	private DocenteRepo docenteRepo;

	@Override
	protected DocenteRepo getRepo() {
		return docenteRepo;
	}

	@Override
	protected Long getEntityId(Docente entity) {
		return entity.getIdDocente();
	}
}
