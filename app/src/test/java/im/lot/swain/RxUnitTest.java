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
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);

        Observable<String> myObservable = Observable.just("hello world");

        myObservable.subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        });
    }
}