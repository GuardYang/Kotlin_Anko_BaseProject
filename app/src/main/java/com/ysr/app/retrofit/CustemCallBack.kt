package com.ysr.app.retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
/**请求回调
 * @author yangshirong
 * @data 2017/12/19
 * 邮箱 yangshirong@log56.com
 */
abstract class CustemCallBack<T> : Callback<T> {
    override fun onResponse(call: Call<T>?, response: Response<T>?) {
        if (response != null) {
            if (response.isSuccessful) {
                onSuccess(response)
            } else {
                onFail(response.message())
            }
        }
    }

    override fun onFailure(call: Call<T>?, t: Throwable?) {
        onFail(t?.message as String)
    }

    abstract fun onSuccess(response: Response<T>?)

    abstract fun onFail(message: String)
}