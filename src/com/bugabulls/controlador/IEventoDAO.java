package com.bugabulls.controlador;

import com.bugabulls.modelo.Evento;
import java.util.List;

public interface IEventoDAO {
    public void insertar(Evento evento) throws Exception;
    public void modificar(Evento evento) throws Exception;
    public void eliminar(Evento evento) throws Exception;
    public Evento consultarPorId(Integer codigoevento) throws Exception;
    public List<Evento> consultar() throws Exception; 
}
