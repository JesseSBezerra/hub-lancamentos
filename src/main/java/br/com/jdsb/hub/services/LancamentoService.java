package br.com.jdsb.hub.services;

import br.com.jdsb.hub.avro.LancamentoEvent;
import br.com.jdsb.hub.dto.LancamentoDTO;
import br.com.jdsb.hub.entity.LancamentoEntity;
import br.com.jdsb.hub.mapper.LancamentoMapper;
import br.com.jdsb.hub.repository.LancamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LancamentoService {

    private final LancamentoRepository repository;
    private final KafkaTemplate<String, LancamentoEvent> kafkaTemplate;

    public LancamentoDTO salvarLancamento(LancamentoDTO dto) {
        if (dto.getId() == null) dto.setId(UUID.randomUUID());
        LancamentoEntity entity = LancamentoMapper.toEntity(dto);
        repository.save(entity);


        kafkaTemplate.send("lancamentos-topic", LancamentoMapper.toEvent(entity));
        return LancamentoMapper.toDTO(entity);
    }
}
