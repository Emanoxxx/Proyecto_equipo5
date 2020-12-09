package mx.uv.sw80640;

//import java.beans.Statement;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import javax.swing.text.StyledEditorKit.BoldAction;

import java.sql.*;

public class DAO {
    public static Conexion conn = new Conexion();
    public static double getNCuentos(String username){
        
        double i=0;
        java.sql.Statement stm = null;
        Connection con=null;
        ResultSet rs =null;
        String contenido="";
        con = conn.getConexion();
        try {

            String sql="Select vistas from Cuento where usuario="+username+"";
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
           
           
            while(rs.next()){
                i++;
                contenido= rs.getString("vistas");
            }
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
            }
        }
        return i;
    }
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
            }
        }
        return x;
    }
    //select * from Cuento order by vistas desc;
    public static List<Cuento> getTop(){
        String x="No creado";
        java.sql.Statement stm = null;
        Connection con=null;
        ResultSet rs =null;
        List<Cuento> cuentos = new ArrayList<Cuento>();
        //Cuento c=new Cuento(nombre,user);
        String contenido="No se encontro o hubo un error.";
        con = conn.getConexion();
        try {
            String sql="select * from Cuento order by vistas desc";
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
           
           int i=0;
            while(rs.next() & i<5){
                i++;
                cuentos.add(new Cuento(rs.getString("nombre"),rs.getString("usuario")));
            }
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
            }
        }
        
        
        return cuentos;
    }
    //
    public static List<Cuento> getCuentos(String user){
        String x="No creado";
        java.sql.Statement stm = null;
        Connection con=null;
        ResultSet rs =null;
        List<Cuento> cuentos = new ArrayList<Cuento>();
        //Cuento c=new Cuento(nombre,user);
        String contenido="No se encontro o hubo un error.";
        con = conn.getConexion();
        try {
            String sql="Select nombre,usuario from Cuento where usuario='"+user+"'";
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
           
           int i=0;
            while(rs.next()){
                i++;
                cuentos.add(new Cuento(rs.getString("nombre"),rs.getString("usuario")));
            }
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
            }
        }
        
        
        return cuentos;
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
            }
        }
        
        Cuento c=new Cuento(nombre,user,contenido);
        return c;
    }
    public static String agregarCuento(String nombre,String username,String c,String gen){
        String r="NO";
        java.sql.Statement stm = null;
        Connection con=null;
        ResultSet rs =null;
        List<Usuarios> resultado =new ArrayList<>();
        con = conn.getConexion();
        try {
            String sql="INSERT INTO Cuento (nombre, usuario, contenido, genero, vistas, imagen) VALUES ("+nombre+","+username+","+c+","+gen+",'"+0+"','"+0+"')";
            stm=con.createStatement();
            stm.execute(sql);
            r="SI";
            System.out.println(r+"Hey mirame wacho llegue");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(rs!=null){
                try {rs.close();} catch (Exception e) {}rs=null;}
            if(stm!=null){
                try {stm.close();} catch (Exception e) {}stm=null;}
            if(con!=null){
                try {con.close();} catch (Exception e) {}con=null;System.out.println("Conexion cerrada");}}
        return r;
    }
    //
    public static String updateUnombre(String nombre, String username){
        String r="NO";java.sql.Statement stm = null;Connection con=null; ResultSet rs =null;
        con = conn.getConexion();
        try {
            System.out.println(username);
            String sql="Update Usuario set nombre="+nombre+" where id="+username;
            
            stm=con.createStatement();
            stm.execute(sql);
            r="SI";
            System.out.println(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(rs!=null){
                try {rs.close();} catch (Exception e) {}rs=null;}
            if(stm!=null){
                try {stm.close();} catch (Exception e) {}stm=null;}
            if(con!=null){
                try {con.close();} catch (Exception e) {}con=null;System.out.println("Conexion cerrada");}}
        return r;
    }
    public static String updateUemail(String email, String username){
        String r="NO";java.sql.Statement stm = null;Connection con=null; ResultSet rs =null;
        con = conn.getConexion();
        try {
            String sql="Update Usuario set email="+email+" where id="+username;
            System.out.println(sql);
            stm=con.createStatement();
            stm.execute(sql);
            r="SI";
            System.out.println("email");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(rs!=null){
                try {rs.close();} catch (Exception e) {}rs=null;}
            if(stm!=null){
                try {stm.close();} catch (Exception e) {}stm=null;}
            if(con!=null){
                try {con.close();} catch (Exception e) {}con=null;System.out.println("Conexion cerrada");}}
        return r;
    }
    public static String updateUid(String id, String username){
        String r="NO";java.sql.Statement stm = null;Connection con=null; ResultSet rs =null;
        con = conn.getConexion();
        try {
            String sql="Update Usuario set id="+id+" where id="+username;
            stm=con.createStatement();
            stm.execute(sql);
            r="SI";
            System.out.println("id");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(rs!=null){
                try {rs.close();} catch (Exception e) {}rs=null;}
            if(stm!=null){
                try {stm.close();} catch (Exception e) {}stm=null;}
            if(con!=null){
                try {con.close();} catch (Exception e) {}con=null;System.out.println("Conexion cerrada");}}
        return r;
    }
    public static String updateUpass(String pass, String username){
        String r="NO";
        java.sql.Statement stm = null;
        Connection con=null; 
        ResultSet rs =null;
        con = conn.getConexion();
        try {
            String sql="Update Usuario set pass="+pass+" where id="+username;
            System.out.println(sql);
            stm=con.createStatement();
            stm.execute(sql);
            r="SI";
            System.out.println("pass");
            System.out.println(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(rs!=null){
                try {
                    rs.close();
                } catch (Exception e) {

                }
                rs=null;
            }
            if(stm!=null){
                try {
                    stm.close();
                }
                catch (Exception e) {
                    
                }
                stm=null;
            }

            if(con!=null){
                try {
                    con.close();
                } catch (Exception e) {

                }con=null;
                System.out.println("Conexion cerrada");
            }}
        return r;
    }
    //
    public static boolean getvalidar(String n, String c) {
        
        String x="No creado";
        java.sql.Statement stm = null;
        Connection con=null;
        ResultSet rs =null;
        List<Usuarios> resultado =new ArrayList<>();
        String contenido="";
        con = conn.getConexion();
        try {

            String sql="Select * from Usuario where id="+n+" and pass="+c+"";
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
           
           int i=0;
            while(rs.next()){
                i++;
                contenido= rs.getString("id");
            }
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
        if(contenido!=""){
            return true;
        }
        return false;
    }
    //
    
}
