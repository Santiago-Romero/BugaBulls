package com.bugabulls.modelo;

import com.bugabulls.modelo.Jugador;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-21T11:28:59")
@StaticMetamodel(Acudiente.class)
public class Acudiente_ { 

    public static volatile SingularAttribute<Acudiente, Long> dniacudiente;
    public static volatile CollectionAttribute<Acudiente, Jugador> jugadorCollection;
    public static volatile SingularAttribute<Acudiente, String> parentesco;
    public static volatile SingularAttribute<Acudiente, String> apellido;
    public static volatile SingularAttribute<Acudiente, String> direccion;
    public static volatile SingularAttribute<Acudiente, Integer> codigoacudiente;
    public static volatile SingularAttribute<Acudiente, BigInteger> telefono;
    public static volatile SingularAttribute<Acudiente, String> nombre;

}