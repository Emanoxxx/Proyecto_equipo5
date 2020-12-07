
var bLogeo = document.getElementById("logSI");
var bRegistro = document.getElementById("regSU");
var cuser =document.getElementById("cerrarU");
var euser =document.getElementById("editar");
///
/*
<a class="apagado" id="cerrarU" href="#">Cerrar Sesion</a>
<a class="apagado" id="editar" href="#">Editar perfil</a>
*/
    var blogin= document.getElementById('acceso');
    var breg= document.getElementById('registro');
    var aUser= document.getElementById('User');
    aUser.innerHTML=getCookie('Usuario');
    var n = getCookie('Usuario');
    if(n!="" & getCookie("Grant")!="Denegado"){
        if(true){
            //console.log(aUser.innerHTML);
            blogin.classList.add("apagado");
            breg.classList.add("apagado");
            aUser.classList.remove("apagado");
            cuser.classList.remove("apagado");
            euser.classList.remove("apagado");
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
        euser.classList.add("apagado");

    }
//
bLogeo.addEventListener('click',function(){
    setCookie("Usuario",document.getElementById("NusuarioSI").value ,0);
    setCookie("Pass",document.getElementById("PasswordSI").value ,0);
    console.log("nombre= " +document.getElementById("NusuarioSI").value);
    console.log("Cokie= " +getCookie("Usuario"));
    axios.post("https://proyectobiblioteca16.herokuapp.com/logg",{
    usuario : getCookie("Usuario"),
    pass : getCookie("Pass")
    })
    .then(function(response) {   
        if(response.data!=""){
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
        euser.classList.add("apagado");
        }
    })
    .catch(function(error) {
        console.log(error)
    });  
     
    });
//
bRegistro.addEventListener('click',function(){
    setCookie("Usuario",document.getElementById("inputIDSUP").value ,0);
    setCookie("Pass",document.getElementById("inputpassSUP").value ,0);
    axios.post("https://proyectobiblioteca16.herokuapp.com/singUp",{
    nombre: document.getElementById("inputNuserSUP").value,
    email: document.getElementById("inputemailSUP").value,
    id: document.getElementById("inputIDSUP").value,
    pass: document.getElementById("inputpassSUP").value
    })
    .then(function(response) {
        if("Usuario Creado"==response.data){
            document.getElementById('Usuario').innerHTML = getCookie("Usuario");
        }else{
            setCookie("Grant","Denegado",0);
            delCookie("Usuario");
            delCookie("Pass");
            blogin.classList.remove("apagado");
            breg.classList.remove("apagado");
            aUser.classList.add("apagado");
            cuser.classList.add("apagado");
            euser.classList.add("apagado");
        }
        
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
    euser.classList.add("apagado");
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
    
