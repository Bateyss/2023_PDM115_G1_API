package com.ues.sv.proyecto.controladministrativoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ues.sv.proyecto.controladministrativoapi.models.Impresion;
import com.ues.sv.proyecto.controladministrativoapi.models.MotivoErrorImpresion;
import com.ues.sv.proyecto.controladministrativoapi.repository.MotivoErrorImpresionRepo;

@Service
public class MotivoErrorImpresionService extends AbstractService<MotivoErrorImpresion, Long, MotivoErrorImpresionRepo> {

	@Autowired
	private MotivoErrorImpresionRepo errorImpresionRepo;

	@Override
	protected MotivoErrorImpresionRepo getRepo() {
		return errorImpresionRepo;
	}

	@Override
	protected Long getEntityId(MotivoErrorImpresion entity) {
		return entity.getIdMotivo();
	}

	public List<MotivoErrorImpresion> obtenerListaPorImpresion(Impresion impresion) {
		return errorImpresionRepo.findByImpresion(impresion);
	}
}
