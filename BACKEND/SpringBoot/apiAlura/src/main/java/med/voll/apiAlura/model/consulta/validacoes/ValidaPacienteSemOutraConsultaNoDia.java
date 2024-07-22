package med.voll.apiAlura.model.consulta.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import med.voll.apiAlura.model.consulta.ConsultaRepository;
import med.voll.apiAlura.model.consulta.DadosAgendamentoConsulta;
import med.voll.apiAlura.model.consulta.ValidacaoException;

@Component
public class ValidaPacienteSemOutraConsultaNoDia  implements ValidadorAgendamentoDeConsulta{

	@Autowired
	private ConsultaRepository repository;
	
	public void validar(DadosAgendamentoConsulta dados) {
		var primeiroHorario = dados.data().withHour(7);
		var ultimoHorario = dados.data().withHour(18);
		
		var pacientePossuiOutraConsultaNoDia = repository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);
		
		if(pacientePossuiOutraConsultaNoDia) {
			throw new ValidacaoException("Paciente já posssui uma consulta nesse dia");
		}
	}
}
