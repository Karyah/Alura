import { AiFillCloseCircle, AiOutlineHeart, AiFillHeart } from 'react-icons/ai';
import './Cards.css'

export const Cards = (props)=>{

    function favoritar(){
        props.aoFavoritar(props.colaborador.id)
    }

    const propsFavorito ={
        size: 25, 
        onClick: favoritar
    }

    return(
       <div className='colaborador'>
            <AiFillCloseCircle 
                size={25} 
                className='deletar' 
                onClick={()=>{ props.aoDeletar(props.colaborador.id)}}
            />
            <div  className='cabecalho' style={{backgroundColor:props.corDeFundo}}>
                <img src={props.imagem} alt={props.nome} />
            </div>

            <div className='rodape'>
                <div className='letras'>
                <h4>{props.nome}</h4>
                <h5>{props.cargo}</h5>

                <div className='favoritar'>
                    {props.colaborador.favorito 
                    ? <AiFillHeart {...propsFavorito} color='ff0000'/> 
                    : <AiOutlineHeart  {...propsFavorito}/>
                    }
                </div>
                </div>
             
            </div>
       </div>

    )
}