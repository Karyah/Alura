package med.voll.apiAlura.model.consulta.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import med.voll.apiAlura.model.consulta.ConsultaRepository;
import med.voll.apiAlura.model.consulta.DadosAgendamentoConsulta;
import med.voll.apiAlura.model.consulta.ValidacaoException;

@Component
public class ValidaMedicoComOutraConsultaNoMesmoHorario  implements ValidadorAgendamentoDeConsulta{

	@Autowired
	private ConsultaRepository repository;
	
	public void validar(DadosAgendamentoConsulta dados) {
		var medicoPossuiOutraConsultaNoMesmoHorario = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
		
		if (medicoPossuiOutraConsultaNoMesmoHorario) {
			throw new ValidacaoException("Este médico já possui outra consulta neste horário");
		}
	}
	
}
