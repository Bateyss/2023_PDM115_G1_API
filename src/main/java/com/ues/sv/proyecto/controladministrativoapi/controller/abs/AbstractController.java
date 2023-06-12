package com.ues.sv.proyecto.controladministrativoapi.controller.abs;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ues.sv.proyecto.controladministrativoapi.service.AbstractService;

public abstract class AbstractController<ENTITY, ID, REPO extends JpaRepository<ENTITY, ID>, SERVICE extends AbstractService<ENTITY, ID, REPO>> {

	protected abstract SERVICE getService();

	protected ResponseEntity<?> obtenerListaEntidad() {
		List<ENTITY> entities = getService().obtenerListaEntidad();
		if (!entities.isEmpty()) {
			return new ResponseEntity<List<ENTITY>>(entities, HttpStatus.OK);
		} else {
			return new ResponseEntity<ErrorResponse>(new ErrorResponse("01", "No se encontraron datos"),
					HttpStatus.NOT_ACCEPTABLE);
		}
	}

	protected ResponseEntity<?> obtenerEntidadPorId(ENTITY entity) {
		entity = getService().buscarEntidadPorId(entity);
		if (entity != null) {
			return new ResponseEntity<ENTITY>(entity, HttpStatus.OK);
		} else {
			return new ResponseEntity<ErrorResponse>(new ErrorResponse("01", "No se encontro el registro"),
					HttpStatus.NOT_ACCEPTABLE);
		}
	}

	protected ResponseEntity<?> crearEntidad(ENTITY entity) {
		try {
			entity = getService().crearEntidad(entity);
			if (entity != null) {
				return new ResponseEntity<ENTITY>(entity, HttpStatus.OK);
			} else {
				return new ResponseEntity<ErrorResponse>(new ErrorResponse("01", "No se puede guardar el registro"),
						HttpStatus.NOT_ACCEPTABLE);
			}
		} catch (Exception e) {
			return new ResponseEntity<ErrorResponse>(
					new ErrorResponse("01", "Error al guardar el registro", e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	protected ResponseEntity<?> editarEntidad(ENTITY entity) {
		try {
			entity = getService().editarEntidad(entity);
			if (entity != null) {
				return new ResponseEntity<ENTITY>(entity, HttpStatus.OK);
			} else {
				return new ResponseEntity<ErrorResponse>(new ErrorResponse("01", "No se puede editar el registro"),
						HttpStatus.NOT_ACCEPTABLE);
			}
		} catch (Exception e) {
			return new ResponseEntity<ErrorResponse>(
					new ErrorResponse("01", "Error al editar el registro", e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	protected ResponseEntity<?> eliminarEntidad(ENTITY entity) {
		try {
			getService().eliminarEntidad(entity);
			if (entity != null) {
				return new ResponseEntity<String>("registro eliminado", HttpStatus.OK);
			} else {
				return new ResponseEntity<ErrorResponse>(new ErrorResponse("01", "No se puede eliminar el registro"),
						HttpStatus.NOT_ACCEPTABLE);
			}
		} catch (Exception e) {
			return new ResponseEntity<ErrorResponse>(
					new ErrorResponse("01", "Error al eliminar el registro", e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
