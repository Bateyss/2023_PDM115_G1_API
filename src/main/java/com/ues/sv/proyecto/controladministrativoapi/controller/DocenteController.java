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
import com.ues.sv.proyecto.controladministrativoapi.models.Docente;
import com.ues.sv.proyecto.controladministrativoapi.repository.DocenteRepo;
import com.ues.sv.proyecto.controladministrativoapi.service.DocenteService;

@Controller
@RequestMapping("/docente")
public class DocenteController extends AbstractController<Docente, Long, DocenteRepo, DocenteService> {

	@Autowired
	private DocenteService service;

	@Override
	protected DocenteService getService() {
		return service;
	}

	@GetMapping(value = "/list")
	public ResponseEntity<?> obtenerLista() {
		return super.obtenerListaEntidad();
	}

	@GetMapping(value = "/id/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable(name = "id") Long id) {
		Docente docente = new Docente();
		docente.setIdDocente(id);
		return super.obtenerEntidadPorId(docente);
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Docente docente) {
		return super.crearEntidad(docente);
	}

	@PutMapping
	public ResponseEntity<?> editar(@RequestBody Docente docente) {
		return super.editarEntidad(docente);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable(name = "id") Long id) {
		Docente docente = new Docente();
		docente.setIdDocente(id);
		return super.eliminarEntidad(service.buscarEntidadPorId(docente));
	}
}
