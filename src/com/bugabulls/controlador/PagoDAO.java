package com.bugabulls.controlador;

import com.bugabulls.modelo.Pago;
import java.util.List;
import javax.persistence.Query;

public class PagoDAO implements IPagoDAO{

    @Override
    public void insertar(Pago pago) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(pago);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void modificar(Pago pago) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(pago);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void eliminar(Pago pago) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(pago);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Pago consultarPorId(Integer codigopago) throws Exception {
        try {
            Pago miPago=EntityManagerHelper.getEntityManager().find(Pago.class, codigopago);
            return miPago;
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Pago> consultar() throws Exception {
        try {
            String jpql="select p from Pago p";
            Query query=EntityManagerHelper.createQuery(jpql);
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
