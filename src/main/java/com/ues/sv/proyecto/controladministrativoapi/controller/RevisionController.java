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
import com.ues.sv.proyecto.controladministrativoapi.models.Revision;
import com.ues.sv.proyecto.controladministrativoapi.repository.RevisionRepo;
import com.ues.sv.proyecto.controladministrativoapi.service.RevisionService;

@Controller
@RequestMapping("/revision")
public class RevisionController extends AbstractController<Revision, Long, RevisionRepo, RevisionService> {

	@Autowired
	private RevisionService service;

	@Override
	protected RevisionService getService() {
		return service;
	}

	@GetMapping(value = "/list")
	public ResponseEntity<?> obtenerLista() {
		return super.obtenerListaEntidad();
	}

	@GetMapping(value = "/id/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable(name = "id") Long id) {
		Revision revision = new Revision();
		revision.setIdRevision(id);
		return super.obtenerEntidadPorId(revision);
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Revision revision) {
		return super.crearEntidad(revision);
	}

	@PutMapping
	public ResponseEntity<?> editar(@RequestBody Revision revision) {
		return super.editarEntidad(revision);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable(name = "id") Long id) {
		Revision revision = new Revision();
		revision.setIdRevision(id);
		return super.eliminarEntidad(service.buscarEntidadPorId(revision));
	}
}
