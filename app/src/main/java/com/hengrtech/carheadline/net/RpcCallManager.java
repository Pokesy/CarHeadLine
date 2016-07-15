package com.hengrtech.carheadline.net;

import rx.Observable;
import rx.Subscriber;
import rx.subscriptions.CompositeSubscription;

public interface RpcCallManager {

  <T> void manageRpcCall(Observable<T> observable, Subscriber<T> subscribe);

  /**
   * RpcCallManager实现类
   */
  class RpcCallManagerImpl implements RpcCallManager {

    private CompositeSubscription mCompositeSubscription = new CompositeSubscription();

    public <T> void manageRpcCall(Observable<T> observable, final Subscriber<T> subscribe) {
      mCompositeSubscription.add(observable.subscribe(subscribe));
    }

    public void unsubscribeAll() {
      mCompositeSubscription.unsubscribe();
    }
  }
}