package com.bugabulls.modelo;

import com.bugabulls.modelo.Acudiente;
import com.bugabulls.modelo.Categoria;
import com.bugabulls.modelo.Evento;
import com.bugabulls.modelo.JugadorEvento;
import com.bugabulls.modelo.Pago;
import com.bugabulls.modelo.Plantilla;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-21T11:28:59")
@StaticMetamodel(Jugador.class)
public class Jugador_ { 

    public static volatile SingularAttribute<Jugador, BigInteger> dnijugador;
    public static volatile SingularAttribute<Jugador, String> direccion;
    public static volatile SingularAttribute<Jugador, String> eps;
    public static volatile SingularAttribute<Jugador, JugadorEvento> jugadorEvento;
    public static volatile SingularAttribute<Jugador, String> nombre;
    public static volatile CollectionAttribute<Jugador, Plantilla> plantillaCollection;
    public static volatile SingularAttribute<Jugador, Integer> codigojugador;
    public static volatile CollectionAttribute<Jugador, Pago> pagoCollection;
    public static volatile SingularAttribute<Jugador, Integer> estadoeliminar;
    public static volatile SingularAttribute<Jugador, Date> fechanacimiento;
    public static volatile SingularAttribute<Jugador, Integer> altura;
    public static volatile SingularAttribute<Jugador, String> apellido;
    public static volatile SingularAttribute<Jugador, Integer> estadocontra;
    public static volatile SingularAttribute<Jugador, Date> fechacobro;
    public static volatile SingularAttribute<Jugador, Acudiente> codigoacudiente;
    public static volatile SingularAttribute<Jugador, Categoria> codigocategoria;
    public static volatile SingularAttribute<Jugador, BigInteger> telefono;
    public static volatile CollectionAttribute<Jugador, Evento> eventoCollection;
    public static volatile SingularAttribute<Jugador, String> contraseña;

}