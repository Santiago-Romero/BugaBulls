package com.bugabulls.controlador;

import com.bugabulls.modelo.Evento;
import java.util.List;
import javax.persistence.Query;

public class EventoDAO implements IEventoDAO{

    @Override
    public void insertar(Evento evento) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(evento);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void modificar(Evento evento) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(evento);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void eliminar(Evento evento) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(evento);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Evento consultarPorId(Integer codigoevento) throws Exception {
        try {
            Evento miEvento=EntityManagerHelper.getEntityManager().find(Evento.class, codigoevento);
            return miEvento;
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Evento> consultar() throws Exception {
        try {
            String jpql="select e from Evento e";
            Query query=EntityManagerHelper.createQuery(jpql);
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
