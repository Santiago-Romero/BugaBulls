package com.bugabulls.controlador;

import com.bugabulls.modelo.SesionCategoria;
import java.util.List;

public interface ISesionCategoriaDAO {
    
    public void insertar(SesionCategoria sesioncategoria) throws Exception;
    public void modificar(SesionCategoria sesioncategoria) throws Exception;
    public void eliminar(SesionCategoria sesioncategoria) throws Exception;
    public SesionCategoria consultarPorId(Integer sesioncategoria) throws Exception;
    public List<SesionCategoria> consultar() throws Exception;

}
