package br.com.jdsb.hublancamentos.controller;

import br.com.jdsb.hublancamentos.dto.LancamentoDTO;
import br.com.jdsb.hublancamentos.services.LancamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lancamentos")
@RequiredArgsConstructor
public class LancamentoController {

    private final LancamentoService service;

    @PostMapping
    public ResponseEntity<LancamentoDTO> salvar(@RequestBody LancamentoDTO dto) {
        return ResponseEntity.ok(service.salvarLancamento(dto));
    }
}