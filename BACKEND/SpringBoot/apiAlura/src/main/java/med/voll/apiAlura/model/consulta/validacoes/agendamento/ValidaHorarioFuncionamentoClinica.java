package med.voll.apiAlura.model.consulta.validacoes.agendamento;

import java.time.DayOfWeek;
import org.springframework.stereotype.Component;
import med.voll.apiAlura.model.consulta.DadosAgendamentoConsulta;
import med.voll.apiAlura.model.consulta.ValidacaoException;

@Component
public class ValidaHorarioFuncionamentoClinica  implements ValidadorAgendamentoDeConsulta{

	public void validar(DadosAgendamentoConsulta dados) {
		var dataConsulta =dados.data();	
		
		var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
		var antesDaAberturaDaClinica = dataConsulta.getHour() < 7; 
		var depoisDoEncerramentoDaClinica = dataConsulta.getHour() > 18;
		
		if (domingo || antesDaAberturaDaClinica || depoisDoEncerramentoDaClinica) {
			throw new ValidacaoException("Consulta fora do horário de funcionamento da clínica");
		}
		
	}
}
