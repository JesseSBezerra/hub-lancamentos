package br.com.jdsb.hublancamentos.services;

import br.com.jdsb.hublancamentos.avro.LancamentoEvent;
import br.com.jdsb.hublancamentos.dto.LancamentoDTO;
import br.com.jdsb.hublancamentos.entity.LancamentoEntity;
import br.com.jdsb.hublancamentos.mapper.LancamentoMapper;
import br.com.jdsb.hublancamentos.repository.LancamentoRepository;
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
