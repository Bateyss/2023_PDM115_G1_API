package com.ues.sv.proyecto.controladministrativoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ues.sv.proyecto.controladministrativoapi.models.Impresion;

@Repository
public interface ImpresionRepo extends JpaRepository<Impresion, Long> {

	List<Impresion> findByEvaluacionIdEvaluacion(Long idEvaluacion);

}
