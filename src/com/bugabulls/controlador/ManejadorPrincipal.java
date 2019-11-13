package com.bugabulls.controlador;

import com.bugabulls.vista.Login;
import static javax.swing.JDialog.setDefaultLookAndFeelDecorated;
import static javax.swing.UIManager.setLookAndFeel;

public class ManejadorPrincipal {

	
public static void main(String[] args) {    
    try{  
  setDefaultLookAndFeelDecorated(true);
  setDefaultLookAndFeelDecorated(true);
  setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
  Login lg = new Login();
  lg.setVisible(true);
}
catch (Exception e)
 {
  e.printStackTrace();
 }
   
}
}



