package com.bugabulls.vista;

import com.bugabulls.controlador.DAOFactory;
import com.bugabulls.controlador.ManejadorConsultarEventos;
import com.bugabulls.modelo.Evento;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class ConsultarEventos extends JDialog {

	private final JPanel contentPanel = new JPanel();
        public JLabel jlnom,jlciu,jlgas,jlini,jlfin;
        public JComboBox jcjuga;
        public JComboBox jcEventos;
        public JButton jbBuscar;
        public JLabel jlerror;

	public ConsultarEventos() {
                setModal(true);
		setBounds(100, 100, 545, 480);
		getContentPane().setLayout(null);
                setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		CrearGui();
		}
	public void CrearGui(){
		
		JLabel jlTitulo = new JLabel("Consultar Evento");
		jlTitulo.setOpaque(true);
		jlTitulo.setForeground(Color.WHITE);
		jlTitulo.setFont(new Font("Simplified Arabic", Font.BOLD, 18));
		jlTitulo.setBackground(new Color(128, 128, 0));
		jlTitulo.setBounds(0, 0, 542, 44);
		getContentPane().add(jlTitulo);
		
		JLabel jlDatosPersonales = new JLabel("Informaci\u00F3n ");
		jlDatosPersonales.setOpaque(true);
		jlDatosPersonales.setForeground(Color.BLACK);
		jlDatosPersonales.setFont(new Font("Simplified Arabic", Font.BOLD, 17));
		jlDatosPersonales.setBackground(new Color(95, 158, 160));
		jlDatosPersonales.setBounds(26, 122, 489, 34);
		getContentPane().add(jlDatosPersonales);
		
		JPanel PanelDatosPersonales = new JPanel();
		PanelDatosPersonales.setLayout(null);
		PanelDatosPersonales.setBorder(new EmptyBorder(0, 0, 0, 0));
		PanelDatosPersonales.setAlignmentY(1.0f);
		PanelDatosPersonales.setBounds(26, 156, 489, 239);
		getContentPane().add(PanelDatosPersonales);
		
		JLabel jlNombre = new JLabel("Nombre Evento:");
		jlNombre.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlNombre.setBounds(10, 21, 442, 33);
		PanelDatosPersonales.add(jlNombre);
                
                jlnom = new JLabel("");
		jlnom.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlnom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlnom.setBounds(150, 21, 442, 33);
		PanelDatosPersonales.add(jlnom);
		
		JLabel jlCiudad = new JLabel("Ciudad:");
		jlCiudad.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlCiudad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlCiudad.setBounds(10, 53, 442, 33);
		PanelDatosPersonales.add(jlCiudad);
                
                jlciu = new JLabel("");
		jlciu.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlciu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlciu.setBounds(150, 53, 442, 33);
		PanelDatosPersonales.add(jlciu);
		
		JLabel jlGastos = new JLabel("Gastos:");
		jlGastos.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlGastos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlGastos.setBounds(10, 85, 442, 33);
		PanelDatosPersonales.add(jlGastos);
		
                jlgas = new JLabel("");
		jlgas.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlgas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlgas.setBounds(150, 85, 442, 33);
		PanelDatosPersonales.add(jlgas);
                
		JLabel jlFechaini = new JLabel("Fecha inicio:");
		jlFechaini.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlFechaini.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlFechaini.setBounds(10, 117, 442, 33);
		PanelDatosPersonales.add(jlFechaini);
                
                jlini = new JLabel("");
		jlini.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlini.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlini.setBounds(150, 117, 442, 33);
		PanelDatosPersonales.add(jlini);
		
		JLabel jlFechaFin = new JLabel("Fecha finalizaci\u00F3n:");
		jlFechaFin.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlFechaFin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlFechaFin.setBounds(10, 149, 442, 33);
		PanelDatosPersonales.add(jlFechaFin);
                
                JLabel jlcantjuga = new JLabel("Asistentes:");
                jlcantjuga.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlcantjuga.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlcantjuga.setBounds(10, 181, 442, 33);
                PanelDatosPersonales.add(jlcantjuga);
                jlfin = new JLabel("");
		jlfin.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlfin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlfin.setBounds(150, 149, 442, 33);
		PanelDatosPersonales.add(jlfin);
                
                jcjuga = new JComboBox();
		jcjuga.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jcjuga.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jcjuga.setBounds(180, 181, 250, 33);
		PanelDatosPersonales.add(jcjuga);
                
                jlerror = new JLabel("");
                jlerror.setHorizontalAlignment(SwingConstants.CENTER);
                jlerror.setForeground(new Color(255, 0, 0));
		jlerror.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlerror.setBounds(20, 422,500, 28);
		getContentPane().add(jlerror);		
		
		jcEventos = new JComboBox();
		jcEventos.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(32, 178, 170), null, null, null));
		jcEventos.setBackground(new Color(220, 220, 220));
		jcEventos.setBounds(26, 66, 299, 34);
		getContentPane().add(jcEventos);
		
		jbBuscar = new JButton("Buscar");
		jbBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		jbBuscar.setFont(new Font("SansSerif", Font.BOLD, 18));
		jbBuscar.setBackground(new Color(220, 220, 220));
		jbBuscar.setBounds(365, 68, 114, 32);
		getContentPane().add(jbBuscar);
		llenarEventos();
                ManejadorConsultarEventos ce = new ManejadorConsultarEventos(this);
                jbBuscar.addActionListener(ce);
		
	}
        public void llenarEventos(){
            try {
                List<Evento> listaEventos=DAOFactory.getEventoDAO().consultar();
                for (Evento eventos : listaEventos) {
                    jcEventos.addItem(eventos.getCodigoevento()+" - "+eventos.getNombre());
                }
            }
            catch (Exception ex) {
                System.out.println(ex);
            }
        }
}