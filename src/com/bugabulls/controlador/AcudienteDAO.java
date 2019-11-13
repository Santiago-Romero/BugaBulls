package com.bugabulls.controlador;

import com.bugabulls.modelo.Acudiente;
import java.util.List;
import javax.persistence.Query;

public class AcudienteDAO implements IAcudienteDAO{

    @Override
    public void insertar(Acudiente acudiente) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(acudiente);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void modificar(Acudiente acudiente) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(acudiente);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void eliminar(Acudiente acudiente) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(acudiente);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Acudiente consultarPorId(Integer dniacudiente) throws Exception {
        try {
            Acudiente miAcudiente=EntityManagerHelper.getEntityManager().find(Acudiente.class, dniacudiente);
            return miAcudiente;
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Acudiente> consultar() throws Exception {
        try {
            String jpql="select a from Acudiente a";
            Query query=EntityManagerHelper.createQuery(jpql);
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
