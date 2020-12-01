
var bLogeo = document.getElementById("logSI");
var bRegistro = document.getElementById("regSU");
///
/*
axios.post("http://192.168.100.4:2022/logg",{
    usuario : getCookie("nombre"),
    pass : getCookie("Pass")
    })
    .then(function(response) {
        if(false){
        var blogin= document.getElementById('acceso');
        var aUser= document.getElementById('User');
        var breg= document.getElementById('registro');
        blogin.classList.add("apagado");
        breg.classList.add("apagado");
        aUser.classList.remove("apagado");
        }
        console.log("LLegando a refresfo");
        var respuesta =response.data;
            
            document.getElementById("User").innerHTML = response.data;
        
        
    })
    .catch(function(error) {
        console.log(error)
    }); */
    var blogin= document.getElementById('acceso');
    var breg= document.getElementById('registro');
    var aUser= document.getElementById('User');
    aUser.innerHTML=getCookie('Usuario');
    var n = getCookie('Usuario');
    if(n!=""){
        if(true){
            //console.log(aUser.innerHTML);
            blogin.classList.add("apagado");
            breg.classList.add("apagado");
            aUser.classList.remove("apagado");
            aUser.href=aUser.href + aUser.innerHTML;
        }
    
    }
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
        document.getElementById(getCookie("Usuario")).innerHTML = response.data;
    })
    .catch(function(error) {
        console.log(error)
    });  
     
    });
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
    
