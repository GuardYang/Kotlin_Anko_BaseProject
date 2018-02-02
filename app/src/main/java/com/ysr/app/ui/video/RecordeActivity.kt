package com.ysr.app.ui.video

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.tencent.rtmp.TXLiveBase
import com.ysr.app.R
import com.ysr.common.utils.LogUtils


/**
 * 录制界面
 */
@Route(path = "/ui/video/RecordeActivity")
class RecordeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recorde)
        val sdkver = TXLiveBase.getSDKVersionStr()
        LogUtils.loge(sdkver)

    }
}
