package util;
import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Alba Consuelo Nieto
 */
public class ServiceLocator{   

    private static String user;
    private static String password;
    private static String mensaje="";
    private static boolean conectado=false;
    
    /**
     * Instancia del ServiceLocator
     */
    private static ServiceLocator instance = null;

    public static String getUsu() {
        return password;
    }

    /**
     * Conexion compartida a la Base de Datos
     */
    private Connection conexion = null;

    /**
     * Bandera que indica el estado de la conexión
     */
    private boolean conexionLibre = true;

    public static String login(String usuario, String password) {
        ServiceLocator.user = usuario;
        ServiceLocator.password = password;
        try {
            instance = null;
            instance = new ServiceLocator();
            mensaje = null; 
            conectado = true;
        } catch (Exception ex) {
            mensaje = "Error conexion base de datos: "+ex.getMessage();
            conectado = false;
            Logger.getLogger(ServiceLocator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mensaje;
    }

    public static String getMensaje() {
        return mensaje;
    }
    /**
     * @return instancia del ServiceLocator para el manejo de la conexion
     */
    public static ServiceLocator getInstance() {
        if (instance == null) {
            try {
                instance = new ServiceLocator();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return instance;
    }

    /**
     * @throws Exception
     *             dice si no se pudo crear la conexion
     */
    private ServiceLocator() throws Exception {
        try {
            // Se registra el Driver y se crea la conexion
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            //String url = "jdbc:oracle://localhost:1521/apoyo_alimentario";
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conexion = DriverManager.getConnection(url, user, password);
            conexion.setAutoCommit(false);            
            mensaje = "Conexión a la base de datos exitosa";
        } catch (Exception e) {
            mensaje = "Error conexion base de datos: "+e.getMessage();
            throw new RHException("ServiceLocator", "ERROR_CONEXION_BD " + e);
        }
     }

    /**
     * Toma la conexion para que ningun otro proceso la puedan utilizar
     * @return da la conexion a la base de datos
     */
    public synchronized Connection tomarConexion() {
        while (!conexionLibre) {
            try {
              wait();
            } catch (InterruptedException e) {
                    e.printStackTrace();
            }
        }

        conexionLibre = false;
        notify();
        return conexion;
    }

    /**
     * Libera la conexion de la bases de datos para que ningun otro
     * proceso la pueda utilizar
     */
    public synchronized void liberarConexion() {
        while (conexionLibre) {
            try {
                    wait();
            } catch (InterruptedException e) {
                    e.printStackTrace();
            }
        }

        conexionLibre = true;
        notify();
    }

    /**
     * Cierra la conexion a la base de datos cuando se termina de
     * ejecutar el programa
     */
    public void close() {
        try {
                conexion.close();
        } catch (SQLException e) {
                e.printStackTrace();
        }
    }

    /**
     * Realiza los cambios en la base de datos. Con este metodo
     * se asegura que no halla inconsitencias en el modelo relacional
     * de la Base de datos.
     * 
     * Se utiliza cuando el procedimiento de insercion es terminado
     * correctamente y se asegura que los datos en el modelo estan bien
     * relacionados.
     */
    public void commit() {
        try {
                conexion.commit();
        } catch (SQLException e) {
                e.printStackTrace();
        }
    }

    /**
     * Deshace los cambios en la base de datos. Con este metodo
     * se asegura que no halla inconsitencias en el modelo relacional
     * de la Base de datos.
     * 
     * Se utiliza por lo general cuando se devuelve una Exepcion.
     * Los procedimientos intermedios no deberia quedar almacenados en la
     * base de datos. 
     */

    public void rollback() {
        try {
                conexion.rollback();
        } catch (SQLException e) {
                e.printStackTrace();
        }
    }

    public static boolean isConectado() {
        return conectado;
    }
    
}

