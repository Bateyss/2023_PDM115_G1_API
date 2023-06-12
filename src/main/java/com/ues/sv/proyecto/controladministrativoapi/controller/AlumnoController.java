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
import com.ues.sv.proyecto.controladministrativoapi.models.Alumno;
import com.ues.sv.proyecto.controladministrativoapi.repository.AlumnoRepo;
import com.ues.sv.proyecto.controladministrativoapi.service.AlumnoService;

@Controller
@RequestMapping("/alumno")
public class AlumnoController extends AbstractController<Alumno, Long, AlumnoRepo, AlumnoService> {

	@Autowired
	private AlumnoService service;

	@Override
	protected AlumnoService getService() {
		return service;
	}

	@GetMapping(value = "/list")
	public ResponseEntity<?> obtenerLista() {
		return super.obtenerListaEntidad();
	}

	@GetMapping(value = "/id/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable(name = "id") Long id) {
		Alumno alumno = new Alumno();
		alumno.setIdAlumno(id);
		return super.obtenerEntidadPorId(alumno);
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Alumno alumno) {
		return super.crearEntidad(alumno);
	}

	@PutMapping
	public ResponseEntity<?> editar(@RequestBody Alumno alumno) {
		return super.editarEntidad(alumno);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable(name = "id") Long id) {
		Alumno alumno = new Alumno();
		alumno.setIdAlumno(id);
		return super.eliminarEntidad(service.buscarEntidadPorId(alumno));
	}
}
