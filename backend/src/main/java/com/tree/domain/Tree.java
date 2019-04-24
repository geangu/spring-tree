package com.tree.domain;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(id, content);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Tree)) {
			return false;
		}
		Tree other = (Tree) obj;
		return Objects.equals(id, other.id) && Objects.equals(content, other.content);
	}

}
