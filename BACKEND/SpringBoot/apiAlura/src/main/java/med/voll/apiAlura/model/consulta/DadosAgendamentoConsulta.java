package med.voll.apiAlura.model.consulta;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.apiAlura.model.medico.Especialidade;

public record DadosAgendamentoConsulta( 
		Long idMedico, 
		@NotNull
		Long idPaciente,
		
		@NotNull
		@Future
		LocalDateTime data,
		
		Especialidade especialidade
		
		) {
	
}
