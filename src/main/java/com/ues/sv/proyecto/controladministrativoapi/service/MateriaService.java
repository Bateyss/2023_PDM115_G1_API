package com.ues.sv.proyecto.controladministrativoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ues.sv.proyecto.controladministrativoapi.models.Materia;
import com.ues.sv.proyecto.controladministrativoapi.repository.MateriaRepo;

@Service
public class MateriaService extends AbstractService<Materia, Long, MateriaRepo> {

	@Autowired
	private MateriaRepo materiaRepo;

	@Override
	protected MateriaRepo getRepo() {
		return materiaRepo;
	}

	@Override
	protected Long getEntityId(Materia entity) {
		return entity.getIdMateria();
	}
}
