package com.bugabulls.controlador;

import com.bugabulls.modelo.Categoria;
import java.util.List;

public interface ICategoriaDAO {
    public void insertar(Categoria categoria) throws Exception;
    public void modificar(Categoria categoria) throws Exception;
    public void eliminar(Categoria categoria) throws Exception;
    public Categoria consultarPorId(Integer codigocategoria) throws Exception;
    public List<Categoria> consultar() throws Exception; 
}
