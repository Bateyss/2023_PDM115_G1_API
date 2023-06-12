package com.ues.sv.proyecto.controladministrativoapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.ues.sv.proyecto.controladministrativoapi.controller.abs.ErrorResponse;
import com.ues.sv.proyecto.controladministrativoapi.models.SolicitudRevision;
import com.ues.sv.proyecto.controladministrativoapi.repository.SolicitudRevisionRepo;
import com.ues.sv.proyecto.controladministrativoapi.service.SolicitudRevisionService;

@Controller
@RequestMapping("/solicitudrevision")
public class SolicitudRevisionController
		extends AbstractController<SolicitudRevision, Long, SolicitudRevisionRepo, SolicitudRevisionService> {

	@Autowired
	private SolicitudRevisionService service;

	@Override
	protected SolicitudRevisionService getService() {
		return service;
	}

	@GetMapping(value = "/list")
	public ResponseEntity<?> obtenerLista() {
		return super.obtenerListaEntidad();
	}

	@GetMapping(value = "/id/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable(name = "id") Long id) {
		SolicitudRevision solicitudRevision = new SolicitudRevision();
		solicitudRevision.setIdSolicitudRevision(id);
		return super.obtenerEntidadPorId(solicitudRevision);
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody SolicitudRevision solicitudRevision) {
		return super.crearEntidad(solicitudRevision);
	}

	@PutMapping
	public ResponseEntity<?> editar(@RequestBody SolicitudRevision solicitudRevision) {
		return super.editarEntidad(solicitudRevision);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable(name = "id") Long id) {
		SolicitudRevision solicitudRevision = new SolicitudRevision();
		solicitudRevision.setIdSolicitudRevision(id);
		return super.eliminarEntidad(service.buscarEntidadPorId(solicitudRevision));
	}

	@GetMapping(value = "/list/evaluacion/{id}")
	public ResponseEntity<?> obtenerListaPorIdEvaluacion(@PathVariable(name = "id") Long id) {
		List<SolicitudRevision> solicitudes = service.obtenerListaEntidadPorIdEvaluacion(id);
		if (!solicitudes.isEmpty()) {
			return new ResponseEntity<List<SolicitudRevision>>(solicitudes, HttpStatus.OK);
		} else {
			return new ResponseEntity<ErrorResponse>(new ErrorResponse("01", "No se encontraron datos"),
					HttpStatus.NOT_ACCEPTABLE);
		}
	}
}
