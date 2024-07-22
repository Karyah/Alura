package med.voll.apiAlura.model.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.apiAlura.model.endereco.DadosEndereco;

public record DadosCadastroPaciente(
		@NotBlank
		String nome,
		
		@NotBlank
		@Email
		String email,
		
		@NotBlank
		String rg,
		
		@NotNull
		@Valid
		DadosEndereco endereco) {

}
