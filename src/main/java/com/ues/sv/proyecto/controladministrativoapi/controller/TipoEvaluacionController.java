package com.ues.sv.proyecto.controladministrativoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ues.sv.proyecto.controladministrativoapi.controller.abs.AbstractController;
import com.ues.sv.proyecto.controladministrativoapi.models.TipoEvaluacion;
import com.ues.sv.proyecto.controladministrativoapi.repository.TipoEvaluacionRepo;
import com.ues.sv.proyecto.controladministrativoapi.service.TipoEvaluacionService;

@Controller
@RequestMapping("/tipoevaluacion")
public class TipoEvaluacionController
		extends AbstractController<TipoEvaluacion, Long, TipoEvaluacionRepo, TipoEvaluacionService> {

	@Autowired
	private TipoEvaluacionService service;

	@Override
	protected TipoEvaluacionService getService() {
		return service;
	}

	@GetMapping(value = "/list")
	public ResponseEntity<?> obtenerLista() {
		return super.obtenerListaEntidad();
	}

	@GetMapping(value = "/id/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable(name = "id") Long id) {
		TipoEvaluacion tipoEvaluacion = new TipoEvaluacion();
		tipoEvaluacion.setIdTipoEvaluacion(id);
		return super.obtenerEntidadPorId(tipoEvaluacion);
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody TipoEvaluacion tipoEvaluacion) {
		return super.crearEntidad(tipoEvaluacion);
	}

	@PutMapping
	public ResponseEntity<?> editar(@RequestBody TipoEvaluacion tipoEvaluacion) {
		return super.editarEntidad(tipoEvaluacion);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable(name = "id") Long id) {
		TipoEvaluacion tipoEvaluacion = new TipoEvaluacion();
		tipoEvaluacion.setIdTipoEvaluacion(id);
		return super.eliminarEntidad(service.buscarEntidadPorId(tipoEvaluacion));
	}
}
