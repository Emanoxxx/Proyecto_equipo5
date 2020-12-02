package mx.uv.sw80640;

//import java.beans.Statement;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.sql.*;

public class DAO {
    public static Conexion conn = new Conexion();
    public static String addUsuario(String nombre,String id,String eml,String pass){
        String x="No creado";
        java.sql.Statement stm = null;
        Connection con=null;
        ResultSet rs =null;
        List<Usuarios> resultado =new ArrayList<>();
        con = conn.getConexion();
        try {
            String sql="INSERT INTO Usuario (nombre, email, id, pass, adm) VALUES ('"+nombre+"','"+eml+"','"+id+"','"+pass+"','"+0+"')";
            stm=con.createStatement();
            stm.execute(sql);
            x="Usuario Creado";
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(rs!=null){
                try {
                    rs.close();
                } catch (Exception e) {
                    //TODO: handle exception
                }
                rs=null;
            }
            if(stm!=null){
                try {
                    stm.close();
                } catch (Exception e) {
                    //TODO: handle exception
                }
                stm=null;
            }
            if(con!=null){
                try {
                    con.close();
                } catch (Exception e) {
                    //TODO: handle exception
                }
                con=null;
                System.out.println("Conexion cerrada");
            }
        }
        return x;
    }
    //
    public static Cuento getCuento(String nombre,String user){
        String x="No creado";
        java.sql.Statement stm = null;
        Connection con=null;
        ResultSet rs =null;
        List<Usuarios> resultado =new ArrayList<>();
        String contenido="No se encontro o hubo un error.";
        con = conn.getConexion();
        try {
            String sql="Select contenido from Cuento where nombre='"+nombre+"'and usuario='"+user+"'";
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
           
           int i=0;
            while(rs.next()){
                i++;
                contenido= rs.getString("contenido");
            }
           System.out.println("LLegue fokiu");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(rs!=null){
                try {
                    rs.close();
                } catch (Exception e) {
                    //TODO: handle exception
                }
                rs=null;
            }
            if(stm!=null){
                try {
                    stm.close();
                } catch (Exception e) {
                    //TODO: handle exception
                }
                stm=null;
            }
            if(con!=null){
                try {
                    con.close();
                } catch (Exception e) {
                    //TODO: handle exception
                }
                con=null;
                System.out.println("Conexion cerrada");
            }
        }
        
        Cuento c=new Cuento(nombre,user,contenido);
        return c;
    }
    //
    
}
