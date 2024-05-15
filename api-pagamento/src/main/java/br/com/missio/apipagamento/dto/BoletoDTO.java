package br.com.missio.apipagamento.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoletoDTO {

    private String codigoBarras;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private String statusBoleto;


}
