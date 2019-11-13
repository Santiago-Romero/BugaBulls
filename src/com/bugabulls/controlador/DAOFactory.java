package com.bugabulls.controlador;

public class DAOFactory {
    private static IAcudienteDAO acudienteDAO=new AcudienteDAO();
    private static IAdministradorDAO administradorDAO=new AdministradorDAO();
    private static ICategoriaDAO categoriaDAO=new CategoriaDAO();
    private static IEntrenadorDAO entrenadorDAO=new EntrenadorDAO();
    private static IEventoDAO eventoDAO=new EventoDAO();
    private static IJugadorDAO jugadorDAO=new JugadorDAO();
    private static IPagoDAO pagoDAO=new PagoDAO();
    private static IPlantillaDAO plantillaDAO=new PlantillaDAO();
    private static ISesionDAO sesionDAO=new SesionDAO();
    private static ISesionCategoriaDAO sesioncategoriaDAO=new SesionCategoriaDAO();
    private static IJugadorEventoDAO jugadoreventoDAO=new JugadorEventoDAO();
    public static IAcudienteDAO getAcudienteDAO() {
        return acudienteDAO;
    }

    public static IAdministradorDAO getAdministradorDAO() {
        return administradorDAO;
    }

    public static ICategoriaDAO getCategoriaDAO() {
        return categoriaDAO;
    }

    public static IEntrenadorDAO getEntrenadorDAO() {
        return entrenadorDAO;
    }

    public static IEventoDAO getEventoDAO() {
        return eventoDAO;
    }
    
    public static IJugadorEventoDAO getJugadorEventoDAO(){
        return jugadoreventoDAO;
    }
    public static IJugadorDAO getJugadorDAO() {
        return jugadorDAO;
    }

    public static IPagoDAO getPagoDAO() {
        return pagoDAO;
    }

    public static IPlantillaDAO getPlantillaDAO() {
        return plantillaDAO;
    }

    public static ISesionDAO getSesionDAO() {
        return sesionDAO;
    }
    public static ISesionCategoriaDAO getSesionCategoriaDAO() {
        return sesioncategoriaDAO;
    }    
}
