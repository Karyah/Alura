import "./CampoTexto.css"

const CampoTexto = (props)=>{
    // console.log(props)

    const aoDigitado = (evento)=>{
        props.aoAlterado(evento.target.value)
    };

    return (
        <div className="campo-texto">
            <label>{props.label}</label>
            <input value={props.valor} onChange={aoDigitado} required={props.obrigatorio} type="text" placeholder={props.placeholder}/>
        </div>
    )
}

export default CampoTexto; 