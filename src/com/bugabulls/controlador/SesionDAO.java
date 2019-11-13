package com.bugabulls.controlador;

import com.bugabulls.modelo.Sesion;
import java.util.List;
import javax.persistence.Query;

public class SesionDAO implements ISesionDAO{

    @Override
    public void insertar(Sesion sesion) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(sesion);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void modificar(Sesion sesion) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(sesion);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void eliminar(Sesion sesion) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(sesion);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Sesion consultarPorId(Integer numerosesion) throws Exception {
        try {
            Sesion miSesion=EntityManagerHelper.getEntityManager().find(Sesion.class, numerosesion);
            return miSesion;
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Sesion> consultar() throws Exception {
        try {
            String jpql="select s from Sesion s";
            Query query=EntityManagerHelper.createQuery(jpql);
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
