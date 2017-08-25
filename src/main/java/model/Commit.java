package model;

import java.util.List;

public class Commit {
    private Author author;
    private Committer committer;
    private String message;
    private GHTree tree;
    private String treeSha;
    private String url;
    private int comment_count;
    private List<String> parents;

    public String getTreeSha() {
        return treeSha;
    }

    public Commit setTreeSha(String treeSha) {
        this.treeSha = treeSha;
        return this;
    }

    public List<String> getParents() {
        return parents;
    }

    public Commit setParents(List<String> parents) {
        this.parents = parents;
        return this;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Committer getCommitter() {
        return committer;
    }

    public void setCommitter(Committer committer) {
        this.committer = committer;
    }

    public String getMessage() {
        return message;
    }

    public Commit setMessage(String message) {
        this.message = message;
        return this;
    }

    public GHTree getTree() {
        return tree;
    }

    public Commit setTree(GHTree tree) {
        this.tree = tree;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }
}
