document.formAgregar.addEventListener("submit",validarform);

function validarform(){
    if(formAgregar.elements.pvp.value > formAgregar.elements.pvp.value.toFixed(2)){
        formAgregar.elements.pvp.style.borderColor = "#E22E11";
        formAgregar.elements.pvp.pvp.focus();
        return true;
    }else if(formAgregar.elements.pvp.value == ""){
        formAgregar.elements.pvp.style.borderColor = "#E22E11";
        formAgregar.elements.pvp.focus();   
        return false;
    }

    let max = 100;

    if(document.forms.formAgregar.getElementById("nombre").value > max){
        formAgregar.elements.pvp.style.borderColor = "#E22E11";
        formAgregar.elements.nombre.focus()
        return false;
    }

}


