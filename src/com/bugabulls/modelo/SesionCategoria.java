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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Santiago Romero
 */
@Entity
@Table(name = "sesion_categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SesionCategoria.findAll", query = "SELECT s FROM SesionCategoria s")
    , @NamedQuery(name = "SesionCategoria.findByNumerosesion", query = "SELECT s FROM SesionCategoria s WHERE s.numerosesion = :numerosesion")})
public class SesionCategoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numerosesion")
    private Integer numerosesion;
    @JoinColumn(name = "codigocategoria", referencedColumnName = "codigocategoria")
    @ManyToOne
    private Categoria codigocategoria;
    @JoinColumn(name = "numerosesion", referencedColumnName = "numerosesion", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Sesion sesion;

    public SesionCategoria() {
    }

    public SesionCategoria(Integer numerosesion) {
        this.numerosesion = numerosesion;
    }

    public Integer getNumerosesion() {
        return numerosesion;
    }

    public void setNumerosesion(Integer numerosesion) {
        this.numerosesion = numerosesion;
    }

    public Categoria getCodigocategoria() {
        return codigocategoria;
    }

    public void setCodigocategoria(Categoria codigocategoria) {
        this.codigocategoria = codigocategoria;
    }

    public Sesion getSesion() {
        return sesion;
    }

    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
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
        if (!(object instanceof SesionCategoria)) {
            return false;
        }
        SesionCategoria other = (SesionCategoria) object;
        if ((this.numerosesion == null && other.numerosesion != null) || (this.numerosesion != null && !this.numerosesion.equals(other.numerosesion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bugabulls.modelo.SesionCategoria[ numerosesion=" + numerosesion + " ]";
    }
    
}
