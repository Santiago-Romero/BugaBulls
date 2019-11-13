
package com.bugabulls.controlador;

import com.bugabulls.vista.Login;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.apache.commons.codec.digest.DigestUtils;

public class CreadorDataBase extends JDialog{
	JLabel u,p;
	JTextField us,pw;
	JButton crear;
	String escrito;
	String contraG="";
	String usuarioG="";
        String conEnc=DigestUtils.md5Hex("9");
	Font fuente1;
	public boolean creado;
        Login lg;
	public CreadorDataBase(Login lg){
            this.lg=lg;
            setModal(true);
            setUndecorated(true);
            setResizable(false);
            setSize(300,200);
            setTitle("Crear Base de Datos");
		Container c=getContentPane();
		c.setLayout(null);
		fuente1=new Font("Arial",Font.PLAIN,16);
		u=new JLabel("Usuario: ");
		p=new JLabel("Contraseña: ");
		us=new JTextField("",15);
		pw=new JTextField("",15);
		crear=new JButton("Crear Base de Datos");
		u.setFont(fuente1);
		us.setFont(fuente1);
		p.setFont(fuente1);
		pw.setFont(fuente1);
		crear.setFont(fuente1);
		u.setBounds(35,40,100,15);
		us.setBounds(135,40,100,30);
		p.setBounds(35,75,100,20);
		pw.setBounds(135,75,100,30);
		crear.setBounds(35,125,200,30);
		c.add(u);
		c.add(us);
		c.add(p);
		c.add(pw);
		c.add(crear);
		c.setBackground(Color.gray.brighter());
		crear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				crearDB();
				}
			});
		us.addKeyListener(new KeyAdapter(){
			 public void keyPressed(KeyEvent e){
				 if(e.getKeyCode()==10){
					 pw.requestFocus();
				 }
			 }
		 });
		pw.addKeyListener(new KeyAdapter(){
			 public void keyPressed(KeyEvent e){
				 if(e.getKeyCode()==10){
					 crear.requestFocus();
				 }
			 }
		 });
		crear.addKeyListener(new KeyAdapter(){
			 public void keyPressed(KeyEvent e){
				 if(e.getKeyCode()==10){
					 crearDB();
				 }
			 }
		 });
		}
	public void crearDB(){
		try{
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection conexion1 = DriverManager.getConnection("jdbc:mysql://localhost/",us.getText(),pw.getText());
    		try{
    			File archivo=new File("claveBD.txt");
    			FileWriter writer=new FileWriter(archivo,true);
    			PrintWriter pr=new PrintWriter(archivo);
    			escrito=us.getText()+"*"+pw.getText()+"-";
    			pr.print(escrito);
    			pr.close();
    		}
    		catch(Exception A){
    			System.out.println(A);
    		}
    		String Query1 = "CREATE DATABASE IF NOT EXISTS `bugabulls` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci */;\n";
                String Query2 = "USE bugabulls;";
                String Query3=
"CREATE TABLE IF NOT EXISTS `acudiente` (\n" +
                        "`codigoacudiente` int(11) NOT NULL,"+
"  `dniacudiente` bigint(20) NOT NULL,\n" +
"  `nombre` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,\n" +
"  `apellido` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,\n" +
"  `parentesco` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,\n" +
"  `telefono` bigint(20) DEFAULT NULL,\n" +
"  `direccion` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,\n" +
"  PRIMARY KEY (`codigoacudiente`)\n" +
") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;\n" +
"\n";
String Query4="/*!40000 ALTER TABLE `acudiente` DISABLE KEYS */;\n";
String Query5="/*!40000 ALTER TABLE `acudiente` ENABLE KEYS */;\n";
String Query6="CREATE TABLE IF NOT EXISTS `administrador` (\n" +
"  `codigoadministrador` int(11) NOT NULL,\n" +
"  `nombre` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,\n" +
"  `apellido` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,\n" +
"  `contraseña` varchar(150) COLLATE utf8_spanish_ci DEFAULT NULL,\n" +
"  `dniadministrador` bigint(20) DEFAULT NULL,\n" +
"  `direccion` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,\n" +
"  `telefono` bigint(20) DEFAULT NULL,\n" +
"  `estadoeliminar` int(1) DEFAULT 0,\n" +
"  `estadocontra` int(1) DEFAULT 0,\n" +        
"  PRIMARY KEY (`codigoadministrador`),\n" +
"  KEY `dniadministrador` (`dniadministrador`)\n" +
") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;\n";
String Query7="/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;\n";
String Query8="INSERT INTO `administrador` (`codigoadministrador`, `nombre`, `apellido`, `contraseña`, `dniadministrador`, `direccion`, `telefono`) VALUES\n" +
"	(90000, 'Desarrollador', 'TSL','"+conEnc+"', 9, '9', 9);\n";
String Query9="/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;\n";
String Query10="CREATE TABLE IF NOT EXISTS `categoria` (\n" +
"  `codigocategoria` int(11) NOT NULL,\n" +
"  `nombre` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,\n" +
"  `horario` time DEFAULT NULL,\n" +
"  `codigoentrenador` int(11) DEFAULT NULL,\n" +
"  PRIMARY KEY (`codigocategoria`),\n" +
"  KEY `FK_categoria_entrenador` (`codigoentrenador`),\n" +
"  CONSTRAINT `FK_categoria_entrenador` FOREIGN KEY (`codigoentrenador`) REFERENCES `entrenador` (`codigoentrenador`) ON DELETE SET NULL ON UPDATE NO ACTION\n" +
") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;\n";
String Query11="/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;\n" ;
String Query12="INSERT INTO `categoria` (`codigocategoria`, `nombre`, `horario`, `codigoentrenador`) VALUES\n" +
"	(1, 'Pre Benjamines', '00:00:00', NULL),\n" +
"	(2, 'Benjamines', '00:00:00', NULL),\n" +
"	(3, 'Minis', '00:00:00', NULL),\n" +
"	(4, 'Infantiles', '00:00:00', NULL),\n" +
"	(5, 'Junior', '00:00:00', NULL);\n";
String Query13="/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;\n";
String Query14="CREATE TABLE IF NOT EXISTS `entrenador` (\n" +
"  `codigoentrenador` int(11) NOT NULL,\n" +
"  `dnientrenador` bigint(20) DEFAULT NULL,\n" +
"  `nombre` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,\n" +
"  `apellido` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,\n" +
"  `telefono` bigint(20) DEFAULT NULL,\n" +
"  `direccion` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,\n" +
"  `contraseña` varchar(150) COLLATE utf8_spanish_ci DEFAULT NULL,\n" +
"  `estadoeliminar` int(1) DEFAULT 0,\n" +
"  `estadocontra` int(1) DEFAULT 0,\n" +           
"  PRIMARY KEY (`codigoentrenador`),\n" +
"  KEY `dnientrenador` (`dnientrenador`)\n" +
") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;\n";
String Query15="/*!40000 ALTER TABLE `entrenador` DISABLE KEYS */;\n";
String Query16="/*!40000 ALTER TABLE `entrenador` ENABLE KEYS */;\n";
String Query17="CREATE TABLE IF NOT EXISTS `evento` (\n" +
"  `codigoevento` int(11) NOT NULL,\n" +
"  `nombre` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,\n" +
"  `ciudad` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,\n" +
"  `gastos` double DEFAULT NULL,\n" +
"  `fechaini` date DEFAULT NULL,\n" +
"  `fechafin` date DEFAULT NULL,\n" +
"  `cantidadjugadores` int(11) DEFAULT NULL,\n" +
"  PRIMARY KEY (`codigoevento`)\n" +
") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;\n";
String Query18="/*!40000 ALTER TABLE `evento` DISABLE KEYS */;\n";
String Query19="/*!40000 ALTER TABLE `evento` ENABLE KEYS */;\n";
String Query20="CREATE TABLE IF NOT EXISTS `jugador` (\n" +
"  `codigojugador` int(11) NOT NULL,\n" +
"  `nombre` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,\n" +
"  `apellido` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,\n" +
"  `direccion` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,\n" +
"  `eps` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,\n" +
"  `fechanacimiento` date DEFAULT NULL,\n" +
"  `telefono` bigint(20) DEFAULT NULL,\n" +
"  `altura` int(11) DEFAULT NULL,\n" +
"  `contraseña` varchar(150) COLLATE utf8_spanish_ci DEFAULT NULL,\n" +
"  `dnijugador` bigint(20) DEFAULT NULL,\n" +
"  `codigocategoria` int(11) DEFAULT NULL,\n" +
"  `codigoacudiente` int(11) DEFAULT NULL,\n" +
"  `fechacobro` date DEFAULT NULL,\n" +
"  `estadoeliminar` int(1) DEFAULT 0,\n" +
"  `estadocontra` int(1) DEFAULT 0,\n" +           
"  PRIMARY KEY (`codigojugador`),\n" +
"  KEY `FK_jugador_categoria` (`codigocategoria`),\n" +
"  KEY `FK_jugador_acudiente` (`codigoacudiente`),\n" +
"  KEY `dnijugador` (`dnijugador`),\n" +
"  CONSTRAINT `FK_jugador_acudiente` FOREIGN KEY (`codigoacudiente`) REFERENCES `acudiente` (`codigoacudiente`) ON DELETE SET NULL ON UPDATE NO ACTION,\n" +
"  CONSTRAINT `FK_jugador_categoria` FOREIGN KEY (`codigocategoria`) REFERENCES `categoria` (`codigocategoria`) ON DELETE CASCADE ON UPDATE CASCADE\n" +
") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;\n";
String Query21="/*!40000 ALTER TABLE `jugador` DISABLE KEYS */;\n";
String Query22="/*!40000 ALTER TABLE `jugador` ENABLE KEYS */;\n";
String Query23="CREATE TABLE IF NOT EXISTS `pago` (\n" +
"  `codigopago` int(11) NOT NULL,\n" +
"  `fechapago` date DEFAULT NULL,\n" +
"  `valor` double DEFAULT NULL,\n" +
"  `codigojugador` int(11) DEFAULT NULL,\n" +
"  PRIMARY KEY (`codigopago`),\n" +
"  KEY `FK_pago_jugador` (`codigojugador`),\n" +
"  CONSTRAINT `FK_pago_jugador` FOREIGN KEY (`codigojugador`) REFERENCES `jugador` (`codigojugador`) ON DELETE SET NULL ON UPDATE NO ACTION\n" +
") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;\n";
String Query24="/*!40000 ALTER TABLE `pago` DISABLE KEYS */;\n";
String Query25="/*!40000 ALTER TABLE `pago` ENABLE KEYS */;\n";
String Query26="CREATE TABLE IF NOT EXISTS `plantilla` (\n" +
"  `numeroplantilla` int(11) NOT NULL,\n" +
"  `codigojugador` int(11) DEFAULT NULL,\n" +
"  `imc` double DEFAULT NULL,\n" +
"  `posicion` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,\n" +
"  `peso` double DEFAULT NULL,\n" +
"  `observacion` varchar(250) COLLATE utf8_spanish_ci DEFAULT NULL,\n" +
"  `tiemposuicidio` double DEFAULT NULL,\n" +
"  `porcentajecestas` double DEFAULT NULL,\n" +
"  `vueltascancha` int(11) DEFAULT NULL,\n" +
"  PRIMARY KEY (`numeroplantilla`),\n" +
"  KEY `FK_plantilla_jugador` (`codigojugador`),\n" +
"  CONSTRAINT `FK_plantilla_jugador` FOREIGN KEY (`codigojugador`) REFERENCES `jugador` (`codigojugador`) ON DELETE SET NULL ON UPDATE CASCADE\n" +
") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;\n";
String Query27="/*!40000 ALTER TABLE `plantilla` DISABLE KEYS */;\n";
String Query28="/*!40000 ALTER TABLE `plantilla` ENABLE KEYS */;\n";
String Query29="CREATE TABLE IF NOT EXISTS `sesion` (\n" +
"  `numerosesion` int(11) NOT NULL,\n" +
"  `nombre` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,\n" +
"  `fecha` date DEFAULT NULL,\n" +
"  `especificacion` varchar(250) COLLATE utf8_spanish_ci DEFAULT NULL,\n" +
"  `codigoentrenador` int(11) DEFAULT NULL,\n" +
"  PRIMARY KEY (`numerosesion`),\n" +
"  KEY `FK_sesion_entrenador` (`codigoentrenador`),\n" +
"  CONSTRAINT `FK_sesion_entrenador` FOREIGN KEY (`codigoentrenador`) REFERENCES `entrenador` (`codigoentrenador`) ON DELETE SET NULL ON UPDATE CASCADE\n" +
") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;\n";
String Query30="/*!40000 ALTER TABLE `sesion` DISABLE KEYS */;\n";
String Query31="/*!40000 ALTER TABLE `sesion` ENABLE KEYS */;\n";
String Query32="CREATE TABLE IF NOT EXISTS `sesion_categoria` (\n" +
"  `numerosesion` int(11) NOT NULL,\n" +
"  `codigocategoria` int(11) DEFAULT NULL,\n" +
"  PRIMARY KEY (`numerosesion`),\n" +
"  KEY `FK_sesion_categoria_categoria` (`codigocategoria`),\n" +
"  CONSTRAINT `FK_sesion_categoria_categoria` FOREIGN KEY (`codigocategoria`) REFERENCES `categoria` (`codigocategoria`) ON DELETE CASCADE ON UPDATE CASCADE,\n" +
"  CONSTRAINT `FK_sesion_categoria_sesion` FOREIGN KEY (`numerosesion`) REFERENCES `sesion` (`numerosesion`) ON DELETE CASCADE ON UPDATE CASCADE\n" +
") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;";
String Query33="CREATE TABLE IF NOT EXISTS `jugador_evento` (\n"+
  "`codigojugador` int(11) DEFAULT NULL,\n"+
  "`codigoevento` int(11) DEFAULT NULL,\n"+
  "KEY `FK__jugador` (`codigojugador`),\n"+
  "KEY `FK__evento` (`codigoevento`)\n"+
  ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci\n";

    		Statement s1 = conexion1.createStatement();
                s1.executeUpdate(Query1);
                s1.executeUpdate(Query2);
                s1.executeUpdate(Query3);
                s1.executeUpdate(Query4);
                s1.executeUpdate(Query5);
                s1.executeUpdate(Query6);
                s1.executeUpdate(Query7);
                s1.executeUpdate(Query8);
                s1.executeUpdate(Query9);
                
                s1.executeUpdate(Query14);
                s1.executeUpdate(Query15);
                s1.executeUpdate(Query16);
                s1.executeUpdate(Query10);
                s1.executeUpdate(Query11);
                s1.executeUpdate(Query12);
                s1.executeUpdate(Query13);
                s1.executeUpdate(Query17);
                s1.executeUpdate(Query18);
                s1.executeUpdate(Query19);
                s1.executeUpdate(Query20);
                s1.executeUpdate(Query21);
                s1.executeUpdate(Query22);
                s1.executeUpdate(Query23);
                s1.executeUpdate(Query24);
                s1.executeUpdate(Query25);
                s1.executeUpdate(Query26);
                s1.executeUpdate(Query27);
                s1.executeUpdate(Query28);
                s1.executeUpdate(Query29);
                s1.executeUpdate(Query30);
                s1.executeUpdate(Query31);
                s1.executeUpdate(Query32);
                s1.executeUpdate(Query33);
    		conexion1.close();
    		creado=true;
    		setVisible(false);
    		}
    	catch(Exception x){
    		System.out.println(x);
    		creado=false;
    		setVisible(false);
    		}
                if(creado==false){
                    lg.setVisible(true);
        lg.jlError.setText("Ha ocurrido un, error datos erroneos");
			}
        if(creado==true){
            lg.jlPresiona.setText("");
            lg.jlFlecha.setIcon(null);
            lg.setVisible(true);
            lg.jlError.setText("Se ha creado exitosamente la base de datos");
            lg.jbEntrar.setEnabled(true);
            lg.jtCodigo.setEnabled(true);
            lg.jtContrasena.setEnabled(true);
            lg.jbCrearBD.setEnabled(false);
			}
        }
}

