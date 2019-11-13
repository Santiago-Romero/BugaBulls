/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bugabulls.modelo;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Santiago Romero
 */
@Entity
@Table(name = "administrador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a")
    , @NamedQuery(name = "Administrador.findByCodigoadministrador", query = "SELECT a FROM Administrador a WHERE a.codigoadministrador = :codigoadministrador")
    , @NamedQuery(name = "Administrador.findByNombre", query = "SELECT a FROM Administrador a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Administrador.findByApellido", query = "SELECT a FROM Administrador a WHERE a.apellido = :apellido")
    , @NamedQuery(name = "Administrador.findByContrase\u00f1a", query = "SELECT a FROM Administrador a WHERE a.contrase\u00f1a = :contrase\u00f1a")
    , @NamedQuery(name = "Administrador.findByDniadministrador", query = "SELECT a FROM Administrador a WHERE a.dniadministrador = :dniadministrador")
    , @NamedQuery(name = "Administrador.findByDireccion", query = "SELECT a FROM Administrador a WHERE a.direccion = :direccion")
    , @NamedQuery(name = "Administrador.findByTelefono", query = "SELECT a FROM Administrador a WHERE a.telefono = :telefono")
    , @NamedQuery(name = "Administrador.findByEstadoeliminar", query = "SELECT a FROM Administrador a WHERE a.estadoeliminar = :estadoeliminar")
    , @NamedQuery(name = "Administrador.findByEstadocontra", query = "SELECT a FROM Administrador a WHERE a.estadocontra = :estadocontra")})
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigoadministrador")
    private Integer codigoadministrador;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "contrase\u00f1a")
    private String contraseña;
    @Column(name = "dniadministrador")
    private BigInteger dniadministrador;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private BigInteger telefono;
    @Column(name = "estadoeliminar")
    private Integer estadoeliminar;
    @Column(name = "estadocontra")
    private Integer estadocontra;

    public Administrador() {
    }

    public Administrador(Integer codigoadministrador) {
        this.codigoadministrador = codigoadministrador;
    }

    public Integer getCodigoadministrador() {
        return codigoadministrador;
    }

    public void setCodigoadministrador(Integer codigoadministrador) {
        this.codigoadministrador = codigoadministrador;
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public BigInteger getDniadministrador() {
        return dniadministrador;
    }

    public void setDniadministrador(BigInteger dniadministrador) {
        this.dniadministrador = dniadministrador;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public BigInteger getTelefono() {
        return telefono;
    }

    public void setTelefono(BigInteger telefono) {
        this.telefono = telefono;
    }

    public Integer getEstadoeliminar() {
        return estadoeliminar;
    }

    public void setEstadoeliminar(Integer estadoeliminar) {
        this.estadoeliminar = estadoeliminar;
    }

    public Integer getEstadocontra() {
        return estadocontra;
    }

    public void setEstadocontra(Integer estadocontra) {
        this.estadocontra = estadocontra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoadministrador != null ? codigoadministrador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.codigoadministrador == null && other.codigoadministrador != null) || (this.codigoadministrador != null && !this.codigoadministrador.equals(other.codigoadministrador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bugabulls.modelo.Administrador[ codigoadministrador=" + codigoadministrador + " ]";
    }
    
}
