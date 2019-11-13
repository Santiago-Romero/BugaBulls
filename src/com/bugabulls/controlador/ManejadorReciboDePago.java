package com.bugabulls.controlador;

import com.bugabulls.modelo.Jugador;
import com.bugabulls.modelo.Pago;
import com.bugabulls.vista.ReciboDePago;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManejadorReciboDePago implements ActionListener,Printable{
    int numeroRecibo = 87382;
    ReciboDePago rdp;
    int administradorLogeado;

    public ManejadorReciboDePago(ReciboDePago rdp,int numeroRecibo,int administradorLogeado) {
        this.administradorLogeado=administradorLogeado;
        this.numeroRecibo=numeroRecibo;
        this.rdp = rdp;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().equals(rdp.jbPagar)){
		    validar();
                    
        }
    }
    public void validar(){
        if(rdp.jtCedula.getText().equals("") || rdp.jtRecibi.getText().equals("") || rdp.jtRecibidode.getText().equals(""))
        {
            rdp.jlerror.setText("Diligencie todos los campos");   
        }
        else{
            pagar();
        }
    }
    public void pagar(){
        try {
            Calendar c1 = GregorianCalendar.getInstance();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            
            Date fechaPagoDate = formato.parse(rdp.jlFechaPago.getText());
            EntityManagerHelper.beginTransaction();
            Jugador jugador=DAOFactory.getJugadorDAO().consultarPorId(Integer.parseInt(rdp.jcCodigoJugador.getSelectedItem().toString().substring(0,5)));
            
            Pago nuevoPago=new Pago();
            nuevoPago.setCodigopago(numeroRecibo);
            nuevoPago.setCodigojugador(jugador);
            nuevoPago.setFechapago(fechaPagoDate);
            c1.add(Calendar.MONTH, 1);
            jugador.setFechacobro(c1.getTime());
            nuevoPago.setValor(Double.parseDouble("25000"));
            DAOFactory.getPagoDAO().insertar(nuevoPago);
            DAOFactory.getJugadorDAO().modificar(jugador);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            imprimir();
        } catch (Exception ex) {
            Logger.getLogger(ManejadorReciboDePago.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void imprimir(){
    try {
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintable(this);
            job.printDialog();
            job.print();
        } catch (PrinterException ex) {
            System.out.println(ex);
        } 
	}

    @Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		if (pageIndex > 0) return NO_SUCH_PAGE;
        Graphics2D g2d = (Graphics2D)graphics;
        g2d.translate(  pageFormat.getImageableX()-25, 
                        pageFormat.getImageableY());
        rdp.panel.printAll(graphics);
        rdp.setVisible(false);
        return PAGE_EXISTS; 
        
	}
}
