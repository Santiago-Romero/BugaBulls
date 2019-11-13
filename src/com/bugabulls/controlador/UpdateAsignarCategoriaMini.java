package com.bugabulls.controlador;

import com.bugabulls.modelo.Categoria;
import com.bugabulls.modelo.Entrenador;
import com.bugabulls.vista.AsignarCategoriaMini;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import javax.swing.JOptionPane;

public class UpdateAsignarCategoriaMini implements ActionListener{
    
    AsignarCategoriaMini acm;
    
    public UpdateAsignarCategoriaMini(AsignarCategoriaMini acm){
		this.acm = acm;
                 sinEntrenador(); 
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(acm.jbGuardar)){
            guardarCategoria();
        }
    }
    public void guardarCategoria(){
        try {
            EntityManagerHelper.beginTransaction();
            Categoria categoriaExistente=DAOFactory.getCategoriaDAO().consultarPorId(3);
            categoriaExistente.setHorario(new Time(acm.dateModel.getDate().getTime()));
            Entrenador entrenador=DAOFactory.getEntrenadorDAO().consultarPorId(Integer.parseInt(acm.jcEntrenador.getSelectedItem().toString().substring(0,5)));
            categoriaExistente.setCodigoentrenador(entrenador);
            DAOFactory.getCategoriaDAO().modificar(categoriaExistente);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"No se ha seleccionado el entrenador");
            System.out.println(ex);
        }
        JOptionPane.showMessageDialog(null,"Información guardada con exito","",JOptionPane.INFORMATION_MESSAGE);
        acm.setVisible(false);
    }
    
      public void sinEntrenador (){  
        if( acm.jcEntrenador.getItemCount()==0){
            acm.jbGuardar.setEnabled(false);
            acm.jlerror.setText("");
            acm.jlerror.setText("No se han registrado entrenadores");
                } }
    
}
