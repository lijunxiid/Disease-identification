package com.czxy.baidu.ai.api;

import com.czxy.baidu.ai.aip.auth.ToKen;
import com.czxy.utils.Base64Util;
import com.czxy.utils.HttpUtil;

import java.net.URLEncoder;

/**
* 植物识别
*/
public class Plant {


    public static String plant(byte[] bytes) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/image-classify/v1/plant";
        try {
            String imgStr = Base64Util.encode(bytes);
            String encode = URLEncoder.encode(imgStr, "UTF-8");

            String param = "baike_num=1&image=" + encode;

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = ToKen.getAuth();

            String result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}