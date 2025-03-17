package br.com.jdsb.hub.repository;

import br.com.jdsb.hub.entity.LancamentoEntity;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

@EnableScan
public interface LancamentoRepository extends CrudRepository<LancamentoEntity, UUID> {
}
