package com.bugabulls.vista;

import com.bugabulls.controlador.DAOFactory;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.border.SoftBevelBorder;

import com.bugabulls.controlador.ManejadorMenuAdministrador;
import com.bugabulls.modelo.Administrador;

import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

public class MenuAdministrador extends JFrame {

	private JPanel Panel;
	public JMenuItem jmiAdministrador;
	public JMenuItem jmiRegistrarJugador;
        public JMenuItem jmiRegistrarEntrenador;
        public JMenuItem jmiModificarJugador;
        public JMenuItem jmiRegistrarAdministrador;
        public JMenuItem jmiModificarEntrenador;
        public JMenuItem jmiModificarAdministrador;
        public JMenuItem jmiEliminarJugador;
        public JMenuItem jmiEliminarEntrenador;
        public JMenuItem jmiEliminarAdministrador;
        public JMenuItem jmiPagarMensualidad;
        public JMenuItem jmiConsultarEventos;
        public JMenuItem jmiPreBenjamines;
        public JMenuItem jmiCrearEventos;
        public JMenuItem jmiBenjamines;
        public JMenuItem jmiMinis;
        public JMenuItem jmiInfantiles;
        public JMenuItem jmiJunior;
        public JMenuItem jmiAsignarPre;
        public JMenuItem jmiAsignarBen;
        public JMenuItem jmiAsignarMin;
        public JMenuItem jmiAsignarInfantiles;
        public JMenuItem jmiAsignarJunior;
        public JMenuItem jmiConsultarSesiones;
        public JMenuItem jmiCopias;  
        public JMenuItem jmiCambiar;
        public JMenuItem jmiManual;
        public JMenuItem jmiJugadorCategoria;
        int administradorLogeado;
        public JLabel jlNombreAdministrador,jlCodigoAdministrador;
        public JButton jbCerrarSesion;
	

	public MenuAdministrador(Login lg,int administradorLogeado) {
            this.administradorLogeado=administradorLogeado;
            setResizable(false);
		setTitle("Menu");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 910, 600);

