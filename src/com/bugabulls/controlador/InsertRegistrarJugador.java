package com.bugabulls.controlador;

import com.bugabulls.modelo.Acudiente;
import com.bugabulls.modelo.Categoria;
import com.bugabulls.modelo.Jugador;
import com.bugabulls.vista.RegistrarJugador;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.codec.digest.DigestUtils;

public class InsertRegistrarJugador implements ActionListener,PropertyChangeListener,KeyListener{
    int laCategoria;
    RegistrarJugador rj;
    FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG Images", "jpg");
    String url;
    int codigoJugador=10000;
    int enconAcud=0;
    int contador=0;
    
    public InsertRegistrarJugador(RegistrarJugador rj,int codigoJugador){
        this.codigoJugador= codigoJugador;
		this.rj = rj;
                rj.jdFechaNacimiento.addPropertyChangeListener(this);
                rj.jtNombre.addKeyListener(this);
                rj.jtApellidos.addKeyListener(this);
                rj.jtDni.addKeyListener(this);
                rj.jtEps.addKeyListener(this);
                rj.jtDireccion.addKeyListener(this);
                rj.jtTelefono.addKeyListener(this);
                rj.jtAltura.addKeyListener(this);               
                rj.jtCedulaFamiliar.addKeyListener(this);
                rj.jtNombreFamiliar.addKeyListener(this);
                rj.jtApellidosFamiliar.addKeyListener(this);
                rj.jtParentescoFamiliar.addKeyListener(this);
                rj.jtTelefonoFamiliar.addKeyListener(this);
                rj.jtDireccionFamiliar.addKeyListener(this);
                rj.jtContrasena.addKeyListener(this);
                rj.jbGuardar.addKeyListener(this);
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().equals(rj.jbGuardar)){
            validar();
        }
        if(e.getSource().equals(rj.jbBuscarAcu)){
        if(rj.jtCedulaFamiliar.getText().isEmpty()){
        rj.jlerrorBuscar.setText("");
        rj.jlerrorBuscar.setText("Introduzca la cedula");
        }
        else{
            buscarAcudiente();
        }
        }
    
