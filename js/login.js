const login = document.querySelector(".login");
const cadastro = document.querySelector(".cadastro");
const form = document.querySelector("#form");
const switchs = document.querySelectorAll(".switch");

let current = 1;

function tab2(){
	form.style.marginLeft = "-100%";
	login.style.background = "none";
	cadastro.style.background = "lightgrey";
	switchs[current - 1].classList.add("active");
}

function tab1(){
	form.style.marginLeft = "0";
	cadastro.style.background = "none";
	login.style.background = "lightgrey";
		switchs[current - 1].classList.remove("active");
}