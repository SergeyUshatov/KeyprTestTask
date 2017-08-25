package model;

public class Tree {
    private String sha;
    private String path;
    private String mode;
    private String type;
    private String content;
    private String url;
    private int size;

    public String getSha() {
        return sha;
    }

    public Tree setSha(String sha) {
        this.sha = sha;
        return this;
    }

    public String getPath() {
        return path;
    }

    public Tree setPath(String path) {
        this.path = path;
        return this;
    }

    public String getMode() {
        return mode;
    }

    public Tree setMode(String mode) {
        this.mode = mode;
        return this;
    }

    public String getType() {
        return type;
    }

    public Tree setType(String type) {
        this.type = type;
        return this;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getUrl() {

        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
