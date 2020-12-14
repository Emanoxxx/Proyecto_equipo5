package mx.uv.sw80640;

public class Cuento {
    public String nombre;
    public String usuario;
    public String contenido;
    public Cuento(String n, String u, String c){
        nombre=n;
        usuario=u;
        contenido=c;
    }
    public Cuento(String n, String u){
        nombre=n;
        usuario=u;
        contenido="";
    }

    public  String getName(){
        return nombre;
    }
    public String getuser() {
        return usuario;
    }
    public String getContent() {
        return contenido;
    }   
    
}
