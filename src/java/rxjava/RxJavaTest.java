package org.bd.java_exercise.rxjava;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class RxJavaTest {

    public static void main(String[] args) {
        RxJavaTest rxJavaTest = new RxJavaTest();

        rxJavaTest.rxChain();
        rxJavaTest.rxCommon();
    }

    private void rxChain() {
        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    for (int i = 0; i <= 5; i++) {
                        subscriber.onNext(i);

                        if (i == 3) {
                            subscriber.onCompleted();
                        }
                    }
                }
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("Rx completed.\n");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Error");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("Receive message: " + integer);
            }
        });
    }

    private void rxCommon() {
        // 被观察者
        Observable<String> stringObservable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                if (subscriber.isUnsubscribed()) {
                    return;
                }

                new Thread(() -> {
                    System.out.println("Wait 3 secs");
                    for (int i = 0; i < 3; i++) {
                        System.out.println("Timer: " + i);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

                subscriber.onNext("message 1");
                subscriber.onNext("message 2");
            }
        });

        // 观察者
        Subscriber<String> stringSubscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("Completed!");
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("Received message from observable: " + s);
            }
        };

        stringObservable.subscribeOn(Schedulers.trampoline())
                .observeOn(Schedulers.computation())
                .subscribe(stringSubscriber);
    }
}
