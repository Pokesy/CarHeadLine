package com.hengrtech.carheadline.net;

import android.content.Context;
import com.hengrtech.carheadline.CustomApp;

/**
 *  化的，供UI调用  接口使用的RpcSubscriber， 一处理HttpError提示
 */
public abstract class UiRpcSubscriber<T> {
  HttpErrorUiNotifier httpErrorUiNotifier;

  public UiRpcSubscriber(Context context) {
    httpErrorUiNotifier =
        ((CustomApp) context.getApplicationContext()).getGlobalComponent().httpErrorUiNotifier();
  }

  public void onApiError(RpcApiError apiError) {
  }

  public void onHttpError(RpcHttpError httpError) {
    httpErrorUiNotifier.notifyUi(httpError);
  }
}
