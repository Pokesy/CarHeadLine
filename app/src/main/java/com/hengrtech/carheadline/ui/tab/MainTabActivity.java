/*
 * 文件名: MainTabActivity
 * 版    权：  Copyright Hengrtech Tech. Co. Ltd. All Rights Reserved.
 * 描    述: [该类的简要描述]
 * 创建人: zhaozeyang
 * 创建时间:16/4/19
 * 
 * 修改人：
 * 修改时间:
 * 修改内容：[修改内容]
 */
package com.hengrtech.carheadline.ui.tab;

import com.hengrtech.carheadline.R;
import com.hengrtech.carheadline.ui.basic.tab.BaseTabActivity;

/**
 * [一句话功述]<BR>
 * [功 详 描述]
 *
 * @author zhaozeyang
 * @version [Taobei Client V20160411, 16/4/19]
 */
public class MainTabActivity extends BaseTabActivity {

  @Override
  protected int getLayoutId() {
    return R.layout.main_tab;
  }

  @Override
  protected Class[] getContentClazzes() {
    return new Class[0];
  }

  @Override
  protected String[] getTabTitles() {
    return null;
  }
}
