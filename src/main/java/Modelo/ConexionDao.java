/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author manja
 */
public class ConexionDao {
     // Declaramos variables para la conexion con la base de datos;
    // cambio en la conexion a la base de datos a una base de datos en la nube con cloud computing para este caso con azure de microsoft
   private static final String URL = "jdbc:sqlserver://sena2.database.windows.net:1433;"
            + "database=centrouniversitario;"
            + "encrypt=true;"
            + "trustServerCertificate=false;"
            + "hostNameInCertificate=*.database.windows.net;"
            + "loginTimeout=30;";
    //public static final String url = "jdbc:mysql://localhost:3306/libreria";
    public static final String username = "emanjarres";
    //public static final String username = "root";
    public static final String pass = "Sena2025..";

    // creamos una función para conectarnos a la base de datos
    public static Connection ObtenerConexion() throws ClassNotFoundException {
        Connection conn = null;
       try {
            // Cargar el driver de SQL Server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Intentar la conexión
            conn = DriverManager.getConnection(URL, username, pass);
            System.out.println("✅ Conexión exitosa a Azure SQL Database");
        } catch (ClassNotFoundException e) {
            System.out.println(" No se encontró el driver JDBC de SQL Server: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println(" Error al conectar a la base de datos: " + e.getMessage());
        }
        // retornamos conn que es conexion para poder acceder al metodo conexión
        return conn;
    }
    public static void main(String[] args){
       try {
           Connection test = ConexionDao.ObtenerConexion();
           if(test!=null){
               System.out.println("Conexión probada correctamente desde main.");
           }else{
               System.out.println("No se pudo establecer la conexión.");
           }
       } catch (ClassNotFoundException ex) {
           System.getLogger(ConexionDao.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
       }
    }
    
    
    

    
}
