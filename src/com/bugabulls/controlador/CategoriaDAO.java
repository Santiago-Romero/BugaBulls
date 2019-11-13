package com.bugabulls.controlador;

import com.bugabulls.modelo.Categoria;
import java.util.List;
import javax.persistence.Query;

public class CategoriaDAO implements ICategoriaDAO{

    @Override
    public void insertar(Categoria categoria) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(categoria);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void modificar(Categoria categoria) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(categoria);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void eliminar(Categoria categoria) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(categoria);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Categoria consultarPorId(Integer codigocategoria) throws Exception {
        try {
            Categoria miCategoria=EntityManagerHelper.getEntityManager().find(Categoria.class, codigocategoria);
            return miCategoria;
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Categoria> consultar() throws Exception {try {
            String jpql="select c from Categoria c";
            Query query=EntityManagerHelper.createQuery(jpql);
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
