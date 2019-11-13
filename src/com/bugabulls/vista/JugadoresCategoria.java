package com.bugabulls.vista;
import com.bugabulls.controlador.DAOFactory;
import com.bugabulls.modelo.Jugador;
import com.bugabulls.modelo.Plantilla;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;

public class JugadoresCategoria extends JDialog implements ItemListener{
	    public JComboBox jcBenjamines;
	    public JComboBox jcPreBenjamines;
	    public JComboBox jcMinis;
	    public JComboBox jcInfantiles;
	    public JComboBox jcJunior;
            public int contadorPre=0, contadorBen=0, contadorMini=0,contadorInf=0,contadorJun=0;
            public PlantillaBenjamines pb;
            public PlantillaPreBenjamines pp;
            public PlantillaMinis pm;
            public PlantillaInfantiles pi;
            public PlantillaJunior pj;
            
           
	    

	public JugadoresCategoria(MenuAdministrador ma) {
                setModal(true);
		setBounds(100, 100, 606, 448);
		getContentPane().setLayout(null);
                setResizable(false);
		setLocationRelativeTo(null);                
                crearGui();
                pb= new PlantillaBenjamines(ma);
                pp= new PlantillaPreBenjamines(ma);
                pm= new PlantillaMinis(ma);
                pi= new PlantillaInfantiles(ma);
                pj= new PlantillaJunior(ma);
                
        }
		public void crearGui(){
		JLabel jlTitulo = new JLabel("Jugadores por categor\u00EDa");
		jlTitulo.setFont(new Font("Simplified Arabic", Font.BOLD, 18));
		jlTitulo.setForeground(new Color(255, 255, 255));
		jlTitulo.setOpaque(true);
		jlTitulo.setBackground(new Color(128, 128, 0));
		jlTitulo.setBounds(0, 0, 590, 56);
		getContentPane().add(jlTitulo);
		
		JLabel jlTitulo1 = new JLabel("Cantidad de jugadores");
		jlTitulo1.setFont(new Font("Simplified Arabic", Font.BOLD, 17));
		jlTitulo1.setBackground(new Color(95, 158, 160));
		jlTitulo1.setOpaque(true);
		jlTitulo1.setBounds(21, 64, 559, 35);
		getContentPane().add(jlTitulo1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(32, 178, 170), null, null, null));
		panel.setBounds(21, 110, 559, 280);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		jcBenjamines = new JComboBox();
		jcBenjamines.setFont(new Font("Lucida Sans", Font.BOLD, 13));				
		jcBenjamines.setBorder(null);
		jcBenjamines.setBounds(45, 22, 471, 36);
		panel.add(jcBenjamines);
		
		jcPreBenjamines = new JComboBox();
		jcPreBenjamines.setBorder(null);
		jcPreBenjamines.setFont(new Font("Lucida Sans", Font.BOLD, 13));		
		jcPreBenjamines.setBounds(45, 69, 471, 36);
		panel.add(jcPreBenjamines);
		
		jcMinis = new JComboBox();
		jcMinis.setBorder(null);
		jcMinis.setFont(new Font("Lucida Sans", Font.BOLD, 13));		
		jcMinis.setBounds(45, 116, 471, 36);
		panel.add(jcMinis);
		
