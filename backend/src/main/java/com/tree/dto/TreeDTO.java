package com.tree.dto;

import com.tree.domain.Tree;

public class TreeDTO extends Tree {

    @Override
    public String toString() {
        return "TreeDTO [id=" + this.getId() + ", content=" + this.getContent() + "]";
    }
}