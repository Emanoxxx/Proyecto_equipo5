var a1= document.getElementById("v1");
var a2= document.getElementById("v2");
var a3= document.getElementById("v3");

let animado= document.querySelectorAll(".animado");
function mostrarScroll(){
    let scrollTop = document.documentElement.scrollTop;
    for (var i=0; i< animado.length; i++){
        let alturaAn= animado[i].offsetTop;
        if(alturaAn-500 <scrollTop){
            animado[i].style.opacity=1;
            if((animado[i].id+"A")==(a1.id)){
                a1.classList.add("active");
                a2.classList.remove("active");
                a3.classList.remove("active");
            }else{
                if((animado[i].id+"A")==(a2.id)){
                    a1.classList.remove("active");
                    a2.classList.add("active");
                    a3.classList.remove("active");
                }else{
                    if((animado[i].id+"A")==(a3.id)){
                        a1.classList.remove("active");
                        a2.classList.remove("active");
                        a3.classList.add("active");
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