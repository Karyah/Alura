package med.voll.apiAlura.model.consulta.validacoes.cancelamento;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import med.voll.apiAlura.model.consulta.ConsultaRepository;
import med.voll.apiAlura.model.consulta.DadosCancelamentoConsulta;
import med.voll.apiAlura.model.consulta.ValidacaoException;

@Component
public class ValidaHorarioAntecedencia implements ValidadorCancelamentoDeConsulta{

	@Autowired
	public ConsultaRepository repository;
	
	@Override
	public void validar(DadosCancelamentoConsulta dados) {
		var consulta = repository.getReferenceById(dados.idConsulta());
		var agora = LocalDateTime.now();
		var diferencaEmHoras = Duration.between(agora, consulta.getData()).toHours();
		
		if (diferencaEmHoras < 24 ){ 
			throw new ValidacaoException("A consulta deve ser cancelada com antecedencia mínima de 24 horas!");
		}
	}

}
