package com.bugabulls.vista;
import com.bugabulls.controlador.ConCopiasSeguridad;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.JSeparator;

public class CopiasSeguridad extends JDialog {
private final JPanel panel = new JPanel();
	public JButton jbCopia;
	public CopiasSeguridad() {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		setBounds(100, 100, 486, 218);
		getContentPane().setLayout(null);
		panel.setBounds(0, 0, 470, 1);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panel);
		panel.setLayout(null);
                setModal(true);
                setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);                            
		setResizable(false);
		setLocationRelativeTo(null);
                CrearGui();
        }
		public void CrearGui(){
                JLabel jlNombreCopia = new JLabel("Copia de Seguridad");
		jlNombreCopia.setBounds(0, 0, 470, 52);
		getContentPane().add(jlNombreCopia);
		jlNombreCopia.setBackground(new Color(128, 128, 0));
		jlNombreCopia.setOpaque(true);		
		jlNombreCopia.setForeground(new Color(255, 255, 255));
		jlNombreCopia.setFont(new Font("Simplified Arabic", Font.BOLD, 18));  
                
                JLabel jlTituloCopia = new JLabel("Copia seguridad");
		jlTituloCopia.setBounds(20, 63, 440, 34);
		getContentPane().add(jlTituloCopia);
		jlTituloCopia.setOpaque(true);
		jlTituloCopia.setBackground(new Color(95, 158, 160));
		jlTituloCopia.setForeground(new Color(0, 0, 0));
		jlTituloCopia.setFont(new Font("Simplified Arabic", Font.BOLD, 17));
                    
                    
                    
		jbCopia = new JButton("Realizar copia de seguridad ahora");
		jbCopia.setBounds(107, 108, 246, 42);
		jbCopia.setBackground(new Color(95, 158, 160));
		jbCopia.setFont(new Font("SansSerif", Font.BOLD, 12));
		getContentPane().add(jbCopia);
		
		ConCopiasSeguridad ccs =new ConCopiasSeguridad(this);
                jbCopia.addActionListener(ccs);
	}
}