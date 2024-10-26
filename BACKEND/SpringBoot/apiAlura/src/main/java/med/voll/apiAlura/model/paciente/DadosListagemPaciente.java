package med.voll.apiAlura.model.paciente;

public record DadosListagemPaciente(
		Long id,
		String nome, 
		String email, 
		String rg) {
	
	public DadosListagemPaciente(Paciente paciente) {
		this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getRg());
	}

}
