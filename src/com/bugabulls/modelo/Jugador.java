/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bugabulls.modelo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "jugador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jugador.findAll", query = "SELECT j FROM Jugador j")
    , @NamedQuery(name = "Jugador.findByCodigojugador", query = "SELECT j FROM Jugador j WHERE j.codigojugador = :codigojugador")
    , @NamedQuery(name = "Jugador.findByNombre", query = "SELECT j FROM Jugador j WHERE j.nombre = :nombre")
    , @NamedQuery(name = "Jugador.findByApellido", query = "SELECT j FROM Jugador j WHERE j.apellido = :apellido")
    , @NamedQuery(name = "Jugador.findByDireccion", query = "SELECT j FROM Jugador j WHERE j.direccion = :direccion")
    , @NamedQuery(name = "Jugador.findByEps", query = "SELECT j FROM Jugador j WHERE j.eps = :eps")
    , @NamedQuery(name = "Jugador.findByFechanacimiento", query = "SELECT j FROM Jugador j WHERE j.fechanacimiento = :fechanacimiento")
    , @NamedQuery(name = "Jugador.findByTelefono", query = "SELECT j FROM Jugador j WHERE j.telefono = :telefono")
    , @NamedQuery(name = "Jugador.findByAltura", query = "SELECT j FROM Jugador j WHERE j.altura = :altura")
    , @NamedQuery(name = "Jugador.findByContrase\u00f1a", query = "SELECT j FROM Jugador j WHERE j.contrase\u00f1a = :contrase\u00f1a")
    , @NamedQuery(name = "Jugador.findByDnijugador", query = "SELECT j FROM Jugador j WHERE j.dnijugador = :dnijugador")
    , @NamedQuery(name = "Jugador.findByFechacobro", query = "SELECT j FROM Jugador j WHERE j.fechacobro = :fechacobro")
    , @NamedQuery(name = "Jugador.findByEstadoeliminar", query = "SELECT j FROM Jugador j WHERE j.estadoeliminar = :estadoeliminar")
    , @NamedQuery(name = "Jugador.findByEstadocontra", query = "SELECT j FROM Jugador j WHERE j.estadocontra = :estadocontra")})
public class Jugador implements Serializable {

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "jugador")
    private JugadorEvento jugadorEvento;

    @ManyToMany(mappedBy = "jugadorCollection")
    private Collection<Evento> eventoCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigojugador")
    private Integer codigojugador;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "eps")
    private String eps;
    @Column(name = "fechanacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento;
    @Column(name = "telefono")
    private BigInteger telefono;
    @Column(name = "altura")
    private Integer altura;
    @Column(name = "contrase\u00f1a")
    private String contraseña;
    @Column(name = "dnijugador")
    private BigInteger dnijugador;
    @Column(name = "fechacobro")
    @Temporal(TemporalType.DATE)
    private Date fechacobro;
    @Column(name = "estadoeliminar")
    private Integer estadoeliminar;
    @Column(name = "estadocontra")
    private Integer estadocontra;
    @JoinColumn(name = "codigoacudiente", referencedColumnName = "codigoacudiente")
    @ManyToOne
    private Acudiente codigoacudiente;
    @JoinColumn(name = "codigocategoria", referencedColumnName = "codigocategoria")
    @ManyToOne
    private Categoria codigocategoria;
    @OneToMany(mappedBy = "codigojugador")
    private Collection<Plantilla> plantillaCollection;
    @OneToMany(mappedBy = "codigojugador")
    private Collection<Pago> pagoCollection;

    public Jugador() {
    }

    public Jugador(Integer codigojugador) {
        this.codigojugador = codigojugador;
    }

    public Integer getCodigojugador() {
        return codigojugador;
    }

    public void setCodigojugador(Integer codigojugador) {
        this.codigojugador = codigojugador;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public BigInteger getTelefono() {
        return telefono;
    }

    public void setTelefono(BigInteger telefono) {
        this.telefono = telefono;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public BigInteger getDnijugador() {
        return dnijugador;
    }

    public void setDnijugador(BigInteger dnijugador) {
        this.dnijugador = dnijugador;
    }

    public Date getFechacobro() {
        return fechacobro;
    }

    public void setFechacobro(Date fechacobro) {
        this.fechacobro = fechacobro;
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

    public Acudiente getCodigoacudiente() {
        return codigoacudiente;
    }

    public void setCodigoacudiente(Acudiente codigoacudiente) {
        this.codigoacudiente = codigoacudiente;
    }

    public Categoria getCodigocategoria() {
        return codigocategoria;
    }

    public void setCodigocategoria(Categoria codigocategoria) {
        this.codigocategoria = codigocategoria;
    }

    @XmlTransient
    public Collection<Plantilla> getPlantillaCollection() {
        return plantillaCollection;
    }

    public void setPlantillaCollection(Collection<Plantilla> plantillaCollection) {
        this.plantillaCollection = plantillaCollection;
    }

    @XmlTransient
    public Collection<Pago> getPagoCollection() {
        return pagoCollection;
    }

    public void setPagoCollection(Collection<Pago> pagoCollection) {
        this.pagoCollection = pagoCollection;
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
        if (!(object instanceof Jugador)) {
            return false;
        }
        Jugador other = (Jugador) object;
        if ((this.codigojugador == null && other.codigojugador != null) || (this.codigojugador != null && !this.codigojugador.equals(other.codigojugador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bugabulls.modelo.Jugador[ codigojugador=" + codigojugador + " ]";
    }

    @XmlTransient
    public Collection<Evento> getEventoCollection() {
        return eventoCollection;
    }

    public void setEventoCollection(Collection<Evento> eventoCollection) {
        this.eventoCollection = eventoCollection;
    }

    public JugadorEvento getJugadorEvento() {
        return jugadorEvento;
    }

    public void setJugadorEvento(JugadorEvento jugadorEvento) {
        this.jugadorEvento = jugadorEvento;
    }
    
}
