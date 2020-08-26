package com.icd.unti;

import com.icd.model.Result;

public class ResultUtil {
	public static Result<Object> success(Object object, String msg) {
        Result<Object> result = new Result<Object>();
        result.setCode(200);
        result.setMsg(msg);
        result.setData(object);
        return result;
    }
    

    public static Result<Object> error(Integer code,Object object, String msg) {
        Result<Object> result = new Result<Object>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(object);
        return result;
    }
}
