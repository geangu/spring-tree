package com.tree.controllers;

import static org.junit.Assert.assertEquals;

import com.tree.domain.Tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import reactor.core.publisher.Flux;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TreeControllerTests {

    @Autowired
    private TreeController controller;
    
    @Test
    public void getVersionAPITest() {
        ResponseEntity<String> response = controller.version();
        assertEquals("API version 1.0.0", response.getBody());
    }

    @Test
    public void getAllTreesTest() throws Exception {
        ResponseEntity<Flux<Tree>> response = controller.listTrees();
        String content = response.getBody().collectList().subscribe().toString();
        assertEquals("[]", content);
    }

}
