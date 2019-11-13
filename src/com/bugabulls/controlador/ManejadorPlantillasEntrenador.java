package com.bugabulls.controlador;

import com.bugabulls.modelo.Jugador;
import com.bugabulls.modelo.Plantilla;
import com.bugabulls.vista.PlantillaJugador;
import com.bugabulls.vista.PlantillasEntrenador;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ManejadorPlantillasEntrenador implements ActionListener,KeyListener,Printable{
    boolean existeJugador=false;
    int plantillaNumero=11110;
    int entrenadorLogeado;
    PlantillasEntrenador pe;
    int codigoPlantilla;
    double elImc;
    public ManejadorPlantillasEntrenador(PlantillasEntrenador pe,int entrenadorLogeado,int plantillaNumero){
        this.plantillaNumero=plantillaNumero;
        this.entrenadorLogeado=entrenadorLogeado;
		this.pe = pe;
                sinCategoria();
                sinJugadoresPrincipio();
                pe.jcCategorias.addKeyListener(this);
                pe.jcJugador.addKeyListener(this);
                pe.jbBuscar.addKeyListener(this);
                pe.jbBuscarJugador.addKeyListener(this);
                pe.jbModificar.addKeyListener(this);
                pe.jtPeso.addKeyListener(this);
                pe.jtImc.addKeyListener(this);
                pe.jtPosicion.addKeyListener(this);
                pe.jtSuicidio.addKeyListener(this);
                pe.jtPorcentajeCesta.addKeyListener(this);
                pe.jtVueltasCancha.addKeyListener(this);
                pe.jtaObservaciones.addKeyListener(this);
                
                
	}
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(pe.jbBuscar)){
            buscarJugador();
        }
        if(e.getSource().equals(pe.jbBuscarJugador)){
            buscarPlantilla();
        }
        if(e.getSource().equals(pe.jbModificar)){
            validar();
           
        }
        if(e.getSource().equals(pe.jbcalc)){
            calcularimc();
           
        }
    }
    public void calcularimc(){
        try {
            Jugador miJugador=DAOFactory.getJugadorDAO().consultarPorId(Integer.parseInt(pe.jcJugador.getSelectedItem().toString().substring(0,5)));
            DecimalFormat decimales = new DecimalFormat("0,000");
            elImc=(Double.parseDouble(pe.jtPeso.getText())/Math.pow(Double.parseDouble(miJugador.getAltura().toString())/100,2))*1000;
            pe.jtImc.setText(decimales.format(elImc));
        } catch (Exception ex) {
            Logger.getLogger(ManejadorPlantillasEntrenador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void buscarJugador(){
        try {            
            pe.jbBuscarJugador.setEnabled(true);
            pe.jbModificar.setEnabled(true);  
            pe.jlerrorBuscar.setText("");
            limpiar();
            List<Jugador> listaJugadores=DAOFactory.getJugadorDAO().consultar();
            pe.jcJugador.removeAllItems();
            for (Jugador jugador : listaJugadores) {
                if(Integer.parseInt(pe.jcCategorias.getSelectedItem().toString().substring(0,1))==jugador.getCodigocategoria().getCodigocategoria()){                    
                    pe.jcJugador.addItem(jugador.getCodigojugador()+" - "+jugador.getNombre());
                }
            }
           if(pe.jcJugador.getItemCount()==0){
           pe.jlerrorBuscar.setText("");
           pe.jlerrorBuscar.setText("No tiene jugadores inscritos");
           pe.jbBuscarJugador.setEnabled(false);
           } 
        } catch (Exception ex) {
            Logger.getLogger(ManejadorPlantillasEntrenador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void buscarPlantilla(){
        try {  
            ponerFoto();
            List<Jugador> listaJugador=DAOFactory.getJugadorDAO().consultar();
            for(Jugador jugador : listaJugador){
                if(Integer.parseInt(pe.jcJugador.getSelectedItem().toString().substring(0,5))==jugador.getCodigojugador()){
                    pe.jtNombre.setText(jugador.getNombre()+" "+jugador.getApellido());
                    pe.jtAltura.setText(jugador.getAltura().toString());
                    pe.jtEps.setText(jugador.getEps());
                    pe.jdFechaNacimiento.setDate(jugador.getFechanacimiento());
                    pe.jtImc.setText("");
                    pe.jtPeso.setText("");
                    pe.jtPosicion.setSelectedIndex(0);
                    pe.jtSuicidio.setText("");
                    pe.jtPorcentajeCesta.setText("");
                    pe.jtVueltasCancha.setText("");
                    pe.jtaObservaciones.setText("");
                }
            }
                List<Plantilla> listaPlantillas=DAOFactory.getPlantillaDAO().consultar();
                existeJugador=false;
            for (Plantilla plantilla : listaPlantillas) {
                if(Integer.parseInt(pe.jcJugador.getSelectedItem().toString().substring(0,5))==plantilla.getCodigojugador().getCodigojugador()){
                    existeJugador=true;
                    pe.jtNombre.setText(plantilla.getCodigojugador().getNombre()+" "+plantilla.getCodigojugador().getApellido());
                    pe.jtAltura.setText(plantilla.getCodigojugador().getAltura().toString());
                    pe.jtEps.setText(plantilla.getCodigojugador().getEps());
                    pe.jdFechaNacimiento.setDate(plantilla.getCodigojugador().getFechanacimiento());
                    pe.jtImc.setText(plantilla.getImc().toString());
                    pe.jtPeso.setText(plantilla.getPeso().toString());
                    pe.jtPosicion.setSelectedItem(plantilla.getPosicion());
                    pe.jtSuicidio.setText(plantilla.getTiemposuicidio().toString());
                    pe.jtPorcentajeCesta.setText(plantilla.getPorcentajecestas().toString());
                    pe.jtVueltasCancha.setText(plantilla.getVueltascancha().toString());
                    pe.jtaObservaciones.setText(plantilla.getObservacion());
                }
            }
        } catch (Exception ex) {
            existeJugador=false;
            Logger.getLogger(PlantillaJugador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sinCategoria(){     
        if( pe.jcCategorias.getItemCount()==0){
            pe.jbBuscar.setEnabled(false);
            pe.jbBuscarJugador.setEnabled(false);
            pe.jbModificar.setEnabled(false);
            pe.jlerrorBuscar.setText("");
            pe.jlerrorBuscar.setText("Sin asignar categorías");
            } }
        
    public void sinJugadoresPrincipio(){
    if(pe.jcCategorias.getItemCount()>=1 && pe.jcJugador.getItemCount()==0){
    pe.jbBuscarJugador.setEnabled(false);
    pe.jbModificar.setEnabled(false);   
    }
    }
   
    
    public void modificarPlantilla(){
        if(existeJugador==false){
            try {
                EntityManagerHelper.beginTransaction();
                Jugador miJugador=DAOFactory.getJugadorDAO().consultarPorId(Integer.parseInt(pe.jcJugador.getSelectedItem().toString().substring(0,5)));
                Plantilla nuevaPlantilla=new Plantilla();
                nuevaPlantilla.setNumeroplantilla(plantillaNumero);
                nuevaPlantilla.setCodigojugador(miJugador);
                nuevaPlantilla.setPeso(Double.parseDouble(pe.jtPeso.getText()));
                nuevaPlantilla.setImc(Double.parseDouble(pe.jtImc.getText()));
                nuevaPlantilla.setPosicion(pe.jtPosicion.getSelectedItem().toString());
                nuevaPlantilla.setObservacion(pe.jtaObservaciones.getText());
                nuevaPlantilla.setTiemposuicidio(Double.parseDouble(pe.jtSuicidio.getText()));
                nuevaPlantilla.setVueltascancha(Integer.parseInt(pe.jtVueltasCancha.getText()));
                nuevaPlantilla.setPorcentajecestas(Double.parseDouble(pe.jtPorcentajeCesta.getText()));
                DAOFactory.getPlantillaDAO().insertar(nuevaPlantilla);
                EntityManagerHelper.commit();
                EntityManagerHelper.closeEntityManager();
            } catch (Exception ex) {
                Logger.getLogger(ManejadorPlantillasEntrenador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(existeJugador==true){
            try {
                List<Plantilla> listaPlantillas=DAOFactory.getPlantillaDAO().consultar();
                for (Plantilla plantilla : listaPlantillas) {
                    if(Integer.parseInt(pe.jcJugador.getSelectedItem().toString().substring(0,5))==plantilla.getCodigojugador().getCodigojugador()){
                        codigoPlantilla=plantilla.getNumeroplantilla();
                    }
                }
                EntityManagerHelper.beginTransaction();
                Plantilla plantillaExistente=DAOFactory.getPlantillaDAO().consultarPorId(codigoPlantilla);
                plantillaExistente.setPeso(Double.parseDouble(pe.jtPeso.getText()));
                plantillaExistente.setImc(Double.parseDouble(pe.jtImc.getText()));
                plantillaExistente.setPosicion(pe.jtPosicion.getSelectedItem().toString());
                plantillaExistente.setObservacion(pe.jtaObservaciones.getText());
                plantillaExistente.setTiemposuicidio(Double.parseDouble(pe.jtSuicidio.getText()));
                plantillaExistente.setVueltascancha(Integer.parseInt(pe.jtVueltasCancha.getText()));
                plantillaExistente.setPorcentajecestas(Double.parseDouble(pe.jtPorcentajeCesta.getText()));
                DAOFactory.getPlantillaDAO().modificar(plantillaExistente);
                EntityManagerHelper.commit();
                EntityManagerHelper.closeEntityManager();
            } catch (Exception ex) {
                Logger.getLogger(ManejadorPlantillasEntrenador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        imprimir();
    }
    
    public void validar(){
   if(pe.jtPeso.getText().equals("") || pe.jtImc.getText().equals("") || pe.jtaObservaciones.getText().equals("")
   || pe.jtSuicidio.getText().equals("") || pe.jtVueltasCancha.getText().equals("") || pe.jtPorcentajeCesta.getText().equals("")){
   pe.jlerror.setText("");
   pe.jlerror.setText("Por favor introduzca toda la información");  
     }    
   else{
   modificarPlantilla();
    JOptionPane.showMessageDialog(null,"Información guardada con exito","",JOptionPane.INFORMATION_MESSAGE);
    pe.setVisible(false);
   }
            
    }
    
    
    
    public void limpiar(){
    quitarFoto();
    pe.jtAltura.setText("");
    pe.jtEps.setText("");
    pe.jtImc.setText("");
    pe.jtNombre.setText("");
    pe.jtPeso.setText("");
    pe.jtPorcentajeCesta.setText("");
    pe.jtPosicion.setSelectedIndex(0);
    pe.jtSuicidio.setText("");
    pe.jtVueltasCancha.setText("");
    pe.jtaObservaciones.setText("");
    pe.jdFechaNacimiento.setCalendar(null);    
    }
    
    
     public void ponerFoto(){        
        ImageIcon fotoPerfil= new ImageIcon (new ImageIcon(""+pe.jcJugador.getSelectedItem().toString().substring(0,5)+".jpg").getImage());
	Icon iconoPerfil = new ImageIcon(fotoPerfil.getImage().getScaledInstance(pe.jlFotoPerfil.getWidth(), pe.jlFotoPerfil.getHeight(),Image.SCALE_DEFAULT));
	pe.jlFotoPerfil.setIcon(iconoPerfil);          
        }
        
        public void quitarFoto(){
        ImageIcon fotoPerfil= new ImageIcon(this.getClass().getResource("/com/bugabulls/imagen/fotoPerfil.png"));
	Icon iconoPerfil = new ImageIcon(fotoPerfil.getImage().getScaledInstance(pe.jlFotoPerfil.getWidth(),pe.jlFotoPerfil.getHeight(),Image.SCALE_DEFAULT));
	pe.jlFotoPerfil.setIcon(iconoPerfil);        
        }

    @Override
    public void keyTyped(KeyEvent e) {
    
    }

    @Override
    public void keyPressed(KeyEvent e) {
     
    }

   @Override
    public void keyReleased(KeyEvent e) {
    if (e.getSource()==pe.jcCategorias){
    if (e.getKeyCode()==KeyEvent.VK_RIGHT)
		{		  
		  pe.jbBuscar.requestFocus();	
                }		
	}
         
     if (e.getSource()==pe.jbBuscar){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  pe.jcCategorias.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  pe.jcJugador.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	          buscarJugador();
		}
                
                if (e.getKeyCode()==KeyEvent.VK_LEFT)
		{
	           pe.jcCategorias.requestFocus();
		}
     } 
            
     if (e.getSource()==pe.jcJugador){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  pe.jbBuscar.requestFocus();	
		}
		
                if (e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
	           pe.jbBuscarJugador.requestFocus();
		}
    
}
       if (e.getSource()==pe.jbBuscarJugador){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  pe.jcJugador.requestFocus();	
		}
		
                if (e.getKeyCode()==KeyEvent.VK_LEFT)
		{
	           pe.jcJugador.requestFocus();
		}
                
                  if (e.getKeyCode()==KeyEvent.VK_DOWN)
		{
	           pe.jtPeso.requestFocus();
		}
                  
                if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           buscarPlantilla();
		}
    
}
       
       
       
    if (e.getSource()==pe.jtPeso){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  pe.jbBuscarJugador.requestFocus();	
		}
		
                if (e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
	           pe.jtImc.requestFocus();
		}
                
                  if (e.getKeyCode()==KeyEvent.VK_DOWN)
		{
	           pe.jtImc.requestFocus();
		}
                  
                if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	          pe.jtImc.requestFocus();
		}
    
}
    
    if (e.getSource()==pe.jtImc){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  pe.jtPeso.requestFocus();	
		}
		
                if (e.getKeyCode()==KeyEvent.VK_LEFT)
		{
	           pe.jtPeso.requestFocus();
		}
                
                  if (e.getKeyCode()==KeyEvent.VK_DOWN)
		{
	           pe.jtPosicion.requestFocus();
		}
                  
                if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	          pe.jtPosicion.requestFocus();
		}
    
}
      
    if (e.getSource()==pe.jtPosicion){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  pe.jtImc.requestFocus();	
		}	
                
                  if (e.getKeyCode()==KeyEvent.VK_DOWN)
		{
	           pe.jtSuicidio.requestFocus();
		}
                  
                if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	          pe.jtSuicidio.requestFocus();
		}   
}
    
        
    if (e.getSource()==pe.jtSuicidio){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  pe.jtPosicion.requestFocus();	
		}	
                
                  if (e.getKeyCode()==KeyEvent.VK_DOWN)
		{
	           pe.jtPorcentajeCesta.requestFocus();
		}
                  
                if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	          pe.jtPorcentajeCesta.requestFocus();
		}   
}
    
        
    if (e.getSource()==pe.jtPorcentajeCesta){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  pe.jtSuicidio.requestFocus();	
		}	
                
                  if (e.getKeyCode()==KeyEvent.VK_DOWN)
		{
	           pe.jtVueltasCancha.requestFocus();
		}
                  
                if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	          pe.jtVueltasCancha.requestFocus();
		}   
}
    if (e.getSource()==pe.jtVueltasCancha){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  pe.jtPorcentajeCesta.requestFocus();	
		}	
                
                  if (e.getKeyCode()==KeyEvent.VK_DOWN)
		{
	           pe.jtaObservaciones.requestFocus();
		}
                  
                if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	          pe.jtaObservaciones.requestFocus();
		}   
}
    
    
    if (e.getSource()==pe.jtaObservaciones){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  pe.jtVueltasCancha.requestFocus();	
		}	
                
                  if (e.getKeyCode()==KeyEvent.VK_DOWN)
		{
	           pe.jbModificar.requestFocus();
		}
                                  
}
    
    
    if (e.getSource()==pe.jbModificar){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  pe.jtaObservaciones.requestFocus();	
		}	
                
                  if (e.getKeyCode()==KeyEvent.VK_DOWN)
		{
	           pe.jcCategorias.requestFocus();
		}
                  
                if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	          validar();
		}   
}
    
    }
public void imprimir(){
    try {
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintable(this);
            job.printDialog();
            job.print();
        } catch (PrinterException ex) {
            System.out.println(ex);
        }
}
public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		if (pageIndex > 0) return NO_SUCH_PAGE;
        Graphics2D g2d = (Graphics2D)graphics;
        g2d.translate(  pageFormat.getImageableX(), 
                        pageFormat.getImageableY());
        pe.panel.printAll(graphics);
        pe.setVisible(false);
        return PAGE_EXISTS; 
        
	}
}
