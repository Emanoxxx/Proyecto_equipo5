package mx.uv.sw80640;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.eclipse.jetty.server.Authentication.Failed;

public class Conexion {
    private static String url = "jdbc:mysql://emanoxxxdb.ckvheunuvy2u.us-east-2.rds.amazonaws.com:3306/emanoxxxdb?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false";

    private static String driverName = "com.mysql.cj.jdbc.Driver";
    private static String username = "admin";
    private static String password = "espartan117";
    private static Connection conexion = null;

    public static Connection getConexion(){
        try{
            Class.forName(driverName);
            conexion = DriverManager.getConnection(url, username, password);
            System.out.println("Sucess Connection");
        } catch(SQLException e){
            System.out.println("Failed to create Connection");
        } catch(ClassNotFoundException e){
            System.out.println("Driver not found");
        }
        return conexion;
    }
}