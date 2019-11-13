package com.bugabulls.controlador;

import com.bugabulls.modelo.Jugador;
import java.util.List;

public interface IJugadorDAO {
   public void insertar(Jugador jugador) throws Exception;
    public void modificar(Jugador jugador) throws Exception;
    public void eliminar(Jugador jugador) throws Exception;
    public Jugador consultarPorId(Integer codigojugador) throws Exception;
    public List<Jugador> consultar() throws Exception; 
}
