package com.hengrtech.carheadline.ui.profile;

import android.os.Bundle;
import android.view.View;
import com.hengrtech.carheadline.R;
import com.hengrtech.carheadline.ui.basic.BasicTitleBarFragment;

/**
 * Created by jiao on 2016/7/18.
 */
public class ProfileFragment extends BasicTitleBarFragment {
  public static final String TYPE = "type";

  @Override protected void onCreateViewCompleted(View view) {

  }

  @Override public int getLayoutId() {
    return R.layout.fragment_profile;
  }

  public static ProfileFragment newInstance(String param1) {
    ProfileFragment fragment = new ProfileFragment();
    Bundle args = new Bundle();
    args.putString(TYPE, param1);
    fragment.setArguments(args);
    return fragment;
  }

}
