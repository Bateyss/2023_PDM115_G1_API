package com.ues.sv.proyecto.controladministrativoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ues.sv.proyecto.controladministrativoapi.models.Usuario;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Long> {

	@Query("SELECT USR FROM Usuario USR WHERE USR.userName = ?1 AND USR.userPass = ?2")
	List<Usuario> findByUserNameAndUserPass(String userName, String userPass);

}
