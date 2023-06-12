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
import com.ues.sv.proyecto.controladministrativoapi.models.Inscripcion;
import com.ues.sv.proyecto.controladministrativoapi.repository.InscripcionRepo;
import com.ues.sv.proyecto.controladministrativoapi.service.InscripcionService;

@Controller
@RequestMapping("/inscripcion")
public class InscripcionController extends AbstractController<Inscripcion, Long, InscripcionRepo, InscripcionService> {

	@Autowired
	private InscripcionService service;

	@Override
	protected InscripcionService getService() {
		return service;
	}

	@GetMapping(value = "/list")
	public ResponseEntity<?> obtenerLista() {
		return super.obtenerListaEntidad();
	}

	@GetMapping(value = "/id/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable(name = "id") Long id) {
		Inscripcion inscripcion = new Inscripcion();
		inscripcion.setIdInscripcion(id);
		return super.obtenerEntidadPorId(inscripcion);
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Inscripcion inscripcion) {
		return super.crearEntidad(inscripcion);
	}

	@PutMapping
	public ResponseEntity<?> editar(@RequestBody Inscripcion inscripcion) {
		return super.editarEntidad(inscripcion);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable(name = "id") Long id) {
		Inscripcion inscripcion = new Inscripcion();
		inscripcion.setIdInscripcion(id);
		return super.eliminarEntidad(service.buscarEntidadPorId(inscripcion));
	}
}
