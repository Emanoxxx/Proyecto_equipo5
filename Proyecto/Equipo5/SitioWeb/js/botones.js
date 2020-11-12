var Inicio= document.getElementById("InicioA");
var Novedades= document.getElementById("NovedadesA");
var Contacto= document.getElementById("ContactoA");
var Acerca= document.getElementById("Acerca deA");
Inicio.addEventListener('click',function(){
    Inicio.classList.add("active");
    Novedades.classList.remove("active");
    Contacto.classList.remove("active");
    Acerca.classList.remove("active");
});
Novedades.addEventListener('click',function(){
    Inicio.classList.remove("active");
    Novedades.classList.add("active");
    Contacto.classList.remove("active");
    Acerca.classList.remove("active");
});
Contacto.addEventListener('click',function(){
    Inicio.classList.remove("active");
    Novedades.classList.remove("active");
    Contacto.classList.add("active");
    Acerca.classList.remove("active");
});
Acerca.addEventListener('click',function(){
    Inicio.classList.remove("active");
    Novedades.classList.remove("active");
    Contacto.classList.remove("active");
    Acerca.classList.add("active");
});
