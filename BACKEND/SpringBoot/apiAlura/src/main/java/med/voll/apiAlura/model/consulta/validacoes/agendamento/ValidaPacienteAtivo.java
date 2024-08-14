package med.voll.apiAlura.model.consulta.validacoes.agendamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import med.voll.apiAlura.model.consulta.DadosAgendamentoConsulta;
import med.voll.apiAlura.model.consulta.ValidacaoException;
import med.voll.apiAlura.model.paciente.PacienteRepository;

@Component
public class ValidaPacienteAtivo  implements ValidadorAgendamentoDeConsulta{

	@Autowired
	private PacienteRepository repository;
	
	public void validar(DadosAgendamentoConsulta dados) {
		var pacienteEstaAtivo = repository.findAtivoById(dados.idPaciente());
		
		if (!pacienteEstaAtivo) {
			throw new ValidacaoException("Consulta não pode ser agendada com paciente excluído");
		}
	}
	
}
