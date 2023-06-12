package com.ues.sv.proyecto.controladministrativoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.ues.sv.proyecto.controladministrativoapi.controller.abs.ErrorResponse;
import com.ues.sv.proyecto.controladministrativoapi.models.Impresion;
import com.ues.sv.proyecto.controladministrativoapi.repository.ImpresionRepo;
import com.ues.sv.proyecto.controladministrativoapi.service.ImpresionService;

@Controller
@RequestMapping("/impresion")
public class ImpresionController extends AbstractController<Impresion, Long, ImpresionRepo, ImpresionService> {

	@Autowired
	private ImpresionService service;

	@Override
	protected ImpresionService getService() {
		return service;
	}

	@GetMapping(value = "/list")
	public ResponseEntity<?> obtenerLista() {
		return super.obtenerListaEntidad();
	}

	@GetMapping(value = "/id/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable(name = "id") Long id) {
		Impresion impresion = new Impresion();
		impresion.setIdImpresion(id);
		return super.obtenerEntidadPorId(impresion);
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Impresion impresion) {
		return super.crearEntidad(impresion);
	}

	@PutMapping
	public ResponseEntity<?> editar(@RequestBody Impresion impresion) {
		return super.editarEntidad(impresion);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable(name = "id") Long id) {
		Impresion impresion = new Impresion();
		impresion.setIdImpresion(id);
		return super.eliminarEntidad(service.buscarEntidadPorId(impresion));
	}

	@GetMapping(value = "/evaluacion/{idEvaluacion}")
	public ResponseEntity<?> obtenerPorIdEvaluacion(@PathVariable(name = "idEvaluacion") Long idEvaluacion) {
		Impresion impresion = service.buscarImpresionPorIdEvaluacion(idEvaluacion);
		if (impresion != null) {
			return new ResponseEntity<Impresion>(impresion, HttpStatus.OK);
		} else {
			return new ResponseEntity<ErrorResponse>(new ErrorResponse("01", "No se encontro el registro"),
					HttpStatus.NOT_ACCEPTABLE);
		}
	}
}
