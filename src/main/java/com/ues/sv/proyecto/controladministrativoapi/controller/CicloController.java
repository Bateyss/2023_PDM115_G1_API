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
import com.ues.sv.proyecto.controladministrativoapi.models.Ciclo;
import com.ues.sv.proyecto.controladministrativoapi.repository.CicloRepo;
import com.ues.sv.proyecto.controladministrativoapi.service.CicloService;

@Controller
@RequestMapping("/ciclo")
public class CicloController extends AbstractController<Ciclo, Long, CicloRepo, CicloService> {

	@Autowired
	private CicloService service;

	@Override
	protected CicloService getService() {
		return service;
	}

	@GetMapping(value = "/list")
	public ResponseEntity<?> obtenerLista() {
		return super.obtenerListaEntidad();
	}

	@GetMapping(value = "/id/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable(name = "id") Long id) {
		Ciclo ciclo = new Ciclo();
		ciclo.setIdCiclo(id);
		return super.obtenerEntidadPorId(ciclo);
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Ciclo ciclo) {
		return super.crearEntidad(ciclo);
	}

	@PutMapping
	public ResponseEntity<?> editar(@RequestBody Ciclo ciclo) {
		return super.editarEntidad(ciclo);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable(name = "id") Long id) {
		Ciclo ciclo = new Ciclo();
		ciclo.setIdCiclo(id);
		return super.eliminarEntidad(service.buscarEntidadPorId(ciclo));
	}
}
