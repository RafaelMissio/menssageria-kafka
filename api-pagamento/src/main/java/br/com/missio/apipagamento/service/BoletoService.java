package br.com.missio.apipagamento.service;


import br.com.missio.apipagamento.controller.exception.AplicationException;
import br.com.missio.apipagamento.dto.BoletoDTO;
import br.com.missio.apipagamento.entity.BoletoEntity;
import br.com.missio.apipagamento.entity.enums.StatusBoleto;
import br.com.missio.apipagamento.mapper.BoletoMapper;
import br.com.missio.apipagamento.repository.BoletoRepository;
import br.com.missio.apipagamento.service.kafka.BoletoProducer;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class BoletoService {
    

    private final BoletoRepository boletoRepository;

    private final BoletoProducer boletoProducer;

    public BoletoService(BoletoRepository boletoRepository, BoletoProducer boletoProducer) {
        this.boletoRepository = boletoRepository;
        this.boletoProducer = boletoProducer;
    }

    public BoletoDTO salvar(String codigoBarras) {
        Objects.requireNonNull(codigoBarras, "Código de barras não pode ser nulo");
        
        var boletoOpional = boletoRepository.findByCodigoBarras(codigoBarras);
        if (boletoOpional.isPresent()) {
            throw new AplicationException("Boleto já cadastrado");
        }
        
        var boleto = BoletoEntity.builder()
                .codigoBarras(codigoBarras)
                .dataCriacao(LocalDateTime.now())
                .dataAtualizacao(LocalDateTime.now())
                .statusBoleto(StatusBoleto.INICIALIZADO)
                .build();

        boletoRepository.save(boleto);
        boletoProducer.enviarMensagem(BoletoMapper.toBoletoAvro(boleto));

        return BoletoMapper.toBoletoDTO(boleto);

    }
}
