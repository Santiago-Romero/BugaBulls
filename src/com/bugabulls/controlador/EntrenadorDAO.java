package com.bugabulls.controlador;

import com.bugabulls.modelo.Entrenador;
import java.util.List;
import javax.persistence.Query;

public class EntrenadorDAO implements IEntrenadorDAO{

    @Override
    public void insertar(Entrenador entrenador) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(entrenador);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void modificar(Entrenador entrenador) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(entrenador);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void eliminar(Entrenador entrenador) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(entrenador);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Entrenador consultarPorId(Integer codigoentrenador) throws Exception {
        try {
            Entrenador miEntrenador=EntityManagerHelper.getEntityManager().find(Entrenador.class, codigoentrenador);
            return miEntrenador;
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Entrenador> consultar() throws Exception {
        try {
            String jpql="select e from Entrenador e";
            Query query=EntityManagerHelper.createQuery(jpql);
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
