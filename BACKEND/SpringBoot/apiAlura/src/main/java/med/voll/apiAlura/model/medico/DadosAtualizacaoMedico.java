package med.voll.apiAlura.model.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.apiAlura.model.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
		@NotNull
		Long id, 
		
		String nome, 
		String email,
		String telefone,
		String crm, 
		Especialidade especialidade,
		DadosEndereco endereco) {

}
