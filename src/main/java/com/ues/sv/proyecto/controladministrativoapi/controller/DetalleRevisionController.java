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
import com.ues.sv.proyecto.controladministrativoapi.models.DetalleRevision;
import com.ues.sv.proyecto.controladministrativoapi.repository.DetalleRevisionRepo;
import com.ues.sv.proyecto.controladministrativoapi.service.DetalleRevisionService;

@Controller
@RequestMapping("/detallerevision")
public class DetalleRevisionController
		extends AbstractController<DetalleRevision, Long, DetalleRevisionRepo, DetalleRevisionService> {

	@Autowired
	private DetalleRevisionService service;

	@Override
	protected DetalleRevisionService getService() {
		return service;
	}

	@GetMapping(value = "/list")
	public ResponseEntity<?> obtenerLista() {
		return super.obtenerListaEntidad();
	}

	@GetMapping(value = "/id/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable(name = "id") Long id) {
		DetalleRevision detalleRevision = new DetalleRevision();
		detalleRevision.setIdDetalle(id);
		return super.obtenerEntidadPorId(detalleRevision);
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody DetalleRevision detalleRevision) {
		return super.crearEntidad(detalleRevision);
	}

	@PutMapping
	public ResponseEntity<?> editar(@RequestBody DetalleRevision detalleRevision) {
		return super.editarEntidad(detalleRevision);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable(name = "id") Long id) {
		DetalleRevision detalleRevision = new DetalleRevision();
		detalleRevision.setIdDetalle(id);
		return super.eliminarEntidad(service.buscarEntidadPorId(detalleRevision));
	}
}
