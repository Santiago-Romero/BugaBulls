package com.bugabulls.controlador;

import com.bugabulls.modelo.Categoria;
import com.bugabulls.modelo.Entrenador;
import com.bugabulls.vista.AsignarCategoriaIn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import javax.swing.JOptionPane;

public class UpdateAsignarCategoriaIn implements ActionListener{
    
    AsignarCategoriaIn aci;
    
    
    public UpdateAsignarCategoriaIn(AsignarCategoriaIn aci){
		this.aci = aci;
                 sinEntrenador(); 
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(aci.jbGuardar)){
            guardarCategoria();
        }
    }    
    public void guardarCategoria(){
        try {
            EntityManagerHelper.beginTransaction();
            Categoria categoriaExistente=DAOFactory.getCategoriaDAO().consultarPorId(4);
            categoriaExistente.setHorario(new Time(aci.dateModel.getDate().getTime()));
            Entrenador entrenador=DAOFactory.getEntrenadorDAO().consultarPorId(Integer.parseInt(aci.jcEntrenador.getSelectedItem().toString().substring(0,5)));
            categoriaExistente.setCodigoentrenador(entrenador);
            DAOFactory.getCategoriaDAO().modificar(categoriaExistente);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"No se ha seleccionado el entrenador");
            System.out.println(ex);
        }
        JOptionPane.showMessageDialog(null,"Información guardada con exito","",JOptionPane.INFORMATION_MESSAGE);
        aci.setVisible(false);
    }
    
      public void sinEntrenador (){  
        if( aci.jcEntrenador.getItemCount()==0){
            aci.jbGuardar.setEnabled(false);
            aci.jlerror.setText("");
            aci.jlerror.setText("No se han registrado entrenadores");
                } }
}
