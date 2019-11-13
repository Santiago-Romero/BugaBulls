package com.bugabulls.controlador;

import com.bugabulls.modelo.Categoria;
import com.bugabulls.modelo.Entrenador;
import com.bugabulls.vista.AsignarCategoriaJunior;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import javax.swing.JOptionPane;

public class UpdateAsignarCategoriaJunior implements ActionListener{
    
    AsignarCategoriaJunior acj;
    
    public UpdateAsignarCategoriaJunior(AsignarCategoriaJunior acj){
		this.acj = acj;
                 sinEntrenador(); 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource().equals(acj.jbGuardar)){
            guardarCategoria();
        }
    }
    public void guardarCategoria(){
        try {
            EntityManagerHelper.beginTransaction();
            Categoria categoriaExistente=DAOFactory.getCategoriaDAO().consultarPorId(5);
            categoriaExistente.setHorario(new Time(acj.dateModel.getDate().getTime()));
            Entrenador entrenador=DAOFactory.getEntrenadorDAO().consultarPorId(Integer.parseInt(acj.jcEntrenador.getSelectedItem().toString().substring(0,5)));
            categoriaExistente.setCodigoentrenador(entrenador);
            DAOFactory.getCategoriaDAO().modificar(categoriaExistente);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"No se ha seleccionado el entrenador");
            System.out.println(ex);
        }
        JOptionPane.showMessageDialog(null,"Información guardada con exito","",JOptionPane.INFORMATION_MESSAGE);
        acj.setVisible(false);
    }
    
      public void sinEntrenador (){  
        if( acj.jcEntrenador.getItemCount()==0){
            acj.jbGuardar.setEnabled(false);
            acj.jlerror.setText("");
            acj.jlerror.setText("No se han registrado entrenadores");
                } }
    
}
