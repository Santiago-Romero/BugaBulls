package com.bugabulls.controlador;

import com.bugabulls.modelo.Acudiente;
import java.util.List;

public interface IAcudienteDAO {
    public void insertar(Acudiente acudiente) throws Exception;
    public void modificar(Acudiente acudiente) throws Exception;
    public void eliminar(Acudiente acudiente) throws Exception;
    public Acudiente consultarPorId(Integer dniacudiente) throws Exception;
    public List<Acudiente> consultar() throws Exception; 
}
