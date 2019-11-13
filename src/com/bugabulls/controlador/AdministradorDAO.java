package com.bugabulls.controlador;

import com.bugabulls.modelo.Administrador;
import java.util.List;
import javax.persistence.Query;

public class AdministradorDAO implements IAdministradorDAO{

    @Override
    public void insertar(Administrador administrador) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(administrador);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void modificar(Administrador administrador) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(administrador);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void eliminar(Administrador administrador) throws Exception {
try {
            EntityManagerHelper.getEntityManager().remove(administrador);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Administrador consultarPorId(Integer codigoadministrador) throws Exception {
        try {
            Administrador miAdministrador=EntityManagerHelper.getEntityManager().find(Administrador.class, codigoadministrador);
            return miAdministrador;
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Administrador> consultar() throws Exception {
        try {
            String jpql="select a from Administrador a";
            Query query=EntityManagerHelper.createQuery(jpql);
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
