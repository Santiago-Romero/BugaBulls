package com.bugabulls.vista;

import com.bugabulls.controlador.DAOFactory;
import com.bugabulls.controlador.InsertRegistrarEntrenador;
import com.bugabulls.controlador.LimitadorCaracteres;
import com.bugabulls.modelo.Entrenador;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class RegistrarEntrenador extends JDialog {
	public JTextField jtNombre;
	public JTextField jtApellido;
	public JTextField jtCedula;
	public JTextField jtTelefono;
	public JTextField jtDireccion;
	public JTextField jtCodigo,jtContrasena;
        public JButton jbGuardar;
        public JLabel jlerror;
        int codigoEntrenador=20000;
	public RegistrarEntrenador(MenuAdministrador ma) {
                setModal(true);
		setBounds(100, 100, 650, 660);
		getContentPane().setLayout(null);
		setResizable(false);
                setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		CrearGui();
	}
		public void CrearGui(){
		JLabel jlFichaEntrenador = new JLabel("Ficha Entrenador");
		jlFichaEntrenador.setOpaque(true);
		jlFichaEntrenador.setForeground(Color.WHITE);
		jlFichaEntrenador.setFont(new Font("Simplified Arabic", Font.BOLD, 18));
		jlFichaEntrenador.setBackground(new Color(128, 128, 0));
		jlFichaEntrenador.setBounds(0, 0, 644, 44);
		getContentPane().add(jlFichaEntrenador);
		
		JLabel jlDatosPersonales = new JLabel("Datos Personales");
		jlDatosPersonales.setOpaque(true);
		jlDatosPersonales.setForeground(Color.BLACK);
		jlDatosPersonales.setFont(new Font("Simplified Arabic", Font.BOLD, 17));
		jlDatosPersonales.setBackground(new Color(95, 158, 160));
		jlDatosPersonales.setBounds(26, 62, 596, 34);
		getContentPane().add(jlDatosPersonales);
		
		JPanel PanelDatosPersonales = new JPanel();
		PanelDatosPersonales.setLayout(null);
		PanelDatosPersonales.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(95, 158, 160), null, null, null));
		PanelDatosPersonales.setAlignmentY(1.0f);
		PanelDatosPersonales.setBounds(26, 112, 596, 264);
		getContentPane().add(PanelDatosPersonales);
		
		JLabel jlNombre = new JLabel("Nombre");
		jlNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlNombre.setBounds(10, 42, 64, 25);
		PanelDatosPersonales.add(jlNombre);
		
		jtNombre = new JTextField();
		jtNombre.setColumns(10);
		jtNombre.setBounds(103, 42, 207, 27);
                jtNombre.setDocument(new LimitadorCaracteres(jtNombre, 50, 1));
		PanelDatosPersonales.add(jtNombre);
		
		JLabel jlApellido = new JLabel("Apellidos");
		jlApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlApellido.setBounds(10, 76, 83, 25);
		PanelDatosPersonales.add(jlApellido);
		
		jtApellido = new JTextField();
		jtApellido.setColumns(10);
		jtApellido.setBounds(103, 76, 207, 27);
                jtApellido.setDocument(new LimitadorCaracteres(jtApellido, 50, 1));
		PanelDatosPersonales.add(jtApellido);
		
		JLabel jlCedula = new JLabel("C\u00E9dula");
		jlCedula.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlCedula.setBounds(10, 112, 64, 25);
		PanelDatosPersonales.add(jlCedula);
		
		jtCedula = new JTextField();
		jtCedula.setColumns(10);
		jtCedula.setBounds(103, 112, 207, 27);
                jtCedula.setDocument(new LimitadorCaracteres(jtCedula, 10, 0));
		PanelDatosPersonales.add(jtCedula);
		
		JLabel jlTelefono = new JLabel("Teléfono");
		jlTelefono.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlTelefono.setBounds(10, 148, 64, 25);
		PanelDatosPersonales.add(jlTelefono);
		
		jtTelefono = new JTextField();
		jtTelefono.setColumns(10);
		jtTelefono.setBounds(103, 148, 207, 27);
                jtTelefono.setDocument(new LimitadorCaracteres(jtTelefono, 10, 0));
		PanelDatosPersonales.add(jtTelefono);
		
		JLabel jlDireccion = new JLabel("Direcci\u00F3n");
		jlDireccion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlDireccion.setBounds(10, 184, 83, 25);
		PanelDatosPersonales.add(jlDireccion);
		
		jtDireccion = new JTextField();
		jtDireccion.setColumns(10);
		jtDireccion.setBounds(103, 184, 207, 27);
                jtDireccion.setDocument(new LimitadorCaracteres(jtDireccion, 50, 2));
		PanelDatosPersonales.add(jtDireccion);
		
		JLabel jlDatosSesion = new JLabel("Informaci\u00F3n de inicio de sesi\u00F3n");
		jlDatosSesion.setBounds(26, 393, 596, 34);
		jlDatosSesion.setOpaque(true);
		jlDatosSesion.setFont(new Font("Simplified Arabic", Font.BOLD, 17));
		jlDatosSesion.setBackground(new Color(95, 158, 160));
		getContentPane().add(jlDatosSesion);
		
		JPanel panelDatosSesion = new JPanel();
		panelDatosSesion.setBounds(26, 443, 596, 89);
		panelDatosSesion.setLayout(null);
		panelDatosSesion.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(95, 158, 160), null, null, null));
		getContentPane().add(panelDatosSesion);
		
		JLabel jlCodigo = new JLabel("Código");
		jlCodigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlCodigo.setBounds(10, 11, 97, 24);
		panelDatosSesion.add(jlCodigo);
		
		jtCodigo = new JTextField();
		jtCodigo.setBackground(Color.WHITE);
		jtCodigo.setColumns(10);
		jtCodigo.setBounds(117, 11, 195, 27);
		jtCodigo.setEditable(false);
		panelDatosSesion.add(jtCodigo);
		
		JLabel jlContrasea = new JLabel("Contrase\u00F1a");
		jlContrasea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlContrasea.setBounds(10, 45, 97, 27);
		panelDatosSesion.add(jlContrasea);
		
		jtContrasena = new JPasswordField();
		jtContrasena.setBounds(117, 45, 195, 27);
                jtContrasena.setDocument(new LimitadorCaracteres(jtContrasena, 50, 2));
		panelDatosSesion.add(jtContrasena);
		
		jbGuardar = new JButton("Guardar");
		jbGuardar.setBackground(new Color(95, 158, 160));
		jbGuardar.setFont(new Font("SansSerif", Font.BOLD, 18));
		jbGuardar.setBounds(120, 553,420, 36);
		getContentPane().add(jbGuardar);
                
                 jlerror = new JLabel("");
                jlerror.setHorizontalAlignment(SwingConstants.CENTER);
                jlerror.setForeground(new Color(255, 0, 0));
		jlerror.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlerror.setBounds(10, 604, 650, 27);
		getContentPane().add(jlerror);
                
                asignarCodigoEntrenador();
                InsertRegistrarEntrenador re = new InsertRegistrarEntrenador(this,codigoEntrenador);
                jbGuardar.addActionListener(re);

	}
                public void asignarCodigoEntrenador(){
                    try {
                        List<Entrenador> listaEntrenadores=DAOFactory.getEntrenadorDAO().consultar();
                        for (Entrenador entrenador : listaEntrenadores) {
                            if(entrenador.getCodigoentrenador()!=null){
                                codigoEntrenador=(entrenador.getCodigoentrenador())+1;
                            }
                        }
                    } catch (Exception ex){
                        Logger.getLogger(RegistrarEntrenador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    jtCodigo.setText(codigoEntrenador+"");
                }
}
