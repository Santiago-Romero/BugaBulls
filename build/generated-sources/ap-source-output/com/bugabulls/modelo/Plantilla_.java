package com.bugabulls.modelo;

import com.bugabulls.modelo.Jugador;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-21T11:28:59")
@StaticMetamodel(Plantilla.class)
public class Plantilla_ { 

    public static volatile SingularAttribute<Plantilla, String> posicion;
    public static volatile SingularAttribute<Plantilla, Double> peso;
    public static volatile SingularAttribute<Plantilla, Integer> vueltascancha;
    public static volatile SingularAttribute<Plantilla, Double> tiemposuicidio;
    public static volatile SingularAttribute<Plantilla, Double> porcentajecestas;
    public static volatile SingularAttribute<Plantilla, Integer> numeroplantilla;
    public static volatile SingularAttribute<Plantilla, Double> imc;
    public static volatile SingularAttribute<Plantilla, String> observacion;
    public static volatile SingularAttribute<Plantilla, Jugador> codigojugador;

}