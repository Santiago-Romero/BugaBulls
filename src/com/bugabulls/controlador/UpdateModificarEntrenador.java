package com.bugabulls.controlador;

import com.bugabulls.modelo.Entrenador;
import com.bugabulls.vista.ModificarEntrenador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigInteger;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UpdateModificarEntrenador implements ActionListener,KeyListener{
    
    ModificarEntrenador moe;
    public UpdateModificarEntrenador(ModificarEntrenador moe){
		this.moe = moe;
                moe.jtApellido.addKeyListener(this);
                moe.jtCedula.addKeyListener(this);
                moe.jtCodigo.addKeyListener(this);
                moe.jtCodigoModificar.addKeyListener(this);
                moe.jtContrasena.addKeyListener(this);
                moe.jtDireccion.addKeyListener(this);
                moe.jtNombre.addKeyListener(this);
                moe.jtTelefono.addKeyListener(this);
                moe.jbBuscar.addKeyListener(this);
                moe.jbModificar.addKeyListener(this);
                
	}
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(moe.jbModificar)){		    
		    validar();
        }
        if(e.getSource().equals(moe.jbBuscar)){	
           if(moe.jtCodigoModificar.getText().equals("")){
           moe.jlerrorBuscar.setText("");
           moe.jlerrorBuscar.setText("No registrado");           
           } 
           else{
           buscarEntrenador();
           }
        }
    }
    public void modificarEntrenador(){
        try {
            EntityManagerHelper.beginTransaction();
            Entrenador entrenadorExistente = DAOFactory.getEntrenadorDAO().consultarPorId(Integer.parseInt(moe.jtCodigoModificar.getText()));
            entrenadorExistente.setDnientrenador(new BigInteger(moe.jtCedula.getText()));
            entrenadorExistente.setNombre(moe.jtNombre.getText());
            entrenadorExistente.setApellido(moe.jtApellido.getText());
            entrenadorExistente.setTelefono(new BigInteger(moe.jtTelefono.getText()));
            entrenadorExistente.setDireccion(moe.jtDireccion.getText());
            entrenadorExistente.setContraseña(moe.jtContrasena.getText());
            DAOFactory.getEntrenadorDAO().modificar(entrenadorExistente);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            JOptionPane.showMessageDialog(null,"Información guardada con exito","",JOptionPane.INFORMATION_MESSAGE);
            moe.setVisible(false);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    public void buscarEntrenador(){
        try {
            Entrenador miEntrenador = DAOFactory.getEntrenadorDAO().consultarPorId(Integer.parseInt(moe.jtCodigoModificar.getText()));
            if(miEntrenador==null){
           moe.jlerrorBuscar.setText("");
           moe.jlerrorBuscar.setText("No registrado");
           moe.jtNombre.setText("");
           moe.jtApellido.setText("");
           moe.jtCedula.setText("");
           moe.jtCodigo.setText("");
           moe.jtContrasena.setText("");
           moe.jtDireccion.setText("");
           moe.jtTelefono.setText("");
          
            }
            else{
            moe.jlerrorBuscar.setText("");
            moe.jtCodigo.setText(miEntrenador.getCodigoentrenador().toString());
            moe.jtCedula.setText(miEntrenador.getDnientrenador().toString());
            moe.jtNombre.setText(miEntrenador.getNombre());
            moe.jtApellido.setText(miEntrenador.getApellido());
            moe.jtTelefono.setText(miEntrenador.getTelefono().toString());
            moe.jtDireccion.setText(miEntrenador.getDireccion());
            moe.jtContrasena.setText(miEntrenador.getContraseña());}
            
        } catch (Exception ex) {
            System.out.println(ex);
            
        }
    }
    
    public void validar(){
        if (moe.jtApellido.getText().equals("") || moe.jtCedula.getText().equals("") ||  moe.jtContrasena.getText().equals("") ||
         moe.jtDireccion.getText().equals("") || moe.jtNombre.getText().equals("") || moe.jtTelefono.getText().equals("") || moe.jtCodigo.getText().equals("")){
            moe.jlerror.setText("");
            moe.jlerror.setText("Por favor diligencie todos los campos");
        }
        else{
            int cedulita=0;
            ////////////////////////////
        try {
            List<Entrenador> listaEntre=DAOFactory.getEntrenadorDAO().consultar();
            for(Entrenador entre :listaEntre){
                if(entre.getDnientrenador().equals(new BigInteger(moe.jtCedula.getText()))){
                    cedulita++;
                    if(entre.getCodigoentrenador()==Integer.parseInt(moe.jtCodigoModificar.getText())){
                        cedulita--;
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(UpdateModificarEntrenador.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(cedulita==0){
             modificarEntrenador();
        }
        else{
            moe.jlerror.setText("Esta cedula ya esta registrada");
        }
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
       if (e.getSource()==moe.jtCodigoModificar){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  moe.jbModificar.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  moe.jbBuscar.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
                    if(moe.jtCodigoModificar.getText().equals("")){
           moe.jlerrorBuscar.setText("");
           moe.jlerrorBuscar.setText("No registrado");           
           } 
           else{
           buscarEntrenador();
           }
	           	
		}
	}    
       
       
       if(e.getSource()==moe.jbBuscar){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  moe.jtCodigoModificar.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		 moe.jtNombre.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           moe.jtNombre.requestFocus();	
		}
	}
        
        
     if (e.getSource()==moe.jtNombre){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  moe.jbBuscar.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  moe.jtApellido.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           moe.jtApellido.requestFocus();	
		}
	}
                 
                   if (e.getSource()==moe.jtApellido){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  moe.jtNombre.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  moe.jtCedula.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           moe.jtCedula.requestFocus();	
		}
	}
                     if (e.getSource()==moe.jtCedula){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  moe.jtApellido.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  moe.jtTelefono.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           moe.jtTelefono.requestFocus();	
		}
	}
                       if (e.getSource()==moe.jtTelefono){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  moe.jtCedula.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  moe.jtDireccion.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           moe.jtDireccion.requestFocus();	
		}
	}
                         if (e.getSource()==moe.jtDireccion){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  moe.jtTelefono.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  moe.jtContrasena.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           moe.jtContrasena.requestFocus();	
		}
	}
                           if (e.getSource()==moe.jtContrasena){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  moe.jtDireccion.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  moe.jbModificar.requestFocus();
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           validar();	
		}
	}   
                           
                           
          if (e.getSource()==moe.jbModificar){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  moe.jtContrasena.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  moe.jtCodigoModificar.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           validar();	
		}
	} 
    }
}
