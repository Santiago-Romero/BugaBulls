package com.bugabulls.controlador;

import com.bugabulls.modelo.Categoria;
import com.bugabulls.modelo.Entrenador;
import com.bugabulls.vista.AsignarCategoriaBen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import javax.swing.JOptionPane;

public class UpdateAsignarCategoriaBen implements ActionListener{
    
    AsignarCategoriaBen acb;
    
    public UpdateAsignarCategoriaBen(AsignarCategoriaBen acb){
		this.acb = acb;
                sinEntrenador();                
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(acb.jbGuardar)){
           guardarCategoria();
        }
    }
    public void guardarCategoria(){
        try {
            EntityManagerHelper.beginTransaction();
            Categoria categoriaExistente=DAOFactory.getCategoriaDAO().consultarPorId(2);
            categoriaExistente.setHorario(new Time(acb.dateModel.getDate().getTime()));
            Entrenador entrenador=DAOFactory.getEntrenadorDAO().consultarPorId(Integer.parseInt(acb.jcEntrenador.getSelectedItem().toString().substring(0,5)));
            categoriaExistente.setCodigoentrenador(entrenador);
            DAOFactory.getCategoriaDAO().modificar(categoriaExistente);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
        } catch (Exception ex) {            
            System.out.println(ex);
        }
        JOptionPane.showMessageDialog(null,"Información guardada con exito","",JOptionPane.INFORMATION_MESSAGE);
        acb.setVisible(false);
    }
    
    public void sinEntrenador (){  
        if( acb.jcEntrenador.getItemCount()==0){
            acb.jbGuardar.setEnabled(false);
            acb.jlerror.setText("");
            acb.jlerror.setText("No se han registrado entrenadores");
                } }
  
    
}
