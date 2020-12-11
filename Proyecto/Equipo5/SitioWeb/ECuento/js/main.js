var usuario=getCookie("Usuario");
var link="https://proyectobiblioteca16.herokuapp.com/UserPage?U=";
document.getElementById("User").innerHTML=getCookie("Usuario");
document.getElementById("User").href=link+usuario;
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