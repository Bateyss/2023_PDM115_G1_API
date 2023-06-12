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
import com.ues.sv.proyecto.controladministrativoapi.models.Coordinador;
import com.ues.sv.proyecto.controladministrativoapi.repository.CoordinadorRepo;
import com.ues.sv.proyecto.controladministrativoapi.service.CoordinadorService;

@Controller
@RequestMapping("/coordinador")
public class CoordinadorController extends AbstractController<Coordinador, Long, CoordinadorRepo, CoordinadorService> {

	@Autowired
	private CoordinadorService service;

	@Override
	protected CoordinadorService getService() {
		return service;
	}

	@GetMapping(value = "/list")
	public ResponseEntity<?> obtenerLista() {
		return super.obtenerListaEntidad();
	}

	@GetMapping(value = "/id/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable(name = "id") Long id) {
		Coordinador coordinador = new Coordinador();
		coordinador.setIdCoordinador(id);
		return super.obtenerEntidadPorId(coordinador);
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Coordinador coordinador) {
		return super.crearEntidad(coordinador);
	}

	@PutMapping
	public ResponseEntity<?> editar(@RequestBody Coordinador coordinador) {
		return super.editarEntidad(coordinador);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable(name = "id") Long id) {
		Coordinador coordinador = new Coordinador();
		coordinador.setIdCoordinador(id);
		return super.eliminarEntidad(service.buscarEntidadPorId(coordinador));
	}
}
