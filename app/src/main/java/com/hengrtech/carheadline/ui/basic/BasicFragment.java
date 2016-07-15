package com.hengrtech.carheadline.ui.basic;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;
import com.hengrtech.carheadline.injection.ActivityComponent;
import com.hengrtech.carheadline.net.RpcCallManager;
import rx.Observable;
import rx.Subscriber;

public abstract class BasicFragment extends BaseFragment implements RpcCallManager {
  private final String mClassName = getClass().getSimpleName();

  /**
   * 进度显示框
   */
  private ProgressDialog mProDialog;


  /**
   *   是否进入pause状态
   */
  private boolean mIsPaused;

  private ActivityComponent mActivityComponent;

  protected RpcCallManagerImpl rpcCallManager = new RpcCallManagerImpl();

  private Object mSessionEventsHandler = new SessionEventsHandler();

  public ActivityComponent createComponent(Activity activity) {
    //return ActivityService.getActivityComponent(activity);
    return null;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    mActivityComponent = createComponent(getActivity());
    super.onCreate(savedInstanceState);
    //getComponent().rootBus().register(this);
    //getComponent().rootBus().register(mSessionEventsHandler);
  }

  @Override
  public void onResume() {
    super.onResume();
    mIsPaused = false;
  }

  @Override
  public void onPause() {
    super.onPause();
    mIsPaused = true;
  }

  public ActivityComponent getComponent() {
    return mActivityComponent;
  }

  /**
   * 显示进度框<BR>
   *
   * @param message 对话框显示信息
   * @param cancelable 对话框可取消标志
   */
  private void showProgressDialog(String message, boolean cancelable) {
    if (mProDialog == null) {
      //mProDialog = new ProgressDialog(getActivity(), cancelable);
    }
    mProDialog.setMessage(message);
    showProgressDialog(mProDialog);
  }

  /**
   * 弹出进度框<BR>
   *
   * @param proDialog 对话框显示信息
   */
  protected void showProgressDialog(ProgressDialog proDialog) {
    if (!mIsPaused) {
      proDialog.show();
    }
  }

  protected boolean isPaused() {
    return mIsPaused;
  }

  /**
   * 显示进度框<BR>
   *
   * @param message 对话框显示信息
   */
  protected void showProgressDialog(String message) {
    // 默认可取消当前对话框
    showProgressDialog(message, true);
  }

  /**
   * 显示进度框<BR>
   *
   * @param msgResId 对话框显示信息
   */
  protected void showProgressDialog(int msgResId) {
    showProgressDialog(getResources().getString(msgResId), true);
  }

  /**
   * 显示进度框<BR>
   *
   * @param msgResId 对话框显示信息
   * @param cancelable 是否可取消的标志
   */
  protected void showProgressDialog(int msgResId, boolean cancelable) {
    showProgressDialog(getResources().getString(msgResId), cancelable);
  }

  /**
   * 关 进度框<BR>
   */
  protected void closeProgressDialog() {
    // 关闭ProgressDialog
    if (null != mProDialog) {
      mProDialog.dismiss();
      mProDialog = null;
    }
  }


  /**
   * 显示短时 的提示内容<BR>
   *
   * @param content 提示内容
   */
  protected void showShortToast(String content) {
    Toast.makeText(getActivity(), content, Toast.LENGTH_SHORT).show();
  }

  /**
   * 显示toast<BR>
   *
   * @param resId 消息资源Id
   */
  protected void showShortToast(int resId) {
    Toast.makeText(getActivity(), resId, Toast.LENGTH_SHORT).show();
  }


  public <T> void manageRpcCall(Observable<T> observable, Subscriber<T> subscribe) {
    rpcCallManager.manageRpcCall(observable, subscribe);
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    rpcCallManager.unsubscribeAll();
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    closeProgressDialog();
  }


  private class SessionEventsHandler {
  }
}