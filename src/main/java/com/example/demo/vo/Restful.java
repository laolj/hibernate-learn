package com.example.demo.vo;

public class Restful {

    private Integer code;

    private String message;

    private Object data;

    public static Restful ok(Object val){
        Restful restful=new Restful();
        restful.setCode(200);
        restful.setMessage("请求成功");
        restful.setData(val);
        return restful;
    }

    public static Restful fail(){
        Restful restful=new Restful();
        restful.setCode(400);
        restful.setMessage("获取数据失败");
        return restful;
    }

    public Restful() {
    }



    public Restful(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
