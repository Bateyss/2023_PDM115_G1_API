package com.ues.sv.proyecto.controladministrativoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ues.sv.proyecto.controladministrativoapi.models.Parametros;
import com.ues.sv.proyecto.controladministrativoapi.repository.ParametrosRepo;

@Service
public class ParametroService extends AbstractService<Parametros, Long, ParametrosRepo> {

	@Autowired
	private ParametrosRepo parametrosRepo;

	@Override
	protected ParametrosRepo getRepo() {
		return parametrosRepo;
	}

	@Override
	protected Long getEntityId(Parametros entity) {
		return entity.getIdParametro();
	}

	public Parametros buscarEntidadPorIdHist(Integer idHistorico) {
		List<Parametros> lista = parametrosRepo.findByIdHistorico(idHistorico);
		return lista.isEmpty() ? null : lista.get(0);
	}
}
