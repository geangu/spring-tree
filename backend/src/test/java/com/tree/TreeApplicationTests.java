package com.tree;

import static org.junit.Assert.assertNotNull;

import com.tree.controllers.TreeController;
import com.tree.services.TreeService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TreeApplicationTests {

	@Autowired
	private TreeController controller;
	@Autowired
	private TreeService treeService;

	@Test
	public void contexLoads() throws Exception {
		assertNotNull(controller);
		assertNotNull(treeService);
	}

}
