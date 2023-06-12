package com.ues.sv.proyecto.controladministrativoapi.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractService<ENTITY, ID, REPO extends JpaRepository<ENTITY, ID>> {

	protected abstract REPO getRepo();

	protected abstract ID getEntityId(ENTITY entity);

	public ENTITY crearEntidad(ENTITY entity) {
		return getRepo().save(entity);
	}

	public ENTITY editarEntidad(ENTITY entity) {
		return getRepo().save(entity);
	}

	public void eliminarEntidad(ENTITY entity) {
		getRepo().deleteById(getEntityId(entity));
	}

	public ENTITY buscarEntidadPorId(ENTITY entity) {
		return getRepo().findById(getEntityId(entity)).orElse(null);
	}
	
	public List<ENTITY> obtenerListaEntidad() {
		return getRepo().findAll();
	}

}
