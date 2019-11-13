package com.bugabulls.controlador;

import com.bugabulls.vista.ConsultarSesiones;
import com.bugabulls.modelo.Sesion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManejadorConsultarSesiones implements ActionListener{
    
    ConsultarSesiones cs;
    
    public ManejadorConsultarSesiones(ConsultarSesiones cs){
        this.cs = cs;
         sinSesiones(); 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(cs.jbBuscar)){		    
		    consultarSesion();
        }
    }

    public void consultarSesion() {
        try {
            EntityManagerHelper.beginTransaction();
            Sesion miSesion = DAOFactory.getSesionDAO().consultarPorId(Integer.parseInt(cs.jcSesiones.getSelectedItem().toString()));
            cs.jlNombre.setText(miSesion.getNombre());
            cs.jdFecha.setDate(miSesion.getFecha());
            cs.jaEspecifi.setText(miSesion.getEspecificacion());
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
        } catch (Exception ex) {
            System.out.println(ex);
           // JOptionPane.showMessageDialog(null,"No se encontró la sesión");
        }
    }
    
    public void sinSesiones (){  
        if( cs.jcSesiones.getItemCount()==0){
            cs.jbBuscar.setEnabled(false);
            cs.jlerror.setText("");
            cs.jlerror.setText("No se han creado sesiones de entrenamiento");
                } }
    
}
