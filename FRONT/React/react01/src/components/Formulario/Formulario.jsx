import "./Formulario.css"
import CampoTexto from "../CampoTexto"
import ListaSuspensa from "../ListaSuspensa"
import Botao from "../Botao"
import {useState} from 'react'

export const Formulario = (props)=>{  

    const [nome, setNome] = useState('');

    const [cargo, setCargo] = useState('');

    const [imagem, setImagem] = useState('');

    const [time, setTime] = useState('');

    const aoSalvar = (evento)=> {
        evento.preventDefault();
        console.log('Foi Submetido.', nome, cargo, imagem, time)
        props.aoColaboradorCadastrado({
            nome, cargo, imagem, time
        })
        setNome('')
        setCargo('')
        setImagem('')
        setTime('')  
    }

    return(
        <section className="formulario">
            <form onSubmit={aoSalvar}>
                <h2>Preencha os dados para criar o card do Colaborador</h2>
                <CampoTexto 
                    valor={nome} 
                    obrigatorio={true}
                    label='Nome' 
                    placeholder='Digite seu nome'
                    aoAlterado={valor => setNome(valor)}
                />
                <CampoTexto 
                    valor={cargo}
                    obrigatorio={true}
                    label='Cargo'
                    placeholder='Digite seu cargo'
                    aoAlterado={valor=>setCargo(valor)}
                />
                <CampoTexto 
                    valor={imagem}
                    label='Imagem' 
                    placeholder='Informe o endereço de sua imagem'
                    aoAlterado={valor=>setImagem(valor)}
                />
                <ListaSuspensa 
                    valor = {time}
                    obrigatorio={true} 
                    label="Times" 
                    itens={props.times}
                    aoAlterado={valor =>setTime(valor)}
                />
                    
              
                <Botao>Criar Card</Botao>
            </form>
        </section>
    )
}