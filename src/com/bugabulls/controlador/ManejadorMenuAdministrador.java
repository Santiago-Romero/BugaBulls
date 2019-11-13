package com.bugabulls.controlador;


import com.bugabulls.vista.ConsultarSesiones;
import com.bugabulls.vista.AsignarCategoriaBen;
import com.bugabulls.vista.AsignarCategoriaIn;
import com.bugabulls.vista.AsignarCategoriaJunior;
import com.bugabulls.vista.AsignarCategoriaMini;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.bugabulls.vista.MenuAdministrador;
import com.bugabulls.vista.RegistrarAdministrador;
import com.bugabulls.vista.RegistrarEntrenador;
import com.bugabulls.vista.RegistrarJugador;
import com.bugabulls.vista.AsignarCategoriaPre;
import com.bugabulls.vista.CambioContraseña;
import com.bugabulls.vista.ConsultarEventos;
import com.bugabulls.vista.CopiasSeguridad;
import com.bugabulls.vista.CrearEventos;
import com.bugabulls.vista.EliminarAdministrador;
import com.bugabulls.vista.EliminarJugador;
import com.bugabulls.vista.ModificarAdministrador;
import com.bugabulls.vista.ModificarEntrenador;
import com.bugabulls.vista.ModificarJugador;
import com.bugabulls.vista.ReciboDePago;
import com.bugabulls.vista.EliminarEntrenador;
import com.bugabulls.vista.JugadoresCategoria;
import com.bugabulls.vista.Login;
import com.bugabulls.vista.PlantillaBenjamines;
import com.bugabulls.vista.PlantillaInfantiles;
import com.bugabulls.vista.PlantillaJunior;
import com.bugabulls.vista.PlantillaMinis;
import com.bugabulls.vista.PlantillaPreBenjamines;


public class ManejadorMenuAdministrador implements ActionListener{

	MenuAdministrador ma;
	int administradorLogeado;
	public ManejadorMenuAdministrador(MenuAdministrador ma,int administradorLogeado){
            this.administradorLogeado=administradorLogeado;
		this.ma = ma;
	}	
	

	@Override
	public void actionPerformed(ActionEvent ae) {		
		if(ae.getSource().equals(ma.jmiRegistrarJugador)){		    
		    RegistrarJugador rj= new RegistrarJugador(ma);
		    rj.setVisible(true);
		}
                if(ae.getSource().equals(ma.jmiRegistrarEntrenador)){		    
		    RegistrarEntrenador re= new RegistrarEntrenador(ma);
		    re.setVisible(true);
		}
                if(ae.getSource().equals(ma.jmiRegistrarAdministrador)){		    
		    RegistrarAdministrador ra= new RegistrarAdministrador(ma);
		    ra.setVisible(true);
		}
                if(ae.getSource().equals(ma.jmiModificarJugador)){
                    ModificarJugador mj= new ModificarJugador(ma);
		    mj.setVisible(true);
		}
                if(ae.getSource().equals(ma.jmiModificarEntrenador)){
                    ModificarEntrenador me= new ModificarEntrenador(ma);
		    me.setVisible(true);
		}
                if(ae.getSource().equals(ma.jmiModificarAdministrador)){
                    ModificarAdministrador mad= new ModificarAdministrador(ma);
		    mad.setVisible(true);
		}
                if(ae.getSource().equals(ma.jmiEliminarJugador)){
                    EliminarJugador ej= new EliminarJugador(ma);
		    ej.setVisible(true);
		}
                if(ae.getSource().equals(ma.jmiEliminarEntrenador)){
                    EliminarEntrenador ee= new EliminarEntrenador(ma);
		    ee.setVisible(true);
		}
                if(ae.getSource().equals(ma.jmiEliminarAdministrador)){
                    EliminarAdministrador ea= new EliminarAdministrador(ma);
		    ea.setVisible(true);
		}
                if(ae.getSource().equals(ma.jmiPagarMensualidad)){
                    ReciboDePago rp= new ReciboDePago(ma,administradorLogeado);
		    rp.setVisible(true);
		}
                if(ae.getSource().equals(ma.jmiPreBenjamines)){
                    PlantillaPreBenjamines pp=new PlantillaPreBenjamines(ma);
                    pp.setVisible(true);
		}
                if(ae.getSource().equals(ma.jmiBenjamines)){
                    PlantillaBenjamines pb=new PlantillaBenjamines(ma);
                    pb.setVisible(true);
		}
                if(ae.getSource().equals(ma.jmiMinis)){
                    PlantillaMinis pm=new PlantillaMinis(ma);
                    pm.setVisible(true);
		}
                if(ae.getSource().equals(ma.jmiInfantiles)){
                    PlantillaInfantiles pi=new PlantillaInfantiles(ma);
                    pi.setVisible(true);
		}
                if(ae.getSource().equals(ma.jmiJunior)){
                    PlantillaJunior pj=new PlantillaJunior(ma);
                    pj.setVisible(true);
		}                
                if(ae.getSource().equals(ma.jmiCrearEventos)){
                    CrearEventos ce= new CrearEventos(ma);
		    ce.setVisible(true);
		}
                if(ae.getSource().equals(ma.jmiConsultarEventos)){
                    ConsultarEventos ce= new ConsultarEventos();
		    ce.setVisible(true);
		}
                if(ae.getSource().equals(ma.jmiAsignarPre)){
                    AsignarCategoriaPre acp= new AsignarCategoriaPre(ma);
		    acp.setVisible(true);
		}
                if(ae.getSource().equals(ma.jmiAsignarBen)){
                    AsignarCategoriaBen acb= new AsignarCategoriaBen(ma);
		    acb.setVisible(true);
		}
                if(ae.getSource().equals(ma.jmiAsignarMin)){
                    AsignarCategoriaMini acm= new AsignarCategoriaMini(ma);
		    acm.setVisible(true);
		}
                if(ae.getSource().equals(ma.jmiAsignarInfantiles)){
                    AsignarCategoriaIn aci= new AsignarCategoriaIn(ma);
		    aci.setVisible(true);
		}
                if(ae.getSource().equals(ma.jmiAsignarJunior)){
                    AsignarCategoriaJunior acj= new AsignarCategoriaJunior(ma);
		    acj.setVisible(true);
		}
                 if(ae.getSource().equals(ma.jmiJugadorCategoria)){
                  JugadoresCategoria jc=new JugadoresCategoria(ma);
                  jc.setVisible(true);
		}
                if(ae.getSource().equals(ma.jmiConsultarSesiones)){
                    ConsultarSesiones cs=new ConsultarSesiones();
                    cs.setVisible(true);
		}
                 if(ae.getSource().equals(ma.jmiCopias)){
                    CopiasSeguridad csd= new CopiasSeguridad();
                    csd.setVisible(true);                    
		}
                
                if(ae.getSource().equals(ma.jmiCambiar)){
                    ma.setVisible(false);
                    CambioContraseña cc= new CambioContraseña(null,administradorLogeado);
                    cc.setVisible(true);                    
		}
                
                
                if(ae.getSource().equals(ma.jmiManual)){
                 ManualUsuario mu= new ManualUsuario();                
                
                    
		}
                if(ae.getSource().equals(ma.jbCerrarSesion)){
                    Login lg = new Login();
                    lg.setVisible(true);
                    ma.setVisible(false);
		}
                
               
                
                	}
}
