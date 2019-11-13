package com.bugabulls.vista;

import com.bugabulls.controlador.DAOFactory;
import com.bugabulls.controlador.InsertRegistrarJugador;
import com.bugabulls.controlador.LimitadorCaracteres;
import com.bugabulls.modelo.Acudiente;
import com.bugabulls.modelo.Jugador;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.Rectangle;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class RegistrarJugador extends JDialog {
	private JLabel jlNombre;
	public JTextField jtNombre;
	public JTextField jtApellidos;
	public JTextField jtDireccion;
	public JTextField jtEps;
	public JTextField jtTelefono;
	public JTextField jtAltura;
	public JTextField jtCategoria;
	public JTextField jtCedulaFamiliar;
	public JTextField jtNombreFamiliar;
	public JTextField jtApellidosFamiliar;
	public JTextField jtParentescoFamiliar;
	public JTextField jtTelefonoFamiliar;
	public JTextField jtDireccionFamiliar;
	public JTextField jtCodigo;
	public JPasswordField jtContrasena;
        public String fechaCobro;
	public JTextField jtDni;
        public JButton jbGuardar;
        public JDateChooser jdFechaNacimiento;
        public JButton jbAgregarFoto;
        public JButton jbBuscarAcu;
        public JLabel jlerror;
        public JLabel jlFotoPerfil;
        int codigoJugador=10000;
        public int codigoAcudiente=80000;
        public JLabel jlerrorBuscar;
        public JLabel jlCm;
        
	public RegistrarJugador(MenuAdministrador ma) {
		setModal(true);
		setBounds(new Rectangle(0, 0, 660, 660));
		getContentPane().setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		CrearGui();
		
		}
		
		
		public void CrearGui(){
                Calendar c2 = new GregorianCalendar();
                String dia = Integer.toString(c2.get(Calendar.DATE));
                String mes = Integer.toString(c2.get(Calendar.MONTH)+1);
                String año = Integer.toString(c2.get(Calendar.YEAR));
                fechaCobro = año+"-"+mes+"-"+dia;
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(true);
		scrollPane.setPreferredSize(new Dimension(650, 660));
		scrollPane.setInheritsPopupMenu(true);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 650, 620);
		getContentPane().add(scrollPane);
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(650, 1000));
		scrollPane.setViewportView(panel);
		panel.setLayout(null);			
		
		JLabel jlRegistrarJugador = new JLabel("Ficha Jugador");
		jlRegistrarJugador.setBounds(0, 0, 644, 44);
		jlRegistrarJugador.setOpaque(true);
		jlRegistrarJugador.setBackground(new Color(128, 128, 0));
		jlRegistrarJugador.setForeground(new Color(255, 255, 255));
		jlRegistrarJugador.setFont(new Font("Simplified Arabic", Font.BOLD, 18));
		panel.add(jlRegistrarJugador);
		
		JPanel panelDatosPersonales = new JPanel();
		panelDatosPersonales.setBounds(26, 112, 596, 334);
		panelDatosPersonales.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panelDatosPersonales.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(95, 158, 160), null, null, null));
		panel.add(panelDatosPersonales);
		
		jlNombre = new JLabel("Nombre");
		jlNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlNombre.setBounds(10, 15, 64, 25);
		panelDatosPersonales.setLayout(null);
		panelDatosPersonales.add(jlNombre);
		
		jtNombre = new JTextField();
		jtNombre.setBounds(103, 15, 207, 27);
                jtNombre.setDocument(new LimitadorCaracteres(jtNombre, 50, 1));
		panelDatosPersonales.add(jtNombre);
		jtNombre.setColumns(10);
		
		JLabel jlApellidos = new JLabel("Apellidos");
		jlApellidos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlApellidos.setBounds(10, 49, 83, 25);
		panelDatosPersonales.add(jlApellidos);
		
		jtApellidos = new JTextField();
		jtApellidos.setBounds(103, 49, 207, 27);
                jtApellidos.setDocument(new LimitadorCaracteres(jtApellidos, 50, 1));
		panelDatosPersonales.add(jtApellidos);
		jtApellidos.setColumns(10);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDireccin.setBounds(10, 184, 83, 26);
		panelDatosPersonales.add(lblDireccin);
		
		jtDireccion = new JTextField();
		jtDireccion.setBounds(103, 184, 207, 27);
                jtDireccion.setDocument(new LimitadorCaracteres(jtDireccion, 50, 2));
		panelDatosPersonales.add(jtDireccion);
		jtDireccion.setColumns(10);
		
		JLabel lblEps = new JLabel("EPS");
		lblEps.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEps.setBounds(10, 150, 46, 27);
		panelDatosPersonales.add(lblEps);
		
		jtEps = new JTextField();
		jtEps.setBounds(103, 150, 207, 27);
                jtEps.setDocument(new LimitadorCaracteres(jtEps, 50, 1));
		panelDatosPersonales.add(jtEps);
		jtEps.setColumns(10);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFechaDeNacimiento.setBounds(10, 116, 157, 27);
		panelDatosPersonales.add(lblFechaDeNacimiento);
		
		JLabel jlTelefono = new JLabel("Teléfono");
		jlTelefono.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlTelefono.setBounds(10, 218, 83, 25);
		panelDatosPersonales.add(jlTelefono);
		
		jtTelefono = new JTextField();
		jtTelefono.setBounds(103, 218, 207, 27);
                jtTelefono.setDocument(new LimitadorCaracteres(jtTelefono, 10, 0));
		panelDatosPersonales.add(jtTelefono);
		jtTelefono.setColumns(10);
		
		jdFechaNacimiento = new JDateChooser();
		jdFechaNacimiento.setBounds(164, 116, 143, 27);
		panelDatosPersonales.add(jdFechaNacimiento);
                 Calendar c1 = GregorianCalendar.getInstance();
                 c1.add(Calendar.YEAR, -6);
                 jdFechaNacimiento.getJCalendar().setMaxSelectableDate(c1.getTime());
                 c1.add(Calendar.YEAR, -13);
                jdFechaNacimiento.getJCalendar().setMinSelectableDate(c1.getTime());
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAltura.setBounds(10, 252, 64, 25);
		panelDatosPersonales.add(lblAltura);
		
		jtAltura = new JTextField();
		jtAltura.setBounds(103, 252, 207, 27);
                jtAltura.setDocument(new LimitadorCaracteres(jtAltura, 3, 0));
		panelDatosPersonales.add(jtAltura);
		jtAltura.setColumns(10);
                
                jlCm = new JLabel("cm");
		jlCm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlCm.setBounds(312, 252,100, 27);
		panelDatosPersonales.add(jlCm);
		
		
		jlFotoPerfil = new JLabel("");
		jlFotoPerfil.setBounds(369, 15, 186, 177);
		ImageIcon fotoPerfil= new ImageIcon(this.getClass().getResource("/com/bugabulls/imagen/fotoPerfil.png"));
		Icon iconoPerfil = new ImageIcon(fotoPerfil.getImage().getScaledInstance(jlFotoPerfil.getWidth(), jlFotoPerfil.getHeight(),Image.SCALE_DEFAULT));
		this.repaint();	
		jlFotoPerfil.setIcon(iconoPerfil);
		panelDatosPersonales.add(jlFotoPerfil);
		
		jbAgregarFoto = new JButton("Agregar foto");
		jbAgregarFoto.setBackground(new Color(95, 158, 160));
		jbAgregarFoto.setFont(new Font("SansSerif", Font.PLAIN, 14));
		jbAgregarFoto.setBounds(399, 217, 128, 36);
		panelDatosPersonales.add(jbAgregarFoto);
		
		JLabel jlDni = new JLabel("DNI");
		jlDni.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlDni.setBounds(10, 81, 83, 26);
		panelDatosPersonales.add(jlDni);
		
		jtDni = new JTextField();
		jtDni.setColumns(10);
		jtDni.setBounds(103, 81, 207, 27);
                jtDni.setDocument(new LimitadorCaracteres(jtDni, 11, 0));
		panelDatosPersonales.add(jtDni);
		
		JLabel jlTituloDatosPersonales = new JLabel("Datos Personales");
		jlTituloDatosPersonales.setBounds(26, 62, 596, 34);
		jlTituloDatosPersonales.setOpaque(true);
		jlTituloDatosPersonales.setBackground(new Color(95, 158, 160));
		jlTituloDatosPersonales.setForeground(new Color(0, 0, 0));
		jlTituloDatosPersonales.setFont(new Font("Simplified Arabic", Font.BOLD, 17));
		panel.add(jlTituloDatosPersonales);
						
		JLabel jlCategoria = new JLabel("Categor\u00EDa ");
		jlCategoria.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlCategoria.setBounds(10, 286, 97, 24);
		panelDatosPersonales.add(jlCategoria);
		
		jtCategoria = new JTextField();
                jtCategoria.setBackground(Color.WHITE);
		jtCategoria.setColumns(10);
		jtCategoria.setBounds(103,286, 207, 27);
                jtCategoria.setBorder(new LineBorder(new Color(171,173,179)));
		jtCategoria.setEditable(false);
		panelDatosPersonales.add(jtCategoria);
		                
		JLabel jlDatosFamiliares = new JLabel("Datos familiares");
		jlDatosFamiliares.setBounds(26, 463, 596, 34);
		jlDatosFamiliares.setOpaque(true);
		jlDatosFamiliares.setFont(new Font("Simplified Arabic", Font.BOLD, 17));
		jlDatosFamiliares.setBackground(new Color(95, 158, 160));
		panel.add(jlDatosFamiliares);
		
		JPanel panelDatosFamiliares = new JPanel();
		panelDatosFamiliares.setBounds(26, 513, 596, 220);
		panelDatosFamiliares.setLayout(null);
		panelDatosFamiliares.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(95, 158, 160), null, null, null));
		panel.add(panelDatosFamiliares);
		
		JLabel jlCedulaFamiliar = new JLabel("Cédula");
		jlCedulaFamiliar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlCedulaFamiliar.setBounds(10, 11, 97, 24);
		panelDatosFamiliares.add(jlCedulaFamiliar);
		
		jtCedulaFamiliar = new JTextField();                
		jtCedulaFamiliar.setColumns(10);
		jtCedulaFamiliar.setBounds(117, 11, 195, 27);
                jtCedulaFamiliar.setDocument(new LimitadorCaracteres(jtCedulaFamiliar, 10, 0));
		panelDatosFamiliares.add(jtCedulaFamiliar);
		
		JLabel jlNombreFamiliar = new JLabel("Nombre");
		jlNombreFamiliar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlNombreFamiliar.setBounds(10, 45, 69, 27);
		panelDatosFamiliares.add(jlNombreFamiliar);
		
		jtNombreFamiliar = new JTextField();
		jtNombreFamiliar.setColumns(10);
		jtNombreFamiliar.setBounds(117, 45, 195, 27);
                jtNombreFamiliar.setDocument(new LimitadorCaracteres(jtNombreFamiliar, 50, 1));
		panelDatosFamiliares.add(jtNombreFamiliar);
		
		JLabel jlApellidosFamiliar = new JLabel("Apellidos");
		jlApellidosFamiliar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlApellidosFamiliar.setBounds(10, 79, 97, 27);
		panelDatosFamiliares.add(jlApellidosFamiliar);
		
		jtApellidosFamiliar = new JTextField();
		jtApellidosFamiliar.setColumns(10);
		jtApellidosFamiliar.setBounds(117, 79, 195, 27);
                jtApellidosFamiliar.setDocument(new LimitadorCaracteres(jtApellidosFamiliar, 50, 1));
		panelDatosFamiliares.add(jtApellidosFamiliar);
		
		jtParentescoFamiliar = new JTextField();
		jtParentescoFamiliar.setColumns(10);
		jtParentescoFamiliar.setBounds(117, 112, 195, 27);
                jtParentescoFamiliar.setDocument(new LimitadorCaracteres(jtParentescoFamiliar, 50, 1));
		panelDatosFamiliares.add(jtParentescoFamiliar);
		
		JLabel jlParentescoFamiliar = new JLabel("Parentesco");
		jlParentescoFamiliar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlParentescoFamiliar.setBounds(10, 112, 97, 27);
		panelDatosFamiliares.add(jlParentescoFamiliar);
		
		jtTelefonoFamiliar = new JTextField();
		jtTelefonoFamiliar.setColumns(10);
		jtTelefonoFamiliar.setBounds(117, 146, 195, 27);
                jtTelefonoFamiliar.setDocument(new LimitadorCaracteres(jtTelefonoFamiliar, 10, 0));
		panelDatosFamiliares.add(jtTelefonoFamiliar);
		
		JLabel jlTelefonoFamiliar = new JLabel("Teléfono");
		jlTelefonoFamiliar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlTelefonoFamiliar.setBounds(10, 146, 97, 27);
		panelDatosFamiliares.add(jlTelefonoFamiliar);
		
		JLabel jlDireccionFamiliar = new JLabel("Dirección");
		jlDireccionFamiliar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlDireccionFamiliar.setBounds(10, 182, 97, 27);
		panelDatosFamiliares.add(jlDireccionFamiliar);
		
		jtDireccionFamiliar = new JTextField();
		jtDireccionFamiliar.setColumns(10);
		jtDireccionFamiliar.setBounds(117, 182, 195, 27);
                jtDireccionFamiliar.setDocument(new LimitadorCaracteres(jtDireccionFamiliar, 50, 2));
		panelDatosFamiliares.add(jtDireccionFamiliar);
		
		JLabel jlDatosSesion = new JLabel("Información de inicio de sesión");
		jlDatosSesion.setBounds(26, 750, 596, 34);
		jlDatosSesion.setOpaque(true);
		jlDatosSesion.setFont(new Font("Simplified Arabic", Font.BOLD, 17));
		jlDatosSesion.setBackground(new Color(95, 158, 160));
		panel.add(jlDatosSesion);
		
		JPanel panelDatosSesion = new JPanel();
		panelDatosSesion.setBounds(26, 800, 596, 89);
		panelDatosSesion.setLayout(null);
		panelDatosSesion.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(95, 158, 160), null, null, null));
		panel.add(panelDatosSesion);
		
		JLabel jlCodigo = new JLabel("Código");
		jlCodigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlCodigo.setBounds(10, 11, 97, 24);
		panelDatosSesion.add(jlCodigo);
		
		jtCodigo = new JTextField();
		jtCodigo.setBackground(Color.WHITE);
		jtCodigo.setColumns(10);
		jtCodigo.setBounds(117, 11, 195, 27);
		jtCodigo.setEditable(false);
                jtCodigo.setBorder(new LineBorder(new Color(171,173,179)));
		panelDatosSesion.add(jtCodigo);
		
		JLabel jlContrasea = new JLabel("Contraseña");
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
		jbGuardar.setBounds(120, 908,420, 36);
		panel.add(jbGuardar);
                
                jbBuscarAcu = new JButton("Buscar");
		jbBuscarAcu.setBackground(new Color(95, 158, 160));
		jbBuscarAcu.setFont(new Font("SansSerif", Font.BOLD, 18));
		jbBuscarAcu.setBounds(320, 11, 97, 24);
		panelDatosFamiliares.add(jbBuscarAcu);
                
                
                jlerrorBuscar = new JLabel("");                
                jlerrorBuscar.setForeground(new Color(255, 0, 0));
		jlerrorBuscar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlerrorBuscar.setBounds(440,11, 300, 27);
		panelDatosFamiliares.add(jlerrorBuscar);
                
                 jlerror = new JLabel("");
                jlerror.setHorizontalAlignment(SwingConstants.CENTER);
                jlerror.setForeground(new Color(255, 0, 0));
		jlerror.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlerror.setBounds(10, 948, 650, 27);
		panel.add(jlerror);
                
                
		asignarCodigoJugador();
                InsertRegistrarJugador rj = new InsertRegistrarJugador(this,codigoJugador);
                jbGuardar.addActionListener(rj);
                jbBuscarAcu.addActionListener(rj);
                jbAgregarFoto.addActionListener(rj);
		}
                public void asignarCodigoJugador(){
                    try {
                        List<Jugador> listaJugadores=DAOFactory.getJugadorDAO().consultar();
                        for (Jugador jugador : listaJugadores) {
                            if(jugador.getCodigojugador()!=null){
                                codigoJugador=(jugador.getCodigojugador())+1;
                            }
                        }
                    } catch (Exception ex){
                        Logger.getLogger(RegistrarJugador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    jtCodigo.setText(codigoJugador+"");
                    try {
                        List<Acudiente> listaAcudientes=DAOFactory.getAcudienteDAO().consultar();
                        for (Acudiente acudiente : listaAcudientes) {
                            if(acudiente.getCodigoacudiente()!=null){
                                codigoAcudiente=(acudiente.getCodigoacudiente())+1;
                            }
                        }
                    } catch (Exception ex){
                        Logger.getLogger(RegistrarJugador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
}
	
