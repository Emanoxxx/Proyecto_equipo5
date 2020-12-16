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
console.log(parametroURL("N"));
console.log(getCookie("Usuario"));
document.getElementById("nombreCuento").value = parametroURL("N");
axios.post("https://proyectobiblioteca16.herokuapp.com/getContenido",{
    nombre: parametroURL("N")+"",
    Usuario: getCookie("Usuario")+"",
    })
    .then(function(response) {
        document.getElementById("contenidoCuento").value= response.data;
    })
    .catch(function(error) {
        console.log(error)
    });
axios.post("https://proyectobiblioteca16.herokuapp.com/getGenero",{
        nombre: parametroURL("N"),
        Usuario: getCookie("Usuario"),
        })
        .then(function(response) {
            document.getElementById("EleccionGenero").value= response.data;
        })
        .catch(function(error) {
            console.log(error)
        });
function parametroURL(_par) {
    var _p = null;
    if (location.search) location.search.substr(1).split("&").forEach(function(pllv) {
      var s = pllv.split("="), 
        ll = s[0],
        v = s[1] && decodeURIComponent(s[1]); 
      if (ll == _par) { 
        if(_p==null){
        _p=v; 
        }else if(Array.isArray(_p)){
        _p.push(v); 
        }else{
        _p=[_p,v]; 
        }
      }
    });
    return _p;
  }
  var borrar=document.getElementById("DeleteCuento");
  borrar.addEventListener('click',function(){
    axios.post("https://proyectobiblioteca16.herokuapp.com/delCuento",{
        nombre: parametroURL("N"),
        user: getCookie("Usuario")
        })
        .then(function(response) {
            if(response.data!="NO"){
                alert("Cuento borrado"); 
            }else{
                alert("Cuento no borrado"); 
            }
        })
        .catch(function(error) {
            console.log(error)
        });  
    
}); 
  var actualizar=document.getElementById("ActualizarCuento");
  actualizar.addEventListener('click',function(){  
    axios.post("https://proyectobiblioteca16.herokuapp.com/UpdCuento",{
        nombre: parametroURL("N"),
        user: getCookie("Usuario"),
        contenido:document.getElementById("contenidoCuento").value,
        genero:document.getElementById("EleccionGenero").value
        })
        .then(function(response) {
            if(response.data!="NO"){
                alert("Cuento actualizado"); 
            }else{
                alert("Cuento no actualizado"); 
            }
        })
        .catch(function(error) {
            console.log(error)
        }); 
}); 