        if(e.getSource().equals(rj.jbAgregarFoto)){
            insertarFoto();   
        }         
       }
    
    
    
     public void insertarFoto(){
      url="";
      JFileChooser jfc= new JFileChooser();    
      jfc.setFileFilter(filter);
      int ventana = jfc.showOpenDialog(rj);
      if(ventana==JFileChooser.APPROVE_OPTION){
      String archivo=jfc.getSelectedFile().getPath();
      String dirFoto= jfc.getSelectedFile().toString();
      rj.jlFotoPerfil.setIcon(new ImageIcon(archivo));
      ImageIcon fotoPerfil= new ImageIcon(archivo);
      Image img= fotoPerfil.getImage();
      Image nuevaFoto = img.getScaledInstance(186,177,java.awt.Image.SCALE_SMOOTH);
      ImageIcon iconoNuevo= new ImageIcon(nuevaFoto);
      rj.jlFotoPerfil.setIcon(iconoNuevo);
      rj.jlFotoPerfil.setSize(186,177);
      url= archivo; 
       }       
     }
     
     
       public void copiarImg(String nombreImg)
    {
    	FileInputStream fregis = null;
    	try{
    		fregis = new FileInputStream(nombreImg);
    	}catch(IOException ioe){
    		
    	}    			
		String nomSal =rj.jtCodigo.getText()+"."+nombreImg.substring(nombreImg.length()-3,nombreImg.length());
    		FileOutputStream fsalida = null;
		
		try{
			fsalida = new FileOutputStream(nomSal, true);
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
    		System.out.println(ioe);
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
            if(acudiente.getDniacudiente()==Integer.parseInt(rj.jtCedulaFamiliar.getText())){
                enconAcud++;
                rj.jlerrorBuscar.setText("");
                rj.jtNombreFamiliar.setText(acudiente.getNombre());
                rj.jtApellidosFamiliar.setText(acudiente.getApellido());
                rj.jtParentescoFamiliar.setText(acudiente.getParentesco());
                rj.jtTelefonoFamiliar.setText(acudiente.getTelefono().toString());
                rj.jtDireccionFamiliar.setText(acudiente.getDireccion());
                rj.jtNombreFamiliar.setEnabled(false);
                rj.jtApellidosFamiliar.setEnabled(false);
                rj.jtTelefonoFamiliar.setEnabled(false);
                rj.jtDireccionFamiliar.setEnabled(false);
                rj.jtParentescoFamiliar.requestFocus();
            }
            }
            if(enconAcud<1){
            enconAcud=0;
            vaciarAcudiente();
            }
        } catch (Exception ex) {
            System.out.println(ex);          
        }
    }
    
    public void registroJugador(String archivo) {             
               copiarImg(archivo); 
               try {       
                rj.jlerror.setText("");               
                EntityManagerHelper.beginTransaction();
                Acudiente nuevoAcudiente=new Acudiente();
                nuevoAcudiente.setCodigoacudiente(rj.codigoAcudiente);
                nuevoAcudiente.setDniacudiente(new Long(rj.jtCedulaFamiliar.getText()));
                nuevoAcudiente.setNombre(rj.jtNombreFamiliar.getText());
                nuevoAcudiente.setApellido(rj.jtApellidosFamiliar.getText());
                nuevoAcudiente.setParentesco(rj.jtParentescoFamiliar.getText());
                nuevoAcudiente.setTelefono(new BigInteger(rj.jtTelefonoFamiliar.getText()));
                nuevoAcudiente.setDireccion(rj.jtDireccionFamiliar.getText());
                DAOFactory.getAcudienteDAO().insertar(nuevoAcudiente);
                EntityManagerHelper.commit();
                EntityManagerHelper.closeEntityManager();              
            }catch (Exception ex) {
                System.out.println("No insertó acudiente");
                System.out.println(ex);
                
            }
        try {
            Calendar c1=new GregorianCalendar();
            c1.add(Calendar.DAY_OF_YEAR, -1);
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            
            EntityManagerHelper.beginTransaction();
            Jugador nuevoJugador=new Jugador();
            nuevoJugador.setCodigojugador(codigoJugador);
            nuevoJugador.setNombre(rj.jtNombre.getText());
            nuevoJugador.setApellido(rj.jtApellidos.getText());
            nuevoJugador.setDireccion(rj.jtDireccion.getText());
            nuevoJugador.setEps(rj.jtEps.getText());
            nuevoJugador.setFechanacimiento(rj.jdFechaNacimiento.getDate());
            nuevoJugador.setTelefono(new BigInteger(rj.jtTelefono.getText()));
            nuevoJugador.setAltura(Integer.parseInt(rj.jtAltura.getText()));
            nuevoJugador.setDnijugador(new BigInteger(rj.jtDni.getText()));
            nuevoJugador.setContraseña(DigestUtils.md5Hex(rj.jtContrasena.getText()));
            nuevoJugador.setFechacobro(c1.getTime());
            Acudiente acudiente=DAOFactory.getAcudienteDAO().consultarPorId(rj.codigoAcudiente);
            nuevoJugador.setCodigoacudiente(acudiente);
            Categoria categoria=DAOFactory.getCategoriaDAO().consultarPorId(laCategoria);
            nuevoJugador.setCodigocategoria(categoria);
            nuevoJugador.setEstadocontra(0);
            nuevoJugador.setEstadoeliminar(0);
            DAOFactory.getJugadorDAO().insertar(nuevoJugador);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            JOptionPane.showMessageDialog(null,"Información guardada con exito","",JOptionPane.INFORMATION_MESSAGE);
            rj.setVisible(false);
        } catch (Exception ex) {
            System.out.println("No inserto el jugador");
            System.out.println(ex);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
        }
        
        
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) { 
    try{
        Calendar fechaActual = Calendar.getInstance(); 
        Calendar fechaNacimiento=rj.jdFechaNacimiento.getCalendar();
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
    
    
    public void validar(){       
        if (rj.jtAltura.getText().equals("")  || rj.jtApellidos.getText().equals("")  || rj.jtApellidosFamiliar.getText().equals("")
                || rj.jtCedulaFamiliar.getText().equals("")  || rj.jtContrasena.getText().equals("")  || rj.jtDireccion.getText().equals("")  || rj.jtDireccionFamiliar.getText().equals("")
                || rj.jtDni.getText().equals("")  || rj.jtEps.getText().equals("")  || rj.jtNombre.getText().equals("")  || rj.jtNombreFamiliar.getText().equals("") || 
                rj.jtParentescoFamiliar.getText().equals("")  || rj.jtTelefono.getText().equals("")  || rj.jtTelefonoFamiliar.getText().equals("") || rj.jtCategoria.getText().equals("") || rj.jdFechaNacimiento.getDate()==null){
            rj.jlerror.setText("Por favor diligencia todos los campos");            
        }   
        else
        if(url==null){        
        rj.jlerror.setText("");
        rj.jlerror.setText("Por favor seleccione una foto");
        }
        else{ 
        buscarDni();
        if(contador==0){            
        registroJugador(url);       
        }
        else{
        rj.jlerror.setText("");
        rj.jlerror.setText("Ya se encuentra registrado un jugador con es DNI");
        contador=0;
        }
        
        }        
        
    }

public void buscarDni(){
        try {
            List<Jugador> listaJugador = DAOFactory.getJugadorDAO().consultar(); 
            for(Jugador jugador : listaJugador){
                if(new BigInteger(rj.jtDni.getText()).equals(jugador.getDnijugador())){
                    contador++;  
             }            
            }
           
        } catch (Exception ex) {    
         System.out.println(ex);
        }
    }  
   

public void vaciarAcudiente(){
            rj.jlerrorBuscar.setText("");    
            rj.jlerrorBuscar.setText("No registrado");          
            rj.jtNombreFamiliar.setEnabled(true);
            rj.jtApellidosFamiliar.setEnabled(true);
            rj.jtParentescoFamiliar.setEnabled(true);
            rj.jtTelefonoFamiliar.setEnabled(true);
            rj.jtDireccionFamiliar.setEnabled(true);
            rj.jtNombreFamiliar.setText("");
            rj.jtApellidosFamiliar.setText("");
            rj.jtParentescoFamiliar.setText("");
            rj.jtTelefonoFamiliar.setText("");
            rj.jtDireccionFamiliar.setText("");
            rj.jtNombreFamiliar.requestFocus();
}
    
    
    public void designarCategoria(int años){
        if(años>=5&&años<=7){
        rj.jtCategoria.setText("Pre Benjamines");
        laCategoria=1;
    }
    if(años>=8&&años<=9){
        rj.jtCategoria.setText("Benjamines");
        laCategoria=2;
    }
    if(años>=10&&años<=12){
        rj.jtCategoria.setText("Minis");
        laCategoria=3;
    }
    if(años>=13&&años<=15){
        rj.jtCategoria.setText("Infantiles");
        laCategoria=4;
    }
    if(años>=16&&años<=18){
        rj.jtCategoria.setText("Junior");
        laCategoria=5;
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
     if (e.getSource()==rj.jtNombre){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  rj.jbGuardar.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  rj.jtApellidos.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           rj.jtApellidos.requestFocus();	
		}
	}
     
       if (e.getSource()==rj.jtApellidos){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  rj.jtNombre.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  rj.jtDni.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           rj.jtDni.requestFocus();	
		}
	}
       
     if (e.getSource()==rj.jtDni){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  rj.jtApellidos.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  rj.jtEps.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           rj.jtEps.requestFocus();	
		}
	} 
     
       if (e.getSource()==rj.jtEps){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  rj.jtDni.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  rj.jtDireccion.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           rj.jtDireccion.requestFocus();	
		}
	}
       
         if (e.getSource()==rj.jtDireccion){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  rj.jtEps.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  rj.jtTelefono.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           rj.jtTelefono.requestFocus();	
		}
	}
         
           if (e.getSource()==rj.jtTelefono){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  rj.jtDireccion.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  rj.jtAltura.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           rj.jtAltura.requestFocus();	
		}
	}
           
             if (e.getSource()==rj.jtAltura){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  rj.jtTelefono.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  rj.jtCedulaFamiliar.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           rj.jtCedulaFamiliar.requestFocus();	
		}
	}
             
               if (e.getSource()==rj.jtCedulaFamiliar){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  rj.jtAltura.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		 if(rj.jtCedulaFamiliar.getText().isEmpty()){
                 rj.jlerrorBuscar.setText("");
                 rj.jlerrorBuscar.setText("Introduzca la cedula");
                  }
                 else{                    
                 buscarAcudiente();
                  }	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	         if(rj.jtCedulaFamiliar.getText().isEmpty()){
                 rj.jlerrorBuscar.setText("");
                 rj.jlerrorBuscar.setText("Introduzca la cedula");
                  }
                 else{                    
                 buscarAcudiente();
                  }	
		}
                
                if (e.getKeyCode()==KeyEvent.VK_TAB)
		{
                if(rj.jtCedulaFamiliar.getText().isEmpty()){
                 rj.jlerrorBuscar.setText("");
                 rj.jlerrorBuscar.setText("Introduzca la cedula");
                  }
                 else{                    
                 buscarAcudiente();
                  }
                
                }
	}
               
                 if (e.getSource()==rj.jtNombreFamiliar){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  rj.jtCedulaFamiliar.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  rj.jtApellidosFamiliar.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           rj.jtApellidosFamiliar.requestFocus();	
		}
	}
                 
                   if (e.getSource()==rj.jtApellidosFamiliar){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  rj.jtNombreFamiliar.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  rj.jtParentescoFamiliar.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           rj.jtParentescoFamiliar.requestFocus();	
		}
	}
                     if (e.getSource()==rj.jtParentescoFamiliar){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  rj.jtApellidosFamiliar.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  rj.jtTelefonoFamiliar.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           rj.jtTelefonoFamiliar.requestFocus();	
		}
	}
                       if (e.getSource()==rj.jtTelefonoFamiliar){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  rj.jtParentescoFamiliar.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  rj.jtDireccionFamiliar.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           rj.jtDireccionFamiliar.requestFocus();	
		}
	}
                         if (e.getSource()==rj.jtDireccionFamiliar){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  rj.jtTelefonoFamiliar.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  rj.jtContrasena.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           rj.jtContrasena.requestFocus();	
		}
	}
                           if (e.getSource()==rj.jtContrasena){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  rj.jtDireccionFamiliar.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  rj.jbGuardar.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           validar();	
		}
	}
                             if (e.getSource()==rj.jbGuardar){
    if (e.getKeyCode()==KeyEvent.VK_UP)
		{		  
		  rj.jtContrasena.requestFocus();	
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN)
                {	  
		  rj.jtNombre.requestFocus();	
		}
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER)
		{
	           validar();	
		}
	}
    }
    
}
