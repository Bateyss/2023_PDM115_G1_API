package com.ues.sv.proyecto.controladministrativoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ues.sv.proyecto.controladministrativoapi.models.DetalleRevision;

@Repository
public interface DetalleRevisionRepo extends JpaRepository<DetalleRevision, Long> {

}
