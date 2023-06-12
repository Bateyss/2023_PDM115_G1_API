package com.ues.sv.proyecto.controladministrativoapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "DETALLEREVISION")
public class DetalleRevision {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_DETALLE")
    private Long idDetalle;

	@JoinColumn(name = "ID_REVISION", referencedColumnName = "ID_REVISION")
	@ManyToOne
    private Revision revision;

    @Column(name = "NOTA_ANTERIOR",nullable = false)
    private Double notaAnterior;

    @Column(name = "NOTA_ACTUAL",nullable = false)
    private Double notaActual;

    public DetalleRevision() {
    }

    public DetalleRevision(Long idDetalle, Revision revision, Double notaAnterior, Double notaActual) {
        this.idDetalle = idDetalle;
        this.revision = revision;
        this.notaAnterior = notaAnterior;
        this.notaActual = notaActual;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetalleRevision that = (DetalleRevision) o;

        return idDetalle.equals(that.idDetalle);
    }

    @Override
    public int hashCode() {
        return idDetalle.hashCode();
    }

    public Long getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Long idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Revision getRevision() {
        return revision;
    }

    public void setRevision(Revision revision) {
        this.revision = revision;
    }

    public Double getNotaAnterior() {
        return notaAnterior;
    }

    public void setNotaAnterior(Double notaAnterior) {
        this.notaAnterior = notaAnterior;
    }

    public Double getNotaActual() {
        return notaActual;
    }

    public void setNotaActual(Double notaActual) {
        this.notaActual = notaActual;
    }
}
