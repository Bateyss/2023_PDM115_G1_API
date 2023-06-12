package com.ues.sv.proyecto.controladministrativoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ues.sv.proyecto.controladministrativoapi.models.SolicitudRevision;

@Repository
public interface SolicitudRevisionRepo extends JpaRepository<SolicitudRevision, Long> {

	List<SolicitudRevision> findByEvaluacionIdEvaluacion(Long idEvaluacion);
}
