package com.ues.sv.proyecto.controladministrativoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ues.sv.proyecto.controladministrativoapi.models.Evaluacion;

@Repository
public interface EvaluacionRepo extends JpaRepository<Evaluacion, Long> {

}
