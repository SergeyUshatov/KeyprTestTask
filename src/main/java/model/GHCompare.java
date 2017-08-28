package model;

import java.util.List;

public class GHCompare {
    private String url;
    private String html_url;
    private String permalink_url;
    private String diff_url;
    private String patch_url;
    private GHCommit base_commit;
    private GHCommit merge_base_commit;
    private String status;
    private int ahead_by;
    private int behind_by;
    private int total_commits;
    private List<GHCommit> commits;
    private List<GHFile> files;

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

    public String getPermalink_url() {
        return permalink_url;
    }

    public void setPermalink_url(String permalink_url) {
        this.permalink_url = permalink_url;
    }

    public String getDiff_url() {
        return diff_url;
    }

    public void setDiff_url(String diff_url) {
        this.diff_url = diff_url;
    }

    public String getPatch_url() {
        return patch_url;
    }

    public void setPatch_url(String patch_url) {
        this.patch_url = patch_url;
    }

    public GHCommit getBase_commit() {
        return base_commit;
    }

    public void setBase_commit(GHCommit base_commit) {
        this.base_commit = base_commit;
    }

    public GHCommit getMerge_base_commit() {
        return merge_base_commit;
    }

    public void setMerge_base_commit(GHCommit merge_base_commit) {
        this.merge_base_commit = merge_base_commit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAhead_by() {
        return ahead_by;
    }

    public void setAhead_by(int ahead_by) {
        this.ahead_by = ahead_by;
    }

    public int getBehind_by() {
        return behind_by;
    }

    public void setBehind_by(int behind_by) {
        this.behind_by = behind_by;
    }

    public int getTotal_commits() {
        return total_commits;
    }

    public void setTotal_commits(int total_commits) {
        this.total_commits = total_commits;
    }

    public List<GHCommit> getCommits() {
        return commits;
    }

    public void setCommits(List<GHCommit> commits) {
        this.commits = commits;
    }

    public List<GHFile> getFiles() {
        return files;
    }

    public void setFiles(List<GHFile> files) {
        this.files = files;
    }
}
