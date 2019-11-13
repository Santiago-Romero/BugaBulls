/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bugabulls.controlador;

import com.bugabulls.modelo.JugadorEvento;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Santiago Romero
 */
public class JugadorEventoDAO implements IJugadorEventoDAO{

    @Override
    public void insertar(JugadorEvento jugadorevento) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(jugadorevento);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void modificar(JugadorEvento jugadorevento) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(jugadorevento);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void eliminar(JugadorEvento jugadorevento) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(jugadorevento);
        } catch (RuntimeException e) {
            throw e;
        }
    }
    @Override
    public List<JugadorEvento> consultar() throws Exception {
        try {
            String jpql="select je from JugadorEvento je";
            Query query=EntityManagerHelper.createQuery(jpql);
            return query.getResultList();
        } catch (RuntimeException je) {
            throw je;
        }
    }
    
}
