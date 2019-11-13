package com.bugabulls.modelo;

import com.bugabulls.modelo.Categoria;
import com.bugabulls.modelo.Sesion;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-21T11:28:59")
@StaticMetamodel(Entrenador.class)
public class Entrenador_ { 

    public static volatile SingularAttribute<Entrenador, Integer> estadoeliminar;
    public static volatile SingularAttribute<Entrenador, BigInteger> dnientrenador;
    public static volatile SingularAttribute<Entrenador, String> apellido;
    public static volatile SingularAttribute<Entrenador, Integer> estadocontra;
    public static volatile CollectionAttribute<Entrenador, Categoria> categoriaCollection;
    public static volatile SingularAttribute<Entrenador, String> direccion;
    public static volatile SingularAttribute<Entrenador, Integer> codigoentrenador;
    public static volatile SingularAttribute<Entrenador, BigInteger> telefono;
    public static volatile CollectionAttribute<Entrenador, Sesion> sesionCollection;
    public static volatile SingularAttribute<Entrenador, String> nombre;
    public static volatile SingularAttribute<Entrenador, String> contraseña;

}