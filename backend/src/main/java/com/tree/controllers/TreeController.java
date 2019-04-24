package com.tree.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.tree.domain.Node;
import com.tree.domain.Tree;
import com.tree.dto.TreeDTO;
import com.tree.services.tree.TreeService;

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

	private static final Logger log = Logger.getLogger(TreeController.class.getName());

	@Autowired
	private TreeService treeService;

	@GetMapping(path = "/api/v1/trees", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Flux<Tree>> listTrees() throws Exception {
		return ResponseEntity.ok().body(this.treeService.listAllTrees());
	}

	@GetMapping(path = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> version() {
		return ResponseEntity.ok().body("API version 1.0.0");
	}

	@PostMapping(path = "/api/v1/trees", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Mono<Tree>> saveTree(@RequestBody TreeDTO tree) throws Exception {
		Mono<Tree> t = this.treeService.saveTree(tree);
		return ResponseEntity.ok().body(t);
	}

	@PutMapping(path = "/api/v1/trees", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateTree(@RequestParam String id, @RequestParam String content) throws Exception {
		Mono<Tree> tree = this.treeService.findById(id);
		tree.subscribe(t -> {
			t.setContent(t.getContent() + content + "\n");
			try {
				this.treeService.saveTree(t).subscribe();
			} catch (Exception e) {
				log.log(Level.SEVERE, e.getLocalizedMessage());
			}
		}, error -> log.log(Level.SEVERE, error.getLocalizedMessage()));
		return ResponseEntity.ok().body("");
	}

	@GetMapping(path = "/api/v1/ancestor", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> ancestor(@RequestParam String id, @RequestParam int node1, @RequestParam int node2)
			throws Exception {

		Tree tree = this.treeService.findTreeById(id);
		Node root = null;
		int ancestor = -1;

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
		if (root != null) {
			ancestor = root.ancestor(node1, node2);
		}
		return ResponseEntity.ok().body("ancestor(" + node1 + "," + node2 + ") = " + ancestor);
	}

}
