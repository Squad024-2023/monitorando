const login = document.querySelector(".login");
const cadastro = document.querySelector(".cadastro");
const form = document.querySelector("#form");
const switchs = document.querySelectorAll(".switch");

let current = 1;

function tab2() {
  form.style.marginLeft = "-100%";
  login.style.background = "none";
  login.style.color = "#4d004d";
  cadastro.style.background = "#e602e6";
  cadastro.style.color = "#ffffff";
  switchs[current - 1].classList.add("active");
}

function tab1() {
  form.style.marginLeft = "0";
  cadastro.style.background = "none";
  cadastro.style.color = "#4d004d";
  login.style.background = "#48c902";
  login.style.color = "#ffffff";
  switchs[current - 1].classList.remove("active");
}
