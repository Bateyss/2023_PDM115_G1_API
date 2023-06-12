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
import com.ues.sv.proyecto.controladministrativoapi.models.Parametros;
import com.ues.sv.proyecto.controladministrativoapi.repository.ParametrosRepo;
import com.ues.sv.proyecto.controladministrativoapi.service.ParametroService;

@Controller
@RequestMapping("/parametros")
public class ParametroController extends AbstractController<Parametros, Long, ParametrosRepo, ParametroService> {

	@Autowired
	private ParametroService service;

	@Override
	protected ParametroService getService() {
		return service;
	}

	@GetMapping(value = "/list")
	public ResponseEntity<?> obtenerLista() {
		return super.obtenerListaEntidad();
	}

	@GetMapping(value = "/id/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable(name = "id") Long id) {
		Parametros parametros = new Parametros();
		parametros.setIdParametro(id);
		return super.obtenerEntidadPorId(parametros);
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Parametros parametros) {
		return super.crearEntidad(parametros);
	}

	@PutMapping
	public ResponseEntity<?> editar(@RequestBody Parametros parametros) {
		return super.editarEntidad(parametros);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable(name = "id") Long id) {
		Parametros parametros = new Parametros();
		parametros.setIdParametro(id);
		return super.eliminarEntidad(service.buscarEntidadPorId(parametros));
	}

	@GetMapping(value = "/historico/{idHistorico}")
	public ResponseEntity<?> obtenerPorIdHist(@PathVariable(name = "idHistorico") Integer idHistorico) {
		Parametros parametros = service.buscarEntidadPorIdHist(idHistorico);
		if (parametros != null) {
			return new ResponseEntity<Parametros>(parametros, HttpStatus.OK);
		} else {
			return new ResponseEntity<ErrorResponse>(new ErrorResponse("01", "No se encontro el registro"),
					HttpStatus.NOT_ACCEPTABLE);
		}
	}
}
