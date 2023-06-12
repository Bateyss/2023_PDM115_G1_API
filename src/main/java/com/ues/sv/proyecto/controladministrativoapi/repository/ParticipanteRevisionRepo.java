package com.ues.sv.proyecto.controladministrativoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ues.sv.proyecto.controladministrativoapi.models.ParticipanteRevision;

@Repository
public interface ParticipanteRevisionRepo extends JpaRepository<ParticipanteRevision, Long> {

}
