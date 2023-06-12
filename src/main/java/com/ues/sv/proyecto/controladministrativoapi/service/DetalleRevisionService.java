package com.ues.sv.proyecto.controladministrativoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ues.sv.proyecto.controladministrativoapi.models.DetalleRevision;
import com.ues.sv.proyecto.controladministrativoapi.repository.DetalleRevisionRepo;

@Service
public class DetalleRevisionService extends AbstractService<DetalleRevision, Long, DetalleRevisionRepo> {

	@Autowired
	private DetalleRevisionRepo detalleRevisionRepo;

	@Override
	protected DetalleRevisionRepo getRepo() {
		return detalleRevisionRepo;
	}

	@Override
	protected Long getEntityId(DetalleRevision entity) {
		return entity.getIdDetalle();
	}

}
