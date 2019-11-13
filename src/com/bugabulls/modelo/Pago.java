/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bugabulls.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Santiago Romero
 */
@Entity
@Table(name = "pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pago.findAll", query = "SELECT p FROM Pago p")
    , @NamedQuery(name = "Pago.findByCodigopago", query = "SELECT p FROM Pago p WHERE p.codigopago = :codigopago")
    , @NamedQuery(name = "Pago.findByFechapago", query = "SELECT p FROM Pago p WHERE p.fechapago = :fechapago")
    , @NamedQuery(name = "Pago.findByValor", query = "SELECT p FROM Pago p WHERE p.valor = :valor")})
public class Pago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigopago")
    private Integer codigopago;
    @Column(name = "fechapago")
    @Temporal(TemporalType.DATE)
    private Date fechapago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @JoinColumn(name = "codigojugador", referencedColumnName = "codigojugador")
    @ManyToOne
    private Jugador codigojugador;

    public Pago() {
    }

    public Pago(Integer codigopago) {
        this.codigopago = codigopago;
    }

    public Integer getCodigopago() {
        return codigopago;
    }

    public void setCodigopago(Integer codigopago) {
        this.codigopago = codigopago;
    }

    public Date getFechapago() {
        return fechapago;
    }

    public void setFechapago(Date fechapago) {
        this.fechapago = fechapago;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
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
        hash += (codigopago != null ? codigopago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pago)) {
            return false;
        }
        Pago other = (Pago) object;
        if ((this.codigopago == null && other.codigopago != null) || (this.codigopago != null && !this.codigopago.equals(other.codigopago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bugabulls.modelo.Pago[ codigopago=" + codigopago + " ]";
    }
    
}
