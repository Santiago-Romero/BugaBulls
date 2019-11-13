package com.bugabulls.controlador;

import com.bugabulls.modelo.Plantilla;
import java.util.List;
import javax.persistence.Query;

public class PlantillaDAO implements IPlantillaDAO{

    @Override
    public void insertar(Plantilla plantilla) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(plantilla);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void modificar(Plantilla plantilla) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(plantilla);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void eliminar(Plantilla plantilla) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(plantilla);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Plantilla consultarPorId(Integer numeroplantilla) throws Exception {
        try {
            Plantilla miPlantilla=EntityManagerHelper.getEntityManager().find(Plantilla.class, numeroplantilla);
            return miPlantilla;
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Plantilla> consultar() throws Exception {
        try {
            String jpql="select p from Plantilla p";
            Query query=EntityManagerHelper.createQuery(jpql);
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
