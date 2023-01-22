import { useState } from 'react';
import Banner from './components/Banner'
import Formulario from './components/Formulario';
import Time from './components/Time'
import Rodape from './components/Rodape';

function App() {

  const times = [
    {nome:'Programação',
      cor1:'#57C278',
      cor2:'#D9F7E9'},

    {nome:'Front-End',
      cor1:'#82CFFA',
      cor2:'#E8F8FF'},

    {nome:'Data-Science',
      cor1:'#A6D157',
      cor2:'#F0F8E2'},

      
    {nome:'DevOps',
    cor1:'#E06B69',
    cor2:'#FDE7E8'},

    {nome:'UX e Design',
    cor1:'#DB6EBF',
    cor2:'#FAE9F5'},

    {nome:'Mobile',
    cor1:'#FFBA05',
    cor2:'#FFF5D9'},

    {nome:'Inovação e Gestão',
    cor1:'#FF8A29',
    cor2:'#FFEEDF'}
  ]
  
  const [colaboradores, setColaboradores] = useState([])

  const aoNovoColaboradorAdicionado= (colaborador) =>{
    // console.log(colaborador)
    setColaboradores([...colaboradores, colaborador])
    // console.log(colaboradores)
  }

  /*toda vez que um colaborador for cadastrado, eu quero adicioná-lo à lista.*/ 

  return (
    <>
      <Banner/>
      <Formulario times={times.map(time => time.nome)} aoColaboradorCadastrado={colaborador => aoNovoColaboradorAdicionado(colaborador)}/>
      {times.map(time => <Time 
      key={time.nome} 
      nome={time.nome} 
      corPrimaria={time.cor1} 
      corSecundaria={time.cor2} 
      colaboradores = {colaboradores.filter(colaborador => colaborador.time === time.nome)}/>)}
      <Rodape/>
     
    
    </>
    
  );
}

export default App;
