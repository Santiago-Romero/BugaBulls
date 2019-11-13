package com.bugabulls.modelo;

import com.bugabulls.modelo.Jugador;
import com.bugabulls.modelo.JugadorEvento;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-21T11:28:59")
@StaticMetamodel(Evento.class)
public class Evento_ { 

    public static volatile SingularAttribute<Evento, Date> fechaini;
    public static volatile CollectionAttribute<Evento, Jugador> jugadorCollection;
    public static volatile SingularAttribute<Evento, String> ciudad;
    public static volatile SingularAttribute<Evento, Date> fechafin;
    public static volatile CollectionAttribute<Evento, JugadorEvento> jugadorEventoCollection;
    public static volatile SingularAttribute<Evento, Integer> codigoevento;
    public static volatile SingularAttribute<Evento, String> nombre;
    public static volatile SingularAttribute<Evento, Integer> cantidadjugadores;
    public static volatile SingularAttribute<Evento, Double> gastos;

}