package med.voll.apiAlura.model.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.apiAlura.model.endereco.DadosEndereco;
import med.voll.apiAlura.model.endereco.Endereco;

public record DadosAtualizacaoPaciente(
		@NotNull
		Long id, 
		String nome,
		String email,
		String rg,
		DadosEndereco endereco
		) {
	

}
