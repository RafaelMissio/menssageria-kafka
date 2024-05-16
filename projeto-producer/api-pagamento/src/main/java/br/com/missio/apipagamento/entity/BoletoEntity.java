package br.com.missio.apipagamento.entity;

import br.com.missio.apipagamento.entity.enums.StatusBoleto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoletoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="codigo_barras")
    private String codigoBarras;

    @Column(name="data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name="data_atualizacao")
    private LocalDateTime dataAtualizacao;

    @Column(name="status_boleto")
    private StatusBoleto statusBoleto;
}
