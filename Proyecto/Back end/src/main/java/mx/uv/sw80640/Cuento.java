package mx.uv.sw80640;

public class Cuento {
    private String nombre;
    private String usuario;
    private String contenido;
    public Cuento(String n, String u, String c){
        nombre=n;
        usuario=u;
        contenido=c;
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
