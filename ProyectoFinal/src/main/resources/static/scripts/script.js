function limitarDecimalesTotal() {
    let totalDecimal = document.getElementById("total").value.toFixed(2);
}

function validarAgregar(){
    if(document.forms.formAgregar.getElementById("pvp").value > document.forms.formAgregar.getElementById("pvp").value.toFixed(2)){
        alert("Formato incorrecto. Recuerda máxm¡imo 2 decimales.")
        document.forms.formAgregar.getElementById("pvp").value.focus()
        return 0;
    }else if(document.forms.formAgregar.getElementById("pvp").value == ""){
        alert("Indique un precio: ")
        document.forms.formAgregar.getElementById("pvp").value.focus()
        return 0;
    }

    let max = 100;

    if(document.forms.formAgregar.getElementById("unidades").value > max){
        alert("Talla inválida")
        document.forms.formAgregar.getElementById("unidades").value.focus()
        return 0;
    }

}


