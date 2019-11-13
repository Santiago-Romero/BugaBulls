package com.bugabulls.controlador;

import com.bugabulls.modelo.Plantilla;
import java.util.List;

public interface IPlantillaDAO {
    public void insertar(Plantilla plantilla) throws Exception;
    public void modificar(Plantilla plantilla) throws Exception;
    public void eliminar(Plantilla plantilla) throws Exception;
    public Plantilla consultarPorId(Integer numeroplantilla) throws Exception;
    public List<Plantilla> consultar() throws Exception;
}
