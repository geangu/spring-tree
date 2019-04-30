package com.tree.services;

import com.tree.domain.Tree;
import com.tree.repositories.TreeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service("treeService")
public class TreeServiceImpl implements TreeService {

	@Autowired
	private TreeRepository treeRepository;

	@Override
	@Transactional
	public Mono<Tree> saveTree(Tree tree) throws Exception {
		return this.treeRepository.save(tree);
	}

	@Override
	public Flux<Tree> listAllTrees() throws Exception {
		return this.treeRepository.findAll();
	}

	@Override
	public Mono<Tree> findById(String id) throws Exception {
		return this.treeRepository.findById(id);
	}

	@Override
	public Tree findTreeById(String id) throws Exception {
		return this.treeRepository.findById(id).block();
	}

}
