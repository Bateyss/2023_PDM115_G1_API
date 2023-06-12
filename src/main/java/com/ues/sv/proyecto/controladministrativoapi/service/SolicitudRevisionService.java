package com.ues.sv.proyecto.controladministrativoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ues.sv.proyecto.controladministrativoapi.models.SolicitudRevision;
import com.ues.sv.proyecto.controladministrativoapi.repository.SolicitudRevisionRepo;

@Service
public class SolicitudRevisionService extends AbstractService<SolicitudRevision, Long, SolicitudRevisionRepo> {

	@Autowired
	private SolicitudRevisionRepo solicitudRevisionRepo;

	@Override
	protected SolicitudRevisionRepo getRepo() {
		return solicitudRevisionRepo;
	}

	@Override
	protected Long getEntityId(SolicitudRevision entity) {
		return entity.getIdSolicitudRevision();
	}

	public List<SolicitudRevision> obtenerListaEntidadPorIdEvaluacion(Long idEvaluacion) {
		return solicitudRevisionRepo.findByEvaluacionIdEvaluacion(idEvaluacion);
	}
}
