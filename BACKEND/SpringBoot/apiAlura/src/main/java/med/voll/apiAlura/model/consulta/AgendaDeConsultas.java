package med.voll.apiAlura.model.consulta;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import med.voll.apiAlura.model.consulta.validacoes.agendamento.ValidadorAgendamentoDeConsulta;
import med.voll.apiAlura.model.consulta.validacoes.cancelamento.ValidadorCancelamentoDeConsulta;
import med.voll.apiAlura.model.medico.Medico;
import med.voll.apiAlura.model.medico.MedicoRepository;
import med.voll.apiAlura.model.paciente.PacienteRepository;

@Service
public class AgendaDeConsultas {
	
	@Autowired
	private ConsultaRepository repository;
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private List<ValidadorAgendamentoDeConsulta> validadores;
	
	@Autowired
	private List<ValidadorCancelamentoDeConsulta> validadoresCancelamento; 
	
	public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dados) {
		
		if(!pacienteRepository.existsById(dados.idPaciente())) {
			throw new ValidacaoException("Id do paciente informado não existe");
		}
		
		if(dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())) {
			throw new ValidacaoException("Id do médico informado não existe");
		}
		
		validadores.forEach(v -> v.validar(dados));
		
		var paciente = pacienteRepository.findById(dados.idPaciente()).get();
		var medico = escolherMedico(dados);
		
		if (medico ==null){
			throw new ValidacaoException("Não existe médico disponivel nesta especialidade nessa data");
		}
		
		var consulta = new Consulta(null, medico, paciente, dados.data(), null);
		repository.save(consulta);
		return new DadosDetalhamentoConsulta(consulta);
	}
	
	public void cancelar(DadosCancelamentoConsulta dados) {
		if (!repository.existsById(dados.idConsulta())) {
			throw new ValidacaoException("Essa consulta não existe");
		}
		
		if(dados.motivoCancelamento() == null) {
			throw new ValidacaoException("A consulta não pode ser cancelada sem um motivo.");
		}
		
		validadoresCancelamento.forEach(v -> v.validar(dados));
		
		var consulta = repository.getReferenceById(dados.idConsulta());
		/*repository.delete(consulta);*/
		consulta.cancelar(dados.motivoCancelamento());
	
	}
	
	
	public Medico escolherMedico(DadosAgendamentoConsulta dados) {
		if(dados.idMedico() != null) {
			return medicoRepository.getReferenceById(dados.idMedico());
		}
		
		if(dados.especialidade() == null) {
			throw new ValidacaoException("Especialidade é obrigatória quando médico não for escolhido");
		}
		
		
		
		return medicoRepository.escolherMedicoLivreAleatorioNaDataCancelamentoIsNull(dados.especialidade(), dados.data());
		
	}
	
}
