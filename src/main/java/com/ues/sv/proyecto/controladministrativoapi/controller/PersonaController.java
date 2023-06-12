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
import com.ues.sv.proyecto.controladministrativoapi.models.Persona;
import com.ues.sv.proyecto.controladministrativoapi.repository.PersonaRepo;
import com.ues.sv.proyecto.controladministrativoapi.service.PersonaService;

@Controller
@RequestMapping("/persona")
public class PersonaController extends AbstractController<Persona, Long, PersonaRepo, PersonaService> {

	@Autowired
	private PersonaService service;

	@Override
	protected PersonaService getService() {
		return service;
	}

	@GetMapping(value = "/list")
	public ResponseEntity<?> obtenerLista() {
		return super.obtenerListaEntidad();
	}

	@GetMapping(value = "/id/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable(name = "id") Long id) {
		Persona persona = new Persona();
		persona.setIdPersona(id);
		return super.obtenerEntidadPorId(persona);
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Persona persona) {
		return super.crearEntidad(persona);
	}

	@PutMapping
	public ResponseEntity<?> editar(@RequestBody Persona persona) {
		return super.editarEntidad(persona);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable(name = "id") Long id) {
		Persona persona = new Persona();
		persona.setIdPersona(id);
		return super.eliminarEntidad(service.buscarEntidadPorId(persona));
	}
}
