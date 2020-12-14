var Inicio= document.getElementById("InicioA");
var Mas_vistos= document.getElementById("Mas vistosA");
var Contacto= document.getElementById("ContactoA");
var Acerca= document.getElementById("Acerca deA");

let animado= document.querySelectorAll(".animado");
function mostrarScroll(){
    let scrollTop = document.documentElement.scrollTop;
    for (var i=0; i< animado.length; i++){
        let alturaAn= animado[i].offsetTop;
        if(alturaAn-500 <scrollTop){
            animado[i].style.opacity=1;
            if((animado[i].id+"A")==(Inicio.id)){
                Inicio.classList.add("active");
                Mas_vistos.classList.remove("active");
                Contacto.classList.remove("active");
                Acerca.classList.remove("active");
            }else{
                if((animado[i].id+"A")==(Mas_vistos.id)){
                    Inicio.classList.remove("active");
                    Mas_vistos.classList.add("active");
                    Contacto.classList.remove("active");
                    Acerca.classList.remove("active");
                }else{
                    if((animado[i].id+"A")==(Contacto.id)){
                        Inicio.classList.remove("active");
                        Mas_vistos.classList.remove("active");
                        Contacto.classList.add("active");
                        Acerca.classList.remove("active");
                    }else{
                        if((animado[i].id+"A")==(Acerca.id)){
                            Inicio.classList.remove("active");
                            Mas_vistos.classList.remove("active");
                            Contacto.classList.remove("active");
                            Acerca.classList.add("active");
                        }
                    } 
                }  
            }
            animado[i].classList.add("mostrarArriba");
            animado[i].classList.remove("mostrarAbajo");
            if(i!=0){
                animado[i-1].style.opacity=0;
                animado[i-1].classList.add("mostrarArriba");
                animado[i-1].classList.remove("mostrarAbajo");
            }
        }
    }
    for (var i=0; i< animado.length; i++){
        let alturaAn= animado[i].offsetTop;
        if(alturaAn-500 >scrollTop){
            animado[i].style.opacity=0;
            animado[i].classList.remove("mostrarArriba");
            animado[i].classList.add("mostrarAbajo");
            
        }
    }
    console.log("lo hice");
}
window.addEventListener('scroll',mostrarScroll);