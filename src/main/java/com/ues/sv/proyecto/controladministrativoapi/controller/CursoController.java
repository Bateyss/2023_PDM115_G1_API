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
import com.ues.sv.proyecto.controladministrativoapi.models.Curso;
import com.ues.sv.proyecto.controladministrativoapi.repository.CursoRepo;
import com.ues.sv.proyecto.controladministrativoapi.service.CursoService;

@Controller
@RequestMapping("/curso")
public class CursoController extends AbstractController<Curso, Long, CursoRepo, CursoService> {

	@Autowired
	private CursoService service;

	@Override
	protected CursoService getService() {
		return service;
	}

	@GetMapping(value = "/list")
	public ResponseEntity<?> obtenerLista() {
		return super.obtenerListaEntidad();
	}

	@GetMapping(value = "/id/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable(name = "id") Long id) {
		Curso curso = new Curso();
		curso.setIdCurso(id);
		return super.obtenerEntidadPorId(curso);
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Curso curso) {
		return super.crearEntidad(curso);
	}

	@PutMapping
	public ResponseEntity<?> editar(@RequestBody Curso curso) {
		return super.editarEntidad(curso);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable(name = "id") Long id) {
		Curso curso = new Curso();
		curso.setIdCurso(id);
		return super.eliminarEntidad(service.buscarEntidadPorId(curso));
	}
}