		jcInfantiles = new JComboBox();
		jcInfantiles.setBorder(null);
		jcInfantiles.setFont(new Font("Lucida Sans", Font.BOLD, 13));		
		jcInfantiles.setBounds(45, 163, 471, 36);
		panel.add(jcInfantiles);		
		jcJunior =  new JComboBox();
		jcJunior.setBorder(null);
		jcJunior.setFont(new Font("Lucida Sans", Font.BOLD, 13));		
		jcJunior.setBounds(45, 210, 471, 36);
		panel.add(jcJunior);
                llenarJugador();                
                jcBenjamines.addItem("Benjamines                       "+contadorBen+"  jugadores");
                jcPreBenjamines.addItem("Pre Benjamines                 "+contadorPre+" jugadores");
                jcMinis.addItem("Minis                                  "+contadorMini+" jugadores");
                jcInfantiles.addItem("Infantiles                           "+contadorInf+" jugadores");
                jcJunior.addItem("Junior                                 "+contadorJun+" jugadores");
                jcBenjamines.setSelectedIndex(contadorBen);
                jcPreBenjamines.setSelectedIndex(contadorPre);
                jcMinis.setSelectedIndex(contadorMini);
                jcJunior.setSelectedIndex(contadorJun);
                jcInfantiles.setSelectedIndex(contadorInf);  
                jcBenjamines.addItemListener(this); 
                jcPreBenjamines.addItemListener(this);
                jcMinis.addItemListener(this);
                jcInfantiles.addItemListener(this);
                jcJunior.addItemListener(this);
                
                
                
	}
                
                 public void llenarJugador(){
                    try {
                        List<Jugador> listaJugador=DAOFactory.getJugadorDAO().consultar();
                        for (Jugador jugador : listaJugador) {
                            if(jugador.getCodigocategoria().getCodigocategoria()==1){
                            contadorPre++;
                            jcPreBenjamines.addItem(jugador.getCodigojugador()+" - "+jugador.getNombre()+" "+jugador.getApellido());
                            }
                            if(jugador.getCodigocategoria().getCodigocategoria()==2){
                            contadorBen++;
                            jcBenjamines.addItem(jugador.getCodigojugador()+" - "+jugador.getNombre()+" "+jugador.getApellido());
                            }
                             if(jugador.getCodigocategoria().getCodigocategoria()==3){
                            contadorMini++;
                            jcMinis.addItem(jugador.getCodigojugador()+" - "+jugador.getNombre()+" "+jugador.getApellido());
                            }
                            if(jugador.getCodigocategoria().getCodigocategoria()==4){
                            contadorInf++;
                            jcInfantiles.addItem(jugador.getCodigojugador()+" - "+jugador.getNombre()+" "+jugador.getApellido());
                            }
                            if(jugador.getCodigocategoria().getCodigocategoria()==5){
                            contadorJun++;
                            jcJunior.addItem(jugador.getCodigojugador()+" - "+jugador.getNombre()+" "+jugador.getApellido());
                            }
                             
                            
                        }
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }

    @Override
    public void itemStateChanged(ItemEvent e) {
      try { 
     if (e.getStateChange() == ItemEvent.SELECTED) {
     if (e.getSource()==jcBenjamines) {        
            String seleccionado=(String)jcBenjamines.getSelectedItem();  
            pb.llenarPlantilla(Integer.parseInt(seleccionado.substring(0,5)));            
           pb.setVisible(true);
           }   
                 
      if (e.getSource()==jcPreBenjamines) {          
           String seleccionado=(String)jcPreBenjamines.getSelectedItem();             
           pp.llenarPlantilla(Integer.parseInt(seleccionado.substring(0,5)));            
           pp.setVisible(true); 
           
        }
       if (e.getSource()==jcMinis) {        
           String seleccionado=(String)jcMinis.getSelectedItem();                     
           pm.llenarPlantilla(Integer.parseInt(seleccionado.substring(0,5)));            
           pm.setVisible(true);
          
       }
        if (e.getSource()==jcInfantiles) {        
           String seleccionado=(String)jcInfantiles.getSelectedItem(); 
           pi.llenarPlantilla(Integer.parseInt(seleccionado.substring(0,5)));            
           pi.setVisible(true); 
           
        }
         if (e.getSource()==jcJunior) {     
           String seleccionado=(String)jcJunior.getSelectedItem();  
           pj.llenarPlantilla(Integer.parseInt(seleccionado.substring(0,5)));            
           pj.setVisible(true); 
           
        }
     }
     
    }
      catch (NumberFormatException  ex) {
}
    
    }
    
    
    }  
