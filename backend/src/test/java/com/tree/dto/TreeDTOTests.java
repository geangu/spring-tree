package com.tree.dto;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TreeDTOTests {
    
    @Test
    public void createTreeTest() {
        // Given
        TreeDTO tree = new TreeDTO();
        String toString = "TreeDTO [id=1, content=5,6,7,9,8,11,10]";

        // When
        tree.setId("1");
        tree.setContent("5,6,7,9,8,11,10");

        // Then
        assertEquals("5,6,7,9,8,11,10", tree.getContent());
        assertEquals(toString, tree.toString());
    }

}