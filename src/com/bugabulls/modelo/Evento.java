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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "evento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e")
    , @NamedQuery(name = "Evento.findByCodigoevento", query = "SELECT e FROM Evento e WHERE e.codigoevento = :codigoevento")
    , @NamedQuery(name = "Evento.findByNombre", query = "SELECT e FROM Evento e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Evento.findByCiudad", query = "SELECT e FROM Evento e WHERE e.ciudad = :ciudad")
    , @NamedQuery(name = "Evento.findByGastos", query = "SELECT e FROM Evento e WHERE e.gastos = :gastos")
    , @NamedQuery(name = "Evento.findByFechaini", query = "SELECT e FROM Evento e WHERE e.fechaini = :fechaini")
    , @NamedQuery(name = "Evento.findByFechafin", query = "SELECT e FROM Evento e WHERE e.fechafin = :fechafin")
    , @NamedQuery(name = "Evento.findByCantidadjugadores", query = "SELECT e FROM Evento e WHERE e.cantidadjugadores = :cantidadjugadores")})
public class Evento implements Serializable {

    @OneToMany(mappedBy = "codigoevento")
    private Collection<JugadorEvento> jugadorEventoCollection;

    @JoinTable(name = "jugador_evento", joinColumns = {
        @JoinColumn(name = "codigoevento", referencedColumnName = "codigoevento")}, inverseJoinColumns = {
        @JoinColumn(name = "codigojugador", referencedColumnName = "codigojugador")})
    @ManyToMany
    private Collection<Jugador> jugadorCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigoevento")
    private Integer codigoevento;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "ciudad")
    private String ciudad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "gastos")
    private Double gastos;
    @Column(name = "fechaini")
    @Temporal(TemporalType.DATE)
    private Date fechaini;
    @Column(name = "fechafin")
    @Temporal(TemporalType.DATE)
    private Date fechafin;
    @Column(name = "cantidadjugadores")
    private Integer cantidadjugadores;

    public Evento() {
    }

    public Evento(Integer codigoevento) {
        this.codigoevento = codigoevento;
    }

    public Integer getCodigoevento() {
        return codigoevento;
    }

    public void setCodigoevento(Integer codigoevento) {
        this.codigoevento = codigoevento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Double getGastos() {
        return gastos;
    }

    public void setGastos(Double gastos) {
        this.gastos = gastos;
    }

    public Date getFechaini() {
        return fechaini;
    }

    public void setFechaini(Date fechaini) {
        this.fechaini = fechaini;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public Integer getCantidadjugadores() {
        return cantidadjugadores;
    }

    public void setCantidadjugadores(Integer cantidadjugadores) {
        this.cantidadjugadores = cantidadjugadores;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoevento != null ? codigoevento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.codigoevento == null && other.codigoevento != null) || (this.codigoevento != null && !this.codigoevento.equals(other.codigoevento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bugabulls.modelo.Evento[ codigoevento=" + codigoevento + " ]";
    }

    @XmlTransient
    public Collection<Jugador> getJugadorCollection() {
        return jugadorCollection;
    }

    public void setJugadorCollection(Collection<Jugador> jugadorCollection) {
        this.jugadorCollection = jugadorCollection;
    }

    @XmlTransient
    public Collection<JugadorEvento> getJugadorEventoCollection() {
        return jugadorEventoCollection;
    }

    public void setJugadorEventoCollection(Collection<JugadorEvento> jugadorEventoCollection) {
        this.jugadorEventoCollection = jugadorEventoCollection;
    }
    
}
