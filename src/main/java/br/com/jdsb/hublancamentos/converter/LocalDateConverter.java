package br.com.jdsb.hublancamentos.converter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

import java.time.LocalDate;

public class LocalDateConverter implements DynamoDBTypeConverter<String, LocalDate> {

    @Override
    public String convert(LocalDate localDate) {
        return localDate.toString(); // yyyy-MM-dd
    }

    @Override
    public LocalDate unconvert(String s) {
        return LocalDate.parse(s);
    }
}
