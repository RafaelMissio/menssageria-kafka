package br.com.missio.apipagamento.service;


import br.com.missio.apipagamento.dto.BoletoDTO;
import br.com.missio.apipagamento.entity.BoletoEntity;
import br.com.missio.apipagamento.entity.enums.StatusBoleto;
import br.com.missio.apipagamento.mapper.BoletoMapper;
import br.com.missio.apipagamento.repository.BoletoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class BoletoService {
    

    private final BoletoRepository boletoRepository;

    public BoletoService(BoletoRepository boletoRepository) {
        this.boletoRepository = boletoRepository;
    }

    public BoletoDTO salvarBoleto(String codigoBarras) {
        Objects.requireNonNull(codigoBarras, "Código de barras não pode ser nulo");
        
        var boletoOpional = boletoRepository.findByCodigoBarras(codigoBarras);
        if (boletoOpional.isPresent()) {
            throw new RuntimeException("Boleto já cadastrado");
        }
        
        var boleto = BoletoEntity.builder()
                .codigoBarras(codigoBarras)
                .dataCriacao(LocalDateTime.now())
                .dataAtualizacao(LocalDateTime.now())
                .statusBoleto(StatusBoleto.INICIALIZADO)
                .build();

        boletoRepository.save(boleto);

        return BoletoMapper.toBoletoDTO(boleto);

    }
}
