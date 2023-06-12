package com.ues.sv.proyecto.controladministrativoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ues.sv.proyecto.controladministrativoapi.models.EncargadoImpresion;
import com.ues.sv.proyecto.controladministrativoapi.repository.EncargadoImpresionRepo;

@Service
public class EncargadoImpresionService extends AbstractService<EncargadoImpresion, Long, EncargadoImpresionRepo> {

	@Autowired
	private EncargadoImpresionRepo encargadoImpresionRepo;

	@Override
	protected EncargadoImpresionRepo getRepo() {
		return encargadoImpresionRepo;
	}

	@Override
	protected Long getEntityId(EncargadoImpresion entity) {
		return entity.getIdEncargado();
	}
}
