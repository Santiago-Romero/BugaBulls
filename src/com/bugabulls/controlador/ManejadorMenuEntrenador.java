package com.bugabulls.controlador;

import com.bugabulls.vista.CambioContraseña;
import com.bugabulls.vista.CrearSesiones;
import com.bugabulls.vista.JugadoresCategoria;
import com.bugabulls.vista.Login;
import com.bugabulls.vista.MenuEntrenador;
import com.bugabulls.vista.ModificarSesiones;
import com.bugabulls.vista.PlantillasEntrenador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManejadorMenuEntrenador implements ActionListener{
    int entrenadorLogeado;
    MenuEntrenador me;
    
    public ManejadorMenuEntrenador(MenuEntrenador me,int entrenadorLogeado){
        this.entrenadorLogeado=entrenadorLogeado;
		this.me = me;
	}
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(me.jmiPlantillas)){		    
		    PlantillasEntrenador pe= new PlantillasEntrenador(me,entrenadorLogeado);
		    pe.setVisible(true);
		}
        
        if(e.getSource().equals(me.jmiCrearSesiones)){		    
		    CrearSesiones cs= new CrearSesiones(me,entrenadorLogeado);
		    cs.setVisible(true);
		}
        if(e.getSource().equals(me.jmiModificarSesiones)){		    
		    ModificarSesiones ms= new ModificarSesiones(me,entrenadorLogeado);
		    ms.setVisible(true);
		}
        
        if(e.getSource().equals(me.jmiCambiar)){
            me.setVisible(false);
		    CambioContraseña cc= new CambioContraseña(null,entrenadorLogeado);
		    cc.setVisible(true);
		}
        
       
        if(e.getSource().equals(me.jmiManual)){	
            ManualUsuario mu= new ManualUsuario();		   
		}
        
        if(e.getSource().equals(me.jbCerrarSesion)){
                    Login lg = new Login();
                    lg.setVisible(true);
                    me.setVisible(false);
		}
    }
    
}
