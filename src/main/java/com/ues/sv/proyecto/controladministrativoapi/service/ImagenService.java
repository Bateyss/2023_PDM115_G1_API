package com.ues.sv.proyecto.controladministrativoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ues.sv.proyecto.controladministrativoapi.models.Imagen;
import com.ues.sv.proyecto.controladministrativoapi.repository.ImagenRepo;

@Service
public class ImagenService extends AbstractService<Imagen, Long, ImagenRepo> {

	@Autowired
	private ImagenRepo imagenRepo;

	@Override
	protected ImagenRepo getRepo() {
		return imagenRepo;
	}

	@Override
	protected Long getEntityId(Imagen entity) {
		return entity.getIdImagen();
	}

}
