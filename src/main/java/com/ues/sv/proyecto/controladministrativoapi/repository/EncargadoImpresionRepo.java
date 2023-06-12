package com.ues.sv.proyecto.controladministrativoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ues.sv.proyecto.controladministrativoapi.models.EncargadoImpresion;

@Repository
public interface EncargadoImpresionRepo extends JpaRepository<EncargadoImpresion, Long> {

}
