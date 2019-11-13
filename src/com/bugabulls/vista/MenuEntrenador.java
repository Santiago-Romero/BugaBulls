package com.bugabulls.vista;

import com.bugabulls.controlador.DAOFactory;
import com.bugabulls.controlador.ManejadorMenuEntrenador;
import com.bugabulls.modelo.Entrenador;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Dimension;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import java.awt.ComponentOrientation;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

public class MenuEntrenador extends JFrame {
	public JMenuItem jmiPlantillas,jmiCrearSesiones,jmiModificarSesiones;        
        public JMenuItem jmiCambiar;
        public JMenuItem jmiManual;
        public JMenuItem jmiCantidadJugadores;
        int entrenadorLogeado;
        public JLabel jlNombreEntrenador,jlCodigoEntrenador;
        public JButton jbCerrarSesion;
	
	public MenuEntrenador(Login lg,int entrenadorLogeado) {
            this.entrenadorLogeado=entrenadorLogeado;
            setResizable(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 830,600);
		getContentPane().setLayout(null);
		crearGui();
	}
		
		public void crearGui(){
		JPanel panel = new JPanel();
		panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel.setBounds(0, 0, 834, 662);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel jlLogo = new JLabel("");
		jlLogo.setBounds(10, 0, 223, 123);		
		ImageIcon logo= new ImageIcon(this.getClass().getResource("/com/bugabulls/imagen/logoEscuela.png"));
		Icon iconoLogo = new ImageIcon(logo.getImage().getScaledInstance(jlLogo.getWidth(), jlLogo.getHeight(),Image.SCALE_DEFAULT));
		jlLogo.setIcon(iconoLogo);
		this.repaint();		
		panel.add(jlLogo);
                
                jlNombreEntrenador = new JLabel("");
                jlNombreEntrenador.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlNombreEntrenador.setBounds(500, 0, 523, 123);	
		panel.add(jlNombreEntrenador);
                
                jlCodigoEntrenador = new JLabel("");
                jlCodigoEntrenador.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlCodigoEntrenador.setBounds(500, 22, 223, 123);	
		panel.add(jlCodigoEntrenador);
                
                jbCerrarSesion=new JButton("Cerrar Sesión");
                jbCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 16));
                jbCerrarSesion.setBounds(610, 70, 145, 25);
                jbCerrarSesion.setBackground(new Color(220, 220, 220));
                panel.add(jbCerrarSesion);
		
		JLabel label = new JLabel("");
		label.setOpaque(true);
		label.setBackground(Color.LIGHT_GRAY);
		label.setBounds(0, 0, 833, 120);
		panel.add(label);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 120, 933, 68);
		panel.add(menuBar);
		
		JMenu jmPlantilla = new JMenu("Plantilla");
		jmPlantilla.setInheritsPopupMenu(true);
		jmPlantilla.setDelay(5);
		jmPlantilla.setMinimumSize(new Dimension(0, 50));
		jmPlantilla.setContentAreaFilled(false);
		jmPlantilla.setHorizontalAlignment(SwingConstants.CENTER);
		jmPlantilla.setHorizontalTextPosition(SwingConstants.CENTER);
		jmPlantilla.setPreferredSize(new Dimension(425, 600));
		jmPlantilla.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		jmPlantilla.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, null, null));
		jmPlantilla.setForeground(new Color(255, 255, 255));
		jmPlantilla.setBackground(new Color(128, 128, 0));
		jmPlantilla.setOpaque(true);		
		menuBar.add(jmPlantilla);
		
		jmiPlantillas = new JMenuItem("Plantillas");
		jmiPlantillas.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 17));
		jmiPlantillas.setPreferredSize(new Dimension(170, 40));
		jmiPlantillas.setBorder(new EmptyBorder(0, 0, 0, 0));
		jmiPlantillas.setBackground(new Color(128, 128, 0));
		jmiPlantillas.setForeground(new Color(255, 255, 255));
		jmiPlantillas.setOpaque(true);
		jmPlantilla.add(jmiPlantillas);
                                
		
		JMenu jmSesiones = new JMenu("Sesiones");
		jmSesiones.setMinimumSize(new Dimension(0, 50));
		jmSesiones.setContentAreaFilled(false);
		jmSesiones.setHorizontalAlignment(SwingConstants.CENTER);
		jmSesiones.setHorizontalTextPosition(SwingConstants.CENTER);
		jmSesiones.setPreferredSize(new Dimension(425, 600));
		jmSesiones.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		jmSesiones.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, null, null));
		jmSesiones.setForeground(new Color(255, 255, 255));
		jmSesiones.setBackground(new Color(128, 128, 0));
		jmSesiones.setOpaque(true);
		menuBar.add(jmSesiones);
		
		jmiCrearSesiones = new JMenuItem("Crear Sesiones");
		jmiCrearSesiones.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		jmiCrearSesiones.setPreferredSize(new Dimension(170, 40));
		jmiCrearSesiones.setBorder(new EmptyBorder(0, 0, 0, 0));
		jmiCrearSesiones.setBackground(new Color(128, 128, 0));
		jmiCrearSesiones.setForeground(new Color(255, 255, 255));
		jmiCrearSesiones.setOpaque(true);
		jmSesiones.add(jmiCrearSesiones);
		
		jmiModificarSesiones = new JMenuItem("Modificar Sesiones");
		jmiModificarSesiones.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		jmiModificarSesiones.setPreferredSize(new Dimension(101, 35));
		jmiModificarSesiones.setBorder(new EmptyBorder(0, 0, 0, 0));
		jmiModificarSesiones.setBackground(new Color(128, 128, 0));
		jmiModificarSesiones.setForeground(new Color(255, 255, 255));
		jmiModificarSesiones.setOpaque(true);
		jmSesiones.add(jmiModificarSesiones);
                
                JMenu jmConfiguracion = new JMenu("Configuración");
		jmConfiguracion.setMinimumSize(new Dimension(0, 50));
		jmConfiguracion.setContentAreaFilled(false);
		jmConfiguracion.setHorizontalAlignment(SwingConstants.CENTER);
		jmConfiguracion.setHorizontalTextPosition(SwingConstants.CENTER);
		jmConfiguracion.setPreferredSize(new Dimension(425, 600));
		jmConfiguracion.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		jmConfiguracion.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, null, null));
		jmConfiguracion.setForeground(new Color(255, 255, 255));
		jmConfiguracion.setBackground(new Color(128, 128, 0));
		jmConfiguracion.setOpaque(true);
		menuBar.add(jmConfiguracion);
                
		jmiCambiar = new JMenuItem("Cambiar Contraseña");
		jmiCambiar.setForeground(new Color(255, 255, 255));
		jmiCambiar.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jmiCambiar.setPreferredSize(new Dimension(180, 35));
		jmiCambiar.setBackground(new Color(128, 128, 0));
		jmiCambiar.setOpaque(true);
		jmConfiguracion.add(jmiCambiar);
		
		JMenu jmAyuda = new JMenu("Ayuda");
		jmAyuda.setForeground(new Color(255, 255, 255));
		jmAyuda.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jmAyuda.setPreferredSize(new Dimension(180, 35));
		jmAyuda.setBackground(new Color(128, 128, 0));
		jmAyuda.setOpaque(true);
		jmConfiguracion.add(jmAyuda);
		
		jmiManual = new JMenuItem("Manual");
		jmiManual.setForeground(new Color(255, 255, 255));
		jmiManual.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jmiManual.setPreferredSize(new Dimension(180, 35));
		jmiManual.setBackground(new Color(128, 128, 0));
		jmiManual.setOpaque(true);
		jmAyuda.add(jmiManual);
		
		JLabel jlBaloncesto = new JLabel("");
		jlBaloncesto.setBounds(0, 179, 833, 483);
		ImageIcon baloncesto= new ImageIcon(this.getClass().getResource("/com/bugabulls/imagen/baloncesto2.jpg"));
		Icon iconoBaloncesto = new ImageIcon(baloncesto.getImage().getScaledInstance(jlBaloncesto.getWidth(), jlBaloncesto.getHeight(),Image.SCALE_DEFAULT));
		jlBaloncesto.setIcon(iconoBaloncesto);
		this.repaint();
		panel.add(jlBaloncesto);
		setLocationRelativeTo(null);
                llenarInicio();
                ManejadorMenuEntrenador me = new ManejadorMenuEntrenador(this,entrenadorLogeado);
                jmiPlantillas.addActionListener(me);
                jmiCrearSesiones.addActionListener(me);
                jmiModificarSesiones.addActionListener(me);
                jmiCambiar.addActionListener(me);
                jmiManual.addActionListener(me);                               
                jbCerrarSesion.addActionListener(me);
                
              
	}
                
        public void llenarInicio(){
        try {
            Entrenador entrenador=DAOFactory.getEntrenadorDAO().consultarPorId(entrenadorLogeado);
                jlNombreEntrenador.setText("Entrenador: "+entrenador.getNombre()+" "+entrenador.getApellido());
                jlCodigoEntrenador.setText("Codigo: "+entrenador.getCodigoentrenador().toString());
        } catch (Exception ex) {
            Logger.getLogger(MenuEntrenador.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
}
