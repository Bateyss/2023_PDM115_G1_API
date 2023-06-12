package com.ues.sv.proyecto.controladministrativoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ues.sv.proyecto.controladministrativoapi.models.Persona;
import com.ues.sv.proyecto.controladministrativoapi.repository.PersonaRepo;

@Service
public class PersonaService extends AbstractService<Persona, Long, PersonaRepo> {

	@Autowired
	private PersonaRepo personaRepo;

	@Override
	protected PersonaRepo getRepo() {
		return personaRepo;
	}

	@Override
	protected Long getEntityId(Persona entity) {
		return entity.getIdPersona();
	}

}
