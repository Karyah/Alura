/*CÓDIGO JS PARA O EXERCICIO.HTML*/ 
const botao = document.querySelector("#Karen");
const  resultado = document.querySelector("#resultado")

botao.addEventListener("click",(evento)=>{
    resultado.innerHTML = "Fui Clicado."
})

// var lista = ["Laranja", "Vermelho", "Branco", "Amarelo", "Rosa"]; 

const lista = document.querySelector("[lista]")
const mostra = document.querySelector("[mostra]")
const esconde = document.querySelector("[esconde]")
const button = document.querySelector("[valor]")

button.addEventListener("click",()=>{
    let valor = button.getAttribute("valor") 
    if(valor==='0'){
        lista.style.display = 'none'
        valor = parseInt(valor)+1;
        console.log(valor)
    }else{
        lista.style.display = 'block'
        valor = parseInt(valor)-1
    }
})







esconde.addEventListener("click",()=>{
    
    lista.style.display = 'none'
})

mostra.addEventListener("click",()=>{
    lista.style.display = 'block'
})
