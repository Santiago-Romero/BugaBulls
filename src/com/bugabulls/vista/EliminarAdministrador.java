package com.bugabulls.vista;

import com.bugabulls.controlador.DeleteEliminarAdministrador;
import com.bugabulls.controlador.LimitadorCaracteres;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

public class EliminarAdministrador extends JDialog {
	public JTextField jtCodigoEliminar;
	public JTextField jtNombre;
	public JTextField jtApellidos;
	public JTextField jtCedula;
	public JTextField jtTelefono;
	public JTextField jtDireccion;
        public JButton jbBuscar,jbEliminar;
        public JLabel jlerror,jlerrorBuscar;
        
	public EliminarAdministrador(MenuAdministrador ma) {
		setModal(true);		
		setBounds(0,0,632,441);
		getContentPane().setLayout(null);
                setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);		
		CrearGui();	
		
		}
		
		
		public void CrearGui(){
			JLabel jlEliminarAdministrador = new JLabel("Eliminar Administrador");
			jlEliminarAdministrador.setOpaque(true);
			jlEliminarAdministrador.setForeground(Color.WHITE);
			jlEliminarAdministrador.setFont(new Font("Simplified Arabic", Font.BOLD, 18));
			jlEliminarAdministrador.setBackground(new Color(128, 128, 0));
			jlEliminarAdministrador.setBounds(0, 0, 644, 44);
			getContentPane().add(jlEliminarAdministrador);
			
			JLabel jlCodigoEliminar = new JLabel("Código Administrador");
			jlCodigoEliminar.setFont(new Font("Tahoma", Font.PLAIN, 16));
			jlCodigoEliminar.setBounds(10, 55, 160, 25);
			getContentPane().add(jlCodigoEliminar);
			
			jtCodigoEliminar = new JTextField();
			jtCodigoEliminar.setColumns(10);
			jtCodigoEliminar.setBounds(200, 55, 186, 25);
                        jtCodigoEliminar.setDocument(new LimitadorCaracteres(jtCodigoEliminar, 5, 0));
			getContentPane().add(jtCodigoEliminar);
			
			jbBuscar = new JButton("Buscar");
			jbBuscar.setFont(new Font("SansSerif", Font.PLAIN, 14));
			jbBuscar.setBackground(new Color(95, 158, 160));
			jbBuscar.setBounds(395, 55, 111, 25);
			getContentPane().add(jbBuscar);
			
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(95, 158, 160), null, null, null));
			panel.setAlignmentY(1.0f);
			panel.setBounds(10, 101, 596, 207);
			getContentPane().add(panel);
			
			JLabel jlNombre = new JLabel("Nombre");
			jlNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
			jlNombre.setBounds(10, 21, 64, 25);
			panel.add(jlNombre);
			
			jtNombre = new JTextField();
			jtNombre.setBorder(new LineBorder(new Color(171, 173, 179)));
			jtNombre.setBackground(Color.WHITE);
			jtNombre.setEditable(false);
			jtNombre.setColumns(10);
			jtNombre.setBounds(103, 21, 207, 27);
			panel.add(jtNombre);
			
			JLabel jlApellidos = new JLabel("Apellidos");
			jlApellidos.setFont(new Font("Tahoma", Font.PLAIN, 16));
			jlApellidos.setBounds(10, 55, 83, 25);
			panel.add(jlApellidos);
			
			jtApellidos = new JTextField();
			jtApellidos.setBorder(new LineBorder(new Color(171, 173, 179)));
			jtApellidos.setBackground(Color.WHITE);
			jtApellidos.setEditable(false);
			jtApellidos.setColumns(10);
			jtApellidos.setBounds(103, 55, 207, 27);
			panel.add(jtApellidos);
			
			JLabel jlCedula = new JLabel("C\u00E9dula");
			jlCedula.setFont(new Font("Tahoma", Font.PLAIN, 16));
			jlCedula.setBounds(10, 89, 64, 25);
			panel.add(jlCedula);
			
			jtCedula = new JTextField();
			jtCedula.setBorder(new LineBorder(new Color(171, 173, 179)));
			jtCedula.setBackground(Color.WHITE);
			jtCedula.setEditable(false);
			jtCedula.setColumns(10);
			jtCedula.setBounds(103, 89, 207, 27);
			panel.add(jtCedula);
			
			JLabel jlTelefono = new JLabel("Teléfono");
			jlTelefono.setFont(new Font("Tahoma", Font.PLAIN, 16));
			jlTelefono.setBounds(10, 123, 64, 25);
			panel.add(jlTelefono);
			
			jtTelefono = new JTextField();
			jtTelefono.setBorder(new LineBorder(new Color(171, 173, 179)));
			jtTelefono.setBackground(Color.WHITE);
			jtTelefono.setEditable(false);
			jtTelefono.setColumns(10);
			jtTelefono.setBounds(103, 123, 207, 27);
			panel.add(jtTelefono);
			
			JLabel jlDireccion = new JLabel("Direcci\u00F3n");
			jlDireccion.setFont(new Font("Tahoma", Font.PLAIN, 16));
			jlDireccion.setBounds(10, 159, 83, 25);
			panel.add(jlDireccion);
			
			jtDireccion = new JTextField();
			jtDireccion.setBorder(new LineBorder(new Color(171, 173, 179)));
			jtDireccion.setBackground(Color.WHITE);
			jtDireccion.setEditable(false);
			jtDireccion.setColumns(10);
			jtDireccion.setBounds(103, 159, 207, 27);
			panel.add(jtDireccion);
			
			jbEliminar = new JButton("Eliminar");
			jbEliminar.setFont(new Font("SansSerif", Font.BOLD, 18));
			jbEliminar.setBackground(new Color(95, 158, 160));
			jbEliminar.setBounds(98, 329, 420, 36);
			getContentPane().add(jbEliminar);
                        
                        jlerrorBuscar = new JLabel("");
                        jlerrorBuscar.setHorizontalAlignment(SwingConstants.CENTER);
                        jlerrorBuscar.setForeground(new Color(255, 0, 0));
		        jlerrorBuscar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		        jlerrorBuscar.setBounds(516, 55, 100, 27);
		        getContentPane().add(jlerrorBuscar);
                
                        jlerror = new JLabel("");
                        jlerror.setHorizontalAlignment(SwingConstants.CENTER);
                        jlerror.setForeground(new Color(255, 0, 0));
		        jlerror.setFont(new Font("Tahoma", Font.PLAIN, 16));
		        jlerror.setBounds(10, 375, 650, 27);
		        getContentPane().add(jlerror);
			
			DeleteEliminarAdministrador ea = new DeleteEliminarAdministrador(this);
                        jbBuscar.addActionListener(ea);
                        jbEliminar.addActionListener(ea);
		}

}
