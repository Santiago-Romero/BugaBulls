/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bugabulls.modelo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Santiago Romero
 */
@Entity
@Table(name = "acudiente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acudiente.findAll", query = "SELECT a FROM Acudiente a")
    , @NamedQuery(name = "Acudiente.findByCodigoacudiente", query = "SELECT a FROM Acudiente a WHERE a.codigoacudiente = :codigoacudiente")
    , @NamedQuery(name = "Acudiente.findByDniacudiente", query = "SELECT a FROM Acudiente a WHERE a.dniacudiente = :dniacudiente")
    , @NamedQuery(name = "Acudiente.findByNombre", query = "SELECT a FROM Acudiente a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Acudiente.findByApellido", query = "SELECT a FROM Acudiente a WHERE a.apellido = :apellido")
    , @NamedQuery(name = "Acudiente.findByParentesco", query = "SELECT a FROM Acudiente a WHERE a.parentesco = :parentesco")
    , @NamedQuery(name = "Acudiente.findByTelefono", query = "SELECT a FROM Acudiente a WHERE a.telefono = :telefono")
    , @NamedQuery(name = "Acudiente.findByDireccion", query = "SELECT a FROM Acudiente a WHERE a.direccion = :direccion")})
public class Acudiente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigoacudiente")
    private Integer codigoacudiente;
    @Basic(optional = false)
    @Column(name = "dniacudiente")
    private long dniacudiente;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "parentesco")
    private String parentesco;
    @Column(name = "telefono")
    private BigInteger telefono;
    @Column(name = "direccion")
    private String direccion;
    @OneToMany(mappedBy = "codigoacudiente")
    private Collection<Jugador> jugadorCollection;

    public Acudiente() {
    }

    public Acudiente(Integer codigoacudiente) {
        this.codigoacudiente = codigoacudiente;
    }

    public Acudiente(Integer codigoacudiente, long dniacudiente) {
        this.codigoacudiente = codigoacudiente;
        this.dniacudiente = dniacudiente;
    }

    public Integer getCodigoacudiente() {
        return codigoacudiente;
    }

    public void setCodigoacudiente(Integer codigoacudiente) {
        this.codigoacudiente = codigoacudiente;
    }

    public long getDniacudiente() {
        return dniacudiente;
    }

    public void setDniacudiente(long dniacudiente) {
        this.dniacudiente = dniacudiente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public BigInteger getTelefono() {
        return telefono;
    }

    public void setTelefono(BigInteger telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @XmlTransient
    public Collection<Jugador> getJugadorCollection() {
        return jugadorCollection;
    }

    public void setJugadorCollection(Collection<Jugador> jugadorCollection) {
        this.jugadorCollection = jugadorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoacudiente != null ? codigoacudiente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acudiente)) {
            return false;
        }
        Acudiente other = (Acudiente) object;
        if ((this.codigoacudiente == null && other.codigoacudiente != null) || (this.codigoacudiente != null && !this.codigoacudiente.equals(other.codigoacudiente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bugabulls.modelo.Acudiente[ codigoacudiente=" + codigoacudiente + " ]";
    }
    
}
