
package com.bugabulls.vista;

import com.bugabulls.controlador.DAOFactory;
import com.bugabulls.controlador.EntityManagerHelper;
import com.bugabulls.modelo.Acudiente;
import com.bugabulls.modelo.Administrador;
import com.bugabulls.modelo.Evento;
import com.bugabulls.modelo.Jugador;
import com.bugabulls.modelo.JugadorEvento;
import com.bugabulls.modelo.Plantilla;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Santiago Romero
 */
public class Asistencia extends JDialog{
    public JButton jbAgregar;
    public JComboBox<String> jcJugadores;
    public JButton jbAceptar;
    public JTextArea jaJuga;
    public JLabel jlerror;
    CrearEventos ce;
    public int codigoEvento;
    public String eljuga="";
    public Asistencia(CrearEventos ce){
        this.ce=ce;
        this.codigoEvento=ce.codigoEvento;
        setModal(true);
		setBounds(100, 100, 650, 465);
		getContentPane().setLayout(null);
                setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		CrearGui();
    }
    public void CrearGui(){
		
		JLabel jlTitulo = new JLabel("Asistencia");
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
		
		JLabel jlNombre = new JLabel("Codigo Jugador");
		jlNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlNombre.setBounds(10, 21, 123, 25);
		PanelDatosPersonales.add(jlNombre);
		
		jcJugadores = new JComboBox<String>();
		jcJugadores.setBounds(243, 22, 207, 27);
		PanelDatosPersonales.add(jcJugadores);
		
		jbAgregar = new JButton("Agregar");
		jbAgregar.setBounds(243, 53, 207, 27);
		PanelDatosPersonales.add(jbAgregar);
		
		JLabel jlAsisten = new JLabel("Asiste");
		jlAsisten.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlAsisten.setBounds(10, 87, 64, 25);
		PanelDatosPersonales.add(jlAsisten);
		
		jaJuga = new JTextArea();
		jaJuga.setColumns(10);
		jaJuga.setBounds(243, 88, 207, 70);
		PanelDatosPersonales.add(jaJuga);
                                
                jbAceptar = new JButton("Aceptar");
                jbAceptar.setBounds(243, 194, 135, 25);
                PanelDatosPersonales.add(jbAceptar);
                
                jlerror = new JLabel("");
                jlerror.setHorizontalAlignment(SwingConstants.CENTER);
                jlerror.setForeground(new Color(255, 0, 0));
		jlerror.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlerror.setBounds(10, 410, 650, 27);
		getContentPane().add(jlerror);
                comboJugadores();
                jbAgregar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				agregar(Integer.parseInt(jcJugadores.getSelectedItem().toString().substring(0,5)));
                                jcJugadores.removeItem(jcJugadores.getSelectedItem());
				}
			});
                jbAceptar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				setVisible(false);
				}
			});
                
                
	}
    public void comboJugadores(){
        try {
            List<Jugador> listaJugador=DAOFactory.getJugadorDAO().consultar();
            for (Jugador jugador : listaJugador) {
                jcJugadores.addItem(jugador.getCodigojugador()+" - "+jugador.getNombre());
            }
        } catch (Exception ex) {
           System.out.println(ex);
        }
    }
    public void agregar(int jugadorSeleccionado){
        try {               
                List<Jugador> listaJugadores=DAOFactory.getJugadorDAO().consultar();
            for (Jugador jugador : listaJugadores) {
                if(jugadorSeleccionado==jugador.getCodigojugador()){
                    eljuga+=jugador.getCodigojugador()+" - "+jugador.getNombre()+"\n";
                    jaJuga.setText(eljuga);
                    agregarBase(jugador.getCodigojugador());
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(PlantillaJugador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void agregarBase(int elcodigo){
        try {
            EntityManagerHelper.beginTransaction();
            JugadorEvento nuevoJugadorEvento=new JugadorEvento();
            Evento evento=DAOFactory.getEventoDAO().consultarPorId(codigoEvento);
            nuevoJugadorEvento.setCodigoevento(evento);
            nuevoJugadorEvento.setCodigojugador(elcodigo);
            DAOFactory.getJugadorEventoDAO().insertar(nuevoJugadorEvento);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
        } catch (Exception ex) {
            System.out.println(ex);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
        }
    }
}
