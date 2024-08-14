package med.voll.apiAlura.model.consulta.validacoes.agendamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import med.voll.apiAlura.model.consulta.DadosAgendamentoConsulta;
import med.voll.apiAlura.model.consulta.ValidacaoException;
import med.voll.apiAlura.model.medico.MedicoRepository;

@Component
public class ValidaMedicoAtivo  implements ValidadorAgendamentoDeConsulta{

	@Autowired
	private MedicoRepository repository;
	
	public void validar(DadosAgendamentoConsulta dados) {
		if(dados.idMedico() == null) {
			return;
		}
		
		var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());
		if(!medicoEstaAtivo) {
			throw new ValidacaoException("Consulta não pode ser agendada com ");
		}
	}
}
