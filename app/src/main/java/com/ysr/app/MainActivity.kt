package com.ysr.app

import com.alibaba.android.arouter.launcher.ARouter
import com.ysr.app.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {

    }

    override fun initPresenter() {
        btn_recorde.setOnClickListener({
            ARouter.getInstance().build("/ui/videorecord/TCVideoRecordActivity").navigation()
//            startActivity(Intent(this, LoginActivity::class.java))
        })
    }


}
