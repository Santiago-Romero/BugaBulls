package com.bugabulls.vista;


import com.bugabulls.controlador.DAOFactory;
import com.bugabulls.modelo.Jugador;
import com.bugabulls.modelo.Plantilla;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class PlantillaBenjamines extends JDialog {
	public JTextField jtNombre;
	public JTextField jtEps;
	public JTextField jtFechaNacimiento;
	public JTextField jtAltura;
	public JTextField jtPeso;
	public JTextField jtImc;
	public JTextField jtPosicion;
	public JTextField jtSuicidio;
	public JTextField jtPorcentajeCestas;
	public JTextField jtVueltasCancha;
        public JTextArea jaObservaciones;
        public JComboBox jcJugadores;
        public JButton jbBuscar;
        public int contador=0;
        private JLabel jlerror;
        private JLabel jlFotoPerfil;

	public PlantillaBenjamines(MenuAdministrador ma) {
            setModal(true);
		setBounds(0, 0, 647, 650);
		getContentPane().setLayout(null);
                setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		crearGui();
	}
		
	    public void crearGui(){
	    	JScrollPane scrollPane = new JScrollPane();
			scrollPane.setAutoscrolls(true);
			scrollPane.setPreferredSize(new Dimension(642, 655));
			scrollPane.setInheritsPopupMenu(true);
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(0, 0, 641, 620);
			getContentPane().add(scrollPane);  
			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel.setPreferredSize(new Dimension(645, 750));
			scrollPane.setViewportView(panel);
			panel.setLayout(null);	
			
			
			
		
		JPanel panelDatosPersonales = new JPanel();
		panelDatosPersonales.setLayout(null);
		panelDatosPersonales.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelDatosPersonales.setBounds(38, 167, 565, 210);
		panel.add(panelDatosPersonales);
		
		
		jlFotoPerfil = new JLabel("");
		jlFotoPerfil.setBounds(10, 21, 186, 177);
		ImageIcon fotoPerfil= new ImageIcon(this.getClass().getResource("/com/bugabulls/imagen/fotoPerfil.png"));
		Icon iconoPerfil = new ImageIcon(fotoPerfil.getImage().getScaledInstance(jlFotoPerfil.getWidth(), jlFotoPerfil.getHeight(),Image.SCALE_DEFAULT));
		this.repaint();			
		jlFotoPerfil.setIcon(iconoPerfil);
		panelDatosPersonales.add(jlFotoPerfil);
		
		JLabel jlNombre = new JLabel("Nombre Completo:");
		jlNombre.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jlNombre.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlNombre.setBounds(221, 21, 334, 35);
		panelDatosPersonales.add(jlNombre);
		
		JLabel jlEps = new JLabel("Eps:");
		jlEps.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		jlEps.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlEps.setBounds(219, 55, 336, 35);
		panelDatosPersonales.add(jlEps);
		
		JLabel jlFechaNacimiento = new JLabel("Fecha Nacimiento:");
		jlFechaNacimiento.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		jlFechaNacimiento.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlFechaNacimiento.setBounds(219, 89, 336, 35);
		panelDatosPersonales.add(jlFechaNacimiento);
		
		JLabel jlAltura = new JLabel("Altura:");
		jlAltura.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		jlAltura.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlAltura.setBounds(221, 123, 336, 35);
		panelDatosPersonales.add(jlAltura);
		
		JLabel jlPeso = new JLabel("Peso:");
		jlPeso.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		jlPeso.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlPeso.setBounds(221, 157, 336, 35);
		panelDatosPersonales.add(jlPeso);
		
		jtNombre = new JTextField();
		jtNombre.setEditable(false);
		jtNombre.setBorder(new EmptyBorder(0, 0, 0, 0));
		jtNombre.setBackground(UIManager.getColor("Button.background"));
		jtNombre.setBounds(350, 25, 205, 27);
		panelDatosPersonales.add(jtNombre);
		jtNombre.setColumns(10);
		
		jtEps = new JTextField();
		jtEps.setEditable(false);
		jtEps.setColumns(10);
		jtEps.setBorder(new EmptyBorder(0, 0, 0, 0));
		jtEps.setBackground(SystemColor.menu);
		jtEps.setBounds(247, 59, 255, 27);
		panelDatosPersonales.add(jtEps);
		
		jtFechaNacimiento = new JTextField();
		jtFechaNacimiento.setEditable(false);
		jtFechaNacimiento.setColumns(10);
		jtFechaNacimiento.setBorder(new EmptyBorder(0, 0, 0, 0));
		jtFechaNacimiento.setBackground(SystemColor.menu);
		jtFechaNacimiento.setBounds(332, 93, 205, 27);
		panelDatosPersonales.add(jtFechaNacimiento);
		
		jtAltura = new JTextField();
		jtAltura.setEditable(false);
		jtAltura.setColumns(10);
		jtAltura.setBorder(new EmptyBorder(0, 0, 0, 0));
		jtAltura.setBackground(SystemColor.menu);
		jtAltura.setBounds(265, 127, 63, 27);
		panelDatosPersonales.add(jtAltura);
		
		JLabel jlCm = new JLabel("cm");
		jlCm.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jlCm.setBounds(332, 129, 46, 23);
		panelDatosPersonales.add(jlCm);
		
		jtPeso = new JTextField();
		jtPeso.setEditable(false);
		jtPeso.setColumns(10);
		jtPeso.setBorder(new EmptyBorder(0, 0, 0, 0));
		jtPeso.setBackground(SystemColor.menu);
		jtPeso.setBounds(261, 162, 205, 27);
		panelDatosPersonales.add(jtPeso);
		
		JLabel jlDatosDeportivos = new JLabel("Datos Deportivos");
		jlDatosDeportivos.setOpaque(true);
		jlDatosDeportivos.setForeground(Color.BLACK);
		jlDatosDeportivos.setFont(new Font("Simplified Arabic", Font.BOLD, 17));
		jlDatosDeportivos.setBackground(new Color(95, 158, 160));
		jlDatosDeportivos.setBounds(38, 388, 570, 37);
		panel.add(jlDatosDeportivos);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_2.setBounds(43, 448, 565, 196);
		panel.add(panel_2);
		
		JLabel jlImc = new JLabel("Indice masa corporal (IMC):");
		jlImc.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jlImc.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlImc.setBounds(0, 0, 565, 35);
		panel_2.add(jlImc);
		
		JLabel jlPosicion = new JLabel("Posici\u00F3n:");
		jlPosicion.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jlPosicion.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlPosicion.setBounds(0, 34, 565, 34);
		panel_2.add(jlPosicion);
		
		JLabel jlTiempoSuicidio = new JLabel("Tiempo de ejecuci\u00F3n ejercicio \"suicidios\":");
		jlTiempoSuicidio.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jlTiempoSuicidio.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlTiempoSuicidio.setBounds(0, 67, 565, 34);
		panel_2.add(jlTiempoSuicidio);
		
		JLabel jlPorcentajeCestas = new JLabel("Porcentaje acierto cestas:");
		jlPorcentajeCestas.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jlPorcentajeCestas.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlPorcentajeCestas.setBounds(0, 100, 565, 34);
		panel_2.add(jlPorcentajeCestas);
		
		JLabel jlVueltasCancha = new JLabel("Vueltas a la cancha:");
		jlVueltasCancha.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jlVueltasCancha.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlVueltasCancha.setBounds(0, 133, 565, 34);
		panel_2.add(jlVueltasCancha);
		
		JLabel jlObservaciones = new JLabel("Observaciones:");
		jlObservaciones.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jlObservaciones.setBounds(0, 171, 128, 25);
		panel_2.add(jlObservaciones);
		
		jtImc = new JTextField();
		jtImc.setEditable(false);
		jtImc.setColumns(10);
		jtImc.setBorder(new EmptyBorder(0, 0, 0, 0));
		jtImc.setBackground(SystemColor.menu);
		jtImc.setBounds(171, 5, 205, 27);
		panel_2.add(jtImc);
		
		jtPosicion = new JTextField();
		jtPosicion.setEditable(false);
		jtPosicion.setColumns(10);
		jtPosicion.setBorder(new EmptyBorder(0, 0, 0, 0));
		jtPosicion.setBackground(SystemColor.menu);
		jtPosicion.setBounds(58, 38, 205, 27);
		panel_2.add(jtPosicion);
		
		jtSuicidio = new JTextField();
		jtSuicidio.setEditable(false);
		jtSuicidio.setColumns(10);
		jtSuicidio.setBorder(new EmptyBorder(0, 0, 0, 0));
		jtSuicidio.setBackground(SystemColor.menu);
		jtSuicidio.setBounds(250, 71, 205, 27);
		panel_2.add(jtSuicidio);
		
		jtPorcentajeCestas = new JTextField();
		jtPorcentajeCestas.setEditable(false);
		jtPorcentajeCestas.setColumns(10);
		jtPorcentajeCestas.setBorder(new EmptyBorder(0, 0, 0, 0));
		jtPorcentajeCestas.setBackground(SystemColor.menu);
		jtPorcentajeCestas.setBounds(159, 104, 205, 27);
		panel_2.add(jtPorcentajeCestas);
		
		jtVueltasCancha = new JTextField();
		jtVueltasCancha.setEditable(false);
		jtVueltasCancha.setColumns(10);
		jtVueltasCancha.setBorder(new EmptyBorder(0, 0, 0, 0));
		jtVueltasCancha.setBackground(SystemColor.menu);
		jtVueltasCancha.setBounds(124, 136, 205, 27);
		panel_2.add(jtVueltasCancha);
		
		
		JLabel jlTitulo = new JLabel("Plantilla Benjamines");
		jlTitulo.setBounds(0, 0, 642, 44);
		panel.add(jlTitulo);
		jlTitulo.setOpaque(true);
		jlTitulo.setForeground(Color.WHITE);
		jlTitulo.setFont(new Font("Simplified Arabic", Font.BOLD, 18));
		jlTitulo.setBackground(new Color(128, 128, 0));
		
		jcJugadores = new JComboBox();
		jcJugadores.setBounds(60, 63, 250, 27);
		panel.add(jcJugadores);
		
		jbBuscar = new JButton("Buscar");
		jbBuscar.setBounds(374, 63, 111, 27);
		panel.add(jbBuscar);
		jbBuscar.setFont(new Font("SansSerif", Font.PLAIN, 14));
		jbBuscar.setBackground(new Color(95, 158, 160));
		
		JLabel jlTitutoDatosPersonales = new JLabel("Datos Personales");
		jlTitutoDatosPersonales.setBounds(33, 125, 570, 37);
		panel.add(jlTitutoDatosPersonales);
		jlTitutoDatosPersonales.setOpaque(true);
		jlTitutoDatosPersonales.setForeground(Color.BLACK);
		jlTitutoDatosPersonales.setFont(new Font("Simplified Arabic", Font.BOLD, 17));
		jlTitutoDatosPersonales.setBackground(new Color(95, 158, 160));
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(43, 648, 565, 84);
		panel.add(scrollPane1);
                
                jlerror = new JLabel("");                
                jlerror.setForeground(new Color(255, 0, 0));
		jlerror.setFont(new Font("Tahoma", Font.PLAIN, 16));
                jlerror.setBounds(53, 98, 313, 27);		
		panel.add(jlerror);
		
		jaObservaciones = new JTextArea();
		jaObservaciones.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(32, 178, 170), null, null, null));
		jaObservaciones.setEditable(false);
		scrollPane1.setViewportView(jaObservaciones);
                llenarJugador();
                sinPlantilla();
                jbBuscar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				llenarPlantilla(Integer.parseInt(jcJugadores.getSelectedItem().toString().substring(0,5)));
				}
		});
	}
            public void llenarJugador(){
                    try {
                        List<Jugador> listaJugador=DAOFactory.getJugadorDAO().consultar();
                        for (Jugador jugador : listaJugador) {
                            if(jugador.getCodigocategoria().getCodigocategoria()==2){
                                  contador++;
                                jcJugadores.addItem(jugador.getCodigojugador()+" - "+jugador.getNombre());
                            }
                        }
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
            
            public void llenarPlantilla(int jugadorSeleccionado){
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            int encoPlan=0;
            try {               
                List<Plantilla> listaPlantillas=DAOFactory.getPlantillaDAO().consultar();
            for (Plantilla plantilla : listaPlantillas) {
                if(jugadorSeleccionado==plantilla.getCodigojugador().getCodigojugador()){
                    contador++;
                    encoPlan++;
                    ponerFoto();
                    jlerror.setText("");
                    jtNombre.setText(plantilla.getCodigojugador().getNombre());
                    jtAltura.setText(plantilla.getCodigojugador().getAltura().toString());
                    jtEps.setText(plantilla.getCodigojugador().getEps());
                    jtFechaNacimiento.setText(formato.format(plantilla.getCodigojugador().getFechanacimiento()));
                    jtImc.setText(plantilla.getImc().toString());
                    jtPeso.setText(plantilla.getPeso().toString());
                    jtPosicion.setText(plantilla.getPosicion());
                    jtSuicidio.setText(plantilla.getTiemposuicidio().toString());
                    jtPorcentajeCestas.setText(plantilla.getPorcentajecestas().toString());
                    jtVueltasCancha.setText(plantilla.getVueltascancha().toString());
                    jaObservaciones.setText(plantilla.getObservacion());
                }
            }
            if(encoPlan<1){
               jlerror.setText("El Jugador no tiene plantilla");
             datosSinPlantilla();
             jtImc.setText("");
             jtPeso.setText("");
             jtPosicion.setText("");
             jtSuicidio.setText("");
             jtPorcentajeCestas.setText("");
             jtVueltasCancha.setText("");
            jaObservaciones.setText("");
            }
        } catch (Exception ex) {
            Logger.getLogger(PlantillaJugador.class.getName()).log(Level.SEVERE, null, ex);
        }}
            
        public void sinPlantilla(){
        if(contador==0){
        jlerror.setText("El entrenador no ha realizado las plantillas");
        jbBuscar.setEnabled(false);
         }
        else{
        contador=0;
        }
        }
        
          public void ponerFoto(){        
        ImageIcon fotoPerfil= new ImageIcon (new ImageIcon(""+jcJugadores.getSelectedItem().toString().substring(0,5)+".jpg").getImage());
	Icon iconoPerfil = new ImageIcon(fotoPerfil.getImage().getScaledInstance(jlFotoPerfil.getWidth(), jlFotoPerfil.getHeight(),Image.SCALE_DEFAULT));
	jlFotoPerfil.setIcon(iconoPerfil);          
        }
        
        public void datosSinPlantilla(){
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {             
            List<Jugador> listaJugador=DAOFactory.getJugadorDAO().consultar();
            for(Jugador jugador : listaJugador){
                if(Integer.parseInt(jcJugadores.getSelectedItem().toString().substring(0,5))==jugador.getCodigojugador()){
                    jtNombre.setText(jugador.getNombre()+" "+jugador.getApellido());
                    jtAltura.setText(jugador.getAltura().toString());
                    jtEps.setText(jugador.getEps());
                    jtFechaNacimiento.setText(formato.format(jugador.getFechanacimiento()));  
                    ImageIcon fotoPerfil= new ImageIcon (new ImageIcon(""+jcJugadores.getSelectedItem().toString().substring(0,5)+".jpg").getImage());
	            Icon iconoPerfil = new ImageIcon(fotoPerfil.getImage().getScaledInstance(jlFotoPerfil.getWidth(),jlFotoPerfil.getHeight(),Image.SCALE_DEFAULT));
	            jlFotoPerfil.setIcon(iconoPerfil);
                }
            }}
        catch (Exception ex) {
            Logger.getLogger(PlantillaJugador.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
          
               
        
        
}

