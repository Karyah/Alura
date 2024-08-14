package med.voll.apiAlura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.apiAlura.model.consulta.AgendaDeConsultas;
import med.voll.apiAlura.model.consulta.DadosAgendamentoConsulta;
import med.voll.apiAlura.model.consulta.DadosCancelamentoConsulta;
import med.voll.apiAlura.model.consulta.DadosDetalhamentoConsulta;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

	@Autowired
	private AgendaDeConsultas agenda;
	
	@PostMapping
	@Transactional
	public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dados) {

		var dto = agenda.agendar(dados);
		return ResponseEntity.ok(dto);
				
	}
	
	@DeleteMapping
	@Transactional
	public ResponseEntity cancelar(@RequestBody @Valid DadosCancelamentoConsulta dados) {
		agenda.cancelar(dados);
		return ResponseEntity.noContent().build();
	}
}
