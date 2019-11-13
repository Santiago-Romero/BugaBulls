/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bugabulls.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Santiago Romero
 */
@Entity
@Table(name = "plantilla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plantilla.findAll", query = "SELECT p FROM Plantilla p")
    , @NamedQuery(name = "Plantilla.findByNumeroplantilla", query = "SELECT p FROM Plantilla p WHERE p.numeroplantilla = :numeroplantilla")
    , @NamedQuery(name = "Plantilla.findByImc", query = "SELECT p FROM Plantilla p WHERE p.imc = :imc")
    , @NamedQuery(name = "Plantilla.findByPosicion", query = "SELECT p FROM Plantilla p WHERE p.posicion = :posicion")
    , @NamedQuery(name = "Plantilla.findByPeso", query = "SELECT p FROM Plantilla p WHERE p.peso = :peso")
    , @NamedQuery(name = "Plantilla.findByObservacion", query = "SELECT p FROM Plantilla p WHERE p.observacion = :observacion")
    , @NamedQuery(name = "Plantilla.findByTiemposuicidio", query = "SELECT p FROM Plantilla p WHERE p.tiemposuicidio = :tiemposuicidio")
    , @NamedQuery(name = "Plantilla.findByPorcentajecestas", query = "SELECT p FROM Plantilla p WHERE p.porcentajecestas = :porcentajecestas")
    , @NamedQuery(name = "Plantilla.findByVueltascancha", query = "SELECT p FROM Plantilla p WHERE p.vueltascancha = :vueltascancha")})
public class Plantilla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numeroplantilla")
    private Integer numeroplantilla;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "imc")
    private Double imc;
    @Column(name = "posicion")
    private String posicion;
    @Column(name = "peso")
    private Double peso;
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "tiemposuicidio")
    private Double tiemposuicidio;
    @Column(name = "porcentajecestas")
    private Double porcentajecestas;
    @Column(name = "vueltascancha")
    private Integer vueltascancha;
    @JoinColumn(name = "codigojugador", referencedColumnName = "codigojugador")
    @ManyToOne
    private Jugador codigojugador;

    public Plantilla() {
    }

    public Plantilla(Integer numeroplantilla) {
        this.numeroplantilla = numeroplantilla;
    }

    public Integer getNumeroplantilla() {
        return numeroplantilla;
    }

    public void setNumeroplantilla(Integer numeroplantilla) {
        this.numeroplantilla = numeroplantilla;
    }

    public Double getImc() {
        return imc;
    }

    public void setImc(Double imc) {
        this.imc = imc;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Double getTiemposuicidio() {
        return tiemposuicidio;
    }

    public void setTiemposuicidio(Double tiemposuicidio) {
        this.tiemposuicidio = tiemposuicidio;
    }

    public Double getPorcentajecestas() {
        return porcentajecestas;
    }

    public void setPorcentajecestas(Double porcentajecestas) {
        this.porcentajecestas = porcentajecestas;
    }

    public Integer getVueltascancha() {
        return vueltascancha;
    }

    public void setVueltascancha(Integer vueltascancha) {
        this.vueltascancha = vueltascancha;
    }

    public Jugador getCodigojugador() {
        return codigojugador;
    }

    public void setCodigojugador(Jugador codigojugador) {
        this.codigojugador = codigojugador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroplantilla != null ? numeroplantilla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plantilla)) {
            return false;
        }
        Plantilla other = (Plantilla) object;
        if ((this.numeroplantilla == null && other.numeroplantilla != null) || (this.numeroplantilla != null && !this.numeroplantilla.equals(other.numeroplantilla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bugabulls.modelo.Plantilla[ numeroplantilla=" + numeroplantilla + " ]";
    }
    
}
