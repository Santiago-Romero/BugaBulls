package com.bugabulls.controlador;

import com.bugabulls.modelo.Evento;
import com.bugabulls.modelo.Jugador;
import com.bugabulls.modelo.JugadorEvento;
import com.bugabulls.vista.ConsultarEventos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;

public class ManejadorConsultarEventos implements ActionListener{
    ConsultarEventos ce;
    
    public ManejadorConsultarEventos(ConsultarEventos ce){
        this.ce = ce;
        sinEventos();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(ce.jbBuscar)){
            ce.jcjuga.removeAllItems();
            consultarEvento();
                    
        }
    }

    private void consultarEvento() {
        try {
            EntityManagerHelper.beginTransaction();
            Evento miEvento = DAOFactory.getEventoDAO().consultarPorId(Integer.parseInt(ce.jcEventos.getSelectedItem().toString().substring(0,3)));
            ce.jlnom.setText(miEvento.getNombre());
            ce.jlciu.setText(miEvento.getCiudad());
            DateFormat fecha = new SimpleDateFormat("yyyy/MM/dd");
            String fechaFin = fecha.format(miEvento.getFechafin());
            String fechaIni = fecha.format(miEvento.getFechaini());
            ce.jlfin.setText(fechaFin);
            ce.jlini.setText(fechaIni);
            ce.jlgas.setText(miEvento.getGastos().toString());
            List<JugadorEvento> listaJugadorEvento = DAOFactory.getJugadorEventoDAO().consultar();
             for(JugadorEvento jugadorevento : listaJugadorEvento){
                 if(jugadorevento.getCodigoevento().getCodigoevento().equals(Integer.parseInt(ce.jcEventos.getSelectedItem().toString().substring(0,3))))
                 {
                     Jugador jugador=DAOFactory.getJugadorDAO().consultarPorId(jugadorevento.getCodigojugador());
                     ce.jcjuga.addItem(jugador.getCodigojugador()+" - "+ jugador.getNombre());
                 }
             }
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
        } catch (Exception ex) {
            System.out.println(ex);           
        }
    }
    
        public void sinEventos (){  
        if( ce.jcEventos.getItemCount()==0){
            ce.jbBuscar.setEnabled(false);
            ce.jlerror.setText("");
            ce.jlerror.setText("No tiene programado ningún evento");
                } }
    
}
