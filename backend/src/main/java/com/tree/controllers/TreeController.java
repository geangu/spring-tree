package com.tree.controllers;

import com.tree.domain.Node;
import com.tree.domain.Tree;
import com.tree.services.tree.TreeService;
import com.tree.utils.api.ApiEndpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class TreeController {

	@Autowired
	private TreeService treeService;

	@GetMapping(path = ApiEndpoints.API_TREES, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Flux<Tree>> listTrees() throws Exception {
		return ResponseEntity.ok().body(this.treeService.listAllTrees());
	}

	@GetMapping(path = ApiEndpoints.API_VERSION, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> version() throws Exception {
		return ResponseEntity.ok().body("API version 1.0.0");
	}

	@PostMapping(path = ApiEndpoints.API_TREES, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Mono<Tree>> saveTree(@RequestBody Tree tree) throws Exception {
		Mono<Tree> t = this.treeService.saveTree(tree);
		return ResponseEntity.ok().body(t);
	}

	@PutMapping(path = ApiEndpoints.API_TREES, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateTree(@RequestParam String id, @RequestParam String content) throws Exception {
		Mono<Tree> tree = this.treeService.findById(id);
		tree.subscribe(t -> {
			t.setContent(t.getContent() + content + "\n");
			try {
				this.treeService.saveTree(t).subscribe();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}, error -> error.printStackTrace(), () -> System.out.println("completed without a value"));
		return ResponseEntity.ok().body("");
	}

	@GetMapping(path = ApiEndpoints.API_ANCESTOR, produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> ancestor(@RequestParam String id, @RequestParam int node1, @RequestParam int node2)
			throws Exception {

		Tree tree = this.treeService.findTreeById(id);
		Node root = null;

		String[] rows = tree.getContent().split("\n");
		for (String row : rows) {
			String[] items = row.split(",");
			for (String data : items) {
				if (root == null) {
					root = new Node();
				}
				root.add(Integer.parseInt(data));
			}
		}

		int ancestor = root.ancestor(node1, node2);
		return ResponseEntity.ok().body("ancestor(" + node1 + "," + node2 + ") = " + ancestor);
	}

}
