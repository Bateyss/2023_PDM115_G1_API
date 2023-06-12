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
import com.ues.sv.proyecto.controladministrativoapi.models.Evaluacion;
import com.ues.sv.proyecto.controladministrativoapi.repository.EvaluacionRepo;
import com.ues.sv.proyecto.controladministrativoapi.service.EvaluacionService;

@Controller
@RequestMapping("/evaluacion")
public class EvaluacionController extends AbstractController<Evaluacion, Long, EvaluacionRepo, EvaluacionService> {

	@Autowired
	private EvaluacionService service;

	@Override
	protected EvaluacionService getService() {
		return service;
	}

	@GetMapping(value = "/list")
	public ResponseEntity<?> obtenerLista() {
		return super.obtenerListaEntidad();
	}

	@GetMapping(value = "/id/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable(name = "id") Long id) {
		Evaluacion evaluacion = new Evaluacion();
		evaluacion.setIdEvaluacion(id);
		return super.obtenerEntidadPorId(evaluacion);
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Evaluacion evaluacion) {
		return super.crearEntidad(evaluacion);
	}

	@PutMapping
	public ResponseEntity<?> editar(@RequestBody Evaluacion evaluacion) {
		return super.editarEntidad(evaluacion);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable(name = "id") Long id) {
		Evaluacion evaluacion = new Evaluacion();
		evaluacion.setIdEvaluacion(id);
		return super.eliminarEntidad(service.buscarEntidadPorId(evaluacion));
	}
}
