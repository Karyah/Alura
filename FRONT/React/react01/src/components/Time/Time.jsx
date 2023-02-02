import './Time.css'
import Cards from '../Cards'
import hexToRgba from 'hex-to-rgba';

export const Time = (props)=>{

    const css ={
        backgroundColor: hexToRgba(props.cor, 0.6),
        backgroundImage: 'url(/img/fundo.png)'
    }
     
    return(
        <section className="time" style={css}>
            <h3 style={{borderColor: props.cor}}>{props.nome}</h3>
            {/* /*o target devolve o elemento que chamou o evento. se eu mudei o input por exemplo, o target devolve o input alterado.*/}
            <input onChange={evento => props.mudarCor(evento.target.value, props.id)} value={props.cor} type="color" className='input-cor'/>
            <div className='colaboradores'>
                {props.colaboradores.map(colaborador => {
                    return(
                        <Cards 
                            corDeFundo={props.cor}
                            colaborador={colaborador}
                            key={colaborador.nome}
                            nome={colaborador.nome} 
                            cargo={colaborador.cargo}
                            imagem={colaborador.imagem}
                            aoDeletar = {props.aoDeletar}
                            aoFavoritar = {props.aoFavoritar}
                        />
                    )      
                })}
            </div>           
        </section>
    )
}