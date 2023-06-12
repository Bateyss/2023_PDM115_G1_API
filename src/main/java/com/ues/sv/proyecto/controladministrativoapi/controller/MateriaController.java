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
import com.ues.sv.proyecto.controladministrativoapi.models.Materia;
import com.ues.sv.proyecto.controladministrativoapi.repository.MateriaRepo;
import com.ues.sv.proyecto.controladministrativoapi.service.MateriaService;

@Controller
@RequestMapping("/materia")
public class MateriaController extends AbstractController<Materia, Long, MateriaRepo, MateriaService> {

	@Autowired
	private MateriaService service;

	@Override
	protected MateriaService getService() {
		return service;
	}

	@GetMapping(value = "/list")
	public ResponseEntity<?> obtenerLista() {
		return super.obtenerListaEntidad();
	}

	@GetMapping(value = "/id/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable(name = "id") Long id) {
		Materia materia = new Materia();
		materia.setIdMateria(id);
		return super.obtenerEntidadPorId(materia);
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Materia materia) {
		return super.crearEntidad(materia);
	}

	@PutMapping
	public ResponseEntity<?> editar(@RequestBody Materia materia) {
		return super.editarEntidad(materia);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable(name = "id") Long id) {
		Materia materia = new Materia();
		materia.setIdMateria(id);
		return super.eliminarEntidad(service.buscarEntidadPorId(materia));
	}
}
