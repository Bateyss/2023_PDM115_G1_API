package com.ues.sv.proyecto.controladministrativoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ues.sv.proyecto.controladministrativoapi.models.Evaluacion;
import com.ues.sv.proyecto.controladministrativoapi.repository.EvaluacionRepo;

@Service
public class EvaluacionService extends AbstractService<Evaluacion, Long, EvaluacionRepo> {

	@Autowired
	private EvaluacionRepo evaluacionRepo;

	@Override
	protected EvaluacionRepo getRepo() {
		return evaluacionRepo;
	}

	@Override
	protected Long getEntityId(Evaluacion entity) {
		return entity.getIdEvaluacion();
	}

}
