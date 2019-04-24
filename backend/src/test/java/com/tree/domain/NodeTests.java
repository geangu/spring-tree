package com.tree.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NodeTests {

    @Test
    public void addNodesToTreeTest() {
        // Given
        Node node = new Node();
        node.data = 10;

        // When
        node.add(20);
        node.add(5);
        node.add(0);

        // Then
        assertEquals(10, node.data);
        assertEquals(20, node.right.data);
        assertEquals( 5, node.left.data);
    }

    @Test
    public void findAncestorTest() {
        // Given
        Node node = new Node();
        node.data = 10;

        // When
        node.add(20);
        node.add(15);
        node.add(25);
        int result = node.ancestor(15, 25);
        int result2 = node.ancestor(35, 25);

        // Then
        assertEquals(20, result);
        assertEquals(-1, result2);
    }

}