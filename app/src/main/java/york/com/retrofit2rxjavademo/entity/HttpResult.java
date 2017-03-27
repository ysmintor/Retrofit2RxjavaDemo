package york.com.retrofit2rxjavademo.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by liukun on 16/3/5.
 */
public class HttpResult<T> {

    // code 为返回的状态码, message 为返回的消息, 演示的没有这两个字段，考虑到真实的环境中基本包含就在这里写定值
    private int code;
    // this will receive message or status, msg as message field
    @SerializedName(value = "message", alternate = {"status", "msg"})
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    //用来模仿Data
    @SerializedName(value = "data", alternate = {"subjects", "result"})
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
