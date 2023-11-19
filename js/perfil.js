const editar = document.getElementById('editar');
const modal_container = document.getElementById('modal_container');
const salvar = document.getElementById('salvar');
const fechar = document.getElementById('fechar');


const deletarp = document.getElementById('deletarp');
const modal_container2 = document.getElementById('modal_container2');
const voltar = document.getElementById('voltar');
const fechar2 = document.getElementById('fechar2');


editar.addEventListener('click', () =>{
    modal_container.classList.add('mostrar');
});

salvar.addEventListener('click', () =>{
    modal_container.classList.remove('mostrar');
});


deletarp.addEventListener('click', () =>{
    modal_container2.classList.add('mostrar');
});

voltar.addEventListener('click', () =>{
    modal_container2.classList.remove('mostrar');
});


fechar.addEventListener('click', () =>{
    modal_container.classList.remove('mostrar');
});
fechar2.addEventListener('click', () =>{
    modal_container2.classList.remove('mostrar');
});