		Panel = new JPanel();
		Panel.setPreferredSize(new Dimension(500, 10));
		Panel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		Panel.setForeground(new Color(255, 255, 255));
		Panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(Panel);
		Panel.setLayout(null);
		CrearGui();
	    }
		
		
		public void CrearGui(){
		
		JLabel jlLogo = new JLabel("");
		jlLogo.setBounds(56, 0, 217, 123);		
		ImageIcon logo= new ImageIcon(this.getClass().getResource("/com/bugabulls/imagen/logoEscuela.png"));
		Icon iconoLogo = new ImageIcon(logo.getImage().getScaledInstance(jlLogo.getWidth(), jlLogo.getHeight(),Image.SCALE_DEFAULT));
		jlLogo.setIcon(iconoLogo);
		this.repaint();		
		Panel.add(jlLogo);
                
                jlNombreAdministrador = new JLabel("");
                jlNombreAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlNombreAdministrador.setBounds(600, 0, 523, 123);	
		Panel.add(jlNombreAdministrador);
                
                jlCodigoAdministrador = new JLabel("");
                jlCodigoAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlCodigoAdministrador.setBounds(600, 22, 223, 123);	
		Panel.add(jlCodigoAdministrador);
                
                jbCerrarSesion=new JButton("Cerrar Sesión");
                jbCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 16));
                jbCerrarSesion.setBounds(705, 70, 145, 25);
                jbCerrarSesion.setBackground(new Color(220, 220, 220));
                Panel.add(jbCerrarSesion);
		
		JLabel jlTitulo = new JLabel("");
		jlTitulo.setBackground(Color.LIGHT_GRAY);
		jlTitulo.setOpaque(true);
		jlTitulo.setBounds(0, 0, 928, 137);
		Panel.add(jlTitulo);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 140, 928, 65);
		Panel.add(menuBar);
		
		JMenu jmRegistrar = new JMenu(" Registrar");
		jmRegistrar.setMinimumSize(new Dimension(0, 50));
		jmRegistrar.setContentAreaFilled(false);
		jmRegistrar.setHorizontalAlignment(SwingConstants.CENTER);
		jmRegistrar.setHorizontalTextPosition(SwingConstants.CENTER);
		jmRegistrar.setPreferredSize(new Dimension(110, 600));
		jmRegistrar.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
		jmRegistrar.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, null, null));
		jmRegistrar.setForeground(new Color(255, 255, 255));
		jmRegistrar.setBackground(new Color(128, 128, 0));
		jmRegistrar.setOpaque(true);		
		menuBar.add(jmRegistrar);
		
		jmiRegistrarJugador = new JMenuItem("Jugador");
		jmiRegistrarJugador.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		jmiRegistrarJugador.setPreferredSize(new Dimension(85, 35));
		jmiRegistrarJugador.setBorder(new EmptyBorder(0, 0, 0, 0));
		jmiRegistrarJugador.setBackground(new Color(128, 128, 0));
		jmiRegistrarJugador.setForeground(new Color(255, 255, 255));
		jmiRegistrarJugador.setOpaque(true);
		jmRegistrar.add(jmiRegistrarJugador);
		
		jmiRegistrarEntrenador = new JMenuItem("Entrenador");
		jmiRegistrarEntrenador.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		jmiRegistrarEntrenador.setPreferredSize(new Dimension(101, 35));
		jmiRegistrarEntrenador.setBorder(new EmptyBorder(0, 0, 0, 0));
		jmiRegistrarEntrenador.setBackground(new Color(128, 128, 0));
		jmiRegistrarEntrenador.setForeground(new Color(255, 255, 255));
		jmiRegistrarEntrenador.setOpaque(true);
		jmRegistrar.add(jmiRegistrarEntrenador);
		
		jmiRegistrarAdministrador = new JMenuItem("Admnistrador");
		jmiRegistrarAdministrador.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		jmiRegistrarAdministrador.setPreferredSize(new Dimension(117, 35));
		jmiRegistrarAdministrador.setBorder(new EmptyBorder(0, 0, 0, 0));
		jmiRegistrarAdministrador.setBackground(new Color(128, 128, 0));
		jmiRegistrarAdministrador.setForeground(new Color(255, 255, 255));
		jmiRegistrarAdministrador.setOpaque(true);
		jmRegistrar.add(jmiRegistrarAdministrador);
		
		JMenu jmModificar = new JMenu("Modificar");
		jmModificar.setPreferredSize(new Dimension(110, 22));
		jmModificar.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
		jmModificar.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, null, null));
		jmModificar.setBackground(new Color(128, 128, 0));
		jmModificar.setForeground(new Color(255, 255, 255));
		jmModificar.setOpaque(true);
		menuBar.add(jmModificar);
		
		jmiModificarJugador = new JMenuItem("Jugador");
		jmiModificarJugador.setPreferredSize(new Dimension(85, 35));
		jmiModificarJugador.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		jmiModificarJugador.setBackground(new Color(128, 128, 0));
		jmiModificarJugador.setForeground(new Color(255, 255, 255));
		jmiModificarJugador.setOpaque(true);
		jmModificar.add(jmiModificarJugador);
		
		jmiModificarEntrenador = new JMenuItem("Entrenador");
		jmiModificarEntrenador.setPreferredSize(new Dimension(101, 35));
		jmiModificarEntrenador.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		jmiModificarEntrenador.setBackground(new Color(128, 128, 0));
		jmiModificarEntrenador.setForeground(new Color(255, 255, 255));
		jmiModificarEntrenador.setOpaque(true);
		jmModificar.add(jmiModificarEntrenador);
		
		jmiModificarAdministrador = new JMenuItem("Administrador");
		jmiModificarAdministrador.setPreferredSize(new Dimension(119, 35));
		jmiModificarAdministrador.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		jmiModificarAdministrador.setBackground(new Color(128, 128, 0));
		jmiModificarAdministrador.setForeground(new Color(255, 255, 255));
		jmiModificarAdministrador.setOpaque(true);
		jmModificar.add(jmiModificarAdministrador);
		
		JMenu jmEliminar = new JMenu("Eliminar");
		jmEliminar.setPreferredSize(new Dimension(100, 22));
		jmEliminar.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
		jmEliminar.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, null, null));
		jmEliminar.setBackground(new Color(128, 128, 0));
		jmEliminar.setOpaque(true);
		jmEliminar.setForeground(new Color(255, 255, 255));
		menuBar.add(jmEliminar);
		
		jmiEliminarJugador = new JMenuItem("Jugador");
		jmiEliminarJugador.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		jmiEliminarJugador.setPreferredSize(new Dimension(85, 35));
		jmiEliminarJugador.setBackground(new Color(128, 128, 0));
		jmiEliminarJugador.setForeground(new Color(255, 255, 255));
		jmiEliminarJugador.setOpaque(true);
		jmEliminar.add(jmiEliminarJugador);
		
		jmiEliminarEntrenador = new JMenuItem("Entrenador");
		jmiEliminarEntrenador.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jmiEliminarEntrenador.setPreferredSize(new Dimension(101, 35));
		jmiEliminarEntrenador.setBackground(new Color(128, 128, 0));
		jmiEliminarEntrenador.setForeground(new Color(255, 255, 255));
		jmiEliminarEntrenador.setOpaque(true);
		jmEliminar.add(jmiEliminarEntrenador);
		
		jmiEliminarAdministrador = new JMenuItem("Administrador");
		jmiEliminarAdministrador.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jmiEliminarAdministrador.setPreferredSize(new Dimension(119, 35));
		jmiEliminarAdministrador.setBackground(new Color(128, 128, 0));
		jmiEliminarAdministrador.setForeground(new Color(255, 255, 255));
		jmiEliminarAdministrador.setOpaque(true);
		jmEliminar.add(jmiEliminarAdministrador);
		
		JMenu jmMensualidad = new JMenu("Mensualidad");
		jmMensualidad.setPreferredSize(new Dimension(130, 22));
		jmMensualidad.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
		jmMensualidad.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, null, null));
		jmMensualidad.setOpaque(true);
		jmMensualidad.setForeground(new Color(255, 255, 255));
		jmMensualidad.setBackground(new Color(128, 128, 0));
		menuBar.add(jmMensualidad);
		
		jmiPagarMensualidad = new JMenuItem("Pagar mensualidad");
		jmiPagarMensualidad.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		jmiPagarMensualidad.setPreferredSize(new Dimension(145, 35));
		jmiPagarMensualidad.setBackground(new Color(128, 128, 0));
		jmiPagarMensualidad.setForeground(new Color(255, 255, 255));
		jmiPagarMensualidad.setOpaque(true);
		jmMensualidad.add(jmiPagarMensualidad);
		
		
		
		JMenu jmEventos = new JMenu("Eventos");
		jmEventos.setPreferredSize(new Dimension(92, 22));
		jmEventos.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
		jmEventos.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, null, null));
		jmEventos.setOpaque(true);
		jmEventos.setForeground(new Color(255, 255, 255));
		jmEventos.setBackground(new Color(128, 128, 0));
		menuBar.add(jmEventos);
		
		jmiCrearEventos = new JMenuItem("Crear eventos");
		jmiCrearEventos.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		jmiCrearEventos.setPreferredSize(new Dimension(115, 35));
		jmiCrearEventos.setBackground(new Color(128, 128, 0));
		jmiCrearEventos.setForeground(new Color(255, 255, 255));
		jmiCrearEventos.setOpaque(true);
		jmEventos.add(jmiCrearEventos);
                
                jmiConsultarEventos = new JMenuItem("Consultar Eventos");
		jmiConsultarEventos.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		jmiConsultarEventos.setPreferredSize(new Dimension(149, 35));
		jmiConsultarEventos.setBackground(new Color(128, 128, 0));
		jmiConsultarEventos.setForeground(new Color(255, 255, 255));
		jmiConsultarEventos.setOpaque(true);
		jmEventos.add(jmiConsultarEventos);
		
		JMenu jmPlantillas = new JMenu(" Plantillas");
		jmPlantillas.setPreferredSize(new Dimension(103, 22));
		jmPlantillas.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
		jmPlantillas.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, null, null));
		jmPlantillas.setBackground(new Color(128, 128, 0));
		jmPlantillas.setForeground(new Color(255, 255, 255));
		jmPlantillas.setOpaque(true);
		menuBar.add(jmPlantillas);
		
		jmiPreBenjamines = new JMenuItem("Pre Benjamines");
		jmiPreBenjamines.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jmiPreBenjamines.setPreferredSize(new Dimension(125, 35));
		jmiPreBenjamines.setBackground(new Color(128, 128, 0));
		jmiPreBenjamines.setForeground(new Color(255, 255, 255));
		jmiPreBenjamines.setOpaque(true);
		jmPlantillas.add(jmiPreBenjamines);
		
		jmiBenjamines = new JMenuItem("Benjamines");
		jmiBenjamines.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		jmiBenjamines.setPreferredSize(new Dimension(105, 35));
		jmiBenjamines.setBackground(new Color(128, 128, 0));
		jmiBenjamines.setForeground(new Color(255, 255, 255));
		jmiBenjamines.setOpaque(true);
		jmPlantillas.add(jmiBenjamines);
		
		jmiMinis = new JMenuItem("Minis");
		jmiMinis.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		jmiMinis.setPreferredSize(new Dimension(73, 35));
		jmiMinis.setBackground(new Color(128, 128, 0));
		jmiMinis.setForeground(new Color(255, 255, 255));
		jmiMinis.setOpaque(true);
		jmPlantillas.add(jmiMinis);
		
		jmiInfantiles = new JMenuItem("Infantiles");
		jmiInfantiles.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		jmiInfantiles.setPreferredSize(new Dimension(91, 35));
		jmiInfantiles.setBackground(new Color(128, 128, 0));
		jmiInfantiles.setForeground(new Color(255, 255, 255));
		jmiInfantiles.setOpaque(true);
		jmPlantillas.add(jmiInfantiles);
		
		jmiJunior = new JMenuItem("Junior");
		jmiJunior.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jmiJunior.setPreferredSize(new Dimension(75, 35));
		jmiJunior.setBackground(new Color(128, 128, 0));
		jmiJunior.setForeground(new Color(255, 255, 255));
		jmiJunior.setOpaque(true);
		jmPlantillas.add(jmiJunior);
		
		JMenu jmCategorias = new JMenu("  Categorías");
		jmCategorias.setHorizontalTextPosition(SwingConstants.CENTER);
		jmCategorias.setHorizontalAlignment(SwingConstants.TRAILING);
		jmCategorias.setPreferredSize(new Dimension(130, 35));
		jmCategorias.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
		jmCategorias.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, null, null));
		jmCategorias.setBackground(new Color(128, 128, 0));
		jmCategorias.setForeground(new Color(255, 255, 255));
		jmCategorias.setOpaque(true);
		menuBar.add(jmCategorias);
		
		JMenu jmAsignarCategorias = new JMenu("Asignar Categor\u00EDas");
		jmAsignarCategorias.setPreferredSize(new Dimension(135, 32));
		jmAsignarCategorias.setForeground(new Color(255, 255, 255));
		jmAsignarCategorias.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jmAsignarCategorias.setOpaque(true);
		jmAsignarCategorias.setBackground(new Color(128, 128, 0));
		jmCategorias.add(jmAsignarCategorias);
		
		jmiAsignarPre = new JMenuItem("Pre Benjamines");
		jmiAsignarPre.setForeground(new Color(255, 255, 255));
		jmiAsignarPre.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jmiAsignarPre.setPreferredSize(new Dimension(135, 35));
		jmiAsignarPre.setBackground(new Color(128, 128, 0));
		jmAsignarCategorias.add(jmiAsignarPre);
		
		jmiAsignarBen = new JMenuItem("Benjamines");
		jmiAsignarBen.setForeground(new Color(255, 255, 255));
		jmiAsignarBen.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jmiAsignarBen.setPreferredSize(new Dimension(135, 35));
		jmiAsignarBen.setBackground(new Color(128, 128, 0));
		jmAsignarCategorias.add(jmiAsignarBen);
		
		jmiAsignarMin = new JMenuItem("Minis");
		jmiAsignarMin.setForeground(new Color(255, 255, 255));
		jmiAsignarMin.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jmiAsignarMin.setPreferredSize(new Dimension(135, 35));
		jmiAsignarMin.setBackground(new Color(128, 128, 0));
		jmAsignarCategorias.add(jmiAsignarMin);
		
		jmiAsignarInfantiles = new JMenuItem("Infantiles");
		jmiAsignarInfantiles.setForeground(new Color(255, 255, 255));
		jmiAsignarInfantiles.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jmiAsignarInfantiles.setPreferredSize(new Dimension(135, 35));
		jmiAsignarInfantiles.setBackground(new Color(128, 128, 0));
		jmAsignarCategorias.add(jmiAsignarInfantiles);
		
		jmiAsignarJunior = new JMenuItem("Junior");
		jmiAsignarJunior.setForeground(new Color(255, 255, 255));
		jmiAsignarJunior.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jmiAsignarJunior.setPreferredSize(new Dimension(135, 35));
		jmiAsignarJunior.setBackground(new Color(128, 128, 0));
		jmAsignarCategorias.add(jmiAsignarJunior);
                
                jmiJugadorCategoria = new JMenuItem("Jugadores por categoría");
		jmiJugadorCategoria.setForeground(new Color(255, 255, 255));
		jmiJugadorCategoria.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jmiJugadorCategoria.setPreferredSize(new Dimension(185, 35));
		jmiJugadorCategoria.setBackground(new Color(128, 128, 0));
		jmCategorias.add(jmiJugadorCategoria);
				
		
		JMenu jmSesiones = new JMenu("Sesiones ");
		jmSesiones.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, null, null));
		jmSesiones.setPreferredSize(new Dimension(100, 22));
		jmSesiones.setOpaque(true);
		jmSesiones.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
		jmSesiones.setBackground(new Color(128, 128, 0));
		jmSesiones.setForeground(new Color(255, 255, 255));
		jmSesiones.setBounds(700, 296, 107, 40);
		menuBar.add(jmSesiones);
		
		jmiConsultarSesiones = new JMenuItem("Consultar sesiones");
		jmiConsultarSesiones.setPreferredSize(new Dimension(141, 35));
		jmiConsultarSesiones.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jmiConsultarSesiones.setBackground(new Color(128, 128, 0));
		jmiConsultarSesiones.setOpaque(true);
		jmiConsultarSesiones.setForeground(new Color(255, 255, 255));
		jmiConsultarSesiones.setArmed(true);
		jmSesiones.add(jmiConsultarSesiones);
                
                JMenu jmConfiguracion = new JMenu("Configuraci\u00F3n");
		jmConfiguracion.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, null, null));
		jmConfiguracion.setPreferredSize(new Dimension(200, 22));
		jmConfiguracion.setOpaque(true);
		jmConfiguracion.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 18));
		jmConfiguracion.setBackground(new Color(128, 128, 0));
		jmConfiguracion.setForeground(new Color(255, 255, 255));
		jmConfiguracion.setBounds(700, 296, 107, 40);
		menuBar.add(jmConfiguracion);	
		
	    jmiCopias = new JMenuItem("Copias de seguridad");
		jmiCopias.setForeground(new Color(255, 255, 255));
		jmiCopias.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jmiCopias.setPreferredSize(new Dimension(180, 35));
		jmiCopias.setBackground(new Color(128, 128, 0));
		jmiCopias.setOpaque(true);
		jmConfiguracion.add(jmiCopias);		
		
		
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
		jlBaloncesto.setBounds(0, 205, 928, 434);
		ImageIcon baloncesto= new ImageIcon(this.getClass().getResource("/com/bugabulls/imagen/baloncesto.jpg"));
		Icon iconoBaloncesto = new ImageIcon(baloncesto.getImage().getScaledInstance(jlBaloncesto.getWidth(), jlBaloncesto.getHeight(),Image.SCALE_DEFAULT));
		jlBaloncesto.setIcon(iconoBaloncesto);
		this.repaint();
		Panel.add(jlBaloncesto);		
		
		setLocationRelativeTo(null);
		llenarInicio();
		ManejadorMenuAdministrador ma = new ManejadorMenuAdministrador(this,administradorLogeado);
		jmiRegistrarJugador.addActionListener(ma);
                jmiRegistrarEntrenador.addActionListener(ma);
                jmiRegistrarAdministrador.addActionListener(ma);
                jmiModificarJugador.addActionListener(ma);
                jmiModificarEntrenador.addActionListener(ma);
		jmiModificarAdministrador.addActionListener(ma);
                jmiEliminarJugador.addActionListener(ma);
                jmiEliminarEntrenador.addActionListener(ma);
                jmiEliminarAdministrador.addActionListener(ma);
                jmiPagarMensualidad.addActionListener(ma);
                jmiConsultarEventos.addActionListener(ma);
                jmiPreBenjamines.addActionListener(ma);
                jmiCrearEventos.addActionListener(ma);
                jmiBenjamines.addActionListener(ma);
                jmiMinis.addActionListener(ma);
                jmiInfantiles.addActionListener(ma);
                jmiJunior.addActionListener(ma);
                jmiAsignarPre.addActionListener(ma);
                jmiAsignarBen.addActionListener(ma);
                jmiAsignarMin.addActionListener(ma);
                jmiAsignarInfantiles.addActionListener(ma);
                jmiAsignarJunior.addActionListener(ma);
                jmiJugadorCategoria.addActionListener(ma);
                jmiConsultarSesiones.addActionListener(ma);
                jmiCopias.addActionListener(ma);                               
                jmiCambiar.addActionListener(ma);
                jmiManual.addActionListener(ma);
                jbCerrarSesion.addActionListener(ma);
                
	}
                public void llenarInicio(){
        try {
            Administrador administrador=DAOFactory.getAdministradorDAO().consultarPorId(administradorLogeado);
                jlNombreAdministrador.setText("Administrador: "+administrador.getNombre()+" "+administrador.getApellido());
                jlCodigoAdministrador.setText("Codigo: "+administrador.getCodigoadministrador().toString());
        } catch (Exception ex) {
            Logger.getLogger(MenuAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
}
