package im.lot.diana;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by luotao on 15/12/9.
 */
@Module(
        injects = {
                Diana.class
        }
)
public class DianaModule {
        @Provides @Singleton public Config provideConfig() {
                return new Config();
        }
}
