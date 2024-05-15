package br.com.missio.apipagamento.mapper;

import br.com.missio.apipagamento.dto.BoletoDTO;
import br.com.missio.apipagamento.entity.BoletoEntity;

public class BoletoMapper {

    public static BoletoDTO toBoletoDTO(BoletoEntity boleto) {
        return BoletoDTO.builder()
                .codigoBarras(boleto.getCodigoBarras())
                .dataCriacao(boleto.getDataCriacao())
                .dataAtualizacao(boleto.getDataAtualizacao())
                .statusBoleto(boleto.getStatusBoleto().name())
                .build();
    }


}
