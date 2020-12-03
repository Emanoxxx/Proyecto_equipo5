var a1= document.getElementById("v1A");
var a2= document.getElementById("v2A");
var a3= document.getElementById("v3A");

var bLogeo = document.getElementById("logSI");
var bRegistro = document.getElementById("regSU");
    var blogin= document.getElementById('acceso');
    var aUser= document.getElementById('User');
    var breg= document.getElementById('registro');
    var cuser =document.getElementById("cerrarU");
    var euser =document.getElementById("editar");

a1.addEventListener('click',function(){
    a1.classList.add("active");
    a2.classList.remove("active");
    a3.classList.remove("active");
});
a2.addEventListener('click',function(){
    a1.classList.remove("active");
    a2.classList.add("active");
    a3.classList.remove("active");
});
a3.addEventListener('click',function(){
    a1.classList.remove("active");
    a2.classList.remove("active");
    a3.classList.add("active");
});


bLogeo.addEventListener('click',function(){
    var n = document.getElementById("NusuarioSI").value;
    if(n!="" & getCookie("Grant")!="Denegado" ){
        if(getCookie("Grant")!="Denegado"){
            //console.log(aUser.innerHTML);
            blogin.classList.add("apagado");
            breg.classList.add("apagado");
            aUser.classList.remove("apagado");
            cuser.classList.remove("apagado");
            euser.classList.remove("apagado");
            aUser.href=aUser.href + aUser.innerHTML;
        }else{
            blogin.classList.remove("apagado");
        breg.classList.remove("apagado");
        aUser.classList.add("apagado");
        cuser.classList.add("apagado");
        euser.classList.add("apagado");
        }
    
    }
});
bRegistro.addEventListener('click',function(){
    var n = document.getElementById("inputIDSUP").value;
    if(n!="" & getCookie("Grant")!="Denegado"){
        if(getCookie("Grant")!="Denegado"){
            //console.log(aUser.innerHTML);
            blogin.classList.add("apagado");
            breg.classList.add("apagado");
            aUser.classList.remove("apagado");
            cuser.classList.remove("apagado");
            euser.classList.remove("apagado");
            aUser.href=aUser.href + aUser.innerHTML;
        }else{
        blogin.classList.remove("apagado");
        breg.classList.remove("apagado");
        aUser.classList.add("apagado");
        cuser.classList.add("apagado");
        euser.classList.add("apagado");
        }
    
    }
});
    
