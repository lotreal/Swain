package im.lot.swain;

import android.app.Application;
import android.content.Context;

/**
 * Created by luotao on 15/12/10.
 */
public class App extends Application {
    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        buildComponentAndInject();
    }

    public void buildComponentAndInject() {
        component = DaggerComponentInitializer.init(this);
    }

    public static AppComponent component(Context context) {
        return ((App) context.getApplicationContext()).component;
    }

    public final static class DaggerComponentInitializer {

        public static AppComponent init(App app) {
            return DaggerAppComponent.builder()
                    .build();
        }

    }
}