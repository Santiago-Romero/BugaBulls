package com.bugabulls.controlador;

import com.bugabulls.modelo.Pago;
import java.util.List;

public interface IPagoDAO {
    public void insertar(Pago pago) throws Exception;
    public void modificar(Pago pago) throws Exception;
    public void eliminar(Pago pago) throws Exception;
    public Pago consultarPorId(Integer codigopago) throws Exception;
    public List<Pago> consultar() throws Exception;
}
