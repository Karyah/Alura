package med.voll.apiAlura.model.medico;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public interface MedicoRepository extends JpaRepository<Medico, Long>{
	Page<Medico> findAllByAtivoTrue(Pageable paginacao);

	
	@Query("""
			select m from Medico m
			where
			m.ativo = true
			and
			m.id not in(
			  select c.medico.id from Consulta c
			  where
			  c.data = :data
			  and
              c.motivoCancelamento is null
			)
			and
			m.especialidade = :especialidade
			order by rand()
			limit 1
			""")
	Medico escolherMedicoLivreAleatorioNaDataCancelamentoIsNull(Especialidade especialidade, @NotNull @Future LocalDateTime data);


	@Query("select m.ativo from Medico m where m.id = :id")
	Boolean findAtivoById(Long id);
}
