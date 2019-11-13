package com.bugabulls.controlador;

import com.bugabulls.modelo.Administrador;
import com.bugabulls.vista.EliminarAdministrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DeleteEliminarAdministrador implements ActionListener,KeyListener{
    
    EliminarAdministrador ea;
    public DeleteEliminarAdministrador(EliminarAdministrador ea){
		this.ea = ea;
                ea.jtApellidos.addKeyListener(this);
                ea.jtCedula.addKeyListener(this);
                ea.jtCodigoEliminar.addKeyListener(this);
                ea.jtDireccion.addKeyListener(this);
                ea.jtNombre.addKeyListener(this);
                ea.jtTelefono.addKeyListener(this);
                ea.jbBuscar.addKeyListener(this);
                ea.jbEliminar.addKeyListener(this);
	}
    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource().equals(ea.jbBuscar)){
      if(ea.jtCodigoEliminar.getText().equals("")){
           vaciar();
           }
           else{
           ea.jlerror.setText("");
           buscarAdministrador();      
      }}
            
        if(e.getSource().equals(ea.jbEliminar)){		    
	if(ea.jtNombre.getText().equals("")){
          ea.jlerror.setText("");
          ea.jlerror.setText("Por favor busque el Administrador que va a eliminar"); 
         } 
       else{
        int confirmar = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar a "+ea.jtNombre.getText()+" "+ea.jtApellidos.getText()+"?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);    
	if(confirmar==0){ //si=0
        eliminarAdministrador();
        }       
         }
        }
    }
    public void buscarAdministrador(){
        try {
            Administrador miAdministrador = DAOFactory.getAdministradorDAO().consultarPorId(Integer.parseInt(ea.jtCodigoEliminar.getText()));
            if(miAdministrador==null){
            vaciar();           
            }
            else{
            ea.jlerrorBuscar.setText("");
            ea.jlerror.setText("");
            ea.jbEliminar.setEnabled(true);
            ea.jtNombre.setText(miAdministrador.getNombre());
            ea.jtApellidos.setText(miAdministrador.getApellido());
            ea.jtDireccion.setText(miAdministrador.getDireccion());
            ea.jtCedula.setText(miAdministrador.getDniadministrador().toString());
            ea.jtTelefono.setText(miAdministrador.getTelefono().toString());
            if(ea.jtCodigoEliminar.getText().equals("90000")){
            ea.jbEliminar.setEnabled(false);
            ea.jlerror.setText("");
            ea.jlerror.setText("El administrador principal no se puede eliminar");                
            }
        }} catch (Exception ex) {
            System.out.println(ex);
            
        }
    }
    public void eliminarAdministrador(){
        try {
            EntityManagerHelper.beginTransaction();
            Administrador admExiste=DAOFactory.getAdministradorDAO().consultarPorId(Integer.parseInt(ea.jtCodigoEliminar.getText()));
            DAOFactory.getAdministradorDAO().eliminar(admExiste);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            JOptionPane.showMessageDialog(null,"Información eliminada con exito","",JOptionPane.INFORMATION_MESSAGE);
            ea.setVisible(false);
        } catch (Exception ex) {
            Logger.getLogger(DeleteEliminarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void vaciar(){
           ea.jlerror.setText("");
           ea.jbEliminar.setEnabled(true);
           ea.jlerrorBuscar.setText("");
           ea.jlerrorBuscar.setText("No registrado");
           ea.jtApellidos.setText("");
           ea.jtCedula.setText("");
           ea.jtDireccion.setText("");
           ea.jtNombre.setText("");
           ea.jtTelefono.setText("");  
    
    }

    @Override
    public void keyTyped(KeyEvent e) {
    
    }

    @Override
    public void keyPressed(KeyEvent e) {
     
    }

    @Override
    public void keyReleased(KeyEvent e) {
     if (e.getSource()==ea.jtCodigoEliminar){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  ea.jbEliminar.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  ea.jbBuscar.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
                if(ea.jtCodigoEliminar.getText().equals("")){
               ea.jlerrorBuscar.setText("");
               ea.jlerrorBuscar.setText("No registrado");           
                  } 
                  else{
                   buscarAdministrador();
               }        
	    	
		}
	}  
     if (e.getSource()==ea.jbBuscar){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  ea.jtCodigoEliminar.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  ea.jbEliminar.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
                if(ea.jtCodigoEliminar.getText().equals("")){
               ea.jlerrorBuscar.setText("");
               ea.jlerrorBuscar.setText("No registrado");           
                  } 
                  else{
                   buscarAdministrador();
               }        
	    	
		}
	} 
     
      if (e.getSource()==ea.jbEliminar){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  ea.jbBuscar.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  ea.jtCodigoEliminar.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
                      if(ea.jtNombre.getText().equals("")){
                     ea.jlerrorBuscar.setText("");
                     ea.jlerrorBuscar.setText("Por favor busque el Administrador que va a eliminar"); 
                     }  
                    else{
	             eliminarAdministrador();
                      }
                      
	    	
		}
	}    
}
    
}
