package com.bugabulls.controlador;

import com.bugabulls.modelo.Jugador;
import java.util.List;
import javax.persistence.Query;

public class JugadorDAO implements IJugadorDAO{

    @Override
    public void insertar(Jugador jugador) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(jugador);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void modificar(Jugador jugador) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(jugador);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void eliminar(Jugador jugador) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(jugador);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Jugador consultarPorId(Integer codigojugador) throws Exception {
        try {
            Jugador miJugador=EntityManagerHelper.getEntityManager().find(Jugador.class, codigojugador);
            return miJugador;
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Jugador> consultar() throws Exception {
        try {
            String jpql="select j from Jugador j";
            Query query=EntityManagerHelper.createQuery(jpql);
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
