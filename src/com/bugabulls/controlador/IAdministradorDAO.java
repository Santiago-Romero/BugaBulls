package com.bugabulls.controlador;

import com.bugabulls.modelo.Administrador;
import java.util.List;

public interface IAdministradorDAO {
    public void insertar(Administrador administrador) throws Exception;
    public void modificar(Administrador administrador) throws Exception;
    public void eliminar(Administrador administrador) throws Exception;
    public Administrador consultarPorId(Integer codigoadministrador) throws Exception;
    public List<Administrador> consultar() throws Exception; 
}
