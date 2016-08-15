/*
 * 文件名: AppServiceComponent
 * 版    权：  Copyright Hengrtech Tech. Co. Ltd. All Rights Reserved.
 * 描    述: [该类的简要描述]
 * 创建人: zhaozeyang
 * 创建时间:16/4/19
 * 
 * 修改人：
 * 修改时间:
 * 修改内容：[修改内容]
 */
package com.hengrtech.carheadline.ui.serviceinjection;

import com.hengrtech.carheadline.net.AppService;
import com.hengrtech.carheadline.net.RpcCallManager;
import com.hengrtech.carheadline.ui.home.InformationFragment;
import com.hengrtech.carheadline.ui.home.MediaFragment;
import com.hengrtech.carheadline.ui.home.PraiseFragment;
import com.hengrtech.carheadline.ui.home.TodayActivity;
import com.hengrtech.carheadline.ui.home.WorkFragment;
import dagger.Component;
import javax.inject.Singleton;

/**
 * 服务器接口 Component<BR>
 *
 * @author zhaozeyang
 * @version [Taobei Client V20160411, 16/4/19]
 */
@Singleton @Component(modules = ServiceModule.class) public interface ServiceComponent {
  RpcCallManager rpcCallManager();

  AppService appService();

  void inject(InformationFragment fragment);
  void inject(PraiseFragment fragment);
  void inject(WorkFragment fragment);
  void inject(MediaFragment fragment);
  void inject(TodayActivity activity);
}
