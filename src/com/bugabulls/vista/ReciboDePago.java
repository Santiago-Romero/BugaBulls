package com.bugabulls.vista;

import com.bugabulls.controlador.DAOFactory;
import com.bugabulls.controlador.LimitadorCaracteres;
import com.bugabulls.controlador.ManejadorReciboDePago;
import com.bugabulls.modelo.Administrador;
import com.bugabulls.modelo.Jugador;
import com.bugabulls.modelo.Pago;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.JRadioButton;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Cursor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ReciboDePago extends JDialog {
        public JLabel jlValor;
	public JTextField jtRecibidode;
	public JTextField jtRecibi;
	public JTextField jtCedula;
        public String fecha;
        public JComboBox jcCodigoJugador;
        public JButton jbPagar;
        public JLabel jlNumeroRecibo;
        public JLabel jlFechaPago;
        int numeroRecibo = 873827;
        boolean aparece;
        public String fechaSistema;
        public Date fechaHoy;
        int administradorLogeado;
        public JPanel panel;
        public JLabel jlerror;
	public ReciboDePago(MenuAdministrador ma,int administradorLogeado) {
            this.administradorLogeado=administradorLogeado;
                setModal(true);
		setBounds(100, 100, 670, 515);
		getContentPane().setLayout(null);
                setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                CrearGui();
        }
		public void CrearGui(){
                    Calendar c2 = new GregorianCalendar();
                    String dia = Integer.toString(c2.get(Calendar.DATE));
                String mes = Integer.toString(c2.get(Calendar.MONTH)+1);
                String año = Integer.toString(c2.get(Calendar.YEAR));
                fecha = año+"-"+mes+"-"+dia;
		panel = new JPanel();
		panel.setFont(new Font("Simplified Arabic", Font.PLAIN, 17));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 663, 477);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel jlLogo = new JLabel("");
		jlLogo.setBounds(25, 19, 116, 79);		
		ImageIcon logo= new ImageIcon(this.getClass().getResource("/com/bugabulls/imagen/logoEscuela.png"));
		Icon iconoLogo = new ImageIcon(logo.getImage().getScaledInstance(jlLogo.getWidth(), jlLogo.getHeight(),Image.SCALE_DEFAULT));
		jlLogo.setIcon(iconoLogo);
		this.repaint();		
		panel.add(jlLogo);
		
		JTextArea jtaEscuelaDeBaloncesto = new JTextArea();
		jtaEscuelaDeBaloncesto.setForeground(new Color(32, 178, 170));
		jtaEscuelaDeBaloncesto.setEditable(false);
		jtaEscuelaDeBaloncesto.setFont(new Font("Simplified Arabic", Font.BOLD, 14)); 
		jtaEscuelaDeBaloncesto.setText("           ESCUELA DE BALONCESTO \"BUGA BULLS\" \r\n             Calle 13a Nro 5e-01  Telefono: 2364482 \n                                Recibo de Pago             ");
		jtaEscuelaDeBaloncesto.setBounds(88, 26, 317, 82);
		panel.add(jtaEscuelaDeBaloncesto);
		
		JPanel panel_1 = new JPanel();
		panel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(32, 178, 170), null, null, null));
		panel_1.setBounds(26, 119, 601, 284);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel jlRecibidode = new JLabel("Recibido de :");
		jlRecibidode.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		jlRecibidode.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(32, 178, 170), null, null, null));
		jlRecibidode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jlRecibidode.setBounds(10, 38, 581, 28);
		panel_1.add(jlRecibidode);
		
		JLabel jlValorPagar = new JLabel("$ 25.000");
		jlValorPagar.setOpaque(true);
		jlValorPagar.setBackground(new Color(220, 220, 220));
		jlValorPagar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jlValorPagar.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(32, 178, 170), null, null, null));
		jlValorPagar.setBounds(446, 11, 145, 28);
		panel_1.add(jlValorPagar);
		
		JLabel jlPorConceptode = new JLabel("Por concepto de: Pago mensualidad");
		jlPorConceptode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jlPorConceptode.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(32, 178, 170), null, null, null));
		jlPorConceptode.setBounds(10, 104, 581, 28);
		panel_1.add(jlPorConceptode);
		
		JLabel jlSumade = new JLabel("La suma de: Veinticinco mil pesos");
		jlSumade.setOpaque(true);
		jlSumade.setBackground(new Color(220, 220, 220));
		jlSumade.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(32, 178, 170), null, null, null));
		jlSumade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jlSumade.setBounds(10, 77, 581, 28);
		panel_1.add(jlSumade);
		
		JLabel jlFechaCobro = new JLabel("Valor a cobrar");
		jlFechaCobro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jlFechaCobro.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(32, 178, 170), null, null, null));
		jlFechaCobro.setBounds(10, 11, 581, 28);
		panel_1.add(jlFechaCobro);
		
		JLabel jlEfectivo = new JLabel("Efectivo");
		jlEfectivo.setPreferredSize(new Dimension(42, 25));
		jlEfectivo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jlEfectivo.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(32, 178, 170), null, null, null));
		jlEfectivo.setBounds(10, 133, 581, 28);
		panel_1.add(jlEfectivo);
		
		JRadioButton jrbEfectivo = new JRadioButton("");
		jrbEfectivo.setBackground(new Color(255, 255, 255));
		jrbEfectivo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jrbEfectivo.setSelected(true);
		jrbEfectivo.setVerifyInputWhenFocusTarget(false);
		jrbEfectivo.setBounds(74, 135, 35, 23);		
		
		panel_1.add(jrbEfectivo);
                
                jtRecibi = new JTextField();
		jtRecibi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtRecibi.setColumns(10);
		jtRecibi.setBorder(null);
		jtRecibi.setBounds(74, 184, 388, 19);
		panel_1.add(jtRecibi);
		
		JLabel jlRecibi = new JLabel("Recib\u00ED:");
		jlRecibi.setOpaque(true);
		jlRecibi.setBackground(new Color(220, 220, 220));
		jlRecibi.setVerticalAlignment(SwingConstants.TOP);
		jlRecibi.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(32, 178, 170), null, null, null));
		jlRecibi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jlRecibi.setBounds(10, 182, 581, 42);
		panel_1.add(jlRecibi);
		
		JLabel jlCedula = new JLabel(" CC:");
		jlCedula.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(32, 178, 170), null, null, null));
		jlCedula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jlCedula.setBounds(10, 220, 581, 34);
		panel_1.add(jlCedula);
		
		JLabel jlCodigoJugador = new JLabel("Jugador:");
		jlCodigoJugador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jlCodigoJugador.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(32, 178, 170), null, null, null));
		jlCodigoJugador.setBounds(303, 38, 276, 28);
		panel_1.add(jlCodigoJugador);
		
		jlValor = new JLabel();
		jlValor.setBorder(null);
                jlValor.setEnabled(false);
		jlValor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jlValor.setBounds(125, 15, 125, 19);
		panel_1.add(jlValor);
		
		jtRecibidode = new JTextField();
		jtRecibidode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtRecibidode.setColumns(10);
		jtRecibidode.setBorder(null);
		jtRecibidode.setBounds(100, 44, 205, 19);
                jtRecibidode.setDocument(new LimitadorCaracteres(jtRecibidode, 50, 1));
		panel_1.add(jtRecibidode);
		
		
		
		jtCedula = new JTextField();
		jtCedula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtCedula.setColumns(10);
		jtCedula.setBorder(null);
		jtCedula.setBounds(51, 228, 230, 19);
                jtCedula.setDocument(new LimitadorCaracteres(jtCedula, 11, 0));
		panel_1.add(jtCedula);
		
		jcCodigoJugador = new JComboBox();
		jcCodigoJugador.setBackground(new Color(255, 255, 255));
		jcCodigoJugador.setBounds(370, 44, 200, 20);
		panel_1.add(jcCodigoJugador);
		
		JLabel jlNumeroRe = new JLabel("Numero");
		jlNumeroRe.setOpaque(true);
		jlNumeroRe.setForeground(new Color(255, 255, 255));
		jlNumeroRe.setBackground(new Color(32, 178, 170));
		jlNumeroRe.setHorizontalAlignment(SwingConstants.CENTER);
		jlNumeroRe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jlNumeroRe.setBounds(407, 35, 106, 17);
		panel.add(jlNumeroRe);
		
		jlNumeroRecibo = new JLabel("109473");
		jlNumeroRecibo.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(32, 178, 170), null, null, null));
		jlNumeroRecibo.setBounds(407, 52, 106, 24);
		panel.add(jlNumeroRecibo);
		
		JLabel jlFechaP = new JLabel("Fecha de pago");
		jlFechaP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jlFechaP.setOpaque(true);
		jlFechaP.setBackground(new Color(32, 178, 170));
		jlFechaP.setForeground(new Color(255, 255, 255));
		jlFechaP.setBounds(519, 35, 108, 17);
		panel.add(jlFechaP);
		
		jlFechaPago = new JLabel("");
		jlFechaPago.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(32, 178, 170), null, null, null));
		jlFechaPago.setBounds(519, 52, 108, 24);
                jlFechaPago.setText(fecha);
		panel.add(jlFechaPago);
		
		jbPagar = new JButton("Pagar");
		jbPagar.setForeground(new Color(255, 255, 255));
		jbPagar.setBackground(new Color(32, 178, 170));
		jbPagar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jbPagar.setBounds(233, 414, 160, 33);
		panel.add(jbPagar);
                
                jlerror = new JLabel("");
		jlerror.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jlerror.setBounds(222, 440, 175, 33);
		panel.add(jlerror);
                asignarNumeroRecibo();
                
                Date fechaActual = new Date();
                SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
                fechaSistema=formateador.format(fechaActual);
                adm();
                fechadelSistema();
                buscarJugadoresDeudores();
                ManejadorReciboDePago rdp=new ManejadorReciboDePago(this,numeroRecibo,administradorLogeado);
                jbPagar.addActionListener(rdp);

	}
                public void adm(){
        try {
            Administrador admin = DAOFactory.getAdministradorDAO().consultarPorId(administradorLogeado);
            jtCedula.setText(admin.getDniadministrador().toString());
            jtRecibi.setText(admin.getNombre());
            jtCedula.setEditable(false);
            jtRecibi.setEditable(false);
        } catch (Exception ex) {
            Logger.getLogger(ManejadorReciboDePago.class.getName()).log(Level.SEVERE, null, ex);
        }
                }
                public void fechadelSistema(){
            try {
                SimpleDateFormat formateador2 = new SimpleDateFormat("yyyy-MM-dd");
                fechaHoy = formateador2.parse(fechaSistema);
            } catch (ParseException ex) {
                Logger.getLogger(ReciboDePago.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
                }
                public void buscarJugadoresDeudores(){
                    
                    try {
                        List<Jugador> listaJugadores=DAOFactory.getJugadorDAO().consultar();
                        if(listaJugadores.isEmpty()){
                            JOptionPane.showMessageDialog(null, "No hay jugadores registrados");
                        }
                        else{
                        for (Jugador jugador : listaJugadores) {
                            System.out.println(jugador.getFechacobro()+" antes? "+fechaHoy);
                            if(jugador.getFechacobro().before(fechaHoy)){
                                jcCodigoJugador.addItem(jugador.getCodigojugador()+"-"+jugador.getNombre()+" "+jugador.getApellido());
                            }
                        }
                        }
                    } 
                    catch (Exception ex) {
                        Logger.getLogger(ReciboDePago.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if(jcCodigoJugador.getItemCount()==0){
                        JOptionPane.showMessageDialog(null,"No hay jugadores que deban");
                        jbPagar.setEnabled(false);
                        
                        
                    }
                }
                public void asignarNumeroRecibo(){
                    try {
                        List<Pago> listaPagos=DAOFactory.getPagoDAO().consultar();
                        for (Pago pago : listaPagos) {
                            if(pago.getCodigojugador()!=null){
                                numeroRecibo=(pago.getCodigopago())+1;
                            }
                        }
                    } catch (Exception ex){
                        Logger.getLogger(RegistrarJugador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    jlNumeroRecibo.setText(numeroRecibo+"");
                }
                
}
