package com.ysr.app.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * @author yangshirong
 * @data 2017/12/12.
 * 邮箱 yangshirong@log56.com
 */

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(this.getLayoutId())
        initPresenter()
        initView()

    }

    //初始化layout
    abstract fun getLayoutId(): Int

    //初始化控件
    abstract fun initView()

    //初始化业务
    abstract fun initPresenter()
}
