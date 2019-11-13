package com.bugabulls.controlador;

import com.bugabulls.modelo.Sesion;
import com.bugabulls.vista.ModificarSesiones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ManejadorModificarSesiones implements ActionListener,KeyListener{
    ModificarSesiones ms;
   
    
    public ManejadorModificarSesiones(ModificarSesiones ms){
		this.ms = ms;
                ms.jtNombre.addKeyListener(this);
                ms.jtaObservaciones.addKeyListener(this);
                ms.jbModificar.addKeyListener(this);
                sinSesiones();
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(ms.jbBuscar)){
            buscarSesion();
        }
        if(e.getSource().equals(ms.jbModificar)){
           validar();
        }
    }

    private void buscarSesion() {
        try {
                List<Sesion> listaSesiones=DAOFactory.getSesionDAO().consultar();
            for (Sesion sesion : listaSesiones) {
                if(Integer.parseInt(ms.jcSesiones.getSelectedItem().toString())==sesion.getNumerosesion()){
                    ms.jtNombre.setText(sesion.getNombre());
                    ms.jdFecha.setDate(sesion.getFecha());
                    ms.jtaObservaciones.setText(sesion.getEspecificacion());
                }
            }
        }
        catch (Exception ex) {
            Logger.getLogger(ManejadorModificarSesiones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void modificarSesion() {
        try {
            EntityManagerHelper.beginTransaction();
            Sesion sesionExistente=DAOFactory.getSesionDAO().consultarPorId(Integer.parseInt(ms.jcSesiones.getSelectedItem().toString()));
            sesionExistente.setNombre(ms.jtNombre.getText());
            sesionExistente.setFecha(ms.jdFecha.getDate());
            sesionExistente.setEspecificacion(ms.jtaObservaciones.getText());
            DAOFactory.getSesionDAO().modificar(sesionExistente);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
        } catch (Exception ex) {
            Logger.getLogger(ManejadorModificarSesiones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sinSesiones (){  
        if( ms.jcSesiones.getItemCount()==0){
            ms.jbBuscar.setEnabled(false);
            ms.jbModificar.setEnabled(false);
            ms.jlerror.setText("");
            ms.jlerror.setText("No han creado sesiones de entrenamiento");
              }
      }
    
    
    private void validar(){
      if(ms.jtNombre.getText().equals("") || ms.jtaObservaciones.getText().equals("") || ms.jdFecha.getDate()==null){
      ms.jlerror.setText("");
      ms.jlerror.setText("Por favor introduzca todos los campos correctamente");           
      }
      else{
      modificarSesion();
      JOptionPane.showMessageDialog(null,"Información guardada con exito","",JOptionPane.INFORMATION_MESSAGE);
      ms.setVisible(false);
      
      
      }
      
      
      }

    @Override
    public void keyTyped(KeyEvent e) {
   
    }

    @Override
    public void keyPressed(KeyEvent e) {
     
    }

    @Override
    public void keyReleased(KeyEvent e) {
     if (e.getSource()==ms.jtNombre){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  ms.jbModificar.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  ms.jtaObservaciones.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           ms.jtaObservaciones.requestFocus();	
		}
	}
    if (e.getSource()==ms.jtaObservaciones){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  ms.jtNombre.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  ms.jbModificar.requestFocus();	
		}
				
	}
    
         if (e.getSource()==ms.jbModificar){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  ms.jtaObservaciones.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  ms.jtNombre.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	        validar();
		}
	}
     
     
    }
    
}
