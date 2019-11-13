package com.bugabulls.modelo;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-21T11:28:59")
@StaticMetamodel(Administrador.class)
public class Administrador_ { 

    public static volatile SingularAttribute<Administrador, Integer> codigoadministrador;
    public static volatile SingularAttribute<Administrador, Integer> estadoeliminar;
    public static volatile SingularAttribute<Administrador, String> apellido;
    public static volatile SingularAttribute<Administrador, BigInteger> dniadministrador;
    public static volatile SingularAttribute<Administrador, Integer> estadocontra;
    public static volatile SingularAttribute<Administrador, String> direccion;
    public static volatile SingularAttribute<Administrador, BigInteger> telefono;
    public static volatile SingularAttribute<Administrador, String> nombre;
    public static volatile SingularAttribute<Administrador, String> contraseña;

}