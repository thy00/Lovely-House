package cn.thyonline.house.common.result;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import lombok.Data;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @Description:返回页面最外层包装
 * @Author: Created by thy
 * @Date: 2018/6/29 19:33
 */
@Data
public class ResultMsg {
    public static final String errorMsgKey="errorMsg";
    public static final String successMsgKey="successMsg";
    private String errorMsg;
    private String successMsg;

    public boolean isSuccess(){
        return errorMsg==null&&successMsg!=null;
    }
    public static ResultMsg errorMsg(String msg){
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setErrorMsg(msg);
        return resultMsg;
    }
    public static ResultMsg successMsg(String msg){
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setSuccessMsg(msg);
        return resultMsg;
    }
    public Map<String,String> asMap(){
        Map<String,String> map=Maps.newHashMap();
        map.put(successMsgKey,successMsg);
        map.put(errorMsgKey,errorMsg);
        return map;
    }

    /**
     * 序列化url
     * @return
     */
    public String asUrlParams(){
        Map<String, String> map = asMap();
        Map<String,String> newMap=Maps.newHashMap();
        map.forEach((k,v)->{if (v!=null) {
            try {
                newMap.put(k,URLEncoder.encode(v,"UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }});
        return Joiner.on("&").useForNull("").withKeyValueSeparator("=").join(newMap);
    }
}
