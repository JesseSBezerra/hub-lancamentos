package br.com.jdsb.hublancamentos.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class LancamentoDTO {
    private UUID id;
    private UUID clientId;
    private String clientSegmento;
    private Double valorLancamento;
    private LocalDate vencimentoLancamento;
    private Double descontoLancamento;
    private Double jurosLancamento;
    private LocalDate dataLancamento;
}