package com.ysr.common.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/**
 * @author yangshirong
 * @data 2017/12/19
 * 邮箱 yangshirong@log56.com
 */

public class GlideUtils {

    public static void loadPicDefSquare(Context context, ImageView view, String uri) {
        RequestOptions options = new RequestOptions()
                .override(ScreenUtils.dip2px(context, 90));
        Glide.with(context).load(uri).apply(options).into(view);
    }
}
