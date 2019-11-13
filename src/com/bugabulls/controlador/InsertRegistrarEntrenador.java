package com.bugabulls.controlador;

import com.bugabulls.modelo.Entrenador;
import com.bugabulls.vista.RegistrarEntrenador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigInteger;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.commons.codec.digest.DigestUtils;

public class InsertRegistrarEntrenador implements ActionListener,KeyListener{
    int codigoEntrenador=20000;
    RegistrarEntrenador re;
    int contador=0;
    public InsertRegistrarEntrenador(RegistrarEntrenador re,int codigoEntrenador){
        this.codigoEntrenador=codigoEntrenador;
		this.re = re;
           re.jtNombre.addKeyListener(this);
           re.jtApellido.addKeyListener(this);
           re.jtCedula.addKeyListener(this);
           re.jtTelefono.addKeyListener(this);
           re.jtDireccion.addKeyListener(this);
           re.jtContrasena.addKeyListener(this);
           re.jbGuardar.addKeyListener(this);
	}
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(re.jbGuardar)){		    
		    validar();
        }
    }
    
    public void registroEntrenador(){
        try {
            EntityManagerHelper.beginTransaction();
            Entrenador nuevoEntrenador=new Entrenador();
            nuevoEntrenador.setCodigoentrenador(codigoEntrenador);
            nuevoEntrenador.setDnientrenador(new BigInteger(re.jtCedula.getText()));
            nuevoEntrenador.setNombre(re.jtNombre.getText());
            nuevoEntrenador.setApellido(re.jtApellido.getText());
            nuevoEntrenador.setTelefono(new BigInteger(re.jtTelefono.getText()));
            nuevoEntrenador.setDireccion(re.jtDireccion.getText());
            nuevoEntrenador.setContraseña(DigestUtils.md5Hex(re.jtContrasena.getText()));
            nuevoEntrenador.setEstadocontra(0);
            nuevoEntrenador.setEstadoeliminar(0);
            DAOFactory.getEntrenadorDAO().insertar(nuevoEntrenador);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            JOptionPane.showMessageDialog(null,"Información guardada con exito","",JOptionPane.INFORMATION_MESSAGE);
            re.setVisible(false);
        } catch (Exception ex) {
            System.out.println(ex);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
        }
    }
    
    
    public void validar(){
        if (re.jtApellido.getText().equals("") || re.jtCedula.getText().equals("") ||  re.jtContrasena.getText().equals("") ||
    re.jtDireccion.getText().equals("") || re.jtNombre.getText().equals("") || re.jtTelefono.getText().equals("")){
            re.jlerror.setText("");
            re.jlerror.setText("Por favor diligencie todos los campos");
        }
        else{
            buscarDni();
        if(contador==0){            
        registroEntrenador();       
        }
        else{
        re.jlerror.setText("");
        re.jlerror.setText("Ya se encuentra registrado un entrenador con es DNI");
        contador=0;
        }
        }
    }
    
    public void buscarDni(){
        try {
            List<Entrenador> listaEntrenador = DAOFactory.getEntrenadorDAO().consultar(); 
            for(Entrenador entrenador : listaEntrenador){
                if(new BigInteger(re.jtCedula.getText()).equals(entrenador.getDnientrenador())){
                    contador++;  
             }            
            }
           
        } catch (Exception ex) {    
         System.out.println(ex);
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
     if (e.getSource()==re.jtNombre){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  re.jbGuardar.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  re.jtApellido.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           re.jtApellido.requestFocus();	
		}
	}
                 
                   if (e.getSource()==re.jtApellido){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  re.jtNombre.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  re.jtCedula.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           re.jtCedula.requestFocus();	
		}
	}
                     if (e.getSource()==re.jtCedula){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  re.jtApellido.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  re.jtTelefono.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           re.jtTelefono.requestFocus();	
		}
	}
                       if (e.getSource()==re.jtTelefono){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  re.jtCedula.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  re.jtDireccion.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           re.jtDireccion.requestFocus();	
		}
	}
                         if (e.getSource()==re.jtDireccion){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  re.jtTelefono.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  re.jtContrasena.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           re.jtContrasena.requestFocus();	
		}
	}
                           if (e.getSource()==re.jtContrasena){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  re.jtDireccion.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  re.jbGuardar.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           validar();	
		}
	}   
                           
                           
          if (e.getSource()==re.jbGuardar){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  re.jtContrasena.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  re.jtNombre.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           validar();	
		}
	} 
    }
}
