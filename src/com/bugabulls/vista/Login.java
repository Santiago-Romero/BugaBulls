package com.bugabulls.vista;

import com.bugabulls.controlador.LeerContraBD;
import com.bugabulls.controlador.LimitadorCaracteres;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Frame;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.CompoundBorder;
import javax.swing.JTextField;

import com.bugabulls.controlador.ManejadorLogin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.UIManager;

public class Login extends JFrame {

	public JPanel Contenedor;
	public JTextField jtCodigo;
	public JPasswordField jtContrasena;
	public JButton jbEntrar,jbCrearBD;
        public JLabel jlError;
        public JLabel jlPresiona;
        public JLabel jlFlecha;
        public Icon iconoFlecha;
	public String usuarioG,contraG;
        
	public Login() {
            
		setResizable(false);
		setExtendedState(Frame.ICONIFIED);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 620);
		Contenedor = new JPanel();
		Contenedor.setForeground(new Color(255, 255, 255));
		Contenedor.setBorder(new CompoundBorder());
		setContentPane(Contenedor);
		Contenedor.setLayout(null);
		CrearGui();
	}
		public void CrearGui(){
		JLabel jlLogo = new JLabel("New label");
		jlLogo.setBounds(165, 23, 310, 130);		
		ImageIcon logo= new ImageIcon(this.getClass().getResource("/com/bugabulls/imagen/logoEscuela.png"));
		Icon iconoLogo = new ImageIcon(logo.getImage().getScaledInstance(jlLogo.getWidth(), jlLogo.getHeight(),Image.SCALE_DEFAULT));
		jlLogo.setIcon(iconoLogo);
		this.repaint();		
		Contenedor.add(jlLogo);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setForeground(new Color(255, 255, 255));
		panel.setBorder(new CompoundBorder());
		panel.setBounds(149, 159, 357, 350);
		Contenedor.add(panel);
		panel.setLayout(null);
		
		JLabel jlLoginTitulo = new JLabel("Login");
		jlLoginTitulo.setOpaque(true);
		jlLoginTitulo.setFont(new Font("Verdana", Font.BOLD, 21));
		jlLoginTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		jlLoginTitulo.setBackground(new Color(128, 128, 0));
		jlLoginTitulo.setForeground(new Color(255, 255, 255));
		jlLoginTitulo.setBounds(0, 0, 357, 55);
		panel.add(jlLoginTitulo);
		
		JLabel jlCodigo = new JLabel("Código de usuario");
		jlCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		jlCodigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlCodigo.setBounds(96, 77, 174, 26);
		panel.add(jlCodigo);
		
		jtCodigo = new JTextField();
		jtCodigo.setBackground(new Color(255, 255, 255));
		jtCodigo.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(230, 230, 250), null));
                jtCodigo.setDocument(new LimitadorCaracteres(jtCodigo, 5, 0));
		jtCodigo.setBounds(39, 114, 283, 31);
		panel.add(jtCodigo);
		jtCodigo.setColumns(10);
		
		JLabel jlContrasena = new JLabel("Contraseña");
		jlContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		jlContrasena.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlContrasena.setBounds(105, 165, 151, 20);
		panel.add(jlContrasena);
		
		jtContrasena = new JPasswordField();
		jtContrasena.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(230, 230, 250), null));
		jtContrasena.setBounds(39, 199, 283, 31);
                jtContrasena.setDocument(new LimitadorCaracteres(jtContrasena, 50, 2));
		panel.add(jtContrasena);
		jtContrasena.setColumns(10);
		
		jbEntrar = new JButton("Entrar");
		jbEntrar.setBorder(new CompoundBorder(new CompoundBorder(null, UIManager.getBorder("Button.border")), null));
		jbEntrar.setBorderPainted(false);
		jbEntrar.setBackground(new Color(128, 128, 0));
		jbEntrar.setForeground(new Color(255, 255, 255));
		jbEntrar.setFont(new Font("Verdana", Font.PLAIN, 17));
		jbEntrar.setBounds(39, 259, 283, 38);
		panel.add(jbEntrar);
                
                jlFlecha = new JLabel("");
		jlFlecha.setBounds(57, 514, 70, 53);		
		ImageIcon flecha= new ImageIcon(this.getClass().getResource("/com/bugabulls/imagen/flecha.png"));
		iconoFlecha = new ImageIcon(flecha.getImage().getScaledInstance(jlFlecha.getWidth(), jlFlecha.getHeight(),Image.SCALE_DEFAULT));
			
		                
                jlPresiona = new JLabel("");
		jlPresiona.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jlPresiona.setForeground(new Color(255, 0, 0));
		jlPresiona.setBounds(128, 505, 276, 53);
                
                Contenedor.add(jlPresiona);
                Contenedor.add(jlFlecha);
		
		jlError = new JLabel("");
		jlError.setForeground(new Color(255, 0, 0));
		jlError.setHorizontalAlignment(SwingConstants.CENTER);
		jlError.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlError.setBounds(10, 308, 347, 25);
		panel.add(jlError);
                
                jbCrearBD = new JButton("BD");
                jbCrearBD.setBounds(5, 545, 40, 40);
                ImageIcon logo2= new ImageIcon(this.getClass().getResource("/com/bugabulls/imagen/iconoBD.png"));
		Icon iconoLogo2 = new ImageIcon(logo2.getImage().getScaledInstance(jbCrearBD.getWidth()+10, jbCrearBD.getHeight(),Image.SCALE_DEFAULT));
                jbCrearBD.setIcon(iconoLogo2);
                Contenedor.add(jbCrearBD);
		
		JLabel jlFondo = new JLabel("");
		jlFondo.setBounds(0, 0, 648, 604);		
		ImageIcon fondo= new ImageIcon(this.getClass().getResource("/com/bugabulls/imagen/login2.jpg"));
		Icon iconoFondo = new ImageIcon(fondo.getImage().getScaledInstance(jlFondo.getWidth(), jlFondo.getHeight(),Image.SCALE_DEFAULT));
		jlFondo.setIcon(iconoFondo);
		this.repaint();		
		Contenedor.add(jlFondo);
		setLocationRelativeTo(null);
		leerContra();
		comprobarBase();
		ManejadorLogin ml = new ManejadorLogin(this);
		jbEntrar.addActionListener(ml);
                jbCrearBD.addActionListener(ml);
	}
                public void comprobarBase(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/",usuarioG,contraG);
			String comienzo = "use bugabulls;";
			Statement s = conexion.createStatement();
			s.executeUpdate(comienzo);
			conexion.close();
			jlError.setText("Conectado a la base de datos");
			jbCrearBD.setEnabled(false);
                            jtCodigo.setEnabled(true);
                            jtContrasena.setEnabled(true);
                            jbEntrar.setEnabled(true);
			} catch (Exception ex) {
                            jlError.setText("No se encontró la base de datos");
                            jbCrearBD.setEnabled(true);
                            jtCodigo.setEnabled(false);
                            jtContrasena.setEnabled(false);
                            jbEntrar.setEnabled(false);
                            jlFlecha.setIcon(iconoFlecha);
                            jlPresiona.setText("Presiona aqu\u00ED para crear la base de datos");
		             this.repaint();
                            System.out.println(ex);
		}
                }
                public void leerContra(){
		LeerContraBD LC=new LeerContraBD();
		usuarioG=LC.usuarioG;
		contraG=LC.contraG;
		}
}
