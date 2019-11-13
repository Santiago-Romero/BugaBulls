package com.bugabulls.vista;

import com.bugabulls.controlador.DAOFactory;
import com.bugabulls.controlador.UpdateAsignarCategoriaBen;
import com.bugabulls.modelo.Entrenador;
import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.sql.Time;
import javax.swing.SwingConstants;
public class AsignarCategoriaBen extends JDialog {
	public JSpinner jsHorarios;	
	public JTextField jtCategoria;
        public JComboBox jcEntrenador;
        public JButton jbGuardar;
	public SpinnerDateModel dateModel;
        public Time time;
        public JLabel jlerror;
        
	public AsignarCategoriaBen(MenuAdministrador ma) {
                setModal(true);
		setBounds(100, 100, 650, 380);
		getContentPane().setLayout(null);
                setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		CrearGui();
                
		}
		public void CrearGui(){
		JLabel jlTitulo = new JLabel("Asignar Categor\u00EDa Benjamines");
		jlTitulo.setOpaque(true);
		jlTitulo.setForeground(Color.WHITE);
		jlTitulo.setFont(new Font("Simplified Arabic", Font.BOLD, 18));
		jlTitulo.setBackground(new Color(128, 128, 0));
		jlTitulo.setBounds(0, 0, 644, 44);
		getContentPane().add(jlTitulo);
		
		JLabel jlTitulo1 = new JLabel("Informaci\u00F3n Categor\u00EDa");
		jlTitulo1.setOpaque(true);
		jlTitulo1.setForeground(Color.BLACK);
		jlTitulo1.setFont(new Font("Simplified Arabic", Font.BOLD, 17));
		jlTitulo1.setBackground(new Color(95, 158, 160));
		jlTitulo1.setBounds(26, 62, 596, 34);
		getContentPane().add(jlTitulo1);
		
		JPanel PanelDatosPersonales = new JPanel();
		PanelDatosPersonales.setLayout(null);
		PanelDatosPersonales.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(95, 158, 160), null, null, null));
		PanelDatosPersonales.setAlignmentY(1.0f);
		PanelDatosPersonales.setBounds(26, 112, 596, 137);
		getContentPane().add(PanelDatosPersonales);
		
		JLabel jlCategoria = new JLabel("Categor\u00EDa");
		jlCategoria.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlCategoria.setBounds(10, 11, 83, 25);
		PanelDatosPersonales.add(jlCategoria);
		
		
		JLabel jlHorarios = new JLabel("Horario");
		jlHorarios.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlHorarios.setBounds(10, 45, 83, 25);
		PanelDatosPersonales.add(jlHorarios);	
		
		
		JLabel jlEntrenador = new JLabel("Entrenador");
		jlEntrenador.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlEntrenador.setBounds(10, 77, 83, 25);
		PanelDatosPersonales.add(jlEntrenador);
                
                dateModel = new SpinnerDateModel();
                jsHorarios = new JSpinner(dateModel);
                JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(jsHorarios, "HH:mm:ss");
                jsHorarios.setEditor(timeEditor);
                time = new Time(dateModel.getDate().getTime());
		jsHorarios.setBounds(103, 45, 207, 27);
		PanelDatosPersonales.add(jsHorarios);
		
		jtCategoria = new JTextField();
		jtCategoria.setFont(new Font("Traditional Arabic", Font.PLAIN, 16));
		jtCategoria.setText("Benjamines");
		jtCategoria.setColumns(10);
		jtCategoria.setBounds(103, 11, 207, 27);
		jtCategoria.setBackground(Color.WHITE);
		jtCategoria.setEditable(false);
		PanelDatosPersonales.add(jtCategoria);
		
		jcEntrenador = new JComboBox();
		jcEntrenador.setBounds(103, 77, 176, 25);
		PanelDatosPersonales.add(jcEntrenador);
                llenarEntrenador();
		
		jbGuardar = new JButton("Guardar");
		jbGuardar.setFont(new Font("SansSerif", Font.BOLD, 18));
		jbGuardar.setBackground(new Color(95, 158, 160));
		jbGuardar.setBounds(230, 270, 170, 27);
		getContentPane().add(jbGuardar);
                
                jlerror = new JLabel("");
                jlerror.setHorizontalAlignment(SwingConstants.CENTER);
                jlerror.setForeground(new Color(255, 0, 0));
		jlerror.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jlerror.setBounds(00, 307, 650, 27);
		 getContentPane().add(jlerror);
                
                
                UpdateAsignarCategoriaBen acb = new UpdateAsignarCategoriaBen(this);
                jbGuardar.addActionListener(acb);
	}
                public void llenarEntrenador(){
                    try {
                        List<Entrenador> listaEntrenador=DAOFactory.getEntrenadorDAO().consultar();
                        for (Entrenador entrenador : listaEntrenador) {
                            jcEntrenador.addItem(entrenador.getCodigoentrenador()+" - "+entrenador.getNombre());
                        }
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
}

