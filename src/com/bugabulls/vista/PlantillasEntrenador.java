package com.bugabulls.vista;


import com.bugabulls.controlador.DAOFactory;
import com.bugabulls.controlador.LimitadorCaracteres;
import com.bugabulls.controlador.ManejadorPlantillasEntrenador;
import com.bugabulls.modelo.Categoria;
import com.bugabulls.modelo.Plantilla;
import com.toedter.calendar.JDateChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.SystemColor;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class PlantillasEntrenador extends JDialog {
	public JTextField jtNombre;
	public JTextField jtEps;
	public JTextField jtAltura;
	public JTextField jtPeso;
	public JTextField jtImc;
	public JComboBox jtPosicion;
	public JTextField jtSuicidio;
	public JTextField jtPorcentajeCesta;
	public JTextField jtVueltasCancha;
        public JButton jbModificar;
        public JLabel jlerror;
        public JLabel jlerrorBuscar;
        public JLabel jlFotoPerfil;
    public JTextArea jtaObservaciones;
    int entrenadorLogeado;
    public JComboBox jcCategorias;
    public JComboBox jcJugador;
    public JButton jbBuscar,jbBuscarJugador;
    int plantillaNumero=11110;
    public JDateChooser jdFechaNacimiento;
    public JButton jbcalc;
    public JPanel panel;
	public PlantillasEntrenador(MenuEntrenador me, int entrenadorLogeado) {
            this.entrenadorLogeado=entrenadorLogeado;
            setModal(true);
		setBounds(0, 0, 645, 660);
		getContentPane().setLayout(null);
                setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		crearGui();
		}
		
		
		public void crearGui(){
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(true);
		scrollPane.setPreferredSize(new Dimension(700, 655));
		scrollPane.setInheritsPopupMenu(true);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 641, 620);
		getContentPane().add(scrollPane);  
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setPreferredSize(new Dimension(645,980));
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
                
		JLabel jlTitulo = new JLabel("Plantillas");
		jlTitulo.setOpaque(true);
		jlTitulo.setForeground(Color.WHITE);
		jlTitulo.setFont(new Font("Simplified Arabic", Font.BOLD, 18));
		jlTitulo.setBackground(new Color(128, 128, 0));
		jlTitulo.setBounds(0, 0, 633, 44);
		panel.add(jlTitulo);
		
		JPanel panelBuscar = new JPanel();
		panelBuscar.setBorder(new LineBorder(new Color(32, 178, 170)));
		panelBuscar.setBounds(10, 55, 613, 149);
		panel.add(panelBuscar);
		panelBuscar.setLayout(null);
		
		JLabel jlMisCategorias = new JLabel("Mis categor\u00EDas");
		jlMisCategorias.setBounds(0, 0, 613, 21);
		panelBuscar.add(jlMisCategorias);
		jlMisCategorias.setOpaque(true);
		jlMisCategorias.setForeground(Color.BLACK);
		jlMisCategorias.setFont(new Font("Simplified Arabic", Font.BOLD, 17));
		jlMisCategorias.setBackground(Color.LIGHT_GRAY);
		
		jcCategorias = new JComboBox();
		jcCategorias.setBounds(0, 32, 225, 27);
		panelBuscar.add(jcCategorias);
		
		jbBuscar = new JButton("Buscar");
		jbBuscar.setBounds(271, 32, 111, 27);
		panelBuscar.add(jbBuscar);
		jbBuscar.setFont(new Font("SansSerif", Font.PLAIN, 14));
		jbBuscar.setBackground(new Color(95, 158, 160));
		
		JLabel jlPlantillasJugador = new JLabel("Plantillas por jugador");
		jlPlantillasJugador.setBounds(0, 70, 613, 21);
		panelBuscar.add(jlPlantillasJugador);
		jlPlantillasJugador.setOpaque(true);
		jlPlantillasJugador.setForeground(Color.BLACK);
		jlPlantillasJugador.setFont(new Font("Simplified Arabic", Font.BOLD, 17));
		jlPlantillasJugador.setBackground(Color.LIGHT_GRAY);
		
		jcJugador = new JComboBox();
		jcJugador.setBounds(0, 102, 225, 27);
		panelBuscar.add(jcJugador);
		
		jbBuscarJugador = new JButton("Buscar");
		jbBuscarJugador.setBounds(271, 102, 111, 27);
		panelBuscar.add(jbBuscarJugador);
		jbBuscarJugador.setFont(new Font("SansSerif", Font.PLAIN, 14));
		jbBuscarJugador.setBackground(new Color(95, 158, 160));
		
		JPanel panelPlantilla = new JPanel();
		panelPlantilla.setLayout(null);
		panelPlantilla.setBounds(0, 0, 633, 749);
		panel.add(panelPlantilla);
		
		JLabel jlTituloDatosPersonales = new JLabel("Datos Personales");
		jlTituloDatosPersonales.setOpaque(true);
		jlTituloDatosPersonales.setForeground(Color.BLACK);
		jlTituloDatosPersonales.setFont(new Font("Simplified Arabic", Font.BOLD, 17));
		jlTituloDatosPersonales.setBackground(new Color(95, 158, 160));
		jlTituloDatosPersonales.setBounds(27, 239, 570, 37);
		panelPlantilla.add(jlTituloDatosPersonales);
		
		JPanel panelDatosPersonales = new JPanel();
		panelDatosPersonales.setLayout(null);
		panelDatosPersonales.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelDatosPersonales.setBounds(27, 287, 565, 219);
		panelPlantilla.add(panelDatosPersonales);
		
		JLabel jlNombre = new JLabel("Nombre Completo:");
		jlNombre.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jlNombre.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlNombre.setBounds(219, 42, 334, 35);
		panelDatosPersonales.add(jlNombre);
		
		JLabel jlEps = new JLabel("Eps:");
		jlEps.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		jlEps.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlEps.setBounds(217, 76, 336, 35);
		panelDatosPersonales.add(jlEps);
		
		JLabel jlFechaNacimiento = new JLabel("Fecha Nacimiento:");
		jlFechaNacimiento.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		jlFechaNacimiento.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlFechaNacimiento.setBounds(217, 110, 336, 35);
		panelDatosPersonales.add(jlFechaNacimiento);
		
		JLabel jlAltura = new JLabel("Altura:");
		jlAltura.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		jlAltura.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlAltura.setBounds(219, 144, 336, 35);
		panelDatosPersonales.add(jlAltura);		
		
		
		jtNombre = new JTextField();
		jtNombre.setEditable(false);
		jtNombre.setColumns(10);
		jtNombre.setBorder(new EmptyBorder(0, 0, 0, 0));
		jtNombre.setBackground(SystemColor.menu);
		jtNombre.setBounds(340, 48, 213, 23);
		panelDatosPersonales.add(jtNombre);
		
		jtEps = new JTextField();
		jtEps.setEditable(false);
		jtEps.setColumns(10);
		jtEps.setBorder(new EmptyBorder(0, 0, 0, 0));
		jtEps.setBackground(SystemColor.menu);
		jtEps.setBounds(248, 82, 213, 23);
		panelDatosPersonales.add(jtEps);
		
		jdFechaNacimiento = new JDateChooser();
		jdFechaNacimiento.setEnabled(false);
		jdFechaNacimiento.setBorder(new EmptyBorder(0, 0, 0, 0));
		jdFechaNacimiento.setBackground(SystemColor.menu);
		jdFechaNacimiento.setBounds(329, 116, 213, 23);
		panelDatosPersonales.add(jdFechaNacimiento);
		
		jtAltura = new JTextField();
		jtAltura.setEditable(false);
		jtAltura.setColumns(10);
		jtAltura.setBorder(new EmptyBorder(0, 0, 0, 0));
		jtAltura.setBackground(SystemColor.menu);
		jtAltura.setBounds(264, 150, 43, 23);
		panelDatosPersonales.add(jtAltura);
		
		JLabel jlCm = new JLabel("cm");
		jlCm.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jlCm.setBackground(SystemColor.menu);
		jlCm.setBounds(308, 150, 46, 23);
		panelDatosPersonales.add(jlCm);
		
		jlFotoPerfil = new JLabel("");
		jlFotoPerfil.setBounds(10, 21, 186, 177);
		ImageIcon fotoPerfil= new ImageIcon(this.getClass().getResource("/com/bugabulls/imagen/fotoPerfil.png"));
		Icon iconoPerfil = new ImageIcon(fotoPerfil.getImage().getScaledInstance(jlFotoPerfil.getWidth(), jlFotoPerfil.getHeight(),Image.SCALE_DEFAULT));
		this.repaint();	
		panelPlantilla.setLayout(null);
		jlFotoPerfil.setIcon(iconoPerfil);
		panelDatosPersonales.add(jlFotoPerfil);		
		
		
		JLabel jlDatosDeportivos = new JLabel("Datos Deportivos");
		jlDatosDeportivos.setOpaque(true);
		jlDatosDeportivos.setForeground(Color.BLACK);
		jlDatosDeportivos.setFont(new Font("Simplified Arabic", Font.BOLD, 17));
		jlDatosDeportivos.setBackground(new Color(95, 158, 160));
		jlDatosDeportivos.setBounds(27, 504, 570, 37);
		panelPlantilla.add(jlDatosDeportivos);
		
		JPanel panelDatosDeportivos = new JPanel();
		panelDatosDeportivos.setLayout(null);
		panelDatosDeportivos.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelDatosDeportivos.setBounds(27, 552, 565, 196);
		panelPlantilla.add(panelDatosDeportivos);	
                
                JLabel jlPeso = new JLabel("Peso:");
		jlPeso.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jlPeso.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlPeso.setBounds(0, 0, 565, 35);
		panelDatosDeportivos.add(jlPeso);
		
                
                jtPeso = new JTextField();
		jtPeso.setColumns(10);
		jtPeso.setBorder(new EmptyBorder(0, 0, 0, 0));
		jtPeso.setBackground(SystemColor.menu);
		jtPeso.setBounds(38, 6, 105, 23);
                jtPeso.setDocument(new LimitadorCaracteres(jtPeso, 10, 3));
		panelDatosDeportivos.add(jtPeso);		
		
		JLabel jlPosicion = new JLabel("Posici\u00F3n:");
		jlPosicion.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jlPosicion.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlPosicion.setBounds(0, 34, 565, 34);
		panelDatosDeportivos.add(jlPosicion);
		
		JLabel jlSuicidio = new JLabel("Tiempo de ejecuci\u00F3n ejercicio \"suicidios\":");
		jlSuicidio.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jlSuicidio.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlSuicidio.setBounds(0, 67, 565, 34);
		panelDatosDeportivos.add(jlSuicidio);
		
		JLabel jlPorcentajeCestas = new JLabel("Porcentaje acierto cestas:");
		jlPorcentajeCestas.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jlPorcentajeCestas.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlPorcentajeCestas.setBounds(0, 100, 565, 34);
		panelDatosDeportivos.add(jlPorcentajeCestas);
		
		JLabel jlVueltasCancha = new JLabel("Vueltas a la cancha:");
		jlVueltasCancha.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jlVueltasCancha.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlVueltasCancha.setBounds(0, 133, 565, 34);
		panelDatosDeportivos.add(jlVueltasCancha);
		
		JLabel jlObservaciones = new JLabel("Observaciones:");
		jlObservaciones.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jlObservaciones.setBounds(0, 171, 128, 25);
		panelDatosDeportivos.add(jlObservaciones);
		
		JLabel jlImc = new JLabel("Indice masa corporal (IMC):");
		jlImc.setBounds(181, 0, 336, 35);
		panelDatosDeportivos.add(jlImc);
		jlImc.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		jlImc.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		
		jtImc = new JTextField();
		jtImc.setBounds(353, 6, 100, 23);
		panelDatosDeportivos.add(jtImc);
		jtImc.setColumns(10);
		jtImc.setBorder(new EmptyBorder(0, 0, 0, 0));
                jtImc.setEditable(false);
                
                jbcalc = new JButton("Calcular");
                jbcalc.setBounds(470, 6, 85, 23);
                panelDatosDeportivos.add(jbcalc);
                
		jtPosicion = new JComboBox();
		jtPosicion.setBorder(new EmptyBorder(0, 0, 0, 0));
		jtPosicion.setBackground(SystemColor.menu);
		jtPosicion.setBounds(56, 39, 200, 25);
		panelDatosDeportivos.add(jtPosicion);
                jtPosicion.addItem("Base");
                jtPosicion.addItem("Escolta");
                jtPosicion.addItem("Alero");
                jtPosicion.addItem("Ala-pivote");
                jtPosicion.addItem("Pivote");
		
		jtSuicidio = new JTextField();
		jtSuicidio.setColumns(10);
		jtSuicidio.setBorder(new EmptyBorder(0, 0, 0, 0));
		jtSuicidio.setBackground(SystemColor.menu);
		jtSuicidio.setBounds(245, 72, 250, 25);
                jtSuicidio.setDocument(new LimitadorCaracteres(jtSuicidio, 10, 3));
		panelDatosDeportivos.add(jtSuicidio);
		
		jtPorcentajeCesta = new JTextField();
		jtPorcentajeCesta.setColumns(10);
		jtPorcentajeCesta.setBorder(new EmptyBorder(0, 0, 0, 0));
		jtPorcentajeCesta.setBackground(SystemColor.menu);
		jtPorcentajeCesta.setBounds(157, 107, 250, 25);
                jtPorcentajeCesta.setDocument(new LimitadorCaracteres(jtPorcentajeCesta, 10, 3));
		panelDatosDeportivos.add(jtPorcentajeCesta);
		
		jtVueltasCancha = new JTextField();
		jtVueltasCancha.setColumns(10);
		jtVueltasCancha.setBorder(new EmptyBorder(0, 0, 0, 0));
		jtVueltasCancha.setBackground(SystemColor.menu);
		jtVueltasCancha.setBounds(123, 136, 250, 25);
                jtVueltasCancha.setDocument(new LimitadorCaracteres(jtVueltasCancha, 4, 0));
		panelDatosDeportivos.add(jtVueltasCancha);
		
		JScrollPane spObservaciones = new JScrollPane();
		spObservaciones.setBounds(38, 756, 565, 125);
		panel.add(spObservaciones);
		
		jtaObservaciones = new JTextArea();
                jtaObservaciones.setDocument(new LimitadorCaracteres(jtaObservaciones, 249, 2));                
		jtaObservaciones.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(32, 178, 170), null, null, null));
		spObservaciones.setViewportView(jtaObservaciones);
		
		jbModificar = new JButton("Modificar");
		jbModificar.setFont(new Font("SansSerif", Font.BOLD, 18));
		jbModificar.setBackground(new Color(95, 158, 160));
		jbModificar.setBounds(209, 896, 216, 34);
		panel.add(jbModificar);
                
                 jlerror = new JLabel("");
                 jlerror.setHorizontalAlignment(SwingConstants.CENTER);
                 jlerror.setForeground(new Color(255, 0, 0));
		 jlerror.setFont(new Font("Tahoma", Font.PLAIN, 16));
		 jlerror.setBounds(10, 940, 650, 27);
		 panel.add(jlerror);
                 
                 jlerrorBuscar = new JLabel("");                 
                 jlerrorBuscar.setForeground(new Color(255, 0, 0));
		 jlerrorBuscar.setFont(new Font("Tahoma", Font.PLAIN, 16));
                 jlerrorBuscar.setBounds(392, 106, 211, 21);		 
		 panelBuscar.add(jlerrorBuscar);
                
                asignarCodigoPlantilla();
		llenarCategorias();
                ManejadorPlantillasEntrenador pe = new ManejadorPlantillasEntrenador(this,entrenadorLogeado,plantillaNumero);
                jbBuscar.addActionListener(pe);
                jbBuscarJugador.addActionListener(pe);
                jbModificar.addActionListener(pe);
                jbcalc.addActionListener(pe);
                
                
                
	}
                public void llenarCategorias(){
                    try {
                        List<Categoria> listaCategorias=DAOFactory.getCategoriaDAO().consultar();
                        for (Categoria categoria : listaCategorias) {
                            if(categoria.getCodigoentrenador()==null){
                                System.out.println("No tiene categorias este entrenador");
                            }
                            else{
                                if(entrenadorLogeado==categoria.getCodigoentrenador().getCodigoentrenador()){
                                jcCategorias.addItem(categoria.getCodigocategoria()+" - "+categoria.getNombre());
                            }
                            }
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(PlantillasEntrenador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                public void asignarCodigoPlantilla(){
                    try {
                        List<Plantilla> listaPlantillas=DAOFactory.getPlantillaDAO().consultar();
                        for (Plantilla plantilla : listaPlantillas) {
                            if(plantilla.getNumeroplantilla()!=null){
                                plantillaNumero=(plantilla.getNumeroplantilla())+1;
                            }
                        }
                    } catch (Exception ex){
                        Logger.getLogger(PlantillasEntrenador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
}
