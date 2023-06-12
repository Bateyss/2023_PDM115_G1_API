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
import com.ues.sv.proyecto.controladministrativoapi.models.Usuario;
import com.ues.sv.proyecto.controladministrativoapi.repository.UsuarioRepo;
import com.ues.sv.proyecto.controladministrativoapi.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController extends AbstractController<Usuario, Long, UsuarioRepo, UsuarioService> {

	@Autowired
	private UsuarioService service;

	@Override
	protected UsuarioService getService() {
		return service;
	}

	@GetMapping(value = "/list")
	public ResponseEntity<?> obtenerLista() {
		return super.obtenerListaEntidad();
	}

	@GetMapping(value = "/id/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable(name = "id") Long id) {
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(id);
		return super.obtenerEntidadPorId(usuario);
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Usuario usuario) {
		return super.crearEntidad(usuario);
	}

	@PutMapping
	public ResponseEntity<?> editar(@RequestBody Usuario usuario) {
		return super.editarEntidad(usuario);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable(name = "id") Long id) {
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(id);
		return super.eliminarEntidad(service.buscarEntidadPorId(usuario));
	}

	@GetMapping(value = "/login/{user}/{pass}")
	public ResponseEntity<?> obtenerPorId(@PathVariable(name = "user") String user,
			@PathVariable(name = "pass") String pass) {
		Usuario usuarioEncontrado = service.buscarUsuarioPorUserAndPass(user, pass);
		if (usuarioEncontrado != null) {
			return new ResponseEntity<Usuario>(usuarioEncontrado, HttpStatus.OK);
		} else {
			return new ResponseEntity<ErrorResponse>(new ErrorResponse("01", "Usuario o Contraseña invalidos"),
					HttpStatus.NOT_ACCEPTABLE);
		}
	}
}
