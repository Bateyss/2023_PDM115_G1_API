package com.ues.sv.proyecto.controladministrativoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ues.sv.proyecto.controladministrativoapi.models.TipoEvaluacion;
import com.ues.sv.proyecto.controladministrativoapi.repository.TipoEvaluacionRepo;

@Service
public class TipoEvaluacionService extends AbstractService<TipoEvaluacion, Long, TipoEvaluacionRepo> {

	@Autowired
	private TipoEvaluacionRepo evaluacionRepo;

	@Override
	protected TipoEvaluacionRepo getRepo() {
		return evaluacionRepo;
	}

	@Override
	protected Long getEntityId(TipoEvaluacion entity) {
		return entity.getIdTipoEvaluacion();
	}
}
