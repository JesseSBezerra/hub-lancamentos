package br.com.jdsb.hublancamentos.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import lombok.extern.log4j.Log4j2;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Log4j2
@EnableDynamoDBRepositories(basePackages = "br.com.jdsb.hublancamentos.repository")
public class DynamoDBConfig {

    @Value("${amazon.dynamodb.region}")
    private String region;

    @Value("${amazon.dynamodb.endpoint:}")
    private String dynamoEndpoint; // opcional para local/dev ok

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        AmazonDynamoDBClientBuilder builder = AmazonDynamoDBClientBuilder.standard()
                .withRegion(region);

        return builder.build(); // credenciais virão automaticamente da Task IAM Role (no ECS)
    }

    @Bean
    public String vercao() {
        log.info("Versão 1.0.0");
        System.out.println("1.0.0");
        return "1.0.0";
    }

}
