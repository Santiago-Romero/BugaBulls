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
@Table(name = "entrenador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entrenador.findAll", query = "SELECT e FROM Entrenador e")
    , @NamedQuery(name = "Entrenador.findByCodigoentrenador", query = "SELECT e FROM Entrenador e WHERE e.codigoentrenador = :codigoentrenador")
    , @NamedQuery(name = "Entrenador.findByDnientrenador", query = "SELECT e FROM Entrenador e WHERE e.dnientrenador = :dnientrenador")
    , @NamedQuery(name = "Entrenador.findByNombre", query = "SELECT e FROM Entrenador e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Entrenador.findByApellido", query = "SELECT e FROM Entrenador e WHERE e.apellido = :apellido")
    , @NamedQuery(name = "Entrenador.findByTelefono", query = "SELECT e FROM Entrenador e WHERE e.telefono = :telefono")
    , @NamedQuery(name = "Entrenador.findByDireccion", query = "SELECT e FROM Entrenador e WHERE e.direccion = :direccion")
    , @NamedQuery(name = "Entrenador.findByContrase\u00f1a", query = "SELECT e FROM Entrenador e WHERE e.contrase\u00f1a = :contrase\u00f1a")
    , @NamedQuery(name = "Entrenador.findByEstadoeliminar", query = "SELECT e FROM Entrenador e WHERE e.estadoeliminar = :estadoeliminar")
    , @NamedQuery(name = "Entrenador.findByEstadocontra", query = "SELECT e FROM Entrenador e WHERE e.estadocontra = :estadocontra")})
public class Entrenador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigoentrenador")
    private Integer codigoentrenador;
    @Column(name = "dnientrenador")
    private BigInteger dnientrenador;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "telefono")
    private BigInteger telefono;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "contrase\u00f1a")
    private String contraseña;
    @Column(name = "estadoeliminar")
    private Integer estadoeliminar;
    @Column(name = "estadocontra")
    private Integer estadocontra;
    @OneToMany(mappedBy = "codigoentrenador")
    private Collection<Sesion> sesionCollection;
    @OneToMany(mappedBy = "codigoentrenador")
    private Collection<Categoria> categoriaCollection;

    public Entrenador() {
    }

    public Entrenador(Integer codigoentrenador) {
        this.codigoentrenador = codigoentrenador;
    }

    public Integer getCodigoentrenador() {
        return codigoentrenador;
    }

    public void setCodigoentrenador(Integer codigoentrenador) {
        this.codigoentrenador = codigoentrenador;
    }

    public BigInteger getDnientrenador() {
        return dnientrenador;
    }

    public void setDnientrenador(BigInteger dnientrenador) {
        this.dnientrenador = dnientrenador;
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
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

    @XmlTransient
    public Collection<Sesion> getSesionCollection() {
        return sesionCollection;
    }

    public void setSesionCollection(Collection<Sesion> sesionCollection) {
        this.sesionCollection = sesionCollection;
    }

    @XmlTransient
    public Collection<Categoria> getCategoriaCollection() {
        return categoriaCollection;
    }

    public void setCategoriaCollection(Collection<Categoria> categoriaCollection) {
        this.categoriaCollection = categoriaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoentrenador != null ? codigoentrenador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entrenador)) {
            return false;
        }
        Entrenador other = (Entrenador) object;
        if ((this.codigoentrenador == null && other.codigoentrenador != null) || (this.codigoentrenador != null && !this.codigoentrenador.equals(other.codigoentrenador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bugabulls.modelo.Entrenador[ codigoentrenador=" + codigoentrenador + " ]";
    }
    
}
