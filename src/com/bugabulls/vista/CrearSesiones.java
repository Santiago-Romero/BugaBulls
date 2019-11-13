package com.bugabulls.vista;

import com.bugabulls.controlador.DAOFactory;
import com.bugabulls.controlador.LimitadorCaracteres;
import com.bugabulls.controlador.ManejadorCrearSesiones;
import com.bugabulls.modelo.Categoria;
import com.bugabulls.modelo.Sesion;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class CrearSesiones extends JDialog {
	public JTextField jtNombre;
	public JDateChooser jdFecha;
	public JButton jbGuardar;
	public JTextArea jtaObservaciones;
        public JComboBox jcCategorias;
	int codigoSesion=55550;
        int entrenadorLogeado;
        public JLabel jlerror;
	public CrearSesiones(MenuEntrenador me,int entrenadorLogeado) {
            this.entrenadorLogeado=entrenadorLogeado;
            setModal(true);
		setBounds(100, 100, 580, 680);
		setResizable(false);
                setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		CrearGui();

	}
	
	public void CrearGui(){
		getContentPane().setLayout(null);
		
		JLabel jlTitulo = new JLabel("Crear Sesiones de Entrenamiento");
		jlTitulo.setBounds(0, 0, 574, 44);
		jlTitulo.setOpaque(true);
		jlTitulo.setForeground(Color.WHITE);
		jlTitulo.setFont(new Font("Simplified Arabic", Font.BOLD, 18));
		jlTitulo.setBackground(new Color(128, 128, 0));
		getContentPane().add(jlTitulo);
		
		
		jcCategorias = new JComboBox();
		jcCategorias.setBounds(117, 70, 225, 27);
		getContentPane().add(jcCategorias);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 121, 517, 91);
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(panel);
		
		JLabel jlNombre = new JLabel("Nombre:");
		jlNombre.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jlNombre.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlNombre.setBounds(0, 0, 565, 35);
		panel.add(jlNombre);
		
		JLabel jlFecha = new JLabel("Fecha:");
		jlFecha.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jlFecha.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlFecha.setBounds(0, 34, 565, 34);
		panel.add(jlFecha);
		
		JLabel jlEspecificaciones = new JLabel("Especificaciones:");
		jlEspecificaciones.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jlEspecificaciones.setBounds(0, 68, 128, 25);
		panel.add(jlEspecificaciones);
		
		jtNombre = new JTextField();
		jtNombre.setBorder(new EmptyBorder(0, 0, 0, 0));
		jtNombre.setBackground(UIManager.getColor("CheckBox.background"));
                jtNombre.setDocument(new LimitadorCaracteres(jtNombre, 50, 2));
		jtNombre.setBounds(59, 4, 436, 27);
		panel.add(jtNombre);
		jtNombre.setColumns(10);
		
		jdFecha = new JDateChooser();
		jdFecha.setBorder(new EmptyBorder(0, 0, 0, 0));
		jdFecha.setBackground(SystemColor.menu);
		jdFecha.setBounds(41, 38, 125, 27);
		panel.add(jdFecha);
		
		JLabel lblCategoras = new JLabel("Categor\u00EDas");
		lblCategoras.setBounds(22, 70, 88, 27);
		lblCategoras.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		getContentPane().add(lblCategoras);
		
			
		JScrollPane spObservaciones = new JScrollPane();
		spObservaciones.setBounds(22, 220, 517, 330);
		getContentPane().add(spObservaciones);
		
		jtaObservaciones = new JTextArea();
		spObservaciones.setViewportView(jtaObservaciones);
                jtaObservaciones.setDocument(new LimitadorCaracteres(jtaObservaciones, 250, 2));
		jtaObservaciones.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(32, 178, 170), null, null, null));
		
                
                jlerror = new JLabel("");
                jlerror.setHorizontalAlignment(SwingConstants.CENTER);
                jlerror.setForeground(new Color(255, 0, 0));
		jlerror.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlerror.setBounds(80, 621, 450, 14);
                getContentPane().add(jlerror);
                
                jbGuardar = new JButton("Guardar");
		jbGuardar.setBounds(171, 576, 216, 34);
		getContentPane().add(jbGuardar);
		jbGuardar.setFont(new Font("SansSerif", Font.BOLD, 18));
		jbGuardar.setBackground(new Color(95, 158, 160));
                asignarCodigoSesion();
                llenarCategorias();
                ManejadorCrearSesiones cs=new ManejadorCrearSesiones(this,entrenadorLogeado,codigoSesion);
                jbGuardar.addActionListener(cs);

	}
        public void asignarCodigoSesion(){
             try {
                        List<Sesion> listaSesiones=DAOFactory.getSesionDAO().consultar();
                        for (Sesion sesion : listaSesiones) {
                            if(sesion.getNumerosesion()!=null){
                                codigoSesion=(sesion.getNumerosesion())+1;
                            }
                        }
                    } catch (Exception ex){
                        Logger.getLogger(RegistrarJugador.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
        public void llenarCategorias(){
            try {
                        List<Categoria> listaCategorias=DAOFactory.getCategoriaDAO().consultar();
                        for (Categoria categoria : listaCategorias) {
                            if(categoria.getCodigoentrenador()!=null){
                                if(entrenadorLogeado==categoria.getCodigoentrenador().getCodigoentrenador()){
                                jcCategorias.addItem(categoria.getCodigocategoria()+" - "+categoria.getNombre());
                            }
                            }
                                    }
                    } catch (Exception ex) {
                        Logger.getLogger(PlantillasEntrenador.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
}
