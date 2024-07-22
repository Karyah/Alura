package med.voll.apiAlura.model.consulta;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import med.voll.apiAlura.model.consulta.validacoes.ValidadorAgendamentoDeConsulta;
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
	
	public void agendar(DadosAgendamentoConsulta dados) {
		
		if(!pacienteRepository.existsById(dados.idPaciente())) {
			throw new ValidacaoException("Id do paciente informado não existe");
		}
		
		if(dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())) {
			throw new ValidacaoException("Id do médico informado não existe");
		}
		
		validadores.forEach(v -> v.validar(dados));
		
		var paciente = pacienteRepository.findById(dados.idPaciente()).get();
		var medico = escolherMedico(dados);
		
		var consulta = new Consulta(null, medico, paciente, dados.data());
		repository.save(consulta);
	}
	
	public Medico escolherMedico(DadosAgendamentoConsulta dados) {
		if(dados.idMedico() != null) {
			return medicoRepository.getReferenceById(dados.idMedico());
		}
		
		if(dados.especialidade() == null) {
			throw new ValidacaoException("Especialidade é obrigatória quando médico não for escolhido");
		}
		
		return medicoRepository.escolherMedicoLivreAleatorioNaData(dados.especialidade(), dados.data());
		
	}
	
}
