import "./Formulario.css"
import Campo from "../Campo"
import ListaSuspensa from "../ListaSuspensa"
import Botao from "../Botao"
import {useState} from 'react'

export const Formulario = (props)=>{  

    const [nome, setNome] = useState('');

    const [cargo, setCargo] = useState('');

    const [imagem, setImagem] = useState('');

    const [time, setTime] = useState('');

    const [nomeTime, setNomeTime] = useState('');

    const [corTime, setCorTime] =useState('');

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

                <Campo 
                    valor={nome} 
                    obrigatorio={true}
                    label='Nome' 
                    placeholder='Digite seu nome'
                    aoAlterado={valor => setNome(valor)}
                />
                <Campo
                    valor={cargo}
                    obrigatorio={true}
                    label='Cargo'
                    placeholder='Digite seu cargo'
                    aoAlterado={valor=>setCargo(valor)}
                />
                <Campo 
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

         
            <form onSubmit={(evento)=>{
                evento.preventDefault();
                props.cadastrarTime({ nome: nomeTime, cor: corTime})

                setCorTime('');
                setNomeTime('');
            }}>

                
                <h2>Preencha os dados para criar um novo time</h2>
                <Campo
                    valor={nomeTime} 
                    obrigatorio
                    label='Time' 
                    placeholder='Digite o nome do seu time'
                    aoAlterado={valor => setNomeTime(valor)}
                />

                <Campo
                    valor={corTime}
                    obrigatorio
                    type='color'
                    label='Cor do Time'
                    placeholder='Digite a cor do time'
                    aoAlterado={valor=>setCorTime(valor)}
                />
                <Botao>Crie um novo time</Botao>
            </form>
                
        </section>
    )
}