package com.bugabulls.modelo;

import com.bugabulls.modelo.Entrenador;
import com.bugabulls.modelo.SesionCategoria;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-21T11:28:59")
@StaticMetamodel(Sesion.class)
public class Sesion_ { 

    public static volatile SingularAttribute<Sesion, Date> fecha;
    public static volatile SingularAttribute<Sesion, SesionCategoria> sesionCategoria;
    public static volatile SingularAttribute<Sesion, Integer> numerosesion;
    public static volatile SingularAttribute<Sesion, Entrenador> codigoentrenador;
    public static volatile SingularAttribute<Sesion, String> especificacion;
    public static volatile SingularAttribute<Sesion, String> nombre;

}