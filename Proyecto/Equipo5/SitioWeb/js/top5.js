var cuentosTop;
axios.post("https://proyectobiblioteca16.herokuapp.com/top5")
    .then(function(response) { 
        cuentosTop=response.data;
        alert(cuentosTop.get(0).nombre);

    })
    .catch(function(error) {
        console.log(error)
    });  