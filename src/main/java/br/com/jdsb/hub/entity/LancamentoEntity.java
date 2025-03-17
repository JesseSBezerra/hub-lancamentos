package br.com.jdsb.hub.entity;

import br.com.jdsb.hub.converter.LocalDateConverter;
import br.com.jdsb.hub.converter.UUIDConverter;
import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@DynamoDBTable(tableName = "tbl_lancamento")
public class LancamentoEntity {

    @DynamoDBHashKey(attributeName = "id")
    @DynamoDBTypeConverted(converter = UUIDConverter.class)
    private UUID id;

    @DynamoDBAttribute(attributeName = "clientId")
    @DynamoDBTypeConverted(converter = UUIDConverter.class)
    private UUID clientId;

    @DynamoDBAttribute(attributeName = "clientSegmento")
    private String clientSegmento;

    @DynamoDBAttribute(attributeName = "valorLancamento")
    private Double valorLancamento;

    @DynamoDBAttribute(attributeName = "vencimentoLancamento")
    @DynamoDBTypeConverted(converter = LocalDateConverter.class)
    private LocalDate vencimentoLancamento;

    @DynamoDBAttribute(attributeName = "descontoLancamento")
    private Double descontoLancamento;

    @DynamoDBAttribute(attributeName = "jurosLancamento")
    private Double jurosLancamento;

    @DynamoDBAttribute(attributeName = "dataLancamento")
    @DynamoDBTypeConverted(converter = LocalDateConverter.class)
    private LocalDate dataLancamento;
}