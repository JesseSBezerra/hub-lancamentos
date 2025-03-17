package br.com.jdsb.hub.mapper;

import br.com.jdsb.hub.avro.LancamentoEvent;
import br.com.jdsb.hub.dto.LancamentoDTO;
import br.com.jdsb.hub.entity.LancamentoEntity;

public class LancamentoMapper {

    public static LancamentoEvent toEvent(LancamentoEntity lancamento) {
        return LancamentoEvent.newBuilder()
                .setId(lancamento.getId().toString())
                .setClientId(lancamento.getClientId().toString())
                .setClientSegmento(lancamento.getClientSegmento())
                .setValorLancamento(lancamento.getValorLancamento())
                .setVencimentoLancamento(lancamento.getVencimentoLancamento().toString())
                .setDescontoLancamento(lancamento.getDescontoLancamento())
                .setJurosLancamento(lancamento.getJurosLancamento())
                .setDataLancamento(lancamento.getDataLancamento().toString())
                .build();
    }

    public static LancamentoEntity toEntity(LancamentoDTO dto) {
        LancamentoEntity entity = new LancamentoEntity();
        entity.setId(dto.getId());
        entity.setClientId(dto.getClientId());
        entity.setClientSegmento(dto.getClientSegmento());
        entity.setValorLancamento(dto.getValorLancamento());
        entity.setVencimentoLancamento(dto.getVencimentoLancamento());
        entity.setDescontoLancamento(dto.getDescontoLancamento());
        entity.setJurosLancamento(dto.getJurosLancamento());
        entity.setDataLancamento(dto.getDataLancamento());
        return entity;
    }

    public static LancamentoDTO toDTO(LancamentoEntity entity) {
        LancamentoDTO dto = new LancamentoDTO();
        dto.setId(entity.getId());
        dto.setClientId(entity.getClientId());
        dto.setClientSegmento(entity.getClientSegmento());
        dto.setValorLancamento(entity.getValorLancamento());
        dto.setVencimentoLancamento(entity.getVencimentoLancamento());
        dto.setDescontoLancamento(entity.getDescontoLancamento());
        dto.setJurosLancamento(entity.getJurosLancamento());
        dto.setDataLancamento(entity.getDataLancamento());
        return dto;
    }
}
