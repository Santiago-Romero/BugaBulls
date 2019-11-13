/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bugabulls.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Santiago Romero
 */
@Entity
@Table(name = "categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c")
    , @NamedQuery(name = "Categoria.findByCodigocategoria", query = "SELECT c FROM Categoria c WHERE c.codigocategoria = :codigocategoria")
    , @NamedQuery(name = "Categoria.findByNombre", query = "SELECT c FROM Categoria c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Categoria.findByHorario", query = "SELECT c FROM Categoria c WHERE c.horario = :horario")})
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigocategoria")
    private Integer codigocategoria;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "horario")
    @Temporal(TemporalType.TIME)
    private Date horario;
    @OneToMany(mappedBy = "codigocategoria")
    private Collection<SesionCategoria> sesionCategoriaCollection;
    @OneToMany(mappedBy = "codigocategoria")
    private Collection<Jugador> jugadorCollection;
    @JoinColumn(name = "codigoentrenador", referencedColumnName = "codigoentrenador")
    @ManyToOne
    private Entrenador codigoentrenador;

    public Categoria() {
    }

    public Categoria(Integer codigocategoria) {
        this.codigocategoria = codigocategoria;
    }

    public Integer getCodigocategoria() {
        return codigocategoria;
    }

    public void setCodigocategoria(Integer codigocategoria) {
        this.codigocategoria = codigocategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    @XmlTransient
    public Collection<SesionCategoria> getSesionCategoriaCollection() {
        return sesionCategoriaCollection;
    }

    public void setSesionCategoriaCollection(Collection<SesionCategoria> sesionCategoriaCollection) {
        this.sesionCategoriaCollection = sesionCategoriaCollection;
    }

    @XmlTransient
    public Collection<Jugador> getJugadorCollection() {
        return jugadorCollection;
    }

    public void setJugadorCollection(Collection<Jugador> jugadorCollection) {
        this.jugadorCollection = jugadorCollection;
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
        hash += (codigocategoria != null ? codigocategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.codigocategoria == null && other.codigocategoria != null) || (this.codigocategoria != null && !this.codigocategoria.equals(other.codigocategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bugabulls.modelo.Categoria[ codigocategoria=" + codigocategoria + " ]";
    }
    
}
