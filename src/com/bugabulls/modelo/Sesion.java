/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bugabulls.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Santiago Romero
 */
@Entity
@Table(name = "sesion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sesion.findAll", query = "SELECT s FROM Sesion s")
    , @NamedQuery(name = "Sesion.findByNumerosesion", query = "SELECT s FROM Sesion s WHERE s.numerosesion = :numerosesion")
    , @NamedQuery(name = "Sesion.findByNombre", query = "SELECT s FROM Sesion s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "Sesion.findByFecha", query = "SELECT s FROM Sesion s WHERE s.fecha = :fecha")
    , @NamedQuery(name = "Sesion.findByEspecificacion", query = "SELECT s FROM Sesion s WHERE s.especificacion = :especificacion")})
public class Sesion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numerosesion")
    private Integer numerosesion;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "especificacion")
    private String especificacion;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "sesion")
    private SesionCategoria sesionCategoria;
    @JoinColumn(name = "codigoentrenador", referencedColumnName = "codigoentrenador")
    @ManyToOne
    private Entrenador codigoentrenador;

    public Sesion() {
    }

    public Sesion(Integer numerosesion) {
        this.numerosesion = numerosesion;
    }

    public Integer getNumerosesion() {
        return numerosesion;
    }

    public void setNumerosesion(Integer numerosesion) {
        this.numerosesion = numerosesion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEspecificacion() {
        return especificacion;
    }

    public void setEspecificacion(String especificacion) {
        this.especificacion = especificacion;
    }

    public SesionCategoria getSesionCategoria() {
        return sesionCategoria;
    }

    public void setSesionCategoria(SesionCategoria sesionCategoria) {
        this.sesionCategoria = sesionCategoria;
    }

    public Entrenador getCodigoentrenador() {
        return codigoentrenador;
    }

    public void setCodigoentrenador(Entrenador codigoentrenador) {
        this.codigoentrenador = codigoentrenador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numerosesion != null ? numerosesion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sesion)) {
            return false;
        }
        Sesion other = (Sesion) object;
        if ((this.numerosesion == null && other.numerosesion != null) || (this.numerosesion != null && !this.numerosesion.equals(other.numerosesion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bugabulls.modelo.Sesion[ numerosesion=" + numerosesion + " ]";
    }
    
}
