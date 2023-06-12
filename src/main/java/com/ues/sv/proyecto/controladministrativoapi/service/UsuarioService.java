package com.ues.sv.proyecto.controladministrativoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ues.sv.proyecto.controladministrativoapi.models.Usuario;
import com.ues.sv.proyecto.controladministrativoapi.repository.UsuarioRepo;

@Service
public class UsuarioService extends AbstractService<Usuario, Long, UsuarioRepo> {

	@Autowired
	private UsuarioRepo usuarioRepo;

	@Override
	protected UsuarioRepo getRepo() {
		return usuarioRepo;
	}

	@Override
	protected Long getEntityId(Usuario entity) {
		return entity.getIdUsuario();
	}

	public Usuario buscarUsuarioPorUserAndPass(String user, String pass) {
		List<Usuario> lista = usuarioRepo.findByUserNameAndUserPass(user, pass);
		return lista.isEmpty() ? null : lista.get(0);
	}

}
