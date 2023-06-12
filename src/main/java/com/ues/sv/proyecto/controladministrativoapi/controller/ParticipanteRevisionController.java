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
import com.ues.sv.proyecto.controladministrativoapi.models.ParticipanteRevision;
import com.ues.sv.proyecto.controladministrativoapi.repository.ParticipanteRevisionRepo;
import com.ues.sv.proyecto.controladministrativoapi.service.ParticipanteRevisionService;

@Controller
@RequestMapping("/participanterevision")
public class ParticipanteRevisionController
		extends AbstractController<ParticipanteRevision, Long, ParticipanteRevisionRepo, ParticipanteRevisionService> {

	@Autowired
	private ParticipanteRevisionService service;

	@Override
	protected ParticipanteRevisionService getService() {
		return service;
	}

	@GetMapping(value = "/list")
	public ResponseEntity<?> obtenerLista() {
		return super.obtenerListaEntidad();
	}

	@GetMapping(value = "/id/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable(name = "id") Long id) {
		ParticipanteRevision participanteRevision = new ParticipanteRevision();
		participanteRevision.setIdParticipante(id);
		return super.obtenerEntidadPorId(participanteRevision);
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody ParticipanteRevision participanteRevision) {
		return super.crearEntidad(participanteRevision);
	}

	@PutMapping
	public ResponseEntity<?> editar(@RequestBody ParticipanteRevision participanteRevision) {
		return super.editarEntidad(participanteRevision);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable(name = "id") Long id) {
		ParticipanteRevision participanteRevision = new ParticipanteRevision();
		participanteRevision.setIdParticipante(id);
		return super.eliminarEntidad(service.buscarEntidadPorId(participanteRevision));
	}
}
