package com.bugabulls.vista;


import com.bugabulls.controlador.DAOFactory;
import com.bugabulls.controlador.ManejadorConsultarSesiones;
import com.bugabulls.modelo.Sesion;
import com.toedter.calendar.JDateChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class ConsultarSesiones extends JDialog {
	public JButton jbBuscar;
        public JTextArea jaEspecifi;
        public JComboBox jcSesiones;
        public JLabel jlNombre;
        public JDateChooser jdFecha;
        public JLabel jlerror;
        
	public ConsultarSesiones() {
            setModal(true);
            setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 580, 550);
		getContentPane().setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		CrearGui();
		}
		
		public void CrearGui(){
		
		JLabel jlTitulo = new JLabel("Consultar Sesiones de Entrenamiento");
		jlTitulo.setOpaque(true);
		jlTitulo.setForeground(Color.WHITE);
		jlTitulo.setFont(new Font("Simplified Arabic", Font.BOLD, 18));
		jlTitulo.setBackground(new Color(128, 128, 0));
		jlTitulo.setBounds(0, 0, 580, 44);
		getContentPane().add(jlTitulo);
		
		jbBuscar = new JButton("Buscar");
		jbBuscar.setFont(new Font("SansSerif", Font.PLAIN, 14));
		jbBuscar.setBackground(new Color(95, 158, 160));
		jbBuscar.setBounds(312, 69, 111, 27);
		getContentPane().add(jbBuscar);
		
		jcSesiones = new JComboBox();
		jcSesiones.setBounds(41, 70, 225, 27);
		getContentPane().add(jcSesiones);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBounds(22, 121, 517, 91);
		getContentPane().add(panel);
		
		JLabel jlNom = new JLabel("Nombre:");
		jlNom.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jlNom.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlNom.setBounds(0, 0, 565, 35);
		panel.add(jlNom);
                
                jlNombre = new JLabel("");
		jlNombre.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jlNombre.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlNombre.setBounds(70, 0, 565, 35);
		panel.add(jlNombre);
		
		JLabel jlFe = new JLabel("Fecha:");
		jlFe.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jlFe.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlFe.setBounds(0, 34, 565, 34);
		panel.add(jlFe);
                
                jdFecha = new JDateChooser();
		jdFecha.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jdFecha.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jdFecha.setBounds(70, 34, 120, 30);
		panel.add(jdFecha);
                jdFecha.setEnabled(false);
		
		JLabel jlEspecificaciones = new JLabel("Especificaciones:");
		jlEspecificaciones.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jlEspecificaciones.setBounds(0, 68, 128, 25);
		panel.add(jlEspecificaciones);
                
		
		jaEspecifi = new JTextArea();
		jaEspecifi.setEditable(false);
		jaEspecifi.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(32, 178, 170), null, null, null));
		jaEspecifi.setBounds(22, 223, 517, 249);
                
                jlerror = new JLabel("");
                jlerror.setHorizontalAlignment(SwingConstants.CENTER);
                jlerror.setForeground(new Color(255, 0, 0));
		jlerror.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlerror.setBounds(80,482, 400, 27);
		getContentPane().add(jlerror);
                
                
		getContentPane().add(jaEspecifi);
                llenarSesiones();
                ManejadorConsultarSesiones cs = new ManejadorConsultarSesiones(this);
                jbBuscar.addActionListener(cs);
	}
                public void llenarSesiones(){
                    try {
                        List<Sesion> listaSesion=DAOFactory.getSesionDAO().consultar();
                        for (Sesion sesion : listaSesion) {
                            jcSesiones.addItem(sesion.getNumerosesion());
                        }
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
}
