package com.bugabulls.controlador;

import com.bugabulls.modelo.Categoria;
import com.bugabulls.modelo.Entrenador;
import com.bugabulls.modelo.Sesion;
import com.bugabulls.modelo.SesionCategoria;
import com.bugabulls.vista.CrearSesiones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ManejadorCrearSesiones implements ActionListener,KeyListener{
    int codigoSesion=55550;
    int entrenadorLogeado;
    CrearSesiones cs;
    
    public ManejadorCrearSesiones(CrearSesiones cs,int entrenadorLogeado,int codigoSesion){
        this.codigoSesion=codigoSesion;
        this.entrenadorLogeado=entrenadorLogeado;
		this.cs = cs;
                 sinCategorias(); 
                 cs.jtNombre.addKeyListener(this);
                 cs.jtaObservaciones.addKeyListener(this);
                 cs.jbGuardar.addKeyListener(this);
	}
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(cs.jbGuardar)){
           validar();
        }
    
    }
    public void guardarSesion(){
        try {
            EntityManagerHelper.beginTransaction();
            Entrenador entrenador=DAOFactory.getEntrenadorDAO().consultarPorId(entrenadorLogeado);
            Categoria categoria=DAOFactory.getCategoriaDAO().consultarPorId(Integer.parseInt(cs.jcCategorias.getSelectedItem().toString().substring(0,1)));
            Sesion nuevaSesion=new Sesion();
            nuevaSesion.setNumerosesion(codigoSesion);
            nuevaSesion.setCodigoentrenador(entrenador);
            nuevaSesion.setFecha(cs.jdFecha.getDate());
            nuevaSesion.setNombre(cs.jtNombre.getText());
            nuevaSesion.setEspecificacion(cs.jtaObservaciones.getText());
            SesionCategoria nuevasesionCategoria=new SesionCategoria();
            nuevasesionCategoria.setCodigocategoria(categoria);
            nuevasesionCategoria.setNumerosesion(codigoSesion);
            DAOFactory.getSesionCategoriaDAO().insertar(nuevasesionCategoria);
            DAOFactory.getSesionDAO().insertar(nuevaSesion);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
        } catch (Exception ex) {
            Logger.getLogger(ManejadorCrearSesiones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      public void sinCategorias (){  
        if( cs.jcCategorias.getItemCount()==0){
            cs.jbGuardar.setEnabled(false);
            cs.jlerror.setText("");
            cs.jlerror.setText("Aún no tiene categorías asignadas");
              }
      }
      
      private void validar(){
      if(cs.jtNombre.getText().equals("") || cs.jtaObservaciones.getText().equals("") || cs.jdFecha.getDate()==null){
      cs.jlerror.setText("");
      cs.jlerror.setText("Por favor introduzca todos los campos correctamente");           
      }
      else{
       guardarSesion();
       JOptionPane.showMessageDialog(null,"Información guardada con exito","",JOptionPane.INFORMATION_MESSAGE);
       cs.setVisible(false);
      
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
     if (e.getSource()==cs.jtNombre){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  cs.jbGuardar.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  cs.jtaObservaciones.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           cs.jtaObservaciones.requestFocus();	
		}
	}
    if (e.getSource()==cs.jtaObservaciones){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  cs.jtNombre.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  cs.jbGuardar.requestFocus();	
		}
				
	}
    
         if (e.getSource()==cs.jbGuardar){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  cs.jtaObservaciones.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  cs.jtNombre.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	        validar();
		}
	}
     
     
    }
    
}
