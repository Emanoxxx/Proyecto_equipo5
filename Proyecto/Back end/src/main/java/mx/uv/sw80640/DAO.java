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
    //getCuentosSearch
    public static List<Cuento> getCuentosSearch(String busqueda){
        java.sql.Statement stm = null;
        Connection con=null;
        ResultSet rs =null;
        List<Cuento> cuentos = new ArrayList<Cuento>();
        String contenido="No se encontro o hubo un error.";
        con = conn.getConexion();
        try {
            String sql="Select nombre,usuario from Cuento where usuario='"+busqueda+"'";
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
           
           int i=0;
            while(rs.next()){
                i++;
                cuentos.add(new Cuento(rs.getString("nombre"),rs.getString("usuario")));
            }
            //Titulo
            sql="Select nombre,usuario from Cuento where nombre='"+busqueda+"'";
            rs=stm.executeQuery(sql);
           
            i=0;
            while(rs.next()){
                i++;
                cuentos.add(new Cuento(rs.getString("nombre"),rs.getString("usuario")));
            }
            //genero
            sql="Select nombre,usuario from Cuento where genero='"+busqueda+"'";
            rs=stm.executeQuery(sql);
           
            i=0;
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
    public static String getTop(){
        String x="No creado";
        java.sql.Statement stm = null;
        Connection con=null;
        ResultSet rs =null;
        String cuentos = "";
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
                cuentos=cuentos + "Cuento-"+(i)+": N("+ rs.getString("nombre")+")U("+rs.getString("usuario")+")";
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
    //getGenero
    public static String getGenero(String nombre,String user){
        java.sql.Statement stm = null;
        Connection con=null;
        ResultSet rs =null;
        List<Usuarios> resultado =new ArrayList<>();
        String contenido="No se encontro o hubo un error.";
        con = conn.getConexion();
        try {
            String sql="Select genero from Cuento where nombre="+nombre+"and usuario="+user+"";
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
            while(rs.next()){
                contenido= rs.getString("genero");
            }
            stm.execute(sql);
            //update Cuento set vistas=vistas+1 where nombre="El perro aterrado" and usuario="emanoxxx";
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
        return contenido;
    }
    
    //getCuentoContenido
    public static Cuento getCuentoContenido(String nombre,String user){
        String x="No creado";
        java.sql.Statement stm = null;
        Connection con=null;
        ResultSet rs =null;
        List<Usuarios> resultado =new ArrayList<>();
        String contenido="No se encontro o hubo un error."+nombre+"nn"+user;
        con = conn.getConexion();
        try {
            String sql="Select contenido from Cuento where nombre="+nombre+"and usuario="+user+"";
            contenido=sql;
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
           
           int i=0;
            while(rs.next()){
                i++;
                contenido= rs.getString("contenido");
            }
            sql="update Cuento set vistas=vistas+1 where nombre='"+nombre+"'and usuario='"+user+"'";
            stm.execute(sql);
            //update Cuento set vistas=vistas+1 where nombre="El perro aterrado" and usuario="emanoxxx";
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
    //
    public static Cuento getCuento(String nombre,String user){
        String x="No creado";
        java.sql.Statement stm = null;
        Connection con=null;
        ResultSet rs =null;
        List<Usuarios> resultado =new ArrayList<>();
        String contenido="No se encontro o hubo un error."+nombre+"nn"+user;
        con = conn.getConexion();
        try {
            String sql="Select contenido from Cuento where nombre='"+nombre+"'and usuario='"+user+"'";
            contenido=sql;
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
           
           int i=0;
            while(rs.next()){
                i++;
                contenido= rs.getString("contenido");
            }
            sql="update Cuento set vistas=vistas+1 where nombre='"+nombre+"'and usuario='"+user+"'";
            stm.execute(sql);
            //update Cuento set vistas=vistas+1 where nombre="El perro aterrado" and usuario="emanoxxx";
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
    }//updateCuento
    public static String updateCuento(String nombre,String username,String c,String gen){
        String r="NO";
        java.sql.Statement stm = null;
        Connection con=null;
        ResultSet rs =null;
        List<Usuarios> resultado =new ArrayList<>();
        con = conn.getConexion();
        try {
            //String sql="Update Usuario set nombre="+nombre+" where id="+username;
            String sql="Update Cuento set nombre="+nombre+",contenido="+c+",genero="+gen+" where nombre="+nombre+"and usuario="+username+"";
            stm=con.createStatement();
            stm.execute(sql);
            r="SI";
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
    public static String delCuento(String nombre,String username){
        String r="NO";
        java.sql.Statement stm = null;
        Connection con=null;
        ResultSet rs =null;
        List<Usuarios> resultado =new ArrayList<>();
        con = conn.getConexion();
        try {
            //String sql="Update Usuario set nombre="+nombre+" where id="+username;
            String sql="delete from Cuento where nombre="+nombre+"and usuario="+username+"";
            stm=con.createStatement();
            stm.execute(sql);
            r="SI";
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
