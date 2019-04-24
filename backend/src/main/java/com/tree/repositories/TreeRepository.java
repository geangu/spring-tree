package com.tree.repositories;

import com.tree.domain.Tree;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;

@Repository
public interface TreeRepository extends ReactiveMongoRepository<Tree, String> {
	
	Mono<Tree> findTreeById(String id) throws Exception;

}
