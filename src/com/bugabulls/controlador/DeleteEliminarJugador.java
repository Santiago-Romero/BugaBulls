package com.bugabulls.controlador;

import com.bugabulls.modelo.Acudiente;
import com.bugabulls.modelo.Jugador;
import com.bugabulls.vista.EliminarJugador;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class DeleteEliminarJugador implements ActionListener,KeyListener{
    EliminarJugador ej;
    public DeleteEliminarJugador(EliminarJugador ej){
		this.ej = ej;
                ej.jtCodigoEliminar.addKeyListener(this);
                ej.jbBuscar.addKeyListener(this);
                ej.jbEliminar.addKeyListener(this);
	}
    @Override
    public void actionPerformed(ActionEvent e) {
          if(e.getSource().equals(ej.jbBuscar)){	
           if(ej.jtCodigoEliminar.getText().equals("")){
           ej.jlerrorBuscar.setText("");
           ej.jlerrorBuscar.setText("No registrado");   
           ej.jlerror.setText("");
           } 
           else{
           ej.jlerror.setText("");
           buscarJugador();
           }
        }
        if(e.getSource().equals(ej.jbEliminar)){               
         if(ej.jtNombre.getText().equals("")){
          ej.jlerror.setText("");
          ej.jlerror.setText("Por favor busque el jugador que va a eliminar"); 
         }  
         else{
         int confirmar = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar a "+ej.jtNombre.getText()+ej.jtApellidos.getText()+"?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);    
	if(confirmar==0){ //si=0
        eliminarJugador();
        eliminarFoto();
        }       
         }
        }
    }
    public void buscarJugador(){
        quitarFoto();
        try {
            Jugador miJugador = DAOFactory.getJugadorDAO().consultarPorId(Integer.parseInt(ej.jtCodigoEliminar.getText()));
             if(miJugador==null)
             {
            ej.jlerrorBuscar.setText("");
            ej.jlerrorBuscar.setText("No registrado");
            ej.jtAltura.setText("");
            ej.jtApellidos.setText("");
            ej.jtDireccion.setText("");
            ej.jtDni.setText("");
            ej.jtEps.setText("");
            ej.jtNombre.setText("");
            ej.jtTelefono.setText("");
             
             }
             else{
             ponerFoto();
            ej.jlerrorBuscar.setText("");
            ej.jlerror.setText("");
            ej.jtNombre.setText(miJugador.getNombre());
            ej.jtApellidos.setText(miJugador.getApellido());
            ej.jtDireccion.setText(miJugador.getDireccion());
            ej.jtEps.setText(miJugador.getEps());
            ej.jdFechaNacimiento.setDate(miJugador.getFechanacimiento());
            ej.jtTelefono.setText(miJugador.getTelefono().toString());
            ej.jtAltura.setText(miJugador.getAltura().toString());
            ej.jtDni.setText(miJugador.getDnijugador().toString());           
           
             }
        } catch (Exception ex) {
            System.out.println(ex);           
        }
    }
    
    public void eliminarJugador(){
        try {
            EntityManagerHelper.beginTransaction();
            Jugador jugExiste=DAOFactory.getJugadorDAO().consultarPorId(Integer.parseInt(ej.jtCodigoEliminar.getText()));
            Acudiente acuExiste=DAOFactory.getAcudienteDAO().consultarPorId(jugExiste.getCodigoacudiente().getCodigoacudiente());
            DAOFactory.getAcudienteDAO().eliminar(acuExiste);
            DAOFactory.getJugadorDAO().eliminar(jugExiste);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            JOptionPane.showMessageDialog(null,"Información eliminada con exito","",JOptionPane.INFORMATION_MESSAGE);
            ej.setVisible(false);
        } catch (Exception ex) {
            Logger.getLogger(DeleteEliminarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarFoto(){
    String nomSal =ej.jtCodigoEliminar.getText()+".jpg";
    		FileOutputStream fsalida = null; 
                File fichero= new File(nomSal);                
		
		try{
                if(fichero.exists()){
                fichero.delete();                
                fsalida = new FileOutputStream(nomSal, true);
                }
		}catch(IOException ioe){
    		
    	}   	
    
    }
    
     public void ponerFoto(){        
        ImageIcon fotoPerfil= new ImageIcon (new ImageIcon(""+ej.jtCodigoEliminar.getText()+".jpg").getImage());
	Icon iconoPerfil = new ImageIcon(fotoPerfil.getImage().getScaledInstance(ej.jlFotoPerfil.getWidth(), ej.jlFotoPerfil.getHeight(),Image.SCALE_DEFAULT));
	ej.jlFotoPerfil.setIcon(iconoPerfil);          
        }

    @Override
    public void keyTyped(KeyEvent e) {
    
    }

    @Override
    public void keyPressed(KeyEvent e) {
     
    }
    public void quitarFoto(){
        ImageIcon fotoPerfil= new ImageIcon(this.getClass().getResource("/com/bugabulls/imagen/fotoPerfil.png"));
	Icon iconoPerfil = new ImageIcon(fotoPerfil.getImage().getScaledInstance(ej.jlFotoPerfil.getWidth(),ej.jlFotoPerfil.getHeight(),Image.SCALE_DEFAULT));
	ej.jlFotoPerfil.setIcon(iconoPerfil);        
        }

     @Override
    public void keyReleased(KeyEvent e) {
     if (e.getSource()==ej.jtCodigoEliminar){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  ej.jbEliminar.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  ej.jbBuscar.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
                if(ej.jtCodigoEliminar.getText().equals("")){
               ej.jlerrorBuscar.setText("");
               ej.jlerrorBuscar.setText("No registrado");           
                  } 
                  else{
                   buscarJugador();
               }        
	    	
		}
	}  
     if (e.getSource()==ej.jbBuscar){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  ej.jtCodigoEliminar.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  ej.jbEliminar.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
                if(ej.jtCodigoEliminar.getText().equals("")){
               ej.jlerrorBuscar.setText("");
               ej.jlerrorBuscar.setText("No registrado");           
                  } 
                  else{
                   buscarJugador();
               }        
	    	
		}
	} 
     
      if (e.getSource()==ej.jbEliminar){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  ej.jbBuscar.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  ej.jtCodigoEliminar.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
                      if(ej.jtNombre.getText().equals("")){
                     ej.jlerrorBuscar.setText("");
                     ej.jlerrorBuscar.setText("Por favor busque el jugador que va a eliminar"); 
                     }  
                    else{
	             eliminarJugador();
                      }
                      
	    	
		}
	}
      
     
     
}}
