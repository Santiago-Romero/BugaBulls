package com.bugabulls.controlador;

import com.bugabulls.modelo.Acudiente;
import com.bugabulls.modelo.Categoria;
import com.bugabulls.modelo.Jugador;
import com.bugabulls.vista.ModificarJugador;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UpdateModificarJugador implements ActionListener,PropertyChangeListener,KeyListener{
    
    ModificarJugador moj;
    int laCategoria;
    FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG Images", "jpg");
    String url;
   int enconAcud=0;
    
    public UpdateModificarJugador(ModificarJugador moj){
		this.moj = moj;     
                moj.jdFechaNacimiento.addPropertyChangeListener(this);
                moj.jtNombre.addKeyListener(this);
                moj.jtApellidos.addKeyListener(this);
                moj.jtDni.addKeyListener(this);
                moj.jtEps.addKeyListener(this);
                moj.jtDireccion.addKeyListener(this);
                moj.jtTelefono.addKeyListener(this);
                moj.jtAltura.addKeyListener(this);               
                moj.jtCedulaFamiliar.addKeyListener(this);
                moj.jtNombreFamiliar.addKeyListener(this);
                moj.jtApellidosFamiliar.addKeyListener(this);
                moj.jtParentescoFamiliar.addKeyListener(this);
                moj.jtTelefonoFamiliar.addKeyListener(this);
                moj.jtDireccionFamiliar.addKeyListener(this);
                moj.jtContrasena.addKeyListener(this);
                moj.jbModificar.addKeyListener(this);
                moj.jtCodigoModificar.addKeyListener(this);
                moj.jbBuscar.addKeyListener(this);
                
	}
  @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(moj.jbBuscar)){	
           if(moj.jtCodigoModificar.getText().equals("")){
            vaciarTodo();             
           } 
           else{
           buscarJugador();
           }
        }
        if(e.getSource().equals(moj.jbModificar)){		    
	validar();
        }
        if(e.getSource().equals(moj.jbAgregarFoto)){
        modificarFoto(); 
        }
        if(e.getSource().equals(moj.jbBuscarAcu)){		    
	  if(moj.jtCedulaFamiliar.getText().equals("")){
           moj.jlerrorBuscarAcu.setText("");
            moj.jlerrorBuscarAcu.setText("No registrado");    
            moj.jtApellidosFamiliar.setText("");
            moj.jtDireccionFamiliar.setText("");
            moj.jtNombreFamiliar.setText("");  
            moj.jtParentescoFamiliar.setText("");
            moj.jtTelefonoFamiliar.setText("");
           } 
           else{
           buscarAcudiente();
           }
        }
        
    }
    public void insertarFoto(){
      url="";
      JFileChooser jfc= new JFileChooser();    
      jfc.setFileFilter(filter);
      int ventana = jfc.showOpenDialog(moj);
      if(ventana==JFileChooser.APPROVE_OPTION){
      String archivo=jfc.getSelectedFile().getPath();
      String dirFoto= jfc.getSelectedFile().toString();
      moj.jlFotoPerfil.setIcon(new ImageIcon(archivo));
      ImageIcon fotoPerfil= new ImageIcon(archivo);
      Image img= fotoPerfil.getImage();
      Image nuevaFoto = img.getScaledInstance(186,177,java.awt.Image.SCALE_SMOOTH);
      ImageIcon iconoNuevo= new ImageIcon(nuevaFoto);
      moj.jlFotoPerfil.setIcon(iconoNuevo);
      moj.jlFotoPerfil.setSize(186,177);
      url= ""; 
       }       
     }
    
     public void modificarFoto(){
      url="";
      JFileChooser jfc= new JFileChooser();    
      jfc.setFileFilter(filter);
      int ventana = jfc.showOpenDialog(moj);
      if(ventana==JFileChooser.APPROVE_OPTION){
      String archivo=jfc.getSelectedFile().getPath();
      String dirFoto= jfc.getSelectedFile().toString();
      moj.jlFotoPerfil.setIcon(new ImageIcon(archivo));
      ImageIcon fotoPerfil= new ImageIcon(archivo);
      Image img= fotoPerfil.getImage();
      Image nuevaFoto = img.getScaledInstance(186,177,java.awt.Image.SCALE_SMOOTH);
      ImageIcon iconoNuevo= new ImageIcon(nuevaFoto);
      moj.jlFotoPerfil.setIcon(iconoNuevo);
      moj.jlFotoPerfil.setSize(186,177);
      url= archivo; 
       }    
     }
     
    
    public void modificarJugador(String archivo){
        
            try {
                EntityManagerHelper.beginTransaction();
                Jugador jugadorExistente=DAOFactory.getJugadorDAO().consultarPorId(Integer.parseInt(moj.jtCodigoModificar.getText()));
                Acudiente acudienteExistente=DAOFactory.getAcudienteDAO().consultarPorId(jugadorExistente.getCodigoacudiente().getCodigoacudiente());
                acudienteExistente.setParentesco(moj.jtParentescoFamiliar.getText());  
                 DAOFactory.getAcudienteDAO().modificar(acudienteExistente);
                EntityManagerHelper.commit();
                EntityManagerHelper.closeEntityManager();
            } catch (Exception ex1) {
                System.out.println(ex1);
            } 
             try {
                List<Acudiente> listaAcudientes = DAOFactory.getAcudienteDAO().consultar();
                for(Acudiente acudiente : listaAcudientes){
            if(acudiente.getDniacudiente()==Integer.parseInt(moj.jtCedulaFamiliar.getText())){
            acudiente.setDniacudiente(new Long(moj.jtCedulaFamiliar.getText()));
            acudiente.setNombre(moj.jtNombreFamiliar.getText());
            acudiente.setApellido(moj.jtApellidosFamiliar.getText());            
            acudiente.setTelefono(new BigInteger(moj.jtTelefonoFamiliar.getText()));
            acudiente.setDireccion(moj.jtDireccionFamiliar.getText());
            DAOFactory.getAcudienteDAO().modificar(acudiente);
                
            }}
            } catch (Exception ex1) {
                System.out.println(ex1);
            } 
            
        try {
            EntityManagerHelper.beginTransaction();
            Jugador jugadorExistente=DAOFactory.getJugadorDAO().consultarPorId(Integer.parseInt(moj.jtCodigoModificar.getText()));
            jugadorExistente.setNombre(moj.jtNombre.getText());
            jugadorExistente.setApellido(moj.jtApellidos.getText());
            jugadorExistente.setDireccion(moj.jtDireccion.getText());
            jugadorExistente.setEps(moj.jtEps.getText());
            jugadorExistente.setFechanacimiento(moj.jdFechaNacimiento.getDate());
            jugadorExistente.setTelefono(new BigInteger(moj.jtTelefono.getText()));
            jugadorExistente.setAltura(Integer.parseInt(moj.jtAltura.getText()));
            jugadorExistente.setDnijugador(new BigInteger(moj.jtDni.getText()));
            jugadorExistente.setContraseña(moj.jtContrasena.getText());
            Categoria categoria=DAOFactory.getCategoriaDAO().consultarPorId(laCategoria);
            jugadorExistente.setCodigocategoria(categoria);
            DAOFactory.getJugadorDAO().modificar(jugadorExistente);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            JOptionPane.showMessageDialog(null,"Información guardada con exito","",JOptionPane.INFORMATION_MESSAGE);
            moj.setVisible(false);
        } catch (Exception ex) {
            System.out.println(ex);
        } 
    }
    
    
    public void buscarAcudiente(){
        try {
            List<Acudiente> listaAcudientes = DAOFactory.getAcudienteDAO().consultar();
            enconAcud=0;
            if(listaAcudientes.isEmpty()){
            vaciarAcudiente();
            }
            for(Acudiente acudiente : listaAcudientes){
            if(acudiente.getDniacudiente()==Integer.parseInt(moj.jtCedulaFamiliar.getText())){
            enconAcud++;
            moj.jlerrorBuscarAcu.setText("");
            moj.jtNombreFamiliar.setText(acudiente.getNombre());
            moj.jtApellidosFamiliar.setText(acudiente.getApellido());
            moj.jtParentescoFamiliar.setText(acudiente.getParentesco());
            moj.jtTelefonoFamiliar.setText(acudiente.getTelefono().toString());
            moj.jtDireccionFamiliar.setText(acudiente.getDireccion());            
            }
            
            }
            if(enconAcud<1){
            enconAcud=0;
            vaciarAcudiente();
            }
         }catch (Exception ex) {
            System.out.println(ex);            
        }
    }
    
   
    
    public void buscarJugador(){
        try {
           Jugador miJugador = DAOFactory.getJugadorDAO().consultarPorId(Integer.parseInt(moj.jtCodigoModificar.getText()));
           if (miJugador==null){
             vaciarTodo();
            }else{
            ponerFoto();   
            moj.jlerrorBuscar.setText("");
            moj.jtNombre.setText(miJugador.getNombre());
            moj.jtApellidos.setText(miJugador.getApellido());
            moj.jtDireccion.setText(miJugador.getDireccion());
            moj.jtEps.setText(miJugador.getEps());
            moj.jdFechaNacimiento.setDate(miJugador.getFechanacimiento());
            moj.jtTelefono.setText(miJugador.getTelefono().toString());
            moj.jtAltura.setText(miJugador.getAltura().toString());
            moj.jtCategoria.setText(miJugador.getCodigocategoria().getNombre());
            moj.jtContrasena.setText(miJugador.getContraseña());
            moj.jtDni.setText(miJugador.getDnijugador().toString());
            moj.jtCodigo.setText(miJugador.getCodigojugador().toString());
            moj.jtCedulaFamiliar.setText(miJugador.getCodigoacudiente().getDniacudiente()+"");
            moj.jtNombreFamiliar.setText(miJugador.getCodigoacudiente().getNombre());
            moj.jtApellidosFamiliar.setText(miJugador.getCodigoacudiente().getApellido());
            moj.jtParentescoFamiliar.setText(miJugador.getCodigoacudiente().getParentesco());
            moj.jtTelefonoFamiliar.setText(miJugador.getCodigoacudiente().getTelefono().toString());
            moj.jtDireccionFamiliar.setText(miJugador.getCodigoacudiente().getDireccion());
        } }catch (Exception ex) {
            System.out.println(ex);
            
        }
    }
   
    
      @Override
    public void propertyChange(PropertyChangeEvent evt) { 
    try{
        Calendar fechaActual = Calendar.getInstance(); 
        Calendar fechaNacimiento=moj.jdFechaNacimiento.getCalendar();
        int años = fechaActual.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
        int meses = fechaActual.get(Calendar.MONTH) - fechaNacimiento.get(Calendar.MONTH);
        int dias = fechaActual.get(Calendar.DAY_OF_MONTH) - fechaNacimiento.get(Calendar.DAY_OF_MONTH);
        if(meses<0 ||(meses==0 && dias<0)){
            años=años-1;
            designarCategoria(años);
            años=0;
        }
        else{
            designarCategoria(años);
            años=0;
        }
    }
    catch(Exception ex){
        System.out.println(ex);
    }
    }
    
    public void designarCategoria(int años){
    if(años>=5&&años<=7){
    moj.jtCategoria.setText("Pre Benjamines");
    laCategoria=1;
    }
    if(años>=8&&años<=9){
    moj.jtCategoria.setText("Benjamines");
    laCategoria=2;
    }
    if(años>=10&&años<=12){
    moj.jtCategoria.setText("Minis");
    laCategoria=3;
    }
    if(años>=13&&años<=15){
    moj.jtCategoria.setText("Infantiles");
    laCategoria=4;
    }
    if(años>=16&&años<=18){
    moj.jtCategoria.setText("Junior");
    laCategoria=5;
    }
    }
    
        public void validar(){
        if (moj.jtAltura.getText().equals("")  || moj.jtApellidos.getText().equals("")  || moj.jtApellidosFamiliar.getText().equals("")
                || moj.jtCedulaFamiliar.getText().equals("")  || moj.jtContrasena.getText().equals("")  || moj.jtCodigo.getText().equals("") || moj.jtDireccion.getText().equals("")  || moj.jtDireccionFamiliar.getText().equals("")
                || moj.jtDni.getText().equals("")  || moj.jtEps.getText().equals("")  || moj.jtNombre.getText().equals("")  || moj.jtNombreFamiliar.getText().equals("") || 
               moj.jtParentescoFamiliar.getText().equals("")  || moj.jtTelefono.getText().equals("")  || moj.jtTelefonoFamiliar.getText().equals("") || moj.jtCategoria.getText().equals("") || moj.jdFechaNacimiento.getDate()==null){
                moj.jlerror.setText("Por favor diligencia todos los campos");
        }  
        else{
            int cedulita=0;
            
        try {
            List<Jugador> listaJuga=DAOFactory.getJugadorDAO().consultar();
            for(Jugador juga :listaJuga){
                if(juga.getDnijugador().equals(new BigInteger(moj.jtDni.getText()))){
                    cedulita++;
                    if(juga.getCodigojugador()==Integer.parseInt(moj.jtCodigoModificar.getText())){
                        cedulita--;
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(UpdateModificarJugador.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(cedulita==0){
             modificarJugador(url);
        }
        else{
            moj.jlerror.setText("Esta cedula ya esta registrada");
        }
        }
    }
        
        
        
        
        
        
        public void ponerFoto(){        
        ImageIcon fotoPerfil= new ImageIcon (new ImageIcon(""+moj.jtCodigoModificar.getText()+".jpg").getImage());
	Icon iconoPerfil = new ImageIcon(fotoPerfil.getImage().getScaledInstance(moj.jlFotoPerfil.getWidth(), moj.jlFotoPerfil.getHeight(),Image.SCALE_DEFAULT));
	moj.jlFotoPerfil.setIcon(iconoPerfil);          
        }
        
        public void quitarFoto(){
        ImageIcon fotoPerfil= new ImageIcon(this.getClass().getResource("/com/bugabulls/imagen/fotoPerfil.png"));
	Icon iconoPerfil = new ImageIcon(fotoPerfil.getImage().getScaledInstance(moj.jlFotoPerfil.getWidth(),moj.jlFotoPerfil.getHeight(),Image.SCALE_DEFAULT));
	moj.jlFotoPerfil.setIcon(iconoPerfil);        
        }
        
        public void vaciarAcudiente(){
            moj.jlerrorBuscarAcu.setText("");    
            moj.jlerrorBuscarAcu.setText("No registrado");          
            moj.jtNombreFamiliar.setEnabled(true);
            moj.jtApellidosFamiliar.setEnabled(true);
            moj.jtParentescoFamiliar.setEnabled(true);
            moj.jtTelefonoFamiliar.setEnabled(true);
            moj.jtDireccionFamiliar.setEnabled(true);
            moj.jtNombreFamiliar.setText("");
            moj.jtApellidosFamiliar.setText("");
            moj.jtParentescoFamiliar.setText("");
            moj.jtTelefonoFamiliar.setText("");
            moj.jtDireccionFamiliar.setText("");
            moj.jtNombreFamiliar.requestFocus();
        
        }
        
       public void vaciarTodo(){
           quitarFoto();
           moj.jlerrorBuscar.setText("");
           moj.jlerrorBuscar.setText("No registrado");
             moj.jtNombre.setText("");
            moj.jtApellidos.setText("");
            moj.jtDireccion.setText("");
            moj.jtEps.setText("");
            moj.jdFechaNacimiento.setCalendar(null);
            moj.jtTelefono.setText("");
            moj.jtAltura.setText("");
            moj.jtCategoria.setText("");
            moj.jtContrasena.setText("");
            moj.jtDni.setText("");
            moj.jtCodigo.setText("");
            moj.jtCedulaFamiliar.setText("");
            moj.jtNombreFamiliar.setText("");
            moj.jtApellidosFamiliar.setText("");
            moj.jtParentescoFamiliar.setText("");
            moj.jtTelefonoFamiliar.setText("");
            moj.jtDireccionFamiliar.setText("");
        } 
        
            
      
        
        
            
        public void copiarImg(String nombreImg)
    {
    	FileInputStream fregis = null;
    	try{
    	fregis = new FileInputStream(nombreImg);
    	}catch(IOException ioe){
    		
    	}    			
		String nomSal =moj.jtCodigo.getText()+".jpg";
    		FileOutputStream fsalida = null; 
                File fichero= new File(nomSal);                
		
		try{
                if(fichero.exists()){
                fichero.delete();                
                fsalida = new FileOutputStream(nomSal, true);
                }
		}catch(IOException ioe){
    		
    	}
    	
    	try{	
			int b = fregis.read();
			while (b != -1) {
				fsalida.write(b);
				b = fregis.read();
			}
			
			fsalida.flush();
			fsalida.close();
			fregis.close();
		}catch(IOException ioe){
    		
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
     if (e.getSource()==moj.jtCodigoModificar){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  moj.jbModificar.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  moj.jbBuscar.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
              if(moj.jtCodigoModificar.getText().equals("")){
                 moj.jlerrorBuscar.setText("");
                 moj.jlerrorBuscar.setText("No registrado");           
           } 
           else{
           buscarJugador();
           }           	
	}
	}   
     
         if (e.getSource()==moj.jbBuscar){
       if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  moj.jtCodigoModificar.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  moj.jtNombre.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	         if(moj.jtCodigoModificar.getText().equals("")){
                 moj.jlerrorBuscar.setText("");
                 moj.jlerrorBuscar.setText("No registrado");           
           } 
           else{
           buscarJugador();
           } 	
		}
	}
        
     if (e.getSource()==moj.jtNombre){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  moj.jbModificar.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  moj.jtApellidos.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           moj.jtApellidos.requestFocus();	
		}
	}
     
       if (e.getSource()==moj.jtApellidos){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  moj.jtNombre.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  moj.jtDni.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           moj.jtDni.requestFocus();	
		}
	}
       
     if (e.getSource()==moj.jtDni){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  moj.jtApellidos.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  moj.jtEps.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           moj.jtEps.requestFocus();	
		}
	} 
     
       if (e.getSource()==moj.jtEps){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  moj.jtDni.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  moj.jtDireccion.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	          moj.jtDireccion.requestFocus();	
		}
	}
       
         if (e.getSource()==moj.jtDireccion){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  moj.jtEps.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  moj.jtTelefono.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           moj.jtTelefono.requestFocus();	
		}
	}
         
           if (e.getSource()==moj.jtTelefono){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  moj.jtDireccion.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  moj.jtAltura.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           moj.jtAltura.requestFocus();	
		}
	}
           
             if (e.getSource()==moj.jtAltura){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  moj.jtTelefono.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  moj.jtCedulaFamiliar.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           moj.jtCedulaFamiliar.requestFocus();	
		}
	}
             
           
               if (e.getSource()==moj.jtCedulaFamiliar){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  moj.jtAltura.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		 if(moj.jtCedulaFamiliar.getText().isEmpty()){
                 moj.jlerrorBuscar.setText("");
                 moj.jlerrorBuscar.setText("Introduzca la cedula");
                  }
                 else{                    
                 buscarAcudiente();
                  }	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	         if(moj.jtCedulaFamiliar.getText().isEmpty()){
                 moj.jlerrorBuscar.setText("");
                 moj.jlerrorBuscar.setText("Introduzca la cedula");
                  }
                 else{                    
                 buscarAcudiente();
                  }	
		}
                
               
	}
          
               
                 if (e.getSource()==moj.jtNombreFamiliar){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  moj.jtCedulaFamiliar.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  moj.jtApellidosFamiliar.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           moj.jtApellidosFamiliar.requestFocus();	
		}
	}
                 
                   if (e.getSource()==moj.jtApellidosFamiliar){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  moj.jtNombreFamiliar.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  moj.jtParentescoFamiliar.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           moj.jtParentescoFamiliar.requestFocus();	
		}
	}
                     if (e.getSource()==moj.jtParentescoFamiliar){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  moj.jtApellidosFamiliar.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  moj.jtTelefonoFamiliar.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           moj.jtTelefonoFamiliar.requestFocus();	
		}
	}
                       if (e.getSource()==moj.jtTelefonoFamiliar){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  moj.jtParentescoFamiliar.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  moj.jtDireccionFamiliar.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           moj.jtDireccionFamiliar.requestFocus();	
		}
	}
                         if (e.getSource()==moj.jtDireccionFamiliar){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  moj.jtTelefonoFamiliar.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  moj.jtContrasena.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           moj.jtContrasena.requestFocus();	
		}
	}
                           if (e.getSource()==moj.jtContrasena){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  moj.jtDireccionFamiliar.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  moj.jbModificar.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           validar();	
		}
	}
                             if (e.getSource()==moj.jbModificar){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  moj.jtContrasena.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  moj.jtCodigoModificar.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           validar();	
		}
	}
       
       
    }
    
}
