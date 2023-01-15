/*CÓDIGO JS PARA O INDEX.HTML*/ 
// const subtrair = document.querySelector("#diminuir")
// const somar = document.querySelector("#somar")
// const braco = document.querySelector("#braco")

// somar.addEventListener("click", ()=>{
//     braco.value = parseInt(braco.value)+1;
// })

// somar.addEventListener("click",()=> {manipulaDados("somar")})

// subtrair.addEventListener("click", ()=> {manipulaDados("subtrair")})

// manipula os dados a partir do parâmetro.



const controle = document.querySelectorAll("[data-controle]")

function manipulaDados(operacao, controle){
    const peca = controle.querySelector("[data-contador]")

    if(operacao==="-"){
        peca.value = parseInt(peca.value)-1;
    }else{
        peca.value = parseInt(peca.value)+1;
    }
} -


/*quero criar um evento para todos os elementos, braco, perna, nucleo. Usaremos array. 
   Todo for each retorna elemento e indice, respectivamente.*/ 


//Como funciona:
// controle.forEach((elemento, indice)=>{
//     console.log(elemento, indice)
// })

//Colocando eventos:
controle.forEach((elemento)=>{
    elemento.addEventListener("click",(evento)=>{

        console.log(evento.target.parentNode)
        // manipulaDados(evento.target.textContent, evento.target.parentNode)
        // target devolve onde aconteceu. 
        //textContent é quando é texto
        //value é quando é input

        /*agora eu vou buscar o atributo data*/ 
        manipulaDados(evento.target.dataset.controle, evento.target.parentNode)
        atualizaEstatisticas(evento.target.dataset.peca, evento.target.dataset.controle)
    })
})



const pecas = {
    "bracos": {
        "forca": 29,
        "poder": 35,
        "energia": -21,
        "velocidade": -5
    },

    "blindagem": {
        "forca": 41,
        "poder": 20,
        "energia": 0,
        "velocidade": -20
    },
    "nucleos":{
        "forca": 0,
        "poder": 7,
        "energia": 48,
        "velocidade": -24
    },
    "pernas":{
        "forca": 27,
        "poder": 21,
        "energia": -32,
        "velocidade": 42
    },
    "foguetes":{
        "forca": 0,
        "poder": 28,
        "energia": 0,
        "velocidade": -2
    }
}

/*Chave Valor. dentro da chave temos o valor, usamos referencias.
Navegação: 

pecas.pernas.energia : devolve o valor da energia das pernas da peça.
OU
pecas["bracos"]*/ 

const estatisticas = document.querySelectorAll("[data-estatistica]")


function atualizaEstatisticas(peca, operacao){
    
    estatisticas.forEach( (elemento) => {
        console.log(pecas[peca][elemento.dataset.estatistica])
        if(operacao=== "+"){
            elemento.textContent = parseInt(elemento.textContent) + pecas[peca][elemento.dataset.estatistica]
        }else{
            elemento.textContent = parseInt(elemento.textContent) - pecas[peca][elemento.dataset.estatistica]
        }

        }   
    )
}

const botao = document.querySelectorAll("[data-botao]")

botao.forEach((elemento)=>{
    elemento.addEventListener("click",(evento)=>{
        alterarCores(evento.target.dataset.botao)

    })
})


function alterarCores(corClicada){
    document.querySelector("[data-imagem]").src = "img/robotron" + corClicada + ".png";
}