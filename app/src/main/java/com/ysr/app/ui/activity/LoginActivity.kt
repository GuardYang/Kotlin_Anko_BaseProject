package com.ysr.app.ui.activity

import com.alibaba.android.arouter.facade.annotation.Route
import com.qihoo360.replugin.RePlugin
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
            intent()
//            ARouter.getInstance().build("/ui/AnkoRegisterActivity").navigation()
        })
    }
    private fun intent() {
        RePlugin.startActivity(this@LoginActivity, RePlugin.createIntent("firstapp", "com.ysr.repluginchildone.MainActivity"))
    }

}
