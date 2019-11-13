package com.bugabulls.modelo;

import com.bugabulls.modelo.Jugador;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-21T11:28:59")
@StaticMetamodel(Pago.class)
public class Pago_ { 

    public static volatile SingularAttribute<Pago, Date> fechapago;
    public static volatile SingularAttribute<Pago, Integer> codigopago;
    public static volatile SingularAttribute<Pago, Double> valor;
    public static volatile SingularAttribute<Pago, Jugador> codigojugador;

}