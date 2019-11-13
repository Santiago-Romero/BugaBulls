package com.bugabulls.vista;

import com.bugabulls.controlador.LimitadorCaracteres;
import com.bugabulls.controlador.UpdateModificarEntrenador;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class ModificarEntrenador extends JDialog {
	public JTextField  jtNombre, jtApellido,jtCedula,jtTelefono,jtDireccion,jtCodigo,jtContrasena;
	public JTextField jtCodigoModificar;
	public JButton jbBuscar,jbModificar;
        public JLabel jlerror,jlerrorBuscar;
        
	public ModificarEntrenador(MenuAdministrador ma) {
                setModal(true);
		setBounds(100, 100, 650, 660);
		getContentPane().setLayout(null);
                setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
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
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBounds(26, 117, 596, 413);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel jlDatosPersonales = new JLabel("Datos Personales");
		jlDatosPersonales.setBounds(0, 0, 596, 34);
		panel.add(jlDatosPersonales);
		jlDatosPersonales.setOpaque(true);
		jlDatosPersonales.setForeground(Color.BLACK);
		jlDatosPersonales.setFont(new Font("Simplified Arabic", Font.BOLD, 17));
		jlDatosPersonales.setBackground(new Color(95, 158, 160));
		
		JPanel PanelDatosPersonales = new JPanel();
		PanelDatosPersonales.setBounds(0, 50, 596, 207);
		panel.add(PanelDatosPersonales);
		PanelDatosPersonales.setLayout(null);
		PanelDatosPersonales.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(95, 158, 160), null, null, null));
		PanelDatosPersonales.setAlignmentY(1.0f);
		
		JLabel jlNombre = new JLabel("Nombre");
		jlNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlNombre.setBounds(10, 21, 64, 25);
		PanelDatosPersonales.add(jlNombre);
		
		jtNombre = new JTextField();
		jtNombre.setColumns(10);
		jtNombre.setBounds(103, 21, 207, 27);
                jtNombre.setDocument(new LimitadorCaracteres(jtNombre, 50, 1));
		PanelDatosPersonales.add(jtNombre);
		
		JLabel jlApellido = new JLabel("Apellidos");
		jlApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlApellido.setBounds(10, 55, 83, 25);
		PanelDatosPersonales.add(jlApellido);
		
		jtApellido = new JTextField();
		jtApellido.setColumns(10);
		jtApellido.setBounds(103, 55, 207, 27);
                 jtApellido.setDocument(new LimitadorCaracteres(jtApellido, 50, 1));
		PanelDatosPersonales.add(jtApellido);
		
		JLabel jlCedula = new JLabel("C\u00E9dula");
		jlCedula.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlCedula.setBounds(10, 89, 64, 25);
		PanelDatosPersonales.add(jlCedula);
		
		jtCedula = new JTextField();
		jtCedula.setColumns(10);
		jtCedula.setBounds(103, 89, 207, 27);
                jtCedula.setDocument(new LimitadorCaracteres(jtCedula, 11, 0));
		PanelDatosPersonales.add(jtCedula);
		
		JLabel jlTelefono = new JLabel("Teléfono");
		jlTelefono.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlTelefono.setBounds(10, 123, 64, 25);
		PanelDatosPersonales.add(jlTelefono);
		
		jtTelefono = new JTextField();
		jtTelefono.setColumns(10);
		jtTelefono.setBounds(103, 123, 207, 27);
                jtTelefono.setDocument(new LimitadorCaracteres(jtTelefono, 11, 0));
		PanelDatosPersonales.add(jtTelefono);
		
		JLabel jlDireccion = new JLabel("Direcci\u00F3n");
		jlDireccion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlDireccion.setBounds(10, 159, 83, 25);
		PanelDatosPersonales.add(jlDireccion);
		
		jtDireccion = new JTextField();
		jtDireccion.setColumns(10);
		jtDireccion.setBounds(103, 159, 207, 27);
                jtDireccion.setDocument(new LimitadorCaracteres(jtDireccion, 50, 2));
		PanelDatosPersonales.add(jtDireccion);
		
		JLabel jlDatosSesion = new JLabel("Informaci\u00F3n de inicio de sesi\u00F3n");
		jlDatosSesion.setBounds(0, 274, 596, 34);
		panel.add(jlDatosSesion);
		jlDatosSesion.setOpaque(true);
		jlDatosSesion.setFont(new Font("Simplified Arabic", Font.BOLD, 17));
		jlDatosSesion.setBackground(new Color(95, 158, 160));
		
		JPanel panelDatosSesion = new JPanel();
		panelDatosSesion.setBounds(0, 324, 596, 89);
		panel.add(panelDatosSesion);
		panelDatosSesion.setLayout(null);
		panelDatosSesion.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(95, 158, 160), null, null, null));
		
		JLabel jlCodigo = new JLabel("Código");
		jlCodigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlCodigo.setBounds(10, 11, 97, 24);
		panelDatosSesion.add(jlCodigo);
		
		jtCodigo = new JTextField();
		jtCodigo.setEditable(false);
		jtCodigo.setBackground(Color.WHITE);
		jtCodigo.setColumns(10);
		jtCodigo.setBounds(117, 11, 195, 27);
                jtCodigo.setBorder(new LineBorder(new Color(171,173,179)));
		panelDatosSesion.add(jtCodigo);
		
		JLabel jlContrasea = new JLabel("Contrase\u00F1a");
		jlContrasea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlContrasea.setBounds(10, 45, 97, 27);
		panelDatosSesion.add(jlContrasea);
		
		jtContrasena = new JPasswordField();
		jtContrasena.setBounds(117, 45, 195, 27);
                jtContrasena.setDocument(new LimitadorCaracteres(jtContrasena, 50, 2));
		panelDatosSesion.add(jtContrasena);
		
		
		jbModificar = new JButton("Modificar");
		jbModificar.setBackground(new Color(95, 158, 160));
		jbModificar.setFont(new Font("SansSerif", Font.BOLD, 18));
		jbModificar.setBounds(120, 553,420, 36);
		getContentPane().add(jbModificar);
		
		JLabel jlCodigoModificar = new JLabel("Código Entrenador");
		jlCodigoModificar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlCodigoModificar.setBounds(26, 70, 165, 25);
		getContentPane().add(jlCodigoModificar);
		
		jtCodigoModificar = new JTextField();
		jtCodigoModificar.setColumns(10);
                jtCodigoModificar.setDocument(new LimitadorCaracteres(jtCodigoModificar, 5, 0));
		jtCodigoModificar.setBounds(182, 70, 186, 25);
		getContentPane().add(jtCodigoModificar);
		
		jbBuscar = new JButton("Buscar");
		jbBuscar.setFont(new Font("SansSerif", Font.PLAIN, 14));
		jbBuscar.setBackground(new Color(95, 158, 160));
		jbBuscar.setBounds(389, 70, 111, 25);
		getContentPane().add(jbBuscar);
                
                jlerrorBuscar = new JLabel("");
                jlerrorBuscar.setHorizontalAlignment(SwingConstants.CENTER);
                jlerrorBuscar.setForeground(new Color(255, 0, 0));
		jlerrorBuscar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlerrorBuscar.setBounds(505, 70, 100, 27);
		getContentPane().add(jlerrorBuscar);
                
                jlerror = new JLabel("");
                jlerror.setHorizontalAlignment(SwingConstants.CENTER);
                jlerror.setForeground(new Color(255, 0, 0));
		jlerror.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlerror.setBounds(10, 596, 650, 27);
		getContentPane().add(jlerror);
                
                UpdateModificarEntrenador moe = new UpdateModificarEntrenador(this);
                jbModificar.addActionListener(moe);
                jbBuscar.addActionListener(moe);
	}

}
