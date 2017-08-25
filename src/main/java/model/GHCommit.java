package model;

import java.util.List;

public class GHCommit {
    private String sha;
    private Commit commit;
    private String url;
    private String html_url;
    private String comments_url;
    private Author author;
    private Committer committer;
    private List<Parent> parents;

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public Commit getCommit() {
        return commit;
    }

    public GHCommit setCommit(Commit commit) {
        this.commit = commit;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getComments_url() {
        return comments_url;
    }

    public void setComments_url(String comments_url) {
        this.comments_url = comments_url;
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

    public List<Parent> getParents() {
        return parents;
    }

    public GHCommit setParents(List<Parent> parents) {
        this.parents = parents;
        return this;
    }
}
