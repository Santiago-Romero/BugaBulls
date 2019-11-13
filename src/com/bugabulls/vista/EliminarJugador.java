package com.bugabulls.vista;

import com.bugabulls.controlador.DeleteEliminarJugador;
import com.bugabulls.controlador.LimitadorCaracteres;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class EliminarJugador extends JDialog {
	public JTextField jtCodigoEliminar;
	public JTextField jtNombre;
	public JTextField jtApellidos;
	public JTextField jtDireccion;
	public JTextField jtEps;
	public JTextField jtTelefono;
	public JTextField jtAltura;
	public JTextField jtDni;
	public JDateChooser jdFechaNacimiento;
        public JButton jbBuscar,jbEliminar;
        public JLabel jlerror,jlerrorBuscar,jlFotoPerfil;
        

	public EliminarJugador(MenuAdministrador ma) {
		setModal(true);		
		setBounds(0,0,632,515);
                setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);		
		CrearGui();	
		
		}
		
		
		public void CrearGui(){
			JLabel jlEliminarJugador = new JLabel("Eliminar Jugador");
			jlEliminarJugador.setOpaque(true);
			jlEliminarJugador.setForeground(Color.WHITE);
			jlEliminarJugador.setFont(new Font("Simplified Arabic", Font.BOLD, 18));
			jlEliminarJugador.setBackground(new Color(128, 128, 0));
			jlEliminarJugador.setBounds(0, 0, 644, 44);
			getContentPane().add(jlEliminarJugador);
			
			JLabel jlCodigoEliminar = new JLabel("Código Jugador");
			jlCodigoEliminar.setFont(new Font("Tahoma", Font.PLAIN, 16));
			jlCodigoEliminar.setBounds(10, 55, 122, 25);
			getContentPane().add(jlCodigoEliminar);
			
			jtCodigoEliminar = new JTextField();
			jtCodigoEliminar.setColumns(10);
			jtCodigoEliminar.setBounds(141, 55, 186, 25);
                        jtCodigoEliminar.setDocument(new LimitadorCaracteres(jtCodigoEliminar, 5, 0));
			getContentPane().add(jtCodigoEliminar);
			
			jbBuscar = new JButton("Buscar");
			jbBuscar.setFont(new Font("SansSerif", Font.PLAIN, 14));
			jbBuscar.setBackground(new Color(95, 158, 160));
			jbBuscar.setBounds(344, 55, 111, 25);
			getContentPane().add(jbBuscar);
			
			JPanel panelDatosPersonales = new JPanel();
			panelDatosPersonales.setLayout(null);
			panelDatosPersonales.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(95, 158, 160), null, null, null));
			panelDatosPersonales.setAlignmentY(1.0f);
			panelDatosPersonales.setBounds(10, 91, 596, 298);
			getContentPane().add(panelDatosPersonales);
			
			JLabel jlNombre = new JLabel("Nombre");
			jlNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
			jlNombre.setBounds(10, 15, 64, 25);
			panelDatosPersonales.add(jlNombre);
			
			jtNombre = new JTextField();
			jtNombre.setBorder(new LineBorder(new Color(171, 173, 179)));
			jtNombre.setBackground(Color.WHITE);
			jtNombre.setDisabledTextColor(Color.WHITE);
			jtNombre.setEditable(false);
			jtNombre.setColumns(10);
			jtNombre.setBounds(103, 15, 207, 27);
			panelDatosPersonales.add(jtNombre);
			
			JLabel jlApellidos = new JLabel("Apellidos");
			jlApellidos.setFont(new Font("Tahoma", Font.PLAIN, 16));
			jlApellidos.setBounds(10, 49, 83, 25);
			panelDatosPersonales.add(jlApellidos);
			
			jtApellidos = new JTextField();
			jtApellidos.setBorder(new LineBorder(new Color(171, 173, 179)));
			jtApellidos.setBackground(Color.WHITE);
			jtApellidos.setEditable(false);
			jtApellidos.setColumns(10);
			jtApellidos.setBounds(103, 49, 207, 27);
			panelDatosPersonales.add(jtApellidos);
			
			JLabel jlDireccion = new JLabel("Direcci\u00F3n");
			jlDireccion.setFont(new Font("Tahoma", Font.PLAIN, 16));
			jlDireccion.setBounds(10, 184, 83, 26);
			panelDatosPersonales.add(jlDireccion);
			
			jtDireccion = new JTextField();
			jtDireccion.setBorder(new LineBorder(new Color(171, 173, 179)));
			jtDireccion.setBackground(Color.WHITE);
			jtDireccion.setEditable(false);
			jtDireccion.setColumns(10);
			jtDireccion.setBounds(103, 184, 207, 27);
			panelDatosPersonales.add(jtDireccion);
			
			JLabel jlEps = new JLabel("EPS");
			jlEps.setFont(new Font("Tahoma", Font.PLAIN, 16));
			jlEps.setBounds(10, 150, 46, 27);
			panelDatosPersonales.add(jlEps);
			
			jtEps = new JTextField();
			jtEps.setBorder(new LineBorder(new Color(171, 173, 179)));
			jtEps.setBackground(Color.WHITE);
			jtEps.setEditable(false);
			jtEps.setColumns(10);
			jtEps.setBounds(103, 150, 207, 27);
			panelDatosPersonales.add(jtEps);
			
			JLabel jlFechaNacimiento = new JLabel("Fecha de Nacimiento");
			jlFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 16));
			jlFechaNacimiento.setBounds(10, 116, 157, 27);
			panelDatosPersonales.add(jlFechaNacimiento);
			
			JLabel jltTelefono = new JLabel("Teléfono");
			jltTelefono.setFont(new Font("Tahoma", Font.PLAIN, 16));
			jltTelefono.setBounds(10, 218, 83, 25);
			panelDatosPersonales.add(jltTelefono);
			
			jtTelefono = new JTextField();
			jtTelefono.setBorder(new LineBorder(new Color(171, 173, 179)));
			jtTelefono.setBackground(Color.WHITE);
			jtTelefono.setEditable(false);
			jtTelefono.setColumns(10);
			jtTelefono.setBounds(103, 218, 207, 27);
			panelDatosPersonales.add(jtTelefono);
			
			JLabel jlAltura = new JLabel("Altura");
			jlAltura.setFont(new Font("Tahoma", Font.PLAIN, 16));
			jlAltura.setBounds(10, 252, 64, 25);
			panelDatosPersonales.add(jlAltura);
			
			jtAltura = new JTextField();
			jtAltura.setBorder(new LineBorder(new Color(171, 173, 179)));
			jtAltura.setBackground(Color.WHITE);
			jtAltura.setEditable(false);
			jtAltura.setColumns(10);
			jtAltura.setBounds(103, 252, 207, 27);
			panelDatosPersonales.add(jtAltura);		
			
			
			JLabel jlDni = new JLabel("DNI");
			jlDni.setFont(new Font("Tahoma", Font.PLAIN, 16));
			jlDni.setBounds(10, 81, 83, 26);
			panelDatosPersonales.add(jlDni);
			
			jtDni = new JTextField();
			jtDni.setBorder(new LineBorder(new Color(171, 173, 179)));
			jtDni.setBackground(Color.WHITE);
			jtDni.setEditable(false);
			jtDni.setColumns(10);
			jtDni.setBounds(103, 81, 207, 27);
			panelDatosPersonales.add(jtDni);
			
			jlFotoPerfil = new JLabel("");
			jlFotoPerfil.setBounds(367, 49, 186, 177);
			ImageIcon fotoPerfil= new ImageIcon(this.getClass().getResource("/com/bugabulls/imagen/fotoPerfil.png"));
			Icon iconoPerfil = new ImageIcon(fotoPerfil.getImage().getScaledInstance(jlFotoPerfil.getWidth(), jlFotoPerfil.getHeight(),Image.SCALE_DEFAULT));
			this.repaint();	
			jlFotoPerfil.setIcon(iconoPerfil);
			panelDatosPersonales.add(jlFotoPerfil);
			
			jdFechaNacimiento = new JDateChooser();
			jdFechaNacimiento.setBorder(new LineBorder(new Color(171, 173, 179)));
			jdFechaNacimiento.setBackground(Color.WHITE);
			jdFechaNacimiento.setBounds(165, 116, 145, 25);
                        jdFechaNacimiento.setEnabled(false);
			panelDatosPersonales.add(jdFechaNacimiento);
			
			jbEliminar = new JButton("Eliminar");
			jbEliminar.setFont(new Font("SansSerif", Font.BOLD, 18));
			jbEliminar.setBackground(new Color(95, 158, 160));
			jbEliminar.setBounds(114, 410, 420, 36);
			getContentPane().add(jbEliminar);
                        
                        jlerrorBuscar = new JLabel("");
                        jlerrorBuscar.setHorizontalAlignment(SwingConstants.CENTER);
                        jlerrorBuscar.setForeground(new Color(255, 0, 0));
		        jlerrorBuscar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		        jlerrorBuscar.setBounds(465, 55, 100, 27);
		        getContentPane().add(jlerrorBuscar);
                
                        jlerror = new JLabel("");
                        jlerror.setHorizontalAlignment(SwingConstants.CENTER);
                        jlerror.setForeground(new Color(255, 0, 0));
		        jlerror.setFont(new Font("Tahoma", Font.PLAIN, 16));
		        jlerror.setBounds(10, 456, 650, 27);
		        getContentPane().add(jlerror);
                        
                        
                        DeleteEliminarJugador ej = new DeleteEliminarJugador(this);
                        jbEliminar.addActionListener(ej);
                        jbBuscar.addActionListener(ej);
			
		}
}
