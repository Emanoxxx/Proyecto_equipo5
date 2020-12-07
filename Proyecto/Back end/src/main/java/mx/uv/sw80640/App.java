package mx.uv.sw80640;
import static spark.Spark.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.*;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.Gson;
import spark.ModelAndView;
import spark.template.jade.JadeTemplateEngine;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 public static void main(String[] args) {
        port(2020);
        Map<String, String> map = new HashMap<>();
        map.put("Nombre", "Emanoxxx");
        get("/UserPage", (rq, rs) -> new ModelAndView(getNombre("emanoxxx"), "UserPage"), new JadeTemplateEngine());
    }
public static Map<String,String> getNombre(String nombre){
    Map<String, String> map = new HashMap<>();
    map.put("Nombre", nombre);
    return map;
}
 */
public class App 
{
    private static Gson gson=new Gson();

    public static void main( String[] args )
    {   
        port(2022);
        get("/UserPage", (rq, rs) -> new ModelAndView(getCuentosUser(""+rq.queryParams("U")), "UserPage"), new JadeTemplateEngine());
        get("/ReadPage", (rq, rs) -> new ModelAndView(getCuentoc(""+rq.queryParams("U"),""+rq.queryParams("N")), "ReadPage"), new JadeTemplateEngine());
        /*get("/UserPage",(request,response)->{
            String user= ""+request.queryParams("Nuser");
            return "Hola "+user+" tu pass es: "+"\n";
        });*/
        options("/*", (request, response) -> {
            
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });
        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));
        post("/singUp",(req,res)->{
            String query = req.body();
            Usuarios usuario=gson.fromJson(query,Usuarios.class);
            String x=DAO.addUsuario(usuario.getName() ,usuario.getId(),usuario.getEmail(),usuario.getPass());;
            System.out.println(x+" "+usuario.getId());
            return x;
        });
        post("/NCuentos",(req,res)->{
            try{
            JsonParser parser = new JsonParser();
            JsonElement arbol = parser.parse(req.body());
            JsonObject peticion =arbol.getAsJsonObject();
            String u= ""+peticion.get("Username");
            System.out.println(u);
            return DAO.getNCuentos(u);
            }catch(Exception e){
                return e.getMessage();
            }
        });
        post("/AddCuento",(req,res)->{
            try{
            JsonParser parser = new JsonParser();
            JsonElement arbol = parser.parse(req.body());
            JsonObject peticion =arbol.getAsJsonObject();
            String n= ""+peticion.get("nombre");
            String u= ""+peticion.get("user");
            String c= ""+peticion.get("contenido");
            String g= ""+peticion.get("genero");
            System.out.println(u);
            return DAO.agregarCuento(n,u,c,g);
            }catch(Exception e){
                return e.getMessage();
            }
        });
        post("/UpdUser",(req,res)->{
            String r="";
            try{
            JsonParser parser = new JsonParser();
            JsonElement arbol = parser.parse(req.body());
            JsonObject peticion =arbol.getAsJsonObject();
            String id= ""+peticion.get("id");
            
            r=id;
            
            String n= ""+peticion.get("nombre");
            String e= ""+peticion.get("email");
            String i= ""+peticion.get("newid");
            String p= ""+peticion.get("pass");
            String x=""+(char)34+(char)34;
            System.out.println(x+ "   "+n);
            
            if(!x.equals(n)){
                
                DAO.updateUnombre(n, id);
            }
            if(!x.equals(e)){
                DAO.updateUemail(e, id);
            }
            if(!x.equals(i)){
                DAO.updateUid(i, id);
                r=i;
                id=i;
            }
            if(!x.equals(p)){
                DAO.updateUpass(p, id);
            }
        }catch(Exception e){
            return e.getMessage();
     }
       return r;
 });

        /*
        id: getCookie("Usuario"),
        nombre: NombreNuevo,
        email: EmailNuevo,
        newid: UsernameNuevo,
        pass: PasswordNuevo
        */

        post("/logg", (req, res) ->{
            try{
            JsonParser parser = new JsonParser();
            JsonElement arbol = parser.parse(req.body());
            JsonObject peticion =arbol.getAsJsonObject();
            String psw= ""+peticion.get("pass");
            String user= ""+peticion.get("usuario");
            System.out.println(user);
            if(validar(user, psw)){
                return ""+user+"";
            }
            return "";
            }catch(Exception e){
                   return e.getMessage();
            }
              
        });
        
        
}
public static boolean validar(String nombre, String pass){
    if(DAO.getvalidar(nombre, pass)){
        return true;
    };
    return false;
}
public static Map<String,Object> getCuentosUser(String nombre){
    Map<String, Object> map = new HashMap<>();
    //List<Cuento> cuentos = new ArrayList<Cuento>();
    map.put("Nombre", nombre);
    //cuentos.add(new Cuento("El dragón de Wawel",nombre));
    //cuentos.add(new Cuento("El Chake",nombre));
    //cuentos.add(new Cuento("El perro aterrado",nombre));
    //System.out.println(cuentos.get(1).getName());
     //map.put("Cuentos",cuentos);
     map.put("Cuentos",DAO.getCuentos(nombre));
    return map;
}
public static Map<String, String> getCuentoc(String user,String nombre){
    Map<String, String> map = new HashMap<>();
    Cuento cuento =DAO.getCuento(nombre, user);
    map.put("Nombre", nombre);
    map.put("Usuario", user);
    map.put("Contenido",cuento.getContent());
    return map;
}
}
