package med.voll.apiAlura.model.paciente;

import med.voll.apiAlura.model.endereco.Endereco;

public record DadosDetalhamentoPaciente(
		Long id, 
		String nome, 
		String email,
		String rg,
		Endereco endereco
		) {
	
	public DadosDetalhamentoPaciente(Paciente paciente) {
		this(paciente.getId(), paciente.getNome(), paciente.getEmail(),
			paciente.getRg(), paciente.getEndereco());
	}

}
