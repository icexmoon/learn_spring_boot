package cn.icexmoon.demo.books.system;


import com.alibaba.fastjson.JSONObject;
import lombok.Data;

@Data
public class Result {
    private boolean success = true;
    private String msg = "";
    private Object data = null;

    @Override
    public String toString(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success",success);
        jsonObject.put("msg",msg);
        jsonObject.put("data",data);
        return jsonObject.toString();
    }
}
