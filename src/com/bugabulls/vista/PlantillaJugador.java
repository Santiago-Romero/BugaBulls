package com.bugabulls.vista;

import com.bugabulls.controlador.DAOFactory;
import com.bugabulls.modelo.Jugador;
import com.bugabulls.modelo.Plantilla;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class PlantillaJugador extends JDialog {
    int jugadorLogeado;
    public JTextField jtNombre;
    public JTextField jtEps;
	public JTextField jtFechaNacimiento;
	public JTextField jtAltura;
	public JTextField jtPeso;
	public JTextField jtImc;
	public JTextField jtPosicion;
	public JTextField jtSuicidio;
	public JTextField jtPorcentajeCestas;
	public JTextField jtVueltasCancha;
        public JTextArea jaObservaciones;
        public JLabel jlFotoPerfil;
        int contador=0;
	public PlantillaJugador(MenuJugador mj,int jugadorLogeado) {
            this.jugadorLogeado=jugadorLogeado;
            setModal(true);
                setBounds(100, 100, 674, 700);
		getContentPane().setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 13));
		panel.setBounds(0, 0, 674, 692);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.setBounds(43, 113, 565, 219);
		panel.add(panel_1);
		
		jlFotoPerfil = new JLabel("");
		jlFotoPerfil.setBounds(10, 21, 186, 177);
		ImageIcon fotoPerfil= new ImageIcon(this.getClass().getResource("/com/bugabulls/imagen/fotoPerfil.png"));
		Icon iconoPerfil = new ImageIcon(fotoPerfil.getImage().getScaledInstance(jlFotoPerfil.getWidth(), jlFotoPerfil.getHeight(),Image.SCALE_DEFAULT));
		this.repaint();	
		panel_1.setLayout(null);
		jlFotoPerfil.setIcon(iconoPerfil);
		panel_1.add(jlFotoPerfil);
		
		JLabel jlNombre = new JLabel("Nombre Completo:");
		jlNombre.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlNombre.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jlNombre.setBounds(221, 21, 334, 35);
		panel_1.add(jlNombre);
		
		JLabel jlEps = new JLabel("Eps:");
		jlEps.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlEps.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		jlEps.setBounds(219, 55, 336, 35);
		panel_1.add(jlEps);
		
		JLabel jlFechaNacimiento = new JLabel("Fecha Nacimiento:");
		jlFechaNacimiento.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		jlFechaNacimiento.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlFechaNacimiento.setBounds(219, 89, 336, 35);
		panel_1.add(jlFechaNacimiento);
		
		JLabel jlAltura = new JLabel("Altura:");
		jlAltura.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		jlAltura.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlAltura.setBounds(221, 123, 336, 35);
		panel_1.add(jlAltura);
		
		JLabel jlPeso = new JLabel("Peso:");
		jlPeso.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		jlPeso.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlPeso.setBounds(221, 157, 336, 35);
		panel_1.add(jlPeso);
		
		jtNombre = new JTextField();
		jtNombre.setBorder(new EmptyBorder(0, 0, 0, 0));
		jtNombre.setEditable(false);
		jtNombre.setBackground(UIManager.getColor("Button.background"));
		jtNombre.setBounds(342, 27, 213, 23);
		panel_1.add(jtNombre);
		jtNombre.setColumns(10);
		
		jtEps = new JTextField();
		jtEps.setEditable(false);
		jtEps.setColumns(10);
		jtEps.setBorder(new EmptyBorder(0, 0, 0, 0));
		jtEps.setBackground(SystemColor.menu);
		jtEps.setBounds(245, 61, 213, 23);
		panel_1.add(jtEps);
		
		jtFechaNacimiento = new JTextField();
		jtFechaNacimiento.setEditable(false);
		jtFechaNacimiento.setColumns(10);
		jtFechaNacimiento.setBorder(new EmptyBorder(0, 0, 0, 0));
		jtFechaNacimiento.setBackground(SystemColor.menu);
		jtFechaNacimiento.setBounds(331, 96, 213, 23);
		panel_1.add(jtFechaNacimiento);
		
		jtAltura = new JTextField();
		jtAltura.setEditable(false);
		jtAltura.setColumns(10);
		jtAltura.setBorder(new EmptyBorder(0, 0, 0, 0));
		jtAltura.setBackground(SystemColor.menu);
		jtAltura.setBounds(265, 130, 43, 23);
		panel_1.add(jtAltura);
		
		JLabel lblCm = new JLabel("cm");
		lblCm.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		lblCm.setBackground(UIManager.getColor("Button.background"));
		lblCm.setBounds(315, 129, 46, 23);
		panel_1.add(lblCm);
		
		jtPeso = new JTextField();
		jtPeso.setEditable(false);
		jtPeso.setColumns(10);
		jtPeso.setBorder(new EmptyBorder(0, 0, 0, 0));
		jtPeso.setBackground(SystemColor.menu);
		jtPeso.setBounds(257, 164, 213, 23);
		panel_1.add(jtPeso);
		
		JLabel jlTitulo = new JLabel("Ficha Jugador");
		jlTitulo.setOpaque(true);
		jlTitulo.setForeground(Color.WHITE);
		jlTitulo.setFont(new Font("Simplified Arabic", Font.BOLD, 18));
		jlTitulo.setBackground(new Color(128, 128, 0));
		jlTitulo.setBounds(0, 0, 674, 44);
		panel.add(jlTitulo);
		
		JLabel jlTitulo1 = new JLabel("Datos Personales");
		jlTitulo1.setOpaque(true);
		jlTitulo1.setForeground(Color.BLACK);
		jlTitulo1.setFont(new Font("Simplified Arabic", Font.BOLD, 17));
		jlTitulo1.setBackground(new Color(95, 158, 160));
		jlTitulo1.setBounds(43, 65, 570, 37);
		panel.add(jlTitulo1);
		
		JLabel jlTitulo2 = new JLabel("Datos Deportivos");
		jlTitulo2.setOpaque(true);
		jlTitulo2.setForeground(Color.BLACK);
		jlTitulo2.setFont(new Font("Simplified Arabic", Font.BOLD, 17));
		jlTitulo2.setBackground(new Color(95, 158, 160));
		jlTitulo2.setBounds(43, 330, 570, 37);
		panel.add(jlTitulo2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_2.setBounds(43, 387, 565, 196);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel jlImc = new JLabel("Indice masa corporal (IMC):");
		jlImc.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jlImc.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlImc.setBounds(0, 0, 565, 35);
		panel_2.add(jlImc);
		
		JLabel jlPosicion = new JLabel("Posici\u00F3n:");
		jlPosicion.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jlPosicion.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlPosicion.setBounds(0, 34, 565, 34);
		panel_2.add(jlPosicion);
		
		JLabel jlTiempoSuicidio = new JLabel("Tiempo de ejecuci\u00F3n ejercicio \"suicidios\":");
		jlTiempoSuicidio.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jlTiempoSuicidio.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlTiempoSuicidio.setBounds(0, 67, 565, 34);
		panel_2.add(jlTiempoSuicidio);
		
		JLabel jlPorcentajeCestas = new JLabel("Porcentaje acierto cestas:");
		jlPorcentajeCestas.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jlPorcentajeCestas.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlPorcentajeCestas.setBounds(0, 100, 565, 34);
		panel_2.add(jlPorcentajeCestas);
		
		JLabel jlVueltasCancha = new JLabel("Vueltas a la cancha:");
		jlVueltasCancha.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		jlVueltasCancha.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(32, 178, 170)));
		jlVueltasCancha.setBounds(0, 133, 565, 34);
		panel_2.add(jlVueltasCancha);
		
		JLabel lblNewLabel = new JLabel("Observaciones:");
		lblNewLabel.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		lblNewLabel.setBounds(0, 171, 128, 25);
		panel_2.add(lblNewLabel);
		
		jtImc = new JTextField();
		jtImc.setEditable(false);
		jtImc.setColumns(10);
		jtImc.setBorder(new EmptyBorder(0, 0, 0, 0));
		jtImc.setBackground(SystemColor.menu);
		jtImc.setBounds(176, 7, 213, 23);
		panel_2.add(jtImc);
		
		jtPosicion = new JTextField();
		jtPosicion.setEditable(false);
		jtPosicion.setColumns(10);
		jtPosicion.setBorder(new EmptyBorder(0, 0, 0, 0));
		jtPosicion.setBackground(SystemColor.menu);
		jtPosicion.setBounds(56, 39, 250, 25);
		panel_2.add(jtPosicion);
		
		jtSuicidio = new JTextField();
		jtSuicidio.setEditable(false);
		jtSuicidio.setColumns(10);
		jtSuicidio.setBorder(new EmptyBorder(0, 0, 0, 0));
		jtSuicidio.setBackground(SystemColor.menu);
		jtSuicidio.setBounds(245, 72, 250, 25);
		panel_2.add(jtSuicidio);
		
		jtPorcentajeCestas = new JTextField();
		jtPorcentajeCestas.setEditable(false);
		jtPorcentajeCestas.setColumns(10);
		jtPorcentajeCestas.setBorder(new EmptyBorder(0, 0, 0, 0));
		jtPorcentajeCestas.setBackground(SystemColor.menu);
		jtPorcentajeCestas.setBounds(157, 107, 250, 25);
		panel_2.add(jtPorcentajeCestas);
		
		jtVueltasCancha = new JTextField();
		jtVueltasCancha.setEditable(false);
		jtVueltasCancha.setColumns(10);
		jtVueltasCancha.setBorder(new EmptyBorder(0, 0, 0, 0));
		jtVueltasCancha.setBackground(SystemColor.menu);
		jtVueltasCancha.setBounds(123, 136, 250, 25);
		panel_2.add(jtVueltasCancha);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 581, 565, 84);
		panel.add(scrollPane);
		
		jaObservaciones = new JTextArea();
		jaObservaciones.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(32, 178, 170), null, null, null));
		jaObservaciones.setEditable(false);               
                jaObservaciones.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));		
		scrollPane.setViewportView(jaObservaciones);
                llenarPlantilla();
                sinPlantilla();

	}
        public void llenarPlantilla(){            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            try {
                List<Plantilla> listaPlantillas=DAOFactory.getPlantillaDAO().consultar();
            for (Plantilla plantilla : listaPlantillas) {   
                    if(jugadorLogeado==plantilla.getCodigojugador().getCodigojugador()){
                    contador++;
                    jtNombre.setText(plantilla.getCodigojugador().getNombre()+" "+plantilla.getCodigojugador().getApellido());
                    jtAltura.setText(plantilla.getCodigojugador().getAltura().toString());
                    jtEps.setText(plantilla.getCodigojugador().getEps());
                    jtFechaNacimiento.setText(formato.format(plantilla.getCodigojugador().getFechanacimiento()));
                    jtImc.setText(plantilla.getImc().toString());
                    jtPeso.setText(plantilla.getPeso().toString());
                    jtPosicion.setText(plantilla.getPosicion());
                    jtSuicidio.setText(plantilla.getTiemposuicidio().toString());
                    jtPorcentajeCestas.setText(plantilla.getPorcentajecestas().toString());
                    jtVueltasCancha.setText(plantilla.getVueltascancha().toString());
                    jaObservaciones.setText(plantilla.getObservacion());
                    ImageIcon fotoPerfil= new ImageIcon (new ImageIcon(""+jugadorLogeado+".jpg").getImage());
	            Icon iconoPerfil = new ImageIcon(fotoPerfil.getImage().getScaledInstance(jlFotoPerfil.getWidth(),jlFotoPerfil.getHeight(),Image.SCALE_DEFAULT));
	            jlFotoPerfil.setIcon(iconoPerfil);
                }               
                
            }
        } catch (Exception ex) {
            Logger.getLogger(PlantillaJugador.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        
        public void datosSinPlantilla(){
         SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {             
            List<Jugador> listaJugador=DAOFactory.getJugadorDAO().consultar();
            for(Jugador jugador : listaJugador){
                if(jugadorLogeado==jugador.getCodigojugador()){
                    jtNombre.setText(jugador.getNombre()+" "+jugador.getApellido());
                    jtAltura.setText(jugador.getAltura().toString());
                    jtEps.setText(jugador.getEps());
                    jtFechaNacimiento.setText(formato.format(jugador.getFechanacimiento()));  
                    ImageIcon fotoPerfil= new ImageIcon (new ImageIcon(""+jugadorLogeado+".jpg").getImage());
	            Icon iconoPerfil = new ImageIcon(fotoPerfil.getImage().getScaledInstance(jlFotoPerfil.getWidth(),jlFotoPerfil.getHeight(),Image.SCALE_DEFAULT));
	            jlFotoPerfil.setIcon(iconoPerfil);
                }
            }}
        catch (Exception ex) {
            Logger.getLogger(PlantillaJugador.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        
        
        public void sinPlantilla(){
        if(contador==0){
        datosSinPlantilla();
        jaObservaciones.setText("El entrenador no ha realizado las plantillas");
        jaObservaciones.setForeground(new Color(165, 42, 42));
         }
        else{
        contador=0;
        }
        }
        
        
        
     }
