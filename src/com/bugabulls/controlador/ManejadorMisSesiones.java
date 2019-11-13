package com.bugabulls.controlador;

import com.bugabulls.modelo.Sesion;
import com.bugabulls.vista.MisSesiones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ManejadorMisSesiones implements ActionListener{
    int jugadorLogeado;
    MisSesiones ms;

    public ManejadorMisSesiones(MisSesiones ms,int jugadorLogeado) {
        this.jugadorLogeado=jugadorLogeado;
        this.ms = ms;
         sinSesiones();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(ms.jbBuscar)){
            buscarSesion();
        }
    }
    public void buscarSesion(){
        try {
                List<Sesion> listaSesiones=DAOFactory.getSesionDAO().consultar();
            for (Sesion sesion : listaSesiones) {
                if(Integer.parseInt(ms.jcSesiones.getSelectedItem().toString())==sesion.getNumerosesion()){
                    ms.jlNombre.setText(sesion.getNombre());
                    ms.jdFecha.setDate(sesion.getFecha());
                    ms.jaEspecifi.setText(sesion.getEspecificacion());
                }
            }
        }
        catch (Exception ex) {
            Logger.getLogger(ManejadorModificarSesiones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public void sinSesiones (){  
        if( ms.jcSesiones.getItemCount()==0){
            ms.jbBuscar.setEnabled(false);
            ms.jlerror.setText("");
            ms.jlerror.setText("No se tiene ninguna sesión de entrenamiento");
               
        } }
    
}
