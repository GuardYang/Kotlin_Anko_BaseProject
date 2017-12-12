package com.ysr.app.moudle.view.activity

import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.ysr.app.R
import com.ysr.app.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*

@Route(path = "/ui/LoginActivity")
class LoginActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initView() {

    }

    override fun initPresenter() {
        button.setOnClickListener({
            ARouter.getInstance().build("/ui/AnkoRegisterActivity").navigation()
        })
    }


}
