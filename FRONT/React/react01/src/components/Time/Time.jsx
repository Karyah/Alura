import './Time.css'
import Cards from '../Cards'

export const Time = (props)=>{

    const css ={
        backgroundColor: props.corSecundaria
    }
     
    return(
        /*se for true ele retorna o que vem apos o &&, se for false, não retorna.*/ 
        // (props.colaboradores.lenght > 0) ?  
        
        <section className="time" style={css}>
            <h3 style={{borderColor: props.corPrimaria}}>{props.nome}</h3>
            <div className='colaboradores'>
                {props.colaboradores.map(colaborador => <Cards 
                corDeFundo={props.corPrimaria}
                key={colaborador.nome}
                nome={colaborador.nome} 
                cargo={colaborador.cargo}
                imagem={colaborador.imagem}
                />)}
            </div>
            
        </section>
        // :''
    )
}