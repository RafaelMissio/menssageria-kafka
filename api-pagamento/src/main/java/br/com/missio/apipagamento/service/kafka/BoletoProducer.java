package br.com.missio.apipagamento.service.kafka;

import br.com.missio.apipagamento.dto.BoletoDTO;
import br.com.missio.avro.Boleto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class BoletoProducer {

    @Value("${spring.kafka.topic-boleto}")
    public String topic;

    private final KafkaTemplate<String, Boleto> kafkaTemplate;

    public BoletoProducer(KafkaTemplate<String, Boleto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviarMensagem(Boleto boleto) {
        // enviar mensagem para fila do kafka
        kafkaTemplate.send(topic, boleto);
    }
}
