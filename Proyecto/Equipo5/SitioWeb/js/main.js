
var bLogeo = document.getElementById("logSI");
var bRegistro = document.getElementById("regSU");
//
axios.post("http://192.168.100.158:2021/logg",{
    usuario : document.getElementById("NusuarioSI").value,
    pass : document.getElementById("PasswordSI").value
    })
    .then(function(response) {
        var respuesta =response.data;
        
            document.getElementById("User").innerHTML = response.data;
        
        
    })
    .catch(function(error) {
        console.log(error)
    }); 

//
bLogeo.addEventListener('click',function(){
    console.log(document.getElementById("NusuarioSI").value);
    axios.post("http://192.168.100.158:2021/logg",{
    usuario : document.getElementById("NusuarioSI").value,
    pass : document.getElementById("PasswordSI").value
    })
    .then(function(response) {   
        document.getElementById("User").innerHTML = response.data;
    })
    .catch(function(error) {
        console.log(error)
    });  
     
    });
//
bRegistro.addEventListener('click',function(){
    axios.post("http://192.168.100.158:2021/singUp",{
    nombre: document.getElementById("inputNuserSUP").value,
    email: document.getElementById("inputemailSUP").value,
    id: document.getElementById("inputIDSUP").value,
    pass: document.getElementById("inputpassSUP").value
    })
    .then(function(response) {
        document.getElementById("User").innerHTML = response.data;
    })
    .catch(function(error) {
        console.log(error)
    });  
     
    });          

    
