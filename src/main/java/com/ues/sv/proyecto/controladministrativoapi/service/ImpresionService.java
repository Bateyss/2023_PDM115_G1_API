package com.ues.sv.proyecto.controladministrativoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ues.sv.proyecto.controladministrativoapi.models.Impresion;
import com.ues.sv.proyecto.controladministrativoapi.repository.ImpresionRepo;

@Service
public class ImpresionService extends AbstractService<Impresion, Long, ImpresionRepo> {

	@Autowired
	private ImpresionRepo impresionRepo;

	@Override
	protected ImpresionRepo getRepo() {
		return impresionRepo;
	}

	@Override
	protected Long getEntityId(Impresion entity) {
		return entity.getIdImpresion();
	}

	public Impresion buscarImpresionPorIdEvaluacion(Long idEvaluacion) {
		List<Impresion> lista = impresionRepo.findByEvaluacionIdEvaluacion(idEvaluacion);
		return lista.isEmpty() ? null : lista.get(0);
	}

}
