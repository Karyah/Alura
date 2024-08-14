package med.voll.apiAlura.model.consulta;

import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoConsulta(@NotNull Long idConsulta, @NotNull MotivoCancelamento motivoCancelamento) {
}
