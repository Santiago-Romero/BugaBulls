package com.bugabulls.controlador;

import com.bugabulls.vista.CopiasSeguridad;
import static com.sun.javafx.fxml.expression.Expression.modulo;
import java.awt.event.*;
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Santiago Romero
 */
public class ConCopiasSeguridad implements ActionListener{
    CopiasSeguridad cs;
    public static File rutabackup=null;
    public static int selecGuardaBack=0;
    public ConCopiasSeguridad(CopiasSeguridad cs){
		this.cs = cs;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource().equals(cs.jbCopia)){
            CrearBackup();
        }
    }
    public void CrearBackup(){
        try 
        {
            int x=0;
            if(x==0){
                File F = new File("bugabullsbackup.sql");
                String RutaFile = F.getPath();
                String Ruta = "C:\\xampp\\mysql\\bin\\mysqldump.exe";
                String clave = " ";
                String user = "root";
                String base = "bugabulls";

                String cad = "\"" + Ruta + "\" --opt --password=" + clave + " --user=" + user + " " + base + " > \"" + RutaFile +"\"\n";
                File fcopi = new File("bugabullsbackup.bat");
                FileWriter fw = new FileWriter(fcopi);
                fw.write(cad, 0, cad.length());
                fw.close();
                Runtime.getRuntime().exec("bugabullsbackup.bat");
                JOptionPane.showMessageDialog(null, "Copia de seguridad realizada con exito");
                cs.setVisible(false);
            }
            else
            {
              JOptionPane.showMessageDialog(null, "Creación De Copia De Seguridad Cancelada Por El Usuario");
            }
        } catch (Exception ex)  {ex.printStackTrace();
        
        }
    }
    public void RestaurarBackUp(){
        /*String rutaMySql="C:\\xampp\\mysql\\bin\\mysqldump.exe";
        String user="root";
        String contra=" ";
        String base="bugabulls";
        String rutaFile="C:\\Users\\Santiago Romero\\Downloads\\BugaBulls\\bugabullsbackup.sql";
         try{
            String cad = "\"" + rutaMySql + "\" --password=" + contra + " --user=" + user + " " + base + " < \"" + rutaFile +"\"\n";
            File fcopi = new File("bugabullsbackup.bat");
            FileWriter fw = new FileWriter(fcopi);
            fw.write(cad, 0, cad.length());
            fw.close();
            Runtime.getRuntime().exec("bugabullsbackup.bat");
         }catch(Exception ex){
             ex.printStackTrace();
         }*/
    }
}
    

