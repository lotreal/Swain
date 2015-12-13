package im.lot.swain;

/**
 * Created by luotao on 15/12/12.
 */
public class AboutActivityMyInjector {
    public static void inject(AboutActivity activity) {
        activity.config = (Config) activity.getIntent().getSerializableExtra("config");
    }
}
