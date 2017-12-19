package com.ysr.app.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query
import rx.Observable


/**
 * @author yangshirong
 * @data 2017/12/19
 * 邮箱 yangshirong@log56.com
 */
interface APIService {
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @POST("/Ebusiness/EbusinessOrderHandle.aspx")
    fun searchData(@Query("RequestData") RequestData: String,
                   @Query("DataSign") DataSign: String
    ): Call<String>

    @GET("homePageApi/homePage.do")
    fun getHomePage(@Query("RequestData") RequestData: String,
                    @Query("DataSign") DataSign: String): Observable<String>
}