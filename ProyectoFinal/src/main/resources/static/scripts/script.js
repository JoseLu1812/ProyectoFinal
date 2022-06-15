//document.formAgregar.addEventListener("submit",validarform);


function validarform(){
    let precio = parseFloat(formAgregar.elements.pvp.value);

    let nom = formAgregar.elements.nombre.value;


    if(precio > precio.toFixed(2)){
        formAgregar.elements.pvp.classList.add('border');
        formAgregar.elements.pvp.classList.add('border-danger');
        formAgregar.elements.pvp.focus();
        return false;
    }else if(precio == "" || precio == 0.0){
        formAgregar.elements.pvp.classList.add('border');
        formAgregar.elements.pvp.classList.add('border-danger');
        formAgregar.elements.pvp.focus();   
        return false;
    }

    let max = 150;

    if(nom.length > max){
        formAgregar.elements.nombre.classList.add('border');
        formAgregar.elements.nombre.classList.add('border-danger');
        nom.focus();
        return false;
    }else if(nom == ""){
        formAgregar.elements.nombre.classList.add('border');
        formAgregar.elements.nombre.classList.add('border-danger');
        nom.focus()
        return false;
    }
}









