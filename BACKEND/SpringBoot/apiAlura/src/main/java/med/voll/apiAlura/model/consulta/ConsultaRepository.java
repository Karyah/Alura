package med.voll.apiAlura.model.consulta;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public interface ConsultaRepository extends JpaRepository<Consulta, Long>{

	
	Boolean existsByMedicoIdAndData(Long idMedico, @NotNull @Future LocalDateTime data);

	Boolean existsByPacienteIdAndDataBetween(@NotNull Long idPaciente, LocalDateTime primeiroHorario,
			LocalDateTime ultimoHorario);

}
