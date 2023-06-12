package com.ues.sv.proyecto.controladministrativoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ues.sv.proyecto.controladministrativoapi.models.Parametros;

@Repository
public interface ParametrosRepo extends JpaRepository<Parametros, Long> {

	List<Parametros> findByIdHistorico(Integer idHistorico);

}
