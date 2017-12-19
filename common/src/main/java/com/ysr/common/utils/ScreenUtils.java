package com.ysr.common.utils;

import android.content.Context;

/**
 * @author yangshirong
 * @data 2017/12/19
 * 邮箱 yangshirong@log56.com
 */

public class ScreenUtils {
    // px 转 dip
    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}
