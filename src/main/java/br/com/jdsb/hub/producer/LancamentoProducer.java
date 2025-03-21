package br.com.jdsb.hub.producer;

import br.com.jdsb.hub.avro.LancamentoEvent;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LancamentoProducer {

    private final KafkaTemplate<String, LancamentoEvent> kafkaTemplate;

    private static final String TOPIC = "lancamento-topic";

    public void send(LancamentoEvent event) {
        kafkaTemplate.send(new ProducerRecord<>(TOPIC, event.getId().toString(), event));
    }
}
