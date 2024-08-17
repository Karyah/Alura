package med.voll.apiAlura.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import med.voll.apiAlura.model.consulta.AgendaDeConsultas;
import med.voll.apiAlura.model.consulta.DadosAgendamentoConsulta;
import med.voll.apiAlura.model.consulta.DadosDetalhamentoConsulta;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class ConsultaControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private JacksonTester<DadosAgendamentoConsulta> dadosAgendamentoConsultaJson; 
	
	@Autowired
	private JacksonTester<DadosDetalhamentoConsulta> dadosDetalhamentoConsultaJson; 
	
	@MockBean
	private AgendaDeConsultas agendaDeConsultas;
	
	@Test	
	@DisplayName("Deveria devolver codigo 400 quando informacoes estao invalidas")
	@WithMockUser
	void agendarCenario1() throws Exception {
		var response = mvc.perform(post("/consultas")).andReturn().getResponse();
		
		assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
	}

	@Test	
	@DisplayName("Deveria devolver codigo 200 quando informacoes estao validas")
	@WithMockUser
	void agendarCenario2() throws Exception {
		
		var data = LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		var dadosDetalhamento = new DadosDetalhamentoConsulta(null, 1L, 5L, data);
		
		when(agendaDeConsultas.agendar(any())).thenReturn(dadosDetalhamento);
		
		var response = mvc.perform(
				post("/consultas")
					.contentType(MediaType.APPLICATION_JSON)
					.content(dadosAgendamentoConsultaJson.write(
							
							new DadosAgendamentoConsulta(1L,5l,data, null)).getJson())
					
			).andReturn().getResponse();
		
		var jsonEsperado = dadosDetalhamentoConsultaJson.write(dadosDetalhamento).getJson();
		
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		
		assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
	}


}
