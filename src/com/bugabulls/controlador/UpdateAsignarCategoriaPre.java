package com.bugabulls.controlador;

import com.bugabulls.modelo.Categoria;
import com.bugabulls.modelo.Entrenador;
import com.bugabulls.vista.AsignarCategoriaPre;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import javax.swing.JOptionPane;

public class UpdateAsignarCategoriaPre implements ActionListener{
    
    AsignarCategoriaPre acp;

    public UpdateAsignarCategoriaPre(AsignarCategoriaPre acp){
		this.acp = acp;
                 sinEntrenador(); 
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(acp.jbGuardar)){
            guardarCategoria();
        }
    }
    public void guardarCategoria(){
        try {
            EntityManagerHelper.beginTransaction();
            Categoria categoriaExistente=DAOFactory.getCategoriaDAO().consultarPorId(1);
            categoriaExistente.setHorario(new Time(acp.dateModel.getDate().getTime()));
            Entrenador entrenador=DAOFactory.getEntrenadorDAO().consultarPorId(Integer.parseInt(acp.jcEntrenador.getSelectedItem().toString().substring(0,5)));
            categoriaExistente.setCodigoentrenador(entrenador);
            DAOFactory.getCategoriaDAO().modificar(categoriaExistente);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"No se ha seleccionado el entrenador");
            System.out.println(ex);
        }
        JOptionPane.showMessageDialog(null,"Información guardada con exito","",JOptionPane.INFORMATION_MESSAGE);
        acp.setVisible(false);
    }
    
      public void sinEntrenador (){  
        if( acp.jcEntrenador.getItemCount()==0){
            acp.jbGuardar.setEnabled(false);
            acp.jlerror.setText("");
            acp.jlerror.setText("No se han registrado entrenadores");
                } }
}
