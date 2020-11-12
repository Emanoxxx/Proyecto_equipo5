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
/**
 * Hello world!
 *
 */
public class App 
{
    private static Gson gson=new Gson();
    public static void main( String[] args )
    {   
        port(2021);
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
        before((req, res) -> res.type("application/json"));
        post("/singUp",(req,res)->{
            String query = req.body();
            System.out.println("1Peticion: "+query);
            Usuarios usuario=gson.fromJson(query,Usuarios.class);
            String x=DAO.addUsuario(usuario.getName() ,usuario.getId(),usuario.getEmail(),usuario.getPass());;
            System.out.println("ejecutan");
            return x+ usuario.getName();
        });
        
        post("/logg", (req, res) ->{
            try{
            JsonParser parser = new JsonParser();
            JsonElement arbol = parser.parse(req.body());
            JsonObject peticion =arbol.getAsJsonObject();
            String psw= ""+peticion.get("pass");
            String user= ""+peticion.get("usuario");
            return "Hola: "+user+"\n";
            }catch(Exception e){
                   return e.getMessage();
            }
              
        });
        
        
}}
