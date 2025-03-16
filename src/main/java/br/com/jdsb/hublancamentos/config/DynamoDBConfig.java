package br.com.jdsb.hublancamentos.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories(basePackages = "br.com.jdsb.hublancamentos.repository")
public class DynamoDBConfig {

    @Value("${aws.accessKey}")
    private String awsAccessKey;

    @Value("${aws.secretKey}")
    private String awsSecretKey;

    @Value("${amazon.dynamodb.region}")
    private String amazonDynamoDBRegion;

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        return AmazonDynamoDBClientBuilder.standard()
                .withRegion(amazonDynamoDBRegion)
                .withCredentials(new AWSStaticCredentialsProvider(
                        new BasicAWSCredentials(awsAccessKey, awsSecretKey)))
                .build();
    }
}
