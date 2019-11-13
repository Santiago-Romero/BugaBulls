
package com.bugabulls.controlador;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class ManualUsuario {
public ManualUsuario(){  
 abrirPdf();

} 
public void abrirPdf(){
 String fileLocal = new String("src/com/bugabulls/manual/ManualUsuario.pdf"); 
try{  
   File path = new File (fileLocal);
   Desktop.getDesktop().open(path);  
  }catch(IOException e){
     e.printStackTrace();
  }catch(IllegalArgumentException e){     
     e.printStackTrace();
 }  
}   
    
}

