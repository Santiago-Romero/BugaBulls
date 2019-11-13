package com.bugabulls.controlador;

import com.bugabulls.modelo.Administrador;
import com.bugabulls.vista.RegistrarAdministrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigInteger;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.commons.codec.digest.DigestUtils;

public class InsertRegistrarAdministrador implements ActionListener,KeyListener{
    int codigoAdministrador = 90000;
    RegistrarAdministrador ra;
    int contador=0;
    public InsertRegistrarAdministrador(RegistrarAdministrador ra,int codigoAdministrador){
        this.codigoAdministrador=codigoAdministrador;
		this.ra = ra;
           ra.jtNombre.addKeyListener(this);
           ra.jtApellido.addKeyListener(this);
           ra.jtCedula.addKeyListener(this);
           ra.jtTelefono.addKeyListener(this);
           ra.jtDireccion.addKeyListener(this);
           ra.jtContrasena.addKeyListener(this);
           ra.jbGuardar.addKeyListener(this);
	}
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(ra.jbGuardar)){		    
		    validar();
        }
    }
    public void validar(){
        if(ra.jtApellido.getText().equals("") || ra.jtCedula.getText().equals("") || ra.jtContrasena.getText().equals("") ||
     ra.jtDireccion.getText().equals("") || ra.jtNombre.getText().equals("") || ra.jtTelefono.getText().equals("")){
     ra.jlerror.setText("Por favor diligencie todos los campos");   
        }
        else{
            buscarDni();
        if(contador==0){            
        registroAdministrador();       
        }
        else{
        ra.jlerror.setText("");
        ra.jlerror.setText("Ya se encuentra registrado un administrador con es DNI");
        contador=0;
        }
        }
    }
    public void buscarDni(){
        try {
            List<Administrador> listaAdministrador = DAOFactory.getAdministradorDAO().consultar(); 
            for(Administrador administrador : listaAdministrador){
                if(new BigInteger(ra.jtCedula.getText()).equals(administrador.getDniadministrador())){
                    contador++;  
             }            
            }
           
        } catch (Exception ex) {    
         System.out.println(ex);
        }
    }
    
    public void registroAdministrador(){
        try {
            EntityManagerHelper.beginTransaction();
            Administrador nuevoAdministrador=new Administrador();
            nuevoAdministrador.setCodigoadministrador(codigoAdministrador);
            nuevoAdministrador.setNombre(ra.jtNombre.getText());
            nuevoAdministrador.setApellido(ra.jtApellido.getText());
            nuevoAdministrador.setContraseña(DigestUtils.md5Hex(ra.jtContrasena.getText()));
            nuevoAdministrador.setDireccion(ra.jtDireccion.getText());
            nuevoAdministrador.setTelefono(new BigInteger(ra.jtTelefono.getText()));
            nuevoAdministrador.setDniadministrador(new BigInteger(ra.jtCedula.getText()));
            nuevoAdministrador.setEstadocontra(0);
            nuevoAdministrador.setEstadoeliminar(0);
            DAOFactory.getAdministradorDAO().insertar(nuevoAdministrador);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            JOptionPane.showMessageDialog(null,"Información guardada con exito","",JOptionPane.INFORMATION_MESSAGE);
            ra.setVisible(false);
        } catch (Exception ex) {
            System.out.println(ex);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
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
     if (e.getSource()==ra.jtNombre){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  ra.jbGuardar.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  ra.jtApellido.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           ra.jtApellido.requestFocus();	
		}
	}
                 
                   if (e.getSource()==ra.jtApellido){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  ra.jtNombre.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  ra.jtCedula.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           ra.jtCedula.requestFocus();	
		}
	}
                     if (e.getSource()==ra.jtCedula){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  ra.jtApellido.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  ra.jtTelefono.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           ra.jtTelefono.requestFocus();	
		}
	}
                       if (e.getSource()==ra.jtTelefono){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  ra.jtCedula.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  ra.jtDireccion.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           ra.jtDireccion.requestFocus();	
		}
	}
                         if (e.getSource()==ra.jtDireccion){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  ra.jtTelefono.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  ra.jtContrasena.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           ra.jtContrasena.requestFocus();	
		}
	}
                           if (e.getSource()==ra.jtContrasena){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  ra.jtDireccion.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  ra.jbGuardar.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           validar();	
		}
	}   
                           
                           
          if (e.getSource()==ra.jbGuardar){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  ra.jtContrasena.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  ra.jtNombre.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           validar();	
		}
	} 
    }
    
}
