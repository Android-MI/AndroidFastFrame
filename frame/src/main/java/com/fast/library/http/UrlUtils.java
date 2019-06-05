package com.fast.library.http;

import com.fast.library.utils.LogUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * 说明：工具类，补全url
 */
public class UrlUtils {

    public static String getFullUrl(String url,List<Part> params,boolean urlEncoder){
        StringBuffer urlFull = new StringBuffer();
        urlFull.append(url);
        if (urlFull.indexOf("?",0) < 0 && !params.isEmpty()){
            urlFull.append("?");
        }
        int flag = 0;
        for (Part part:params){
            String key = part.getKey();
            String value = part.getValue();
            if (urlEncoder){
                try {
                    key = URLEncoder.encode(key,"UTF-8");
                    value = URLEncoder.encode(value,"UTF-8");
                }catch (UnsupportedEncodingException e){
                    LogUtils.e(e);
                }
            }
            urlFull.append(key).append("=").append(value);
            if (++flag != params.size()){
                urlFull.append("&");
            }
        }
        return urlFull.toString();
    }

}
