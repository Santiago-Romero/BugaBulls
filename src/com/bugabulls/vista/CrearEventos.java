package com.bugabulls.vista;

import com.bugabulls.controlador.DAOFactory;
import com.bugabulls.controlador.LimitadorCaracteres;
import com.bugabulls.controlador.ManejadorCrearEventos;
import com.bugabulls.modelo.Evento;
import com.bugabulls.modelo.Jugador;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import com.toedter.calendar.JDateChooser;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class CrearEventos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField jtNombre,jtGastos,jtCiudad;
        public JButton jbGuardar;
        public JDateChooser jcFechaini,jcFechafin;
        public JLabel jlerror;
        int codigoEvento=500;
	public CrearEventos(MenuAdministrador ma) {
                setModal(true);
		setBounds(100, 100, 650, 465);
		getContentPane().setLayout(null);
                setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		CrearGui();
		}
	public void CrearGui(){
		
		JLabel jlTitulo = new JLabel("Nuevo Evento");
		jlTitulo.setOpaque(true);
		jlTitulo.setForeground(Color.WHITE);
		jlTitulo.setFont(new Font("Simplified Arabic", Font.BOLD, 18));
		jlTitulo.setBackground(new Color(128, 128, 0));
		jlTitulo.setBounds(0, 0, 644, 44);
		getContentPane().add(jlTitulo);
		
		JLabel jlDatosPersonales = new JLabel("Informaci\u00F3n ");
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
		PanelDatosPersonales.setBounds(26, 113, 596, 239);
		getContentPane().add(PanelDatosPersonales);
		
		JLabel jlNombre = new JLabel("Nombre Evento");
		jlNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlNombre.setBounds(10, 21, 123, 25);
		PanelDatosPersonales.add(jlNombre);
		
		jtNombre = new JTextField();
		jtNombre.setColumns(10);
		jtNombre.setBounds(243, 22, 207, 27);
                jtNombre.setDocument(new LimitadorCaracteres(jtNombre, 50, 1));
		PanelDatosPersonales.add(jtNombre);
		
		JLabel jlCiudad = new JLabel("Ciudad");
		jlCiudad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlCiudad.setBounds(10, 53, 83, 25);
		PanelDatosPersonales.add(jlCiudad);
		
		jtCiudad = new JTextField();
		jtCiudad.setColumns(10);
		jtCiudad.setBounds(243, 53, 207, 27);
                jtCiudad.setDocument(new LimitadorCaracteres(jtCiudad, 50, 1));
		PanelDatosPersonales.add(jtCiudad);
		
		JLabel jlGastos = new JLabel("Gastos");
		jlGastos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlGastos.setBounds(10, 87, 64, 25);
		PanelDatosPersonales.add(jlGastos);
		
		jtGastos = new JTextField();
		jtGastos.setColumns(10);
		jtGastos.setBounds(243, 88, 207, 27);
                jtGastos.setDocument(new LimitadorCaracteres(jtGastos, 20, 3));
		PanelDatosPersonales.add(jtGastos);
		
		JLabel jlFechaini = new JLabel("Fecha inicio");
		jlFechaini.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlFechaini.setBounds(10, 124, 83, 25);
		PanelDatosPersonales.add(jlFechaini);
		
		JLabel jlFechaFin = new JLabel("Fecha finalizaci\u00F3n");
		jlFechaFin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlFechaFin.setBounds(10, 159, 123, 25);
		PanelDatosPersonales.add(jlFechaFin);
                
		jcFechaini = new JDateChooser();
		jcFechaini.setDateFormatString("d-MM-yyyy");
		jcFechaini.setBounds(243, 124, 135, 25);
		PanelDatosPersonales.add(jcFechaini);
                Calendar c1 = GregorianCalendar.getInstance();
                jcFechaini.getJCalendar().setMinSelectableDate(c1.getTime());
		
		jcFechafin = new JDateChooser();
		jcFechafin.setBounds(243, 159, 135, 25);
		PanelDatosPersonales.add(jcFechafin);
                Calendar c2 = GregorianCalendar.getInstance();
                c2.add(Calendar.DAY_OF_YEAR, 1);
                jcFechafin.getJCalendar().setMinSelectableDate(c2.getTime());
                jlerror = new JLabel("");
                jlerror.setHorizontalAlignment(SwingConstants.CENTER);
                jlerror.setForeground(new Color(255, 0, 0));
		jlerror.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlerror.setBounds(10, 410, 650, 27);
		getContentPane().add(jlerror);
                
                
		jbGuardar = new JButton("Guardar");
		jbGuardar.setFont(new Font("SansSerif", Font.BOLD, 18));
		jbGuardar.setBackground(new Color(95, 158, 160));
		jbGuardar.setBounds(209, 366, 216, 34);
		getContentPane().add(jbGuardar);
		asignarCodigoEvento();
                /*llenarCantidadJugadores();*/
		ManejadorCrearEventos ce = new ManejadorCrearEventos(this,codigoEvento);
                jbGuardar.addActionListener(ce);
	}
        /*public void llenarCantidadJugadores(){
            try {
                int i;
                List<Jugador> listaJugadores=DAOFactory.getJugadorDAO().consultar();
                if(listaJugadores==null){
                    i=0;
                }
                else{
                    i=1;
                }
                for (Jugador jugador : listaJugadores) {
                    jcNumeroJugadores.addItem(i++);
                }
            } catch (Exception ex) {
                Logger.getLogger(CrearEventos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
        public void asignarCodigoEvento(){
                    try {
                        List<Evento> listaEventos=DAOFactory.getEventoDAO().consultar();
                        for (Evento evento : listaEventos) {
                            if(evento.getCodigoevento()!=null){
                                codigoEvento=(evento.getCodigoevento())+1;
                            }
                        }
                    } catch (Exception ex){
                        Logger.getLogger(RegistrarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
}
