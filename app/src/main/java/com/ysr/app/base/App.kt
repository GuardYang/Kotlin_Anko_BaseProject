package com.ysr.app.base

import android.content.Context
import android.support.multidex.MultiDex
import com.alibaba.android.arouter.launcher.ARouter
import com.qihoo360.replugin.RePluginApplication
import com.ysr.app.BuildConfig

/**
 * @author yangshirong
 * @data 2017/12/12.
 * 邮箱 yangshirong@log56.com
 */

class App : RePluginApplication() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.LOG_DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog()     // 打印日志
            ARouter.openDebug()   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.printStackTrace() // 打印日志的时候打印线程堆栈
        }
        ARouter.init(this) // 尽可能早，推荐在Application中初始化
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        //初始化分包
        MultiDex.install(this)
    }
}
