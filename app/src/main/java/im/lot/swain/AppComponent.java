package im.lot.swain;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by luotao on 15/12/10.
 */
@Singleton
@Component
public interface AppComponent {
    void inject(MainActivity activity);
    void inject(AboutActivity activity);
}
