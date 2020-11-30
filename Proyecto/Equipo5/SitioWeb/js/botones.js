var Inicio= document.getElementById("InicioA");
var Mas_vistos= document.getElementById("Mas vistosA");
var Contacto= document.getElementById("ContactoA");
var Acerca= document.getElementById("Acerca deA");

var bLogeo = document.getElementById("logSI");
var bRegistro = document.getElementById("regSU");
    var blogin= document.getElementById('acceso');
    var aUser= document.getElementById('User');
    var breg= document.getElementById('registro');


Inicio.addEventListener('click',function(){
    Inicio.classList.add("active");
    Mas_vistos.classList.remove("active");
    Contacto.classList.remove("active");
    Acerca.classList.remove("active");
});
Mas_vistos.addEventListener('click',function(){
    Inicio.classList.remove("active");
    Mas_vistos.classList.add("active");
    Contacto.classList.remove("active");
    Acerca.classList.remove("active");
});
Contacto.addEventListener('click',function(){
    Inicio.classList.remove("active");
    Mas_vistos.classList.remove("active");
    Contacto.classList.add("active");
    Acerca.classList.remove("active");
});
Acerca.addEventListener('click',function(){
    Inicio.classList.remove("active");
    Mas_vistos.classList.remove("active");
    Contacto.classList.remove("active");
    Acerca.classList.add("active");
});

bLogeo.addEventListener('click',function(){
    var n = document.getElementById("NusuarioSI").value;
    if(n!=""){
        if(true){
            //console.log(aUser.innerHTML);
            blogin.classList.add("apagado");
            breg.classList.add("apagado");
            aUser.classList.remove("apagado");
            aUser.href=aUser.href + aUser.innerHTML;
        }
    
    }
});
bRegistro.addEventListener('click',function(){
    blogin.classList.add("apagado");
    breg.classList.add("apagado");
    aUser.classList.remove("apagado");
    aUser.href=aUser.href + aUser.innerHTML;
});
    
