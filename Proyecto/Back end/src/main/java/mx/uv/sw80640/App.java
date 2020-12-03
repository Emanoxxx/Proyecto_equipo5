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
        get("/UserPage", (rq, rs) -> new ModelAndView(getNombre(""+rq.queryParams("U")), "UserPage"), new JadeTemplateEngine());
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
            System.out.println("Regresando "+usuario.getId());
            return usuario.getId();
        });
        post("/NCuentos",(req,res)->{
            JsonParser parser = new JsonParser();
            JsonElement arbol = parser.parse(req.body());
            JsonObject peticion =arbol.getAsJsonObject();
            String u= ""+peticion.get("Username");
            return DAO.getNCuentos(u);
        });
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
public static Map<String,String> getNombre(String nombre){
    Map<String, String> map = new HashMap<>();
    map.put("Nombre", nombre);
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
