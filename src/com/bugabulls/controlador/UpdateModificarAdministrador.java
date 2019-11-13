package com.bugabulls.controlador;

import com.bugabulls.modelo.Administrador;
import com.bugabulls.vista.ModificarAdministrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigInteger;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UpdateModificarAdministrador implements ActionListener,KeyListener{
    
    
    ModificarAdministrador moa;
    public UpdateModificarAdministrador(ModificarAdministrador moa){
		this.moa = moa;
                moa.jtApellido.addKeyListener(this);
                moa.jtCedula.addKeyListener(this);
                moa.jtCodigo.addKeyListener(this);
                moa.jtCodigoModificar.addKeyListener(this);
                moa.jtContrasena.addKeyListener(this);
                moa.jtDireccion.addKeyListener(this);
                moa.jtNombre.addKeyListener(this);
                moa.jtTelefono.addKeyListener(this);
                moa.jbBuscar.addKeyListener(this);
                moa.jbModificar.addKeyListener(this);
	}
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(moa.jbModificar)){		    
		    validar();
        }
        if(e.getSource().equals(moa.jbBuscar)){	
           if(moa.jtCodigoModificar.getText().equals("")){
           vaciar();          
           } 
           else{
           buscarAdministrador();
           }
        }
    }
    public void modificarAdministrador(){
        
        
        try {
            EntityManagerHelper.beginTransaction();
            Administrador administradorExistente = DAOFactory.getAdministradorDAO().consultarPorId(Integer.parseInt(moa.jtCodigoModificar.getText()));
            administradorExistente.setNombre(moa.jtNombre.getText());
            administradorExistente.setApellido(moa.jtApellido.getText());
            administradorExistente.setContraseña(moa.jtContrasena.getText());
            administradorExistente.setDniadministrador(new BigInteger(moa.jtCedula.getText()));
            administradorExistente.setDireccion(moa.jtDireccion.getText());
            administradorExistente.setTelefono(new BigInteger(moa.jtTelefono.getText()));
            DAOFactory.getAdministradorDAO().modificar(administradorExistente);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            JOptionPane.showMessageDialog(null,"Información guardada con exito","",JOptionPane.INFORMATION_MESSAGE);
            moa.setVisible(false);
        } catch (Exception ex) {
            Logger.getLogger(UpdateModificarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void buscarAdministrador(){
        try {
            Administrador miAdministrador = DAOFactory.getAdministradorDAO().consultarPorId(Integer.parseInt(moa.jtCodigoModificar.getText()));
            if(miAdministrador==null){
             vaciar();       
            }
            else{
            moa.jlerrorBuscar.setText("");
            moa.jbModificar.setEnabled(true);
            moa.jtNombre.setText(miAdministrador.getNombre());
            moa.jtApellido.setText(miAdministrador.getApellido());
            moa.jtCodigo.setText(miAdministrador.getCodigoadministrador().toString());
            moa.jtContrasena.setText(miAdministrador.getContraseña());
            moa.jtDireccion.setText(miAdministrador.getDireccion());
            moa.jtTelefono.setText(miAdministrador.getTelefono().toString());
            moa.jtCedula.setText(miAdministrador.getDniadministrador().toString());
            if(moa.jtCodigoModificar.getText().equals("9")){
            moa.jlerror.setText("");
            moa.jlerror.setText("No puede modificar la informacion del administrador principal");
            moa.jbModificar.setEnabled(false);          
              }
        } }catch (Exception ex) {
            System.out.println(ex);            
        }
    }
    
    public void validar(){
        if (moa.jtApellido.getText().equals("") || moa.jtCedula.getText().equals("") ||  moa.jtContrasena.getText().equals("") ||
         moa.jtDireccion.getText().equals("") || moa.jtNombre.getText().equals("") || moa.jtTelefono.getText().equals("") || moa.jtCodigo.getText().equals("")){
            moa.jlerror.setText("");
            moa.jlerror.setText("Por favor diligencie todos los campos");
        }
        else{
            ////////////////////////////
            int cedulita=0;
            
        try {
            List<Administrador> listaAdmin=DAOFactory.getAdministradorDAO().consultar();
            for(Administrador admin :listaAdmin){
                if(admin.getDniadministrador().equals(new BigInteger(moa.jtCedula.getText()))){
                    cedulita++;
                    if(admin.getCodigoadministrador()==Integer.parseInt(moa.jtCodigoModificar.getText())){
                        cedulita--;
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(UpdateModificarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(cedulita==0){
             modificarAdministrador();
        }
        else{
            moa.jlerror.setText("Esta cedula ya esta registrada");
        }
        ///////////////
           
        }
    }
    
    public void vaciar(){
       moa.jlerror.setText("");
           moa.jbModificar.setEnabled(true);
           moa.jlerrorBuscar.setText("");
           moa.jlerrorBuscar.setText("No registrado");
           moa.jtNombre.setText("");
           moa.jtApellido.setText("");
           moa.jtCedula.setText("");
           moa.jtCodigo.setText("");
           moa.jtContrasena.setText("");
           moa.jtDireccion.setText("");
           moa.jtTelefono.setText("");  
    }

    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
      
    }

    @Override
    public void keyReleased(KeyEvent e) {
       if (e.getSource()==moa.jtCodigoModificar){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  moa.jbModificar.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  moa.jbBuscar.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
           if(moa.jtCodigoModificar.getText().equals("")){
           moa.jlerrorBuscar.setText("");
           moa.jlerrorBuscar.setText("No registrado");           
           } 
           else{
           buscarAdministrador();
           }
	           	
		}
	}    
       
       
       if(e.getSource()==moa.jbBuscar){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  moa.jtCodigoModificar.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		 moa.jtNombre.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           moa.jtNombre.requestFocus();	
		}
	}
        
        
     if (e.getSource()==moa.jtNombre){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  moa.jbBuscar.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  moa.jtApellido.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           moa.jtApellido.requestFocus();	
		}
	}
                 
                   if (e.getSource()==moa.jtApellido){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  moa.jtNombre.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  moa.jtCedula.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           moa.jtCedula.requestFocus();	
		}
	}
                     if (e.getSource()==moa.jtCedula){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  moa.jtApellido.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  moa.jtTelefono.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           moa.jtTelefono.requestFocus();	
		}
	}
                       if (e.getSource()==moa.jtTelefono){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  moa.jtCedula.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  moa.jtDireccion.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           moa.jtDireccion.requestFocus();	
		}
	}
                         if (e.getSource()==moa.jtDireccion){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  moa.jtTelefono.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  moa.jtContrasena.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           moa.jtContrasena.requestFocus();	
		}
	}
                           if (e.getSource()==moa.jtContrasena){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  moa.jtDireccion.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  moa.jbModificar.requestFocus();
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           validar();	
		}
	}   
                           
                           
          if (e.getSource()==moa.jbModificar){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  moa.jtContrasena.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  moa.jtCodigoModificar.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           validar();	
		}
	} 
    }
    
}
