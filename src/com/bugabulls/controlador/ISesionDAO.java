package com.bugabulls.controlador;

import com.bugabulls.modelo.Sesion;
import java.util.List;

public interface ISesionDAO {
    public void insertar(Sesion sesion) throws Exception;
    public void modificar(Sesion sesion) throws Exception;
    public void eliminar(Sesion sesion) throws Exception;
    public Sesion consultarPorId(Integer numerosesion) throws Exception;
    public List<Sesion> consultar() throws Exception;
}
