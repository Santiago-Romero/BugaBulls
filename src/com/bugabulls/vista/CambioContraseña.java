package com.bugabulls.vista;

import com.bugabulls.controlador.ContCambioContraseña;
import com.bugabulls.controlador.LimitadorCaracteres;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import javafx.scene.control.PasswordField;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

public class CambioContraseña extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JPasswordField jtContraseñaNueva;
	public JPasswordField jtContraseñaNueva1;
        public JPasswordField jtContraseña;
        public JLabel jlError;
        public int logeado;
	public JButton jbCambiar;
        Login lg;
	public CambioContraseña(Login lg,int logeado) {
            this.logeado=logeado;
            this.lg=lg;
		setBounds(100, 100, 570, 479);
                setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);                
		setResizable(false);
		setLocationRelativeTo(null);             
                crearGui();
                        
                        }
              public void crearGui(){
                
		
		JLabel jlNombreCambio = new JLabel("Cambio contrase\u00F1a");
		jlNombreCambio.setBackground(new Color(128, 128, 0));
		jlNombreCambio.setOpaque(true);
		jlNombreCambio.setForeground(new Color(255, 255, 255));
		jlNombreCambio.setFont(new Font("Simplified Arabic", Font.BOLD, 18));
		jlNombreCambio.setBounds(0, 0, 554,52);
		contentPanel.add(jlNombreCambio);
		
		JLabel jlTitulo = new JLabel("Contrase\u00F1a actual");
		jlTitulo.setBackground(new Color(95, 158, 160));
		jlTitulo.setFont(new Font("Simplified Arabic", Font.BOLD, 17));
		jlTitulo.setOpaque(true);
		jlTitulo.setBounds(34, 63, 486, 28);
		contentPanel.add(jlTitulo);
		
		JPanel panel = new JPanel();
		panel.setBounds(34, 102, 486, 65);
		panel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(95, 158, 160), null, null, null));
		contentPanel.add(panel);
		
		JLabel jlContraseña = new JLabel("Contrase\u00F1a actual");
		jlContraseña.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlContraseña.setBounds(10, 15, 143, 25);
		panel.setLayout(null);
		panel.add(jlContraseña);
		
		jtContraseña = new JPasswordField();
		jtContraseña.setBounds(152, 15, 207, 27);
                jtContraseña.setDocument(new LimitadorCaracteres(jtContraseña, 50, 2));
		panel.add(jtContraseña);
		jtContraseña.setColumns(10);
		
		JLabel jlTitulo1 = new JLabel("Contrase\u00F1a nueva");
		jlTitulo1.setOpaque(true);
		jlTitulo1.setFont(new Font("Simplified Arabic", Font.BOLD, 17));
		jlTitulo1.setBackground(new Color(95, 158, 160));
		jlTitulo1.setBounds(34, 183, 486, 28);
		contentPanel.add(jlTitulo1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(95, 158, 160), null, null, null));
		panel_1.setAlignmentY(1.0f);
		panel_1.setBounds(34, 228, 486, 113);
		contentPanel.add(panel_1);
		
		JLabel jlContraseñaNueva = new JLabel("Contrase\u00F1a nueva");
		jlContraseñaNueva.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlContraseñaNueva.setBounds(10, 15, 143, 25);
		panel_1.add(jlContraseñaNueva);
		
		jtContraseñaNueva = new JPasswordField();
		jtContraseñaNueva.setColumns(10);
		jtContraseñaNueva.setBounds(152, 15, 207, 27);
                jtContraseñaNueva.setDocument(new LimitadorCaracteres(jtContraseñaNueva, 50, 2));
		panel_1.add(jtContraseñaNueva);
		
		JLabel jlContraseñaNueva1 = new JLabel("Verificar contrase\u00F1a");
		jlContraseñaNueva1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlContraseñaNueva1.setBounds(10, 62, 143, 25);
		panel_1.add(jlContraseñaNueva1);
		
		jtContraseñaNueva1 = new JPasswordField();
		jtContraseñaNueva1.setColumns(10);
		jtContraseñaNueva1.setBounds(152, 62, 207, 27);
                jtContraseñaNueva1.setDocument(new LimitadorCaracteres(jtContraseñaNueva1, 50, 2));
		panel_1.add(jtContraseñaNueva1);
		
		jbCambiar = new JButton("Cambiar contraseña");
		jbCambiar.setBackground(new Color(95, 158, 160));
		jbCambiar.setFont(new Font("SansSerif", Font.BOLD, 18));
		jbCambiar.setBounds(130, 364,301, 36);		
		contentPanel.add(jbCambiar);
                
                jlError = new JLabel("");
		jlError.setForeground(new Color(255, 0, 0));
		jlError.setHorizontalAlignment(SwingConstants.CENTER);
		jlError.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlError.setBounds(113, 411, 347, 25);
		contentPanel.add(jlError);
                
		ContCambioContraseña ccc = new ContCambioContraseña(this,lg);
		jbCambiar.addActionListener(ccc);
	}
             
             
}