package com.ues.sv.proyecto.controladministrativoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ues.sv.proyecto.controladministrativoapi.models.Alumno;
import com.ues.sv.proyecto.controladministrativoapi.repository.AlumnoRepo;

@Service
public class AlumnoService extends AbstractService<Alumno, Long, AlumnoRepo> {

	@Autowired
	private AlumnoRepo alumnoRepo;

	@Override
	protected AlumnoRepo getRepo() {
		return alumnoRepo;
	}

	@Override
	protected Long getEntityId(Alumno entity) {
		return entity.getIdAlumno();
	}

}
