package com.ues.sv.proyecto.controladministrativoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ues.sv.proyecto.controladministrativoapi.models.Curso;
import com.ues.sv.proyecto.controladministrativoapi.repository.CursoRepo;

@Service
public class CursoService extends AbstractService<Curso, Long, CursoRepo> {

	@Autowired
	private CursoRepo cursoRepo;

	@Override
	protected CursoRepo getRepo() {
		return cursoRepo;
	}

	@Override
	protected Long getEntityId(Curso entity) {
		return entity.getIdCurso();
	}

}
