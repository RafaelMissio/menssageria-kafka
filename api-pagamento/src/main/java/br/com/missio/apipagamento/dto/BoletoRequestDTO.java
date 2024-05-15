package br.com.missio.apipagamento.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoletoRequestDTO {

    @NotNull(message = "Código de barras é obrigatório")
    @NotEmpty(message = "Código de barras é obrigatório")
    private String codigoBarras;


}
