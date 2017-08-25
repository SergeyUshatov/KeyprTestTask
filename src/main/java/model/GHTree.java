package model;

import java.util.List;

public class GHTree {
    private String sha;
    private String url;
    private List<Tree> tree;
    private String base_tree;

    public String getBase_tree() {
        return base_tree;
    }

    public GHTree setBase_tree(String base_tree) {
        this.base_tree = base_tree;
        return this;
    }

    public String getSha() {
        return sha;
    }

    public GHTree setSha(String sha) {
        this.sha = sha;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public GHTree setTree(List<Tree> tree) {
        this.tree = tree;
        return this;
    }

    public List<Tree> getTree() {
        return tree;
    }


}
