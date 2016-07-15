package com.hengrtech.carheadline.ui.basic;

import android.os.Bundle;
import com.hengrtech.carheadline.net.RpcCallManager;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by zhaozeyang on 16/4/11.
 */
public class BasicActivity extends BaseFragmentActivity implements RpcCallManager {
  private RpcCallManager.RpcCallManagerImpl rpcCallManager =
      new RpcCallManager.RpcCallManagerImpl();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  public <T> void manageRpcCall(Observable<T> observable, Subscriber<T> subscribe) {
    rpcCallManager.manageRpcCall(observable, subscribe);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    rpcCallManager.unsubscribeAll();
  }

}
