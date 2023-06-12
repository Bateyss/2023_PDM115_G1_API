package com.ues.sv.proyecto.controladministrativoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ues.sv.proyecto.controladministrativoapi.models.Inscripcion;

@Repository
public interface InscripcionRepo extends JpaRepository<Inscripcion, Long> {

}
