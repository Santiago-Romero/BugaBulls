package com.bugabulls.controlador;

import com.bugabulls.vista.CambioContraseña;
import com.bugabulls.vista.MenuJugador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.bugabulls.vista.PlantillaJugador;
import com.bugabulls.vista.ConsultarEventos;
import com.bugabulls.vista.FechaCobro;
import com.bugabulls.vista.Login;
import com.bugabulls.vista.MisSesiones;



public class ManejadorMenuJugador implements ActionListener{
    MenuJugador mj;
    int jugadorLogeado;
    public ManejadorMenuJugador(MenuJugador mj,int jugadorLogeado){
		this.mj = mj;
                this.jugadorLogeado = jugadorLogeado;
	}	
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(mj.jmiInfoPersonal)){		    
		    PlantillaJugador pj= new PlantillaJugador(mj,jugadorLogeado);
		    pj.setVisible(true);
		}
        if(e.getSource().equals(mj.jmiMensualidad)){		    
		    FechaCobro fc= new FechaCobro(mj,jugadorLogeado);
		    fc.setVisible(true);
		}
        if(e.getSource().equals(mj.jmiEventos)){		    
		    ConsultarEventos ce= new ConsultarEventos();
		    ce.setVisible(true);
		}
        if(e.getSource().equals(mj.jmiSesion)){	
            MisSesiones ms=new MisSesiones(mj,jugadorLogeado);
            ms.setVisible(true);
		}        
          if(e.getSource().equals(mj.jmiCambiar)){
              mj.setVisible(false);
                    CambioContraseña cc = new CambioContraseña(null,jugadorLogeado);
                    cc.setVisible(true);                    
		}         
           if(e.getSource().equals(mj.jmiManual)){
               ManualUsuario mu= new ManualUsuario();
                                   
                 }
        if(e.getSource().equals(mj.jbCerrarSesion)){
                    Login lg = new Login();
                    lg.setVisible(true);
                    mj.setVisible(false);
		}
        
       
    
}}
