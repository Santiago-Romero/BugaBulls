package com.bugabulls.vista;

import com.bugabulls.controlador.DAOFactory;
import com.bugabulls.controlador.ManejadorMenuJugador;
import com.bugabulls.modelo.Jugador;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JMenuItem;

public class MenuJugador extends JFrame {

	private JPanel panel;
        public JMenuItem jmiInfoPersonal,jmiMensualidad,jmiSesion,jmiEventos;       
        public JMenuItem jmiCambiar;
        public JMenuItem jmiManual;
        int jugadorLogeado;
        public JLabel jlNombreJugador,jlCodigoJugador;
        public JButton jbCerrarSesion;
        
	public MenuJugador(Login lg, int jugadorLogeado) {
                this.jugadorLogeado=jugadorLogeado;
                setResizable(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 920, 600);
		setLocationRelativeTo(null);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel jlLogo = new JLabel("");
		jlLogo.setBounds(38, 11, 223, 123);		
		ImageIcon logo= new ImageIcon(this.getClass().getResource("/com/bugabulls/imagen/logoEscuela.png"));
		Icon iconoLogo = new ImageIcon(logo.getImage().getScaledInstance(jlLogo.getWidth(), jlLogo.getHeight(),Image.SCALE_DEFAULT));
		jlLogo.setIcon(iconoLogo);
		this.repaint();		
		panel.add(jlLogo);
                
                jlNombreJugador = new JLabel("");
                jlNombreJugador.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlNombreJugador.setBounds(700, 0, 223, 123);	
		panel.add(jlNombreJugador);
                
                jlCodigoJugador = new JLabel("");
                jlCodigoJugador.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlCodigoJugador.setBounds(700, 22, 223, 123);	
		panel.add(jlCodigoJugador);
                
                jbCerrarSesion=new JButton("Cerrar Sesión");
                jbCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 16));
                jbCerrarSesion.setBounds(700, 95, 145, 25);
                jbCerrarSesion.setBackground(new Color(220, 220, 220));
                panel.add(jbCerrarSesion);
		
		JLabel jlTitulo = new JLabel("");
		jlTitulo.setBackground(Color.LIGHT_GRAY);
		jlTitulo.setOpaque(true);
		jlTitulo.setBounds(0, 0, 937, 150);
		panel.add(jlTitulo);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 140, 933, 68);
		panel.add(menuBar);
		
		JMenu jmInfoPersonal = new JMenu("Informacion Personal ");
		jmInfoPersonal.setInheritsPopupMenu(true);
		jmInfoPersonal.setDelay(5);
		jmInfoPersonal.setMinimumSize(new Dimension(0, 50));
		jmInfoPersonal.setContentAreaFilled(false);
		jmInfoPersonal.setHorizontalAlignment(SwingConstants.CENTER);
		jmInfoPersonal.setHorizontalTextPosition(SwingConstants.CENTER);
		jmInfoPersonal.setPreferredSize(new Dimension(300, 600));
		jmInfoPersonal.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
		jmInfoPersonal.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, null, null));
		jmInfoPersonal.setForeground(new Color(255, 255, 255));
		jmInfoPersonal.setBackground(new Color(128, 128, 0));
		jmInfoPersonal.setOpaque(true);		
		menuBar.add(jmInfoPersonal);
		
		jmiInfoPersonal = new JMenuItem("Plantilla");
		jmiInfoPersonal.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		jmiInfoPersonal.setPreferredSize(new Dimension(140, 40));
		jmiInfoPersonal.setBorder(new EmptyBorder(0, 0, 0, 0));
		jmiInfoPersonal.setBackground(new Color(128, 128, 0));
		jmiInfoPersonal.setForeground(new Color(255, 255, 255));
		jmiInfoPersonal.setOpaque(true);
		jmInfoPersonal.add(jmiInfoPersonal);
		
		JMenu jmMensualidad = new JMenu("Mensualidad");
		jmMensualidad.setMinimumSize(new Dimension(0, 50));
		jmMensualidad.setContentAreaFilled(false);
		jmMensualidad.setHorizontalAlignment(SwingConstants.CENTER);
		jmMensualidad.setHorizontalTextPosition(SwingConstants.CENTER);
		jmMensualidad.setPreferredSize(new Dimension(220, 600));
		jmMensualidad.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
		jmMensualidad.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, null, null));
		jmMensualidad.setForeground(new Color(255, 255, 255));
		jmMensualidad.setBackground(new Color(128, 128, 0));
		jmMensualidad.setOpaque(true);
		menuBar.add(jmMensualidad);
		
		jmiMensualidad = new JMenuItem("Fecha de cobro");
		jmiMensualidad.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		jmiMensualidad.setPreferredSize(new Dimension(125, 40));
		jmiMensualidad.setBorder(new EmptyBorder(0, 0, 0, 0));
		jmiMensualidad.setBackground(new Color(128, 128, 0));
		jmiMensualidad.setForeground(new Color(255, 255, 255));
		jmiMensualidad.setOpaque(true);
		jmMensualidad.add(jmiMensualidad);
		
				
		JMenu jmSesion = new JMenu(" Sesi\u00F3n");
		jmSesion.setMinimumSize(new Dimension(0, 50));
		jmSesion.setContentAreaFilled(false);
		jmSesion.setHorizontalAlignment(SwingConstants.CENTER);
		jmSesion.setHorizontalTextPosition(SwingConstants.CENTER);
		jmSesion.setPreferredSize(new Dimension(220, 600));
		jmSesion.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
		jmSesion.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, null, null));
		jmSesion.setForeground(new Color(255, 255, 255));
		jmSesion.setBackground(new Color(128, 128, 0));
		jmSesion.setOpaque(true);
		menuBar.add(jmSesion);
		
		jmiSesion = new JMenuItem("Mis Sesiones");
		jmiSesion.setPreferredSize(new Dimension(115, 40));
		jmiSesion.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		jmiSesion.setBackground(new Color(128, 128, 0));
		jmiSesion.setForeground(new Color(255, 255, 255));
		jmiSesion.setOpaque(true);
		jmSesion.add(jmiSesion);
		
		JMenu jmEventos = new JMenu("   Eventos");
		jmEventos.setMinimumSize(new Dimension(0, 50));
		jmEventos.setContentAreaFilled(false);
		jmEventos.setHorizontalAlignment(SwingConstants.CENTER);
		jmEventos.setHorizontalTextPosition(SwingConstants.CENTER);
		jmEventos.setPreferredSize(new Dimension(190, 600));
		jmEventos.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
		jmEventos.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, null, null));
		jmEventos.setForeground(new Color(255, 255, 255));
		jmEventos.setBackground(new Color(128, 128, 0));
		jmEventos.setOpaque(true);
		menuBar.add(jmEventos);	
		
		jmiEventos = new JMenuItem("Eventos");
		jmiEventos.setPreferredSize(new Dimension(105, 40));
		jmiEventos.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		jmiEventos.setBackground(new Color(128, 128, 0));
		jmiEventos.setForeground(new Color(255, 255, 255));
		jmiEventos.setOpaque(true);
		jmEventos.add(jmiEventos);
                
                JMenu jmConfiguracion = new JMenu("Configuración");
		jmConfiguracion.setMinimumSize(new Dimension(0, 50));
		jmConfiguracion.setContentAreaFilled(false);
		jmConfiguracion.setHorizontalAlignment(SwingConstants.CENTER);
		jmConfiguracion.setHorizontalTextPosition(SwingConstants.CENTER);
		jmConfiguracion.setPreferredSize(new Dimension(190, 600));
		jmConfiguracion.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
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
		jlBaloncesto.setInheritsPopupMenu(false);
		jlBaloncesto.setBounds(0, 205, 928, 434);
		ImageIcon baloncesto= new ImageIcon(this.getClass().getResource("/com/bugabulls/imagen/baloncesto3.jpg"));
		Icon iconoBaloncesto = new ImageIcon(baloncesto.getImage().getScaledInstance(jlBaloncesto.getWidth(), jlBaloncesto.getHeight(),Image.SCALE_DEFAULT));
		jlBaloncesto.setIcon(iconoBaloncesto);
		this.repaint();
		panel.add(jlBaloncesto);
                llenarInicio();
                ManejadorMenuJugador mj = new ManejadorMenuJugador(this,jugadorLogeado);
		jmiInfoPersonal.addActionListener(mj);
                jmiMensualidad.addActionListener(mj);
                jmiSesion.addActionListener(mj);
                jmiEventos.addActionListener(mj);                
                jmiCambiar.addActionListener(mj);
                jmiManual.addActionListener(mj);
                jbCerrarSesion.addActionListener(mj);
                
                
        }
        public void llenarInicio(){
        try {
            Jugador jugador=DAOFactory.getJugadorDAO().consultarPorId(jugadorLogeado);
                jlNombreJugador.setText("Jugador: "+jugador.getNombre()+" "+jugador.getApellido());
                jlCodigoJugador.setText("Codigo: "+jugador.getCodigojugador().toString());
        } catch (Exception ex) {
            Logger.getLogger(MenuJugador.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
}
	
	

