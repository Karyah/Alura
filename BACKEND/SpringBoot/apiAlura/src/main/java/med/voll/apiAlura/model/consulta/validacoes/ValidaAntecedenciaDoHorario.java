package med.voll.apiAlura.model.consulta.validacoes;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import med.voll.apiAlura.model.consulta.DadosAgendamentoConsulta;
import med.voll.apiAlura.model.consulta.ValidacaoException;

@Component
public class ValidaAntecedenciaDoHorario implements ValidadorAgendamentoDeConsulta{

	public void validar(DadosAgendamentoConsulta dados) {
		var agora = LocalDateTime.now();
		var horarioConsulta = dados.data();
		var diferencaEmMinutos = Duration.between(agora, horarioConsulta).toMinutes();
		
		if (diferencaEmMinutos < 30 ) {
			throw new ValidacaoException("A consulta deve ser agendada com antecedencia mínima de 30 minutos");
		}
	}
}
