package com.bugabulls.controlador;

import com.bugabulls.modelo.Entrenador;
import com.bugabulls.vista.EliminarEntrenador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DeleteEliminarEntrenador implements ActionListener,KeyListener{
    
    EliminarEntrenador ee;
    public DeleteEliminarEntrenador(EliminarEntrenador ee){
		this.ee = ee;
                ee.jtApellidos.addKeyListener(this);
                ee.jtCedula.addKeyListener(this);
                ee.jtCodigoEliminar.addKeyListener(this);
                ee.jtDireccion.addKeyListener(this);
                ee.jtNombre.addKeyListener(this);
                ee.jtTelefono.addKeyListener(this);
                ee.jbBuscar.addKeyListener(this);
                ee.jbEliminar.addKeyListener(this);
	}
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(ee.jbBuscar)){
      if(ee.jtCodigoEliminar.getText().equals("")){
           ee.jlerrorBuscar.setText("");
           ee.jlerrorBuscar.setText("No registrado");   
           ee.jlerror.setText("");
           }
           else{
           ee.jlerror.setText("");
           buscarEntrenador();      
      }}
        if(e.getSource().equals(ee.jbEliminar)){		    
	if(ee.jtNombre.getText().equals("")){
          ee.jlerror.setText("");
          ee.jlerror.setText("Por favor busque el Entrenador que va a eliminar"); 
         } 
       else{
        int confirmar = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar a "+ee.jtNombre.getText()+" "+ee.jtApellidos.getText()+"?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);    
	if(confirmar==0){ //si=0
        eliminarEntrenador();
        }       
         }
        }
        
        
    }
    public void buscarEntrenador(){
        try {
            Entrenador miEntrenador = DAOFactory.getEntrenadorDAO().consultarPorId(Integer.parseInt(ee.jtCodigoEliminar.getText()));
            if(miEntrenador==null){
            ee.jlerrorBuscar.setText("");
            ee.jlerrorBuscar.setText("No registrado");
            ee.jtApellidos.setText("");
            ee.jtCedula.setText("");
            ee.jtDireccion.setText("");
            ee.jtNombre.setText("");
            ee.jtTelefono.setText("");           
            }
            else{
            ee.jlerrorBuscar.setText("");
            ee.jlerror.setText("");
            ee.jtCedula.setText(miEntrenador.getDnientrenador().toString());
            ee.jtNombre.setText(miEntrenador.getNombre());
            ee.jtApellidos.setText(miEntrenador.getApellido());
            ee.jtTelefono.setText(miEntrenador.getTelefono().toString());
            ee.jtDireccion.setText(miEntrenador.getDireccion());
        }} catch (Exception ex) {
            System.out.println(ex);            
        }
    }
    public void eliminarEntrenador(){
        try {
            EntityManagerHelper.beginTransaction();
            Entrenador entExiste=DAOFactory.getEntrenadorDAO().consultarPorId(Integer.parseInt(ee.jtCodigoEliminar.getText()));
            DAOFactory.getEntrenadorDAO().eliminar(entExiste);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            JOptionPane.showMessageDialog(null,"Información eliminada con exito","",JOptionPane.INFORMATION_MESSAGE);
            ee.setVisible(false);
        } catch (Exception ex) {
            Logger.getLogger(DeleteEliminarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
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
     if (e.getSource()==ee.jtCodigoEliminar){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  ee.jbEliminar.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  ee.jbBuscar.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
                if(ee.jtCodigoEliminar.getText().equals("")){
               ee.jlerrorBuscar.setText("");
               ee.jlerrorBuscar.setText("No registrado");           
                  } 
                  else{
                   buscarEntrenador();
               }        
	    	
		}
	}  
     if (e.getSource()==ee.jbBuscar){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  ee.jtCodigoEliminar.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  ee.jbEliminar.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
                if(ee.jtCodigoEliminar.getText().equals("")){
               ee.jlerrorBuscar.setText("");
               ee.jlerrorBuscar.setText("No registrado");           
                  } 
                  else{
                   buscarEntrenador();
               }        
	    	
		}
	} 
     
      if (e.getSource()==ee.jbEliminar){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  ee.jbBuscar.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  ee.jtCodigoEliminar.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
                      if(ee.jtNombre.getText().equals("")){
                     ee.jlerrorBuscar.setText("");
                     ee.jlerrorBuscar.setText("Por favor busque el Administrador que va a eliminar"); 
                     }  
                    else{
	             eliminarEntrenador();
                      }
                      
	    	
		}
	}    
}
    
}
