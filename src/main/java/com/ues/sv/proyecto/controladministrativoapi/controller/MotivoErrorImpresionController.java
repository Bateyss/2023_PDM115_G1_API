package com.ues.sv.proyecto.controladministrativoapi.controller;

import java.util.List;

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
import com.ues.sv.proyecto.controladministrativoapi.models.MotivoErrorImpresion;
import com.ues.sv.proyecto.controladministrativoapi.repository.MotivoErrorImpresionRepo;
import com.ues.sv.proyecto.controladministrativoapi.service.MotivoErrorImpresionService;

@Controller
@RequestMapping("/motivoerrorimpresion")
public class MotivoErrorImpresionController
		extends AbstractController<MotivoErrorImpresion, Long, MotivoErrorImpresionRepo, MotivoErrorImpresionService> {

	@Autowired
	private MotivoErrorImpresionService service;

	@Override
	protected MotivoErrorImpresionService getService() {
		return service;
	}

	@GetMapping(value = "/list")
	public ResponseEntity<?> obtenerLista() {
		return super.obtenerListaEntidad();
	}

	@GetMapping(value = "/id/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable(name = "id") Long id) {
		MotivoErrorImpresion motivoErrorImpresion = new MotivoErrorImpresion();
		motivoErrorImpresion.setIdMotivo(id);
		return super.obtenerEntidadPorId(motivoErrorImpresion);
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody MotivoErrorImpresion motivoErrorImpresion) {
		return super.crearEntidad(motivoErrorImpresion);
	}

	@PutMapping
	public ResponseEntity<?> editar(@RequestBody MotivoErrorImpresion motivoErrorImpresion) {
		return super.editarEntidad(motivoErrorImpresion);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable(name = "id") Long id) {
		MotivoErrorImpresion motivoErrorImpresion = new MotivoErrorImpresion();
		motivoErrorImpresion.setIdMotivo(id);
		return super.eliminarEntidad(service.buscarEntidadPorId(motivoErrorImpresion));
	}

	@GetMapping(value = "/list/impresion")
	public ResponseEntity<?> obtenerListaPorImpresion(@RequestBody Impresion impresion) {
		List<MotivoErrorImpresion> motivos = service.obtenerListaPorImpresion(impresion);
		if (!motivos.isEmpty()) {
			return new ResponseEntity<List<MotivoErrorImpresion>>(motivos, HttpStatus.OK);
		} else {
			return new ResponseEntity<ErrorResponse>(new ErrorResponse("01", "No se encontraron datos"),
					HttpStatus.NOT_ACCEPTABLE);
		}
	}
}
