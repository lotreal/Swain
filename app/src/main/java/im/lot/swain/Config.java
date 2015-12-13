package im.lot.swain;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by luotao on 15/12/10.
 */
@Singleton
public class Config implements Serializable {
    @Inject
    public Config() {
    }
}
