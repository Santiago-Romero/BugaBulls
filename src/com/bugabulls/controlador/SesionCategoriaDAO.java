package com.bugabulls.controlador;

import com.bugabulls.modelo.SesionCategoria;
import java.util.List;
import javax.persistence.Query;

public class SesionCategoriaDAO implements ISesionCategoriaDAO{

    @Override
    public void insertar(SesionCategoria sesioncategoria) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(sesioncategoria);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void modificar(SesionCategoria sesioncategoria) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(sesioncategoria);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void eliminar(SesionCategoria sesioncategoria) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(sesioncategoria);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public SesionCategoria consultarPorId(Integer sesioncategoria) throws Exception {
        try {
            SesionCategoria miSesioncategoria=EntityManagerHelper.getEntityManager().find(SesionCategoria.class, sesioncategoria);
            return miSesioncategoria;
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<SesionCategoria> consultar() throws Exception {
        try {
            String jpql="select e from SesionCategoria e";
            Query query=EntityManagerHelper.createQuery(jpql);
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
