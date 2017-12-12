package com.ysr.app.ui

import android.text.InputType.TYPE_CLASS_TEXT
import android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import com.alibaba.android.arouter.facade.annotation.Route
import com.ysr.app.R
import com.ysr.app.base.AnkoBaseActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * @author yangshirong
 * @data 2017/12/12
 * 邮箱 yangshirong@log56.com
 */
@Route(path = "/ui/AnkoRegisterActivity")
class AnkoRegisterActivity : AnkoBaseActivity() {
    override fun initView() {
        AnkoRegisterActivityUi().setContentView(this)
    }

    override fun initPresenter() {

    }


    class AnkoRegisterActivityUi : AnkoComponent<AnkoRegisterActivity> {

        private val customStyle = { v: Any ->
            when (v) {
                is Button -> v.textSize = 16f
                is EditText -> v.textSize = 14f
            }
        }

        override fun createView(ui: AnkoContext<AnkoRegisterActivity>) = with(ui) {
            verticalLayout {
                padding = dip(32)

                imageView(android.R.drawable.ic_menu_manage).lparams {
                    margin = dip(16)
                    gravity = Gravity.CENTER
                }
                val name = editText {
                    hintResource = R.string.hint_name
                }
                val password = editText {
                    hintResource = R.string.hint_password
                    inputType = TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_PASSWORD
                }
                button("注册") {
                    onClick {
                        toast("${name.text} ${password.text}")
                    }
                }

            }.applyRecursively(customStyle)
        }
    }
}
