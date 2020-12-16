var cuentosTop;
var cuentos=new Array();
var cuento=new Array();
axios.post("https://proyectobiblioteca16.herokuapp.com/top5")
    .then(function(response) { 
        cuentosTop=response.data;
        var i=0;
        var escribiendo=0;
        var actual="";
        var nombre="";
        var usuario="";
        var j=0;
        while(i<5){
            while(cuentosTop[j]!=")"){
                if(escribiendo!=0){
                    actual=actual+cuentosTop[j]
                }
                if(cuentosTop[j]=="("){
                    escribiendo=1;
                }
                j++;
            }
            j++;
            nombre=actual;
            escribiendo=0;
            actual="";
            while(cuentosTop[j]!=")"){
                if(escribiendo!=0){
                    actual=actual+cuentosTop[j]
                }
                if(cuentosTop[j]=="("){
                    escribiendo=1;
                }
                j++;
            }
            j++;
            usuario=actual;
            cuento=[nombre,usuario];
            escribiendo=0;
            actual="";
            cuentos.push(cuento);
            i++;
        }
        var i=0;
        while(i<5){
            nombre=cuentos[i][0];
            var usuario=cuentos[i][1];
            document.getElementById("Titulo"+(i+1)).innerHTML=nombre;
            document.getElementById("Autor"+(i+1)).innerHTML=usuario;
            document.getElementById("Leer"+(i+1)).href="https://proyectobiblioteca16.herokuapp.com/ReadPage?U="+usuario+"&N="+nombre;
            
            i++;
        }
        

    })
    .catch(function(error) {
        console.log(error)
    }); 
    

    