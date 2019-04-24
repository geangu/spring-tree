package com.tree.services.tree;

import com.tree.domain.Tree;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TreeService {

	Flux<Tree> listAllTrees() throws Exception;
	
	Mono<Tree> saveTree(Tree tree) throws Exception;
	
	Mono<Tree> findById(String id) throws Exception;

	Tree findTreeById(String id) throws Exception;
}
