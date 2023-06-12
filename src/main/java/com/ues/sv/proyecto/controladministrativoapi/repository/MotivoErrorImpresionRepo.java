package com.ues.sv.proyecto.controladministrativoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ues.sv.proyecto.controladministrativoapi.models.Impresion;
import com.ues.sv.proyecto.controladministrativoapi.models.MotivoErrorImpresion;

@Repository
public interface MotivoErrorImpresionRepo extends JpaRepository<MotivoErrorImpresion, Long> {

	List<MotivoErrorImpresion> findByImpresion(Impresion impresion);

}
