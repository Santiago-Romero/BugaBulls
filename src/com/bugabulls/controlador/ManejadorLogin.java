package com.bugabulls.controlador;

import com.bugabulls.modelo.Administrador;
import com.bugabulls.modelo.Entrenador;
import com.bugabulls.modelo.Jugador;
import com.bugabulls.vista.CambioContraseña;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.bugabulls.vista.Login;
import com.bugabulls.vista.MenuAdministrador;
import com.bugabulls.vista.MenuEntrenador;
import com.bugabulls.vista.MenuJugador;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.digest.DigestUtils;

public class ManejadorLogin implements ActionListener,KeyListener{
    String codigo,contraseña,cualCodigo;
    Login lg;
    public boolean creado;
    public ManejadorLogin(Login lg){
		this.lg = lg;
                lg.jtCodigo.addKeyListener(this);
                lg.jtContrasena.addKeyListener(this);
                lg.jbEntrar.addKeyListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(lg.jbEntrar)){            
            validarTodosUsuarios();
        }
        if(ae.getSource().equals(lg.jbCrearBD)){
            
            crearBD();
        }
    }
    
    public void crearBD(){
        lg.setVisible(false);
        CreadorDataBase DB = new CreadorDataBase(lg);
        DB.setVisible(true);
        
    }
    
    public void validarTodosUsuarios(){ 
        
        if((lg.jtCodigo.getText().equals("") && lg.jtContrasena.getText().equals("")) || (lg.jtCodigo.getText().equals("") || lg.jtContrasena.getText().equals(""))){
         lg.jlError.setText("");
         lg.jlError.setText("Por favor ingrese todos los campos");
        }
        else{
        cualCodigo=lg.jtCodigo.getText().substring(0, 1);
        if(cualCodigo.equals("1")){               
            validarJugador();            
        }
        else
        if(cualCodigo.equals("2")){             
            validarEntrenador();            
        } 
        else
        if(cualCodigo.equals("9")){            
            validarAdministrador();
        }
        else
        if(!cualCodigo.equals("1") || !cualCodigo.equals("2") || !cualCodigo.equals("3"))
        {
        lg.jlError.setText("");
        lg.jlError.setText("El codigo no pertenece a la escuela");
        
       }
        } 
       
     }
  
    public void validarJugador(){
        codigo="";
        contraseña="";       
               
        try {
            List<Jugador> listaJugadores=DAOFactory.getJugadorDAO().consultar();
            if(listaJugadores.isEmpty()){
             lg.jlError.setText("");
             lg.jlError.setText("No hay jugadores registrados");
             
            }
            
            for (Jugador jugador : listaJugadores) {
                
                codigo=jugador.getCodigojugador().toString();
                contraseña=jugador.getContraseña();
                if(codigo.equals(lg.jtCodigo.getText())){
                    if(contraseña.equals(DigestUtils.md5Hex(lg.jtContrasena.getText()))){
                        if(jugador.getEstadocontra()==0){
                            abrirContra();
                        }
                        else{
                            abrirMenuJugador();
                        }
                    }
                    else{
                     lg.jlError.setText("");
                     lg.jlError.setText(jugador.getNombre()+",Contraseña erronea");
                    }
                }
                else{
                    lg.jlError.setText("");
                    lg.jlError.setText("Datos Erroneos");
                }
                
            }
        } catch (Exception ex) {
           // System.out.println("No se encontró el codigo");
            lg.jlError.setText("");
            lg.jlError.setText("Datos Erroneos");
            Logger.getLogger(ManejadorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    
       
    }
    public void validarEntrenador(){
        codigo="";
        contraseña="";        
        try {
            List<Entrenador> listaEntrenadores=DAOFactory.getEntrenadorDAO().consultar();
            if(listaEntrenadores.isEmpty()){
            lg.jlError.setText("");
            lg.jlError.setText("No hay entrenadores registrados");
                }
            for (Entrenador entrenador : listaEntrenadores) {
                codigo=entrenador.getCodigoentrenador().toString();
                contraseña=entrenador.getContraseña();
                if(codigo.equals(lg.jtCodigo.getText())){
                    if(contraseña.equals(DigestUtils.md5Hex(lg.jtContrasena.getText()))){
                        if(entrenador.getEstadocontra()==0){
                            abrirContra();
                        }
                        else{
                            abrirMenuEntrenador();
                        }
                    }
                    else{
                    lg.jlError.setText("");
                    lg.jlError.setText(entrenador.getNombre()+",Contraseña erronea");  
                    }
                }
                else{
                    lg.jlError.setText("");
                    lg.jlError.setText("Datos Erroneos");
                }
                
            }
        } catch (Exception ex) {
            //System.out.println("No se encontró el codigo");
            lg.jlError.setText("");
            lg.jlError.setText("Datos Erroneos");
            Logger.getLogger(ManejadorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void validarAdministrador() {
        codigo="";
        contraseña="";
        try {
            List<Administrador> listaAdministradores=DAOFactory.getAdministradorDAO().consultar();
           
            for (Administrador administrador : listaAdministradores) {
                codigo=administrador.getCodigoadministrador().toString();
                contraseña=administrador.getContraseña();
                if(codigo.equals(lg.jtCodigo.getText())){
                    if(contraseña.equals(DigestUtils.md5Hex(lg.jtContrasena.getText()))){
                        if(!codigo.equals("90000")){
                            if(administrador.getEstadocontra()==0){
                                abrirContra();
                            }
                            else
                            {
                                abrirMenuAdministrador();
                            }
                        }
                        else{
                            abrirMenuAdministrador();
                        }
                    }
                    else{
                    lg.jlError.setText("");
                    lg.jlError.setText(administrador.getNombre()+",Contraseña erronea"); 
                      
                    }
                }
                else{
                    lg.jlError.setText("");
                    lg.jlError.setText("Datos Erroneos");
                }
                
            }
        } catch (Exception ex) {
           // System.out.println("No se encontró el codigo");
            lg.jlError.setText("");
            lg.jlError.setText("Datos Erroneos");
            Logger.getLogger(ManejadorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void abrirContra(){
        lg.setVisible(false);
        CambioContraseña cc = new CambioContraseña(lg,Integer.parseInt(lg.jtCodigo.getText()));
        cc.setVisible(true);
    }
    public void abrirMenuAdministrador() {
        lg.setVisible(false);
        MenuAdministrador ma = new MenuAdministrador(lg,Integer.parseInt(lg.jtCodigo.getText()));
        ma.setVisible(true);
    }

    public void abrirMenuJugador() {
        lg.setVisible(false);
        MenuJugador mj = new MenuJugador(lg,Integer.parseInt(lg.jtCodigo.getText()));
        mj.setVisible(true);
    }

    public void abrirMenuEntrenador() {
        lg.setVisible(false);
        MenuEntrenador me = new MenuEntrenador(lg,Integer.parseInt(lg.jtCodigo.getText()));
        me.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {    
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
    if (e.getSource()==lg.jtCodigo){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  lg.jbEntrar.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  lg.jtContrasena.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           lg.jtContrasena.requestFocus();	
		}
	}
    
    
    if (e.getSource()==lg.jtContrasena){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  lg.jtCodigo.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  lg.jbEntrar.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           validarTodosUsuarios();	
		}
	}
    
    if (e.getSource()==lg.jbEntrar){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  lg.jtContrasena.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  lg.jtCodigo.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	         validarTodosUsuarios();
		}
	}
    
    }
    }

