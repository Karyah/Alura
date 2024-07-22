package med.voll.apiAlura.model.paciente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteServices {
	
	@Autowired
	private PacienteRepository repository;
	
	public boolean isPacienteAtivo(Long id) {
		var paciente = repository.getReferenceById(id);
		return paciente.getAtivo();
	}
}
