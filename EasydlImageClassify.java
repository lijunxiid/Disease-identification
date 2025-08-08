package com.czxy.baidu.ai.api;

import com.czxy.baidu.ai.aip.auth.AuthService;
import com.czxy.utils.Base64Util;
import com.czxy.utils.GsonUtils;
import com.czxy.utils.HttpUtil;

import java.util.HashMap;
import java.util.Map;

/**
* easydl图像分类
*/
public class EasydlImageClassify {


    public static String easydlImageClassify(byte[] bytes) {
        // 请求url
        String url = "https://aip.baidubce.com/rpc/2.0/ai_custom/v1/classification/icrops";
        try {
            Map<String, Object> map = new HashMap<>();

            //转成base64图片编码
            String encode = Base64Util.encode(bytes);

            map.put("image", encode);
            map.put("top_num", 3);

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = AuthService.getAuth();

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
//        EasydlImageClassify.easydlImageClassify();
    }
}