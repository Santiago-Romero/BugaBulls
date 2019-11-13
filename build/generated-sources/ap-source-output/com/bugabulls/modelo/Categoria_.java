package com.bugabulls.modelo;

import com.bugabulls.modelo.Entrenador;
import com.bugabulls.modelo.Jugador;
import com.bugabulls.modelo.SesionCategoria;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-21T11:28:59")
@StaticMetamodel(Categoria.class)
public class Categoria_ { 

    public static volatile CollectionAttribute<Categoria, SesionCategoria> sesionCategoriaCollection;
    public static volatile SingularAttribute<Categoria, Date> horario;
    public static volatile CollectionAttribute<Categoria, Jugador> jugadorCollection;
    public static volatile SingularAttribute<Categoria, Integer> codigocategoria;
    public static volatile SingularAttribute<Categoria, Entrenador> codigoentrenador;
    public static volatile SingularAttribute<Categoria, String> nombre;

}