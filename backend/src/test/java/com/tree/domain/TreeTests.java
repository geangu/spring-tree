package com.tree.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TreeTests {

    @Test
    public void createTreeTest() {
        // Given
        Tree tree = new Tree();
        Tree tree2 = new Tree("2");
        Tree tree3 = new Tree("3", "3,4,6,5,20");
        String toString = "Tree [id=1, content=5,6,7,9,8,11,10]";
        
        // When
        tree.setId("1");
        tree.setContent("5,6,7,9,8,11,10");
        String content = tree3.getContent();

        // Then
        assertEquals("5,6,7,9,8,11,10", tree.getContent());
        assertEquals("3,4,6,5,20", content);
        assertEquals("2", tree2.getId());
        assertEquals(toString, tree.toString());
    }

}