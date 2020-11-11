package mx.uv.sw80640;

import javax.swing.text.StyledEditorKit.BoldAction;

public class Usuarios {
    private String nombre;
    private String email;
    private String id;
    private String pass;
    private boolean adm;

    public Usuarios(String nombre, String email, String pass, String id, boolean adm) {
     this.nombre=nombre;
     this.email=email;
     this.id=id;
     this.pass=pass;
     this.adm=adm;
    }
    public Usuarios(String nombre, String email, String pass, String id) {
        this.nombre=nombre;
        this.email=email;
        this.id=id;
        this.pass=pass;
        this.adm=false;
       }
       public Usuarios( String email, String pass) {
        this.id="";
        this.setEmail(email);
        this.setContrasena(pass);
    }
       public String toString(){
        return "Usuario: "+email;
    }
    public  String getName(){
        return nombre;
    }
    public String getPass() {
        return pass;
    }
    public String getEmail() {
        return email;
    }
    public String getId() {
        return id;
    }

    public void setContrasena(String pass) {
        this.pass = pass;
    }

    

    public void setEmail(String email) {
        this.email = email;
    }
    public void setId(String id) {
        this.id = id;
    }
    
    
}
