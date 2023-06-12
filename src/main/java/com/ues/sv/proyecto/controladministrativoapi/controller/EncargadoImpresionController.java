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
import com.ues.sv.proyecto.controladministrativoapi.models.EncargadoImpresion;
import com.ues.sv.proyecto.controladministrativoapi.repository.EncargadoImpresionRepo;
import com.ues.sv.proyecto.controladministrativoapi.service.EncargadoImpresionService;

@Controller
@RequestMapping("/encargadoimpresion")
public class EncargadoImpresionController
		extends AbstractController<EncargadoImpresion, Long, EncargadoImpresionRepo, EncargadoImpresionService> {

	@Autowired
	private EncargadoImpresionService service;

	@Override
	protected EncargadoImpresionService getService() {
		return service;
	}

	@GetMapping(value = "/list")
	public ResponseEntity<?> obtenerLista() {
		return super.obtenerListaEntidad();
	}

	@GetMapping(value = "/id/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable(name = "id") Long id) {
		EncargadoImpresion encargadoImpresion = new EncargadoImpresion();
		encargadoImpresion.setIdEncargado(id);
		return super.obtenerEntidadPorId(encargadoImpresion);
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody EncargadoImpresion encargadoImpresion) {
		return super.crearEntidad(encargadoImpresion);
	}

	@PutMapping
	public ResponseEntity<?> editar(@RequestBody EncargadoImpresion encargadoImpresion) {
		return super.editarEntidad(encargadoImpresion);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable(name = "id") Long id) {
		EncargadoImpresion encargadoImpresion = new EncargadoImpresion();
		encargadoImpresion.setIdEncargado(id);
		return super.eliminarEntidad(service.buscarEntidadPorId(encargadoImpresion));
	}
}
