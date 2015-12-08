package im.lot.yi;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import im.lot.yi.util.DateUtils;

/**
 * Created by luotao on 15/12/8.
 */
public class Authorization implements Serializable {
    private Application app;
    private Date createdAt;
    private Date updatedAt;
    private int id;
    private List<String> scopes;
    private String note;
    private String noteUrl;
    private String token;
    private String url;

    public Authorization() {
    }

    public Application getApp() {
        return this.app;
    }

    public Authorization setApp(Application app) {
        this.app = app;
        return this;
    }

    public Date getCreatedAt() {
        return DateUtils.clone(this.createdAt);
    }

    public Authorization setCreatedAt(Date createdAt) {
        this.createdAt = DateUtils.clone(createdAt);
        return this;
    }

    public Date getUpdatedAt() {
        return DateUtils.clone(this.updatedAt);
    }

    public Authorization setUpdatedAt(Date updatedAt) {
        this.updatedAt = DateUtils.clone(updatedAt);
        return this;
    }

    public int getId() {
        return this.id;
    }

    public Authorization setId(int id) {
        this.id = id;
        return this;
    }

    public String getNote() {
        return this.note;
    }

    public Authorization setNote(String note) {
        this.note = note;
        return this;
    }

    public String getNoteUrl() {
        return this.noteUrl;
    }

    public Authorization setNoteUrl(String noteUrl) {
        this.noteUrl = noteUrl;
        return this;
    }

    public List<String> getScopes() {
        return this.scopes;
    }

    public Authorization setScopes(List<String> scopes) {
        this.scopes = scopes;
        return this;
    }

    public String getToken() {
        return this.token;
    }

    public Authorization setToken(String token) {
        this.token = token;
        return this;
    }

    public String getUrl() {
        return this.url;
    }

    public Authorization setUrl(String url) {
        this.url = url;
        return this;
    }
}
