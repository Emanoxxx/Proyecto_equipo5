
var bLogeo = document.getElementById("logSI");
var bRegistro = document.getElementById("regSU");
var cuser =document.getElementById("cerrarU");
var numeroCuentos =document.getElementById("NCuentos");
///
/*
<a class="apagado" id="cerrarU" href="#">Cerrar Sesion</a>paginavista
<a class="apagado" id="editar" href="#">Editar perfil</a>
*/
    var pvista =document.getElementById("paginavista");
    var blogin= document.getElementById('acceso');
    var breg= document.getElementById('registro');
    var aUser= document.getElementById('User');
    aUser.innerHTML=getCookie('Usuario');
    var n = getCookie('Usuario');
    pvista.href="http://localhost:2022/UserPage?U="+getCookie('Usuario');
    axios.post("http://192.168.100.4:2022/NCuentos",{
    Username: getCookie('Usuario')
    })
    .then(function(response) {
        numeroCuentos.innerHTML = response.data;
    })
    .catch(function(error) {
        console.log(error)
    }); 
    if(n!="" & getCookie("Grant")!="Denegado"){
        if(true){
            //console.log(aUser.innerHTML);
            blogin.classList.add("apagado");
            breg.classList.add("apagado");
            aUser.classList.remove("apagado");
            cuser.classList.remove("apagado");
            aUser.href=aUser.href + aUser.innerHTML;
        }
    
    }else{
        delCookie("Usuario");
        delCookie("Pass");
        delCookie("Grant");
        blogin.classList.remove("apagado");
        breg.classList.remove("apagado");
        aUser.classList.add("apagado");
        cuser.classList.add("apagado");


    }
//
var CuentoNombre = document.getElementById('nombreCuento').value;
var CuentoGenero = document.getElementById('EleccionGenero').value;
var CuentoContenido = document.getElementById('contenidoCuento').value;
var addCuento= document.getElementById('addCuento');
addCuento.addEventListener('click',function(){
    axios.post("http://192.168.100.4:2022/AddCuento",{
    nombre : CuentoNombre, 
    user: getCookie("Usuario"),
    contenido: document.getElementById('contenidoCuento').value,
    genero: document.getElementById('EleccionGenero').value
    })
    .then(function(response) {   
        
    })
    .catch(function(error) {
        console.log(error)
    });  
     
    });
//
bLogeo.addEventListener('click',function(){
    setCookie("Usuario",document.getElementById("NusuarioSI").value ,0);
    setCookie("Pass",document.getElementById("PasswordSI").value ,0);
    console.log("nombre= " +document.getElementById("NusuarioSI").value);
    console.log("Cokie= " +getCookie("Usuario"));
    axios.post("http://192.168.100.4:2022/logg",{
    usuario : getCookie("Usuario"),
    pass : getCookie("Pass")
    })
    .then(function(response) {   
        if(response.data!=""){
            blogin.classList.add("apagado");
            breg.classList.add("apagado");
            aUser.classList.remove("apagado");
            cuser.classList.remove("apagado");
            setCookie("Grant","Acceso",0);
            aUser.classList.remove("apagado");
        }else{
            setCookie("Grant","Denegado",0);
        delCookie("Usuario");
        delCookie("Pass");
        delCookie("Grant");
        blogin.classList.remove("apagado");
        breg.classList.remove("apagado");
        aUser.classList.add("apagado");
        cuser.classList.add("apagado");

        }
    })
    .catch(function(error) {
        console.log(error)
    });  
     
    });
//
//

bRegistro.addEventListener('click',function(){
    setCookie("Usuario",document.getElementById("inputIDSUP").value ,0);
    setCookie("Pass",document.getElementById("inputpassSUP").value ,0);
    axios.post("http://192.168.100.4:2022/singUp",{
    nombre: document.getElementById("inputNuserSUP").value,
    email: document.getElementById("inputemailSUP").value,
    id: document.getElementById("inputIDSUP").value,
    pass: document.getElementById("inputpassSUP").value
    })
    .then(function(response) {
        document.getElementById(getCookie("Usuario")).innerHTML = response.data;
    })
    .catch(function(error) {
        console.log(error)
    });  
     
    });    
cuser.addEventListener('click',function(){  
    delCookie("Usuario");
    delCookie("Pass");
    delCookie("Grant");
    blogin.classList.remove("apagado");
    breg.classList.remove("apagado");
    aUser.classList.add("apagado");
    cuser.classList.add("apagado");
});   
function delCookie(nombre){
    valor="";
    expiracion="";
    var d = new Date();
    d.setTime(d.getTime()+expiracion*24*60*60*1000);
    var expira = "expieres="+d.toUTCString();
    document.cookie = nombre+ "=" + valor +";" + expira +";path=/";
}      
function setCookie(nombre, valor, expiracion){
    var d = new Date();
    d.setTime(d.getTime()+expiracion*24*60*60*1000);
    var expira = "expieres="+d.toUTCString();
    document.cookie = nombre+ "=" + valor +";" + expira +";path=/";
}
function getCookie(nombre){
    var nom= nombre +"=";
    var array = document.cookie.split(";");
    for(var i=0; i<array.length; i++){
        var c = array[i];
        while (c.charAt(0)==" "){
            c= c.substring(1);
        }
        if(c.indexOf(nombre)==0){
            return c.substring(nombre.length + 1, c.length);
        }
    }
    return  "";
}
    
