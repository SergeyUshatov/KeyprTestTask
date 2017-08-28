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
    private GHStats stats;
    private List<GHFile> files;


    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public Commit getCommit() {
        return commit;
    }

    public void setCommit(Commit commit) {
        this.commit = commit;
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

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public GHStats getStats() {
        return stats;
    }

    public void setStats(GHStats stats) {
        this.stats = stats;
    }

    public List<GHFile> getFiles() {
        return files;
    }

    public void setFiles(List<GHFile> files) {
        this.files = files;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GHCommit)) return false;

        GHCommit ghCommit = (GHCommit) o;

        return getSha().equals(ghCommit.getSha());
    }

    @Override
    public int hashCode() {
        return getSha().hashCode();
    }
}
