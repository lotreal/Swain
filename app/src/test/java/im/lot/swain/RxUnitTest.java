package im.lot.swain;

import org.junit.Test;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class RxUnitTest {
    @Test
    public void helloworld() throws Exception {
        Observable.just("Hello, world!").subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        });

        Observable.just("Hello, world!")
            .subscribe(s -> System.out.println(s));
    }
}
