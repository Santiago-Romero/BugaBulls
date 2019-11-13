package com.bugabulls.controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.bugabulls.modelo.JugadorEvento;
import java.util.List;

/**
 *
 * @author Santiago Romero
 */
public interface IJugadorEventoDAO {
    public void insertar(JugadorEvento jugadorevento) throws Exception;
    public void modificar(JugadorEvento jugadorevento) throws Exception;
    public void eliminar(JugadorEvento jugadorevento) throws Exception;
    public List<JugadorEvento> consultar() throws Exception; 
}
