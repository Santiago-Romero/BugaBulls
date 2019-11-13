package com.bugabulls.vista;


import com.bugabulls.controlador.DAOFactory;
import com.bugabulls.modelo.Jugador;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.BevelBorder;

public class FechaCobro extends JDialog {
    JLabel jlFechaCobro;
    int jugadorLogeado;
	public FechaCobro(MenuJugador mj,int jugadorLogeado) {
            this.jugadorLogeado=jugadorLogeado;
                setModal(true);
		setBounds(100, 100, 562, 222);
		getContentPane().setLayout(null);
                setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 546, 193);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel jlLogo = new JLabel("");
		jlLogo.setBounds(380, 0, 116, 79);		
		ImageIcon logo= new ImageIcon(this.getClass().getResource("/com/bugabulls/imagen/logoEscuela.png"));
		Icon iconoLogo = new ImageIcon(logo.getImage().getScaledInstance(jlLogo.getWidth(), jlLogo.getHeight(),Image.SCALE_DEFAULT));
		jlLogo.setIcon(iconoLogo);
		this.repaint();		
		panel.add(jlLogo);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("           ESCUELA DE BALONCESTO \"BUGA BULLS\" \r\n             Calle 13a Nro 5e-01  Telefono: 2364482 \n                                Fecha de Cobro             ");
		textArea.setForeground(new Color(32, 178, 170));
		textArea.setFont(new Font("Simplified Arabic", Font.BOLD, 14));
		textArea.setEditable(false);
		textArea.setBounds(10, 12, 546, 82);
		panel.add(textArea);
		
		JLabel jlFechaC = new JLabel("Fecha de cobro:");
		jlFechaC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jlFechaC.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(32, 178, 170), null, null, null));
		jlFechaC.setBounds(10, 107, 526, 28);
		panel.add(jlFechaC);
                
                jlFechaCobro = new JLabel("");
		jlFechaCobro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jlFechaCobro.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(32, 178, 170), null, null, null));
		jlFechaCobro.setBounds(130, 107, 526, 28);
		panel.add(jlFechaCobro);
		
		JLabel jlPrecio = new JLabel("$ 25.000");
		jlPrecio.setOpaque(true);
		jlPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jlPrecio.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(32, 178, 170), null, null, null));
		jlPrecio.setBackground(new Color(220, 220, 220));
		jlPrecio.setBounds(391, 107, 145, 28);
		panel.add(jlPrecio);
		
		JLabel jlCantidad = new JLabel("Total a pagar: Veinticinco mil pesos");
		jlCantidad.setOpaque(true);
		jlCantidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jlCantidad.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(32, 178, 170), null, null, null));
		jlCantidad.setBackground(new Color(220, 220, 220));
		jlCantidad.setBounds(10, 135, 526, 28);
		panel.add(jlCantidad);
                llenarPanel();
	}
        public void llenarPanel(){ 
        try {
            Jugador jugador=DAOFactory.getJugadorDAO().consultarPorId(jugadorLogeado);
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            
            jlFechaCobro.setText(formato.format(jugador.getFechacobro()));
        } catch (Exception ex) {
            Logger.getLogger(FechaCobro.class.getName()).log(Level.SEVERE, null, ex);
        }
                }
        

}
