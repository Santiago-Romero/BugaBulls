package com.bugabulls.controlador;

import com.bugabulls.modelo.Entrenador;
import java.util.List;

public interface IEntrenadorDAO {
    public void insertar(Entrenador entrenador) throws Exception;
    public void modificar(Entrenador entrenador) throws Exception;
    public void eliminar(Entrenador entrenador) throws Exception;
    public Entrenador consultarPorId(Integer codigoentrenador) throws Exception;
    public List<Entrenador> consultar() throws Exception; 
}
