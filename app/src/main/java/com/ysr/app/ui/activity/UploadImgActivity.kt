package com.ysr.app.ui.activity

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.provider.MediaStore
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.ysr.app.R
import com.ysr.app.base.BaseActivity
import com.ysr.common.utils.FileUtils
import com.ysr.common.utils.GlideUtils
import com.ysr.common.utils.LogUtils
import kotlinx.android.synthetic.main.activity_upload_img.*


/**
 * 上传图片
 */
@Route(path = "/ui/UploadImgActivity")
class UploadImgActivity : BaseActivity(), View.OnClickListener {
    // 权限授权
    val PERMISSIONS_GRANTED = 0x000
    // 权限拒绝
    val PERMISSIONS_DENIED = 0x001
    //打开相册
    val PK_LEFT_CHOOSE_PHOTO_REQUEST = 0x003
    private var mContext: Context? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_upload_img
    }

    override fun initView() {
        btn_select.setOnClickListener(this)
        btn_upload.setOnClickListener(this)

    }

    override fun initPresenter() {
        mContext = this
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_select -> {
                if (!isPermitWriteStorage()) {

                } else {
                    openPhoto()
                }
            }
            R.id.btn_upload -> {



            }


        }
    }

    //打开相册
    private fun openPhoto() {
        val intent = Intent(Intent.ACTION_PICK, null)
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*")
        startActivityForResult(intent, PK_LEFT_CHOOSE_PHOTO_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (resultCode) {
            RESULT_OK -> {
                when (requestCode) {
                    PK_LEFT_CHOOSE_PHOTO_REQUEST -> {
                        if (null != data) {
                            val imgPath: String
                            val uri = data!!.data
                            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
                                imgPath = uri.getPath()
                            } else {
                                imgPath = FileUtils.getRealFilePath(mContext, uri)
                            }
                            if (null != imgPath) {
                                GlideUtils.loadPicDefSquare(mContext, imageView, imgPath)
                            }
                            LogUtils.loge("imgPath>>$imgPath")
                        }

                    }
                }

            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PERMISSIONS_GRANTED -> {
                if (grantResults.size === 0 || grantResults[0] !== PackageManager.PERMISSION_GRANTED) {

                } else {

                }
                return
            }
        }
    }

    //判断sdl版本是否大于23
    private fun isPermitWriteStorage(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
        } else {
            true
        }

    }

}
