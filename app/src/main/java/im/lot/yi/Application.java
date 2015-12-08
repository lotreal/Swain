package im.lot.yi;

import java.io.Serializable;

/**
 * Created by luotao on 15/12/8.
 */
public class Application implements Serializable {
    private static final long serialVersionUID = 5675660442127228497L;
    private String name;
    private String url;

    public Application() {
    }

    public String getName() {
        return this.name;
    }

    public Application setName(String name) {
        this.name = name;
        return this;
    }

    public String getUrl() {
        return this.url;
    }

    public Application setUrl(String url) {
        this.url = url;
        return this;
    }
}