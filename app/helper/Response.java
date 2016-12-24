package helper;

import com.alibaba.fastjson.JSON;
import exception.KitchenException;
import play.libs.Json;
import play.mvc.Result;
import utils.ERROR;

import static play.mvc.Results.ok;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/10 下午4:23
 * @Descrition:
 */
public class Response<T> {
    private String code;
    private String message;
    private T data;

    private static <T> String getResponse(ERROR error, T data) {
        Response response = new Response();
        response.code = error.code;
        response.message = error.msg;
        response.data = data;
        return JSON.toJSONString(response);
    }

    private static <T> String getResponse(KitchenException error, T data) {
        Response response = new Response();
        response.code = error.getCode();
        response.message = error.getMessage();
        response.data = data;
        return JSON.toJSONString(response);
    }

    public static <T> Result getSuccessResult(T data){
        return ok(getResponse(ERROR.SUCCESS, data));
    }

    public static Result getErrorResult(KitchenException k){
        return ok(getResponse(k, null));
    }

    public static Result getErrorResult(Exception k){
        return ok(getResponse(ERROR.UNKNOWN_ERROR, null));
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
