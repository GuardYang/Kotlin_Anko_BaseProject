package com.ysr.app.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * @author yangshirong
 * @data 2017/12/12
 * 邮箱 yangshirong@log56.com
 */

abstract class AnkoBaseActivity : AppCompatActivity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPresenter()
        initView()
    }

    abstract fun initView()

    abstract fun initPresenter()
}
