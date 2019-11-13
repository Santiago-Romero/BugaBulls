
package com.bugabulls.controlador;

import com.bugabulls.modelo.Administrador;
import com.bugabulls.modelo.Entrenador;
import com.bugabulls.modelo.Jugador;
import com.bugabulls.vista.CambioContraseña;
import com.bugabulls.vista.Login;
import com.bugabulls.vista.MenuAdministrador;
import com.bugabulls.vista.MenuEntrenador;
import com.bugabulls.vista.MenuJugador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.codec.digest.DigestUtils;

public class ContCambioContraseña implements ActionListener{
    String codigo,contraseña,cualCodigo;
    CambioContraseña cc;
    Login lg;
    public ContCambioContraseña(CambioContraseña cc,Login lg) {
        this.lg=lg;
        this.cc=cc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(cc.jbCambiar)){
            validarTodosUsuarios();
        }
    }
    public void validarTodosUsuarios(){ 
        if(cc.jtContraseñaNueva.getText().equals("")||cc.jtContraseñaNueva1.getText().equals("")||cc.jtContraseña.getText().equals("")){
         cc.jlError.setText("");
         cc.jlError.setText("Por favor ingrese todos los campos");
        }
        else{
        cualCodigo=(cc.logeado+"").substring(0, 1);
        if(cualCodigo.equals("1")){               
            validarJugador();            
        }
        else
        if(cualCodigo.equals("2")){             
            validarEntrenador();            
        } 
        else
        if(cualCodigo.equals("9")){
            validarAdministrador();
        }
        } 
       
     }
    
    public void validarJugador(){
        codigo="";
        contraseña="";       
        try {
            List<Jugador> listaJugadores=DAOFactory.getJugadorDAO().consultar();
            if(listaJugadores.isEmpty()){
             cc.jlError.setText("");
             cc.jlError.setText("No hay jugadores registrados");
            }
            for (Jugador jugador : listaJugadores) {
                codigo=jugador.getCodigojugador().toString();
                contraseña=jugador.getContraseña();
                if(codigo.equals(""+cc.logeado)){
                    if(contraseña.equals(DigestUtils.md5Hex(cc.jtContraseña.getText()))){
                        cambiarContraJ();
                    }
                    else{
                     cc.jlError.setText("");
                     cc.jlError.setText(jugador.getNombre()+",Contraseña erronea");
                    }
                }
                else{
                    cc.jlError.setText("");
                    cc.jlError.setText("Datos Erroneos");
                }
                
            }
        } catch (Exception ex) {
           // System.out.println("No se encontró el codigo");
            cc.jlError.setText("");
            cc.jlError.setText("Datos Erroneos");
            Logger.getLogger(ManejadorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void validarEntrenador(){
        codigo="";
        contraseña="";        
        try {
            List<Entrenador> listaEntrenadores=DAOFactory.getEntrenadorDAO().consultar();
            if(listaEntrenadores.isEmpty()){
            cc.jlError.setText("");
            cc.jlError.setText("No hay entrenadores registrados");
                }
            for (Entrenador entrenador : listaEntrenadores) {
                codigo=entrenador.getCodigoentrenador().toString();
                contraseña=entrenador.getContraseña();
                if(codigo.equals(""+cc.logeado)){
                    if(contraseña.equals(DigestUtils.md5Hex(cc.jtContraseña.getText()))){
                        cambiarContraE();
                    }
                    else{
                    cc.jlError.setText("");
                    cc.jlError.setText(entrenador.getNombre()+",Contraseña erronea");  
                    }
                }
                else{
                    cc.jlError.setText("");
                    cc.jlError.setText("Datos Erroneos");
                }
                
            }
        } catch (Exception ex) {
            //System.out.println("No se encontró el codigo");
            cc.jlError.setText("");
            cc.jlError.setText("Datos Erroneos");
            Logger.getLogger(ManejadorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void validarAdministrador() {
        codigo="";
        contraseña="";
        try {
            List<Administrador> listaAdministradores=DAOFactory.getAdministradorDAO().consultar();
            for (Administrador administrador : listaAdministradores) {
                codigo=administrador.getCodigoadministrador().toString();
                contraseña=administrador.getContraseña();
                if(codigo.equals(""+cc.logeado)){
                    if(contraseña.equals(DigestUtils.md5Hex(cc.jtContraseña.getText()))){
                        cambiarContraA();
                    }
                    else{
                    cc.jlError.setText("");
                    cc.jlError.setText(administrador.getNombre()+",Contraseña erronea"); 
                    }
                }
                else{
                    cc.jlError.setText("");
                    cc.jlError.setText("Datos Erroneos");
                }
                
            }
        } catch (Exception ex) {
           // System.out.println("No se encontró el codigo");
            cc.jlError.setText("");
            cc.jlError.setText("Datos Erroneos");
            Logger.getLogger(ManejadorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cambiarContraA(){
        if(cc.jtContraseñaNueva.getText().equals(cc.jtContraseñaNueva1.getText())){
            try {
                EntityManagerHelper.beginTransaction();
                Administrador administradorExistente = DAOFactory.getAdministradorDAO().consultarPorId(cc.logeado);
                administradorExistente.setContraseña(DigestUtils.md5Hex(cc.jtContraseñaNueva.getText()));
                administradorExistente.setEstadocontra(1);
                DAOFactory.getAdministradorDAO().modificar(administradorExistente);
                EntityManagerHelper.commit();
                EntityManagerHelper.closeEntityManager();
                JOptionPane.showMessageDialog(null,"Contraseña modificada","",JOptionPane.INFORMATION_MESSAGE);
                cc.setVisible(false);
                MenuAdministrador ma = new MenuAdministrador(lg,cc.logeado);
                ma.setVisible(true);
            }
            catch (Exception ex) {
                Logger.getLogger(UpdateModificarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            cc.jlError.setText("");
            cc.jlError.setText("Las contraseñas no coinciden");
        }
    }
    
        public void cambiarContraE(){
        if(cc.jtContraseñaNueva.getText().equals(cc.jtContraseñaNueva1.getText())){
            try {
                EntityManagerHelper.beginTransaction();
                Entrenador entrenadorExistente = DAOFactory.getEntrenadorDAO().consultarPorId(cc.logeado);
                entrenadorExistente.setContraseña(DigestUtils.md5Hex(cc.jtContraseñaNueva.getText()));
                entrenadorExistente.setEstadocontra(1);
                DAOFactory.getEntrenadorDAO().modificar(entrenadorExistente);
                EntityManagerHelper.commit();
                EntityManagerHelper.closeEntityManager();
                JOptionPane.showMessageDialog(null,"Contraseña modificada","",JOptionPane.INFORMATION_MESSAGE);
                cc.setVisible(false);
                MenuEntrenador me = new MenuEntrenador(lg,cc.logeado);
                me.setVisible(true);
            }
            catch (Exception ex) {
                Logger.getLogger(UpdateModificarEntrenador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            cc.jlError.setText("");
            cc.jlError.setText("Las contraseñas no coinciden");
        }
    }
    
        
    public void cambiarContraJ(){
        if(cc.jtContraseñaNueva.getText().equals(cc.jtContraseñaNueva1.getText())){
            try {
                EntityManagerHelper.beginTransaction();
                Jugador jugadorExistente = DAOFactory.getJugadorDAO().consultarPorId(cc.logeado);
                jugadorExistente.setContraseña(DigestUtils.md5Hex(cc.jtContraseñaNueva.getText()));
                jugadorExistente.setEstadocontra(1);
                DAOFactory.getJugadorDAO().modificar(jugadorExistente);
                EntityManagerHelper.commit();
                EntityManagerHelper.closeEntityManager();
                JOptionPane.showMessageDialog(null,"Contraseña modificada","",JOptionPane.INFORMATION_MESSAGE);
                cc.setVisible(false);
                MenuJugador mj = new MenuJugador(lg,cc.logeado);
                mj.setVisible(true);
            }
            catch (Exception ex) {
                Logger.getLogger(UpdateModificarAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            cc.jlError.setText("");
            cc.jlError.setText("Las contraseñas no coinciden");
        }
    }
    
}
