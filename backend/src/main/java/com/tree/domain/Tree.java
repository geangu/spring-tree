package com.tree.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "trees")
public class Tree {

	@Id
	private String id;
	private String content;

	public Tree() {
	}

	public Tree(String id) {
		this.id = id;
	}

	public Tree(String id, String content) {
		this.id = id;
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Tree [id=" + id + ", content=" + content + "]";
	}
}
