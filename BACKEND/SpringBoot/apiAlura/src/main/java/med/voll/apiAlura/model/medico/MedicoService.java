package med.voll.apiAlura.model.medico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {
	
	@Autowired
	private MedicoRepository repository;
	
	public boolean isMedicoAtivo(Long id)	 {
		Medico medico = repository.getReferenceById(id);
		return medico.getAtivo();
	}
	
}
