package med.voll.apiAlura.model.medico;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import jakarta.persistence.EntityManager;
import med.voll.apiAlura.model.consulta.Consulta;
import med.voll.apiAlura.model.endereco.DadosEndereco;
import med.voll.apiAlura.model.paciente.DadosCadastroPaciente;
import med.voll.apiAlura.model.paciente.Paciente;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) 
@ActiveProfiles("test")
public class MedicoRepositoryTest {

	@Autowired
	private MedicoRepository medicoRepository;
	
	@Autowired
	private EntityManager em;
	
	@org.junit.jupiter.api.Test
	@DisplayName("Deveria devolver null quando unico medico cadastrado nao esta disponivel na data.")
	public void testEscolherMedicoLivreAleatorioNaDataCancelamentoIsNullCenario1() {
		/*given*/
		LocalDate date = LocalDate.now()
                .with(TemporalAdjusters.next(DayOfWeek.MONDAY));
		
		LocalTime time = LocalTime.of(10, 30);	
			
		LocalDateTime proximaSegundaAs10 = LocalDateTime.of(date, time);
	
        var medico = cadastrarMedico( "Medico", "medico@email.com", "123456", Especialidade.CARDIOLOGIA);
        
        var paciente = cadastrarPaciente("Paciente", "paciente@email.com", "0000000");
        
        cadastrarConsulta(medico, paciente, proximaSegundaAs10);
        
        /*when*/
        var medicoLivre = medicoRepository.escolherMedicoLivreAleatorioNaDataCancelamentoIsNull(Especialidade.CARDIOLOGIA, proximaSegundaAs10);
        
        /*then ou assert*/
        assertThat(medicoLivre).isNull();
	}
	
	@org.junit.jupiter.api.Test
	@DisplayName("Deveria devolver medico quando ele estiver disponivel na data")
	public void testEscolherMedicoLivreAleatorioNaDataCancelamentoIsNullCenario2() {
		
		LocalDate date = LocalDate.now()
                .with(TemporalAdjusters.next(DayOfWeek.MONDAY));
		
		LocalTime time = LocalTime.of(10, 30);	
		
		LocalDateTime proximaSegundaAs10 = LocalDateTime.of(date, time);
		
        var medico = cadastrarMedico( "Medico", "medico@email.com", "123456", Especialidade.CARDIOLOGIA);

        var medicoLivre = medicoRepository.escolherMedicoLivreAleatorioNaDataCancelamentoIsNull(Especialidade.CARDIOLOGIA, proximaSegundaAs10);
        
        assertThat(medicoLivre).isEqualTo(medico);
	}
	
	
	private void cadastrarConsulta(Medico medico, Paciente paciente, LocalDateTime data) {
	    em.persist(new Consulta(null, medico, paciente, data, null));
	}

	private Medico cadastrarMedico(String nome, String email, String crm, Especialidade especialidade) {
		
	    var medico = new Medico(dadosMedico(nome, email, crm, especialidade));
	    em.persist(medico);
	    return medico;
	}

	private Paciente cadastrarPaciente(String nome, String email, String rg) {
	    var paciente = new Paciente(dadosPaciente(nome, email, rg));
	    em.persist(paciente);
	    return paciente;
	}

	private DadosCadastroMedico dadosMedico(String nome, String email, String crm, Especialidade especialidade) {
	    return new DadosCadastroMedico(
	            nome,
	            email,
	            "61999999999",
	            crm,
	            especialidade,
	            dadosEndereco()
	    );
	}

	private DadosCadastroPaciente dadosPaciente(String nome, String email, String rg) {
	    return new DadosCadastroPaciente(
	            nome,
	            email,       
	            rg,
	            dadosEndereco()
	    );
	}

	private DadosEndereco dadosEndereco() {
	    return new DadosEndereco(
	            "rua xpto",
	            "bairro",
	            "00000000",
	            "Brasilia",
	            "DF",
	            null,
	            null
	    );
	}
}
		