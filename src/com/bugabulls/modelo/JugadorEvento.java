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
@Table(name = "jugador_evento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JugadorEvento.findAll", query = "SELECT j FROM JugadorEvento j")
    , @NamedQuery(name = "JugadorEvento.findByCodigojugador", query = "SELECT j FROM JugadorEvento j WHERE j.codigojugador = :codigojugador")})
public class JugadorEvento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigojugador")
    private Integer codigojugador;
    @JoinColumn(name = "codigoevento", referencedColumnName = "codigoevento")
    @ManyToOne
    private Evento codigoevento;
    @JoinColumn(name = "codigojugador", referencedColumnName = "codigojugador", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Jugador jugador;

    public JugadorEvento() {
    }

    public JugadorEvento(Integer codigojugador) {
        this.codigojugador = codigojugador;
    }

    public Integer getCodigojugador() {
        return codigojugador;
    }

    public void setCodigojugador(Integer codigojugador) {
        this.codigojugador = codigojugador;
    }

    public Evento getCodigoevento() {
        return codigoevento;
    }

    public void setCodigoevento(Evento codigoevento) {
        this.codigoevento = codigoevento;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigojugador != null ? codigojugador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JugadorEvento)) {
            return false;
        }
        JugadorEvento other = (JugadorEvento) object;
        if ((this.codigojugador == null && other.codigojugador != null) || (this.codigojugador != null && !this.codigojugador.equals(other.codigojugador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bugabulls.modelo.JugadorEvento[ codigojugador=" + codigojugador + " ]";
    }
    
}
