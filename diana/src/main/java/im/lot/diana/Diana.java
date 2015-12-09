package im.lot.diana;


import javax.inject.Inject;

import dagger.ObjectGraph;

/**
 * Created by luotao on 15/12/9.
 */
public class Diana {
    @Inject
    Config config;

    public Diana() {
        ObjectGraph objectGraph = ObjectGraph.create(DianaModule.class);
        objectGraph.inject(this);
    }

    public Config getConfig() {
        return config;
    }
}
