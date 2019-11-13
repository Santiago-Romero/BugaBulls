package com.bugabulls.controlador;

import com.bugabulls.modelo.Evento;
import com.bugabulls.vista.Asistencia;
import com.bugabulls.vista.CrearEventos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import javax.swing.JOptionPane;

public class ManejadorCrearEventos implements ActionListener,KeyListener{
    int codigoEvento = 500;
    CrearEventos ce;
    
    public ManejadorCrearEventos(CrearEventos ce,int codigoEvento){
        this.codigoEvento=codigoEvento;
		this.ce = ce;
                ce.jtCiudad.addKeyListener(this);
                ce.jtGastos.addKeyListener(this);
                ce.jtNombre.addKeyListener(this);
                /*ce.jcNumeroJugadores.addKeyListener(this);*/
                ce.jbGuardar.addKeyListener(this); 
                 /*sinJugadores();  */
                
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(ce.jbGuardar)){            
            validar();
            
            
        }
    }
    public void guardarEvento(){
        try {
            EntityManagerHelper.beginTransaction();
            Evento nuevoEvento=new Evento();
            nuevoEvento.setCodigoevento(codigoEvento);
            nuevoEvento.setNombre(ce.jtNombre.getText());
            nuevoEvento.setCiudad(ce.jtCiudad.getText());
            nuevoEvento.setGastos(Double.parseDouble(ce.jtGastos.getText()));
            nuevoEvento.setFechaini(ce.jcFechaini.getDate());
            nuevoEvento.setFechafin(ce.jcFechafin.getDate());
            /*nuevoEvento.setCantidadjugadores(Integer.parseInt(ce.jcNumeroJugadores.getSelectedItem().toString()));*/
            DAOFactory.getEventoDAO().insertar(nuevoEvento);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JOptionPane.showMessageDialog(null,"Diligencie los asistentes","",JOptionPane.INFORMATION_MESSAGE);
        ce.setVisible(false);
        Asistencia as = new Asistencia(ce);
        as.setVisible(true);
    }
    
    public void validar(){    
    if(ce.jtCiudad.getText().equals("")|| ce.jtGastos.getText().equals("") || ce.jtNombre.getText().equals("")|| ce.jcFechaini.getDate()==null
    || ce.jcFechafin.getDate()==null){
    ce.jlerror.setText("");
    ce.jlerror.setText("Por favor diligencie todos los campos");       
    }
    else{
        Date fechaDate1 = ce.jcFechaini.getDate();
        Date fechaDate2 = ce.jcFechafin.getDate();
        if ( fechaDate1.before(fechaDate2) ){//  "La Fecha 1 es menor ";
         guardarEvento();        
        }
        else{
        ce.jlerror.setText("");
        ce.jlerror.setText("fecha de finalización debe ser posterior a la fecha de inicio");
        }
}}     
    
     /*public void sinJugadores (){  
        if( ce.jcNumeroJugadores.getItemCount()==0){
            ce.jbGuardar.setEnabled(false);
            ce.jlerror.setText("");
            ce.jlerror.setText("Aún no hay jugadores inscritos");
                } }*/
    
           
    
    @Override
    public void keyReleased(KeyEvent e) {
     if (e.getSource()==ce.jtNombre){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  ce.jbGuardar.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  ce.jtCiudad.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           ce.jtCiudad.requestFocus();	
		}
	}
                 
                   if (e.getSource()==ce.jtCiudad){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  ce.jtNombre.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  ce.jtGastos.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           ce.jtGastos.requestFocus();	
		}
	}
                     if (e.getSource()==ce.jtGastos){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  ce.jtCiudad.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		 /* ce.jcNumeroJugadores.requestFocus();*/	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	          /* ce.jcNumeroJugadores.requestFocus();*/	
		}
	}
                     
                         /*  if (e.getSource()==ce.jcNumeroJugadores){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  ce.jtGastos.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  ce.jbGuardar.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	          validar(); 
		}
	}  */  
                           
                               if (e.getSource()==ce.jbGuardar){
   /* if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  ce.jcNumeroJugadores.requestFocus();	
		}*/
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  ce.jtNombre.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	          validar(); 
		}
	}
                     
                      
	} 

    @Override
    public void keyTyped(KeyEvent e) {
     
    }

    @Override
    public void keyPressed(KeyEvent e) {
      
    }}

    
    
    